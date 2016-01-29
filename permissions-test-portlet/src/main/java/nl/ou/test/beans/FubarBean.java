package nl.ou.test.beans;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import nl.ou.test.model.Foo;
import nl.ou.test.service.FooLocalServiceUtil;

@ManagedBean
@ViewScoped
public class FubarBean {
	private static final Log LOG = LogFactoryUtil.getLog(FubarBean.class);
	public static final String VIEW_PERMISSION = "VIEW_FOO";
	public static final String MODEL_NAME = "nl.ou.test.model.Foo";

	@PostConstruct
	private void init() {
		LOG.debug("PostConstruct");
		createDefaultFoo();
	}

	public int getSomeValue() {
		LOG.debug("getTotal");
		try {
			return FooLocalServiceUtil.getFoosCount();
		} catch (final SystemException e) {
			LOG.error(e);
		}
		return GetterUtil.DEFAULT_INTEGER;
	}

	private void createDefaultFoo() {
		LOG.debug("createDefaultFoo");
		final LiferayFacesContext lfc = LiferayFacesContext.getInstance();
		try {
			final int foosCount = FooLocalServiceUtil.getFoosCount();

			if (foosCount == 0) {
				LOG.debug("No foos found, create one");
				final Foo foo = FooLocalServiceUtil.createFoo(lfc.getCompanyId(), lfc.getScopeGroupId(),
						lfc.getUserId());
				foo.setBooleanField(true);
				foo.setIntField(42);
				foo.setStringField("The answer");
				FooLocalServiceUtil.addFoo(foo);
			}
		} catch (final SystemException e) {
			LOG.error(e);
		}
	}

	public boolean isViewPermitted() {
		boolean result = false;
		final LiferayFacesContext lfc = LiferayFacesContext.getInstance();
		try {
			final PermissionChecker pc = getPermissionChecker();
			result = pc.hasPermission(lfc.getScopeGroupId(), MODEL_NAME, lfc.getScopeGroupId(), VIEW_PERMISSION);
		} catch (final PrincipalException e) {
			LOG.error(e);
		}
		LOG.debug(VIEW_PERMISSION + " permission for user " + lfc.getUser().getFullName() + " is " + result);
		return result;
	}

	private PermissionChecker getPermissionChecker() throws PrincipalException {
		final PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		if (permissionChecker == null) {
			throw new PrincipalException("PermissionChecker not initialized");
		}
		return permissionChecker;
	}

}
