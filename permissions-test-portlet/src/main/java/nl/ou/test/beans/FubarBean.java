package nl.ou.test.beans;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
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
		LOG.debug("IRL also do permissionchecking when updating, deleting etc.");
	}

	public int getFoosCount() {
		int result = GetterUtil.DEFAULT_INTEGER;
		final LiferayFacesContext lfc = LiferayFacesContext.getInstance();
		try {
			if (lfc.getScopeGroup().isGuest()) {
				for (final Group site : lfc.getUser().getMySiteGroups()) {
					if (isViewPermitted(site.getGroupId())) {
						result += FooLocalServiceUtil.getFoos(site.getGroupId()).size();
					}
				}
			} else {
				result = FooLocalServiceUtil.getFoosCount(lfc.getScopeGroupId());
			}
		} catch (final SystemException | PortalException e) {
			LOG.error(e);
			lfc.addGlobalErrorMessage(e.getMessage());
		}
		return result;
	}

	private PermissionChecker getPermissionChecker() throws PrincipalException {
		final LiferayFacesContext lfc = LiferayFacesContext.getInstance();
		final PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		if (permissionChecker == null) {
			lfc.addGlobalErrorMessage("PermissionChecker not initialized");
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

	public boolean isViewPermitted(final long groupId) {
		return isPermitted(VIEW_PERMISSION, groupId);
	}

	public boolean isUpdatePermitted(final long groupId) {
		return isPermitted(UPDATE_PERMISSION, groupId);
	}

	public boolean isAddPermitted(final long groupId) {
		return isPermitted(ADD_PERMISSION, groupId);
	}

	public boolean isDeletePermitted(final long groupId) {
		return isPermitted(DELETE_PERMISSION, groupId);
	}

	private boolean isPermitted(final String permission) {
		final LiferayFacesContext lfc = LiferayFacesContext.getInstance();
		boolean permitted = false;
		try {
			final PermissionChecker pc = getPermissionChecker();
			permitted = pc.hasPermission(lfc.getScopeGroupId(), MODEL_NAME, lfc.getScopeGroupId(), permission);
		} catch (final PrincipalException e) {
			LOG.error(e);
			lfc.addGlobalErrorMessage(e.getMessage());
		}

		LOG.debug("Permission " + permission + " for user " + lfc.getUser().getFullName() + ", group "
				+ lfc.getScopeGroupId() + " is " + permitted);

		return permitted;
	}

	private boolean isPermitted(final String permission, final long groupId) {
		final LiferayFacesContext lfc = LiferayFacesContext.getInstance();
		boolean permitted = false;
		try {
			final PermissionChecker pc = getPermissionChecker();
			permitted = pc.hasPermission(groupId, MODEL_NAME, groupId, permission);
		} catch (final PrincipalException e) {
			LOG.error(e);
			lfc.addGlobalErrorMessage(e.getMessage());
		}

		LOG.debug("Permission " + permission + " for user " + lfc.getUser().getFullName() + ", group " + groupId
				+ " is " + permitted);

		return permitted;
	}

	/**
	 * Get the foos of the current site the user has view permission to. When
	 * current site is guest (which acts as an aggregator site), get foos from
	 * all sites the user is a member of and has the view permission.
	 *
	 * @return foos
	 */
	public List<Foo> getFoos() {
		final LiferayFacesContext lfc = LiferayFacesContext.getInstance();

		LOG.debug("ScopeGroup is " + lfc.getScopeGroup().getName());

		List<Foo> result = new ArrayList<Foo>();
		try {
			if (lfc.getScopeGroup().isGuest()) {
				for (final Group site : lfc.getUser().getMySiteGroups()) {
					if (isViewPermitted(site.getGroupId())) {
						result.addAll(FooLocalServiceUtil.getFoos(site.getGroupId()));
					}
				}
			} else {
				result = FooLocalServiceUtil.getFoos(lfc.getScopeGroupId());
			}
		} catch (final SystemException | PortalException e) {
			LOG.error(e);
			lfc.addGlobalErrorMessage(e.getMessage());
		}
		LOG.debug("Got " + result.size() + " foos");
		return result;
	}

	public String doUpdateFoos() {
		final LiferayFacesContext lfc = LiferayFacesContext.getInstance();
		try {
			final List<Foo> foos = new ArrayList<Foo>();
			if (lfc.getScopeGroup().isGuest()) {
				foos.addAll(FooLocalServiceUtil.getFoos(0, FooLocalServiceUtil.getFoosCount()));
			} else {
				foos.addAll(FooLocalServiceUtil.getFoos(lfc.getScopeGroupId()));
			}
			for (final Foo foo : foos) {
				foo.setBooleanField(!foo.getBooleanField());
				foo.setIntField(foo.getIntField() + 1);
				FooLocalServiceUtil.updateFoo(foo);
			}
		} catch (final SystemException e) {
			LOG.error(e);
			lfc.addGlobalErrorMessage(e.getMessage());
		}
		return null;
	}

	public String doDeleteFoos() {
		final LiferayFacesContext lfc = LiferayFacesContext.getInstance();
		LOG.debug("Delete foos");
		try {
			if (lfc.getScopeGroup().isGuest()) {
				FooLocalServiceUtil.deleteAll();
			} else {
				FooLocalServiceUtil.deleteAll(lfc.getScopeGroupId());
			}
		} catch (final SystemException e) {
			LOG.error(e);
			lfc.addGlobalErrorMessage(e.getMessage());
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
