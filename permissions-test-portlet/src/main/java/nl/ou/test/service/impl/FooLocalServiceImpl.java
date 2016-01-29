package nl.ou.test.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.ResourceConstants;

import java.util.Date;
import java.util.List;

import nl.ou.test.model.Foo;
import nl.ou.test.service.base.FooLocalServiceBaseImpl;

/**
 * The implementation of the foo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link nl.ou.test.service.FooLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see nl.ou.test.service.base.FooLocalServiceBaseImpl
 * @see nl.ou.test.service.FooLocalServiceUtil
 */
public class FooLocalServiceImpl extends FooLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * nl.ou.test.service.FooLocalServiceUtil} to access the foo local service.
	 */

	private static final Log LOG = LogFactoryUtil.getLog(FooLocalServiceImpl.class);

	@Override
	public Foo createFoo(final long companyId, final long groupId, final long userId) {
		Foo result = null;
		try {
			result = super.createFoo(CounterLocalServiceUtil.increment(Foo.class.getName()));
			result.setCompanyId(companyId);
			result.setGroupId(groupId);
			result.setUserId(userId);
			final Date now = new Date();
			result.setCreateDate(now);
			result.setModifiedDate(now);
			LOG.debug("Created foo " + result.getFooId());
		} catch (final SystemException e) {

		}
		return result;
	}

	@Override
	public Foo addFoo(final Foo foo) throws SystemException {
		LOG.debug("Add Foo " + foo.getFooId());
		final Foo result = super.addFoo(foo);
		try {
			LOG.debug("Add resource for Foo " + foo.getFooId());
			resourceLocalService.addResources(foo.getCompanyId(), foo.getGroupId(), foo.getUserId(),
					Foo.class.getName(), foo.getFooId(), false, true, false);
		} catch (final PortalException e) {
			LOG.error(e);
		}
		return result;
	}

	@Override
	public Foo deleteFoo(final Foo foo) throws SystemException {
		LOG.debug("Delete Foo " + foo.getFooId());
		final Foo result = super.deleteFoo(foo);
		try {
			LOG.debug("Delete resoure for Foo " + result.getFooId());
			resourceLocalService.deleteResource(result.getCompanyId(), Foo.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, result.getFooId());
		} catch (final PortalException e) {
			LOG.error(e);
		}
		return result;
	}

	@Override
	public Foo deleteFoo(final long fooId) throws PortalException, SystemException {
		final Foo result = super.deleteFoo(fooId);
		LOG.debug("Delete resoure for Foo " + result.getFooId());
		resourceLocalService.deleteResource(result.getCompanyId(), Foo.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, result.getFooId());
		return result;
	}

	@Override
	public Foo updateFoo(final Foo foo) throws SystemException {
		foo.setModifiedDate(new Date());
		return super.updateFoo(foo);
	}

	@Override
	public void deleteAll() throws SystemException {
		fooPersistence.removeAll();
	}

	public void deleteAll(final long groupId) throws SystemException {
		for (final Foo foo : fooPersistence.findBygroup(groupId)) {
			fooPersistence.remove(foo);
		}
	}

	@Override
	public int getFoosCount(final long groupId) throws SystemException {
		return fooPersistence.countBygroup(groupId);
	}

	@Override
	public List<Foo> getFoos(final long groupId) throws SystemException {
		return fooPersistence.findBygroup(groupId);
	}
}
