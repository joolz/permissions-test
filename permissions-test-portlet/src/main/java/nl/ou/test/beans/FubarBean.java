package nl.ou.test.beans;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import nl.ou.test.model.Foo;
import nl.ou.test.service.FooLocalServiceUtil;

@ManagedBean
@ViewScoped
public class FubarBean {
	private static final Log LOG = LogFactoryUtil.getLog(FubarBean.class);
	public static final String MODEL_NAME = "nl.ou.test.model.Foo";
	public static final String VIEW_PERMISSION = "VIEW_FOO";
	public static final String ADD_PERMISSION = "ADD_FOO";
	public static final String DELETE_PERMISSION = "DELETE_FOO";
	public static final String UPDATE_PERMISSION = "UPDATE_FOO";

	@PostConstruct
	private void init() {
		LOG.debug("PostConstruct");
	}

	public int getFoosCount() {
		try {
			return FooLocalServiceUtil.getFoosCount();
		} catch (final SystemException e) {
			LOG.error(e);
		}
		return GetterUtil.DEFAULT_INTEGER;
	}

	private PermissionChecker getPermissionChecker() throws PrincipalException {
		final PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		if (permissionChecker == null) {
			throw new PrincipalException("PermissionChecker not initialized");
		}
		return permissionChecker;
	}

	public boolean isViewPermitted() {
		return isPermitted(VIEW_PERMISSION);
	}

	public boolean isUpdatePermitted() {
		return isPermitted(UPDATE_PERMISSION);
	}

	public boolean isAddPermitted() {
		return isPermitted(ADD_PERMISSION);
	}

	public boolean isDeletePermitted() {
		return isPermitted(DELETE_PERMISSION);
	}

	private boolean isPermitted(final String permission) {
		LOG.debug("IRL also do permissionchecking when updating, deleting etc.");
		boolean result = false;
		final LiferayFacesContext lfc = LiferayFacesContext.getInstance();
		try {
			final PermissionChecker pc = getPermissionChecker();
			result = pc.hasPermission(lfc.getScopeGroupId(), MODEL_NAME, lfc.getScopeGroupId(), permission);
		} catch (final PrincipalException e) {
			LOG.error(e);
		}
		LOG.debug(permission + " permission for user " + lfc.getUser().getFullName() + " is " + result);
		return result;
	}

	public List<Foo> getFoos() {
		List<Foo> result = new ArrayList<Foo>();
		try {
			result = FooLocalServiceUtil.getFoos(0, FooLocalServiceUtil.getFoosCount());
		} catch (final SystemException e) {
			LOG.error(e);
		}
		LOG.debug("Got " + result.size() + " foos");
		return result;
	}

	public String doUpdateFoos() {
		try {
			for (final Foo foo : FooLocalServiceUtil.getFoos(0, FooLocalServiceUtil.getFoosCount())) {
				foo.setBooleanField(!foo.getBooleanField());
				foo.setIntField(foo.getIntField() + 1);
				FooLocalServiceUtil.updateFoo(foo);
			}
		} catch (final SystemException e) {
			LOG.error(e);
		}
		return null;
	}

	public String doDeleteFoos() {
		LOG.debug("Delete foos");
		try {
			FooLocalServiceUtil.deleteAll();
		} catch (final SystemException e) {
			LOG.error(e);
		}
		return null;
	}

	public String doAddFoo() {
		final LiferayFacesContext lfc = LiferayFacesContext.getInstance();
		try {
			final Foo foo = FooLocalServiceUtil.createFoo(lfc.getCompanyId(), lfc.getScopeGroupId(), lfc.getUserId());
			foo.setBooleanField(true);
			foo.setIntField(42);
			foo.setStringField("The answer");
			FooLocalServiceUtil.addFoo(foo);
		} catch (final SystemException e) {
			LOG.error(e);
		}
		return null;
	}

	public String getMaker(final Foo foo) {
		try {
			final User maker = UserLocalServiceUtil.getUser(foo.getUserId());
			return maker.getFullName();
		} catch (PortalException | SystemException e) {
			LOG.error(e);
		}
		return StringPool.BLANK;
	}
}
