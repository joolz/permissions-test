package nl.ou.test.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;

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
		} catch (final SystemException e) {

		}
		return result;
	}
}
