package nl.ou.test.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import nl.ou.test.model.Foo;

import java.util.List;

/**
 * The persistence utility for the foo service. This utility wraps {@link FooPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FooPersistence
 * @see FooPersistenceImpl
 * @generated
 */
public class FooUtil {
    private static FooPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Foo foo) {
        getPersistence().clearCache(foo);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Foo> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Foo> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Foo> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Foo update(Foo foo) throws SystemException {
        return getPersistence().update(foo);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Foo update(Foo foo, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(foo, serviceContext);
    }

    /**
    * Returns all the foos where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.ou.test.model.Foo> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the foos where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.ou.test.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @return the range of matching foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.ou.test.model.Foo> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the foos where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.ou.test.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.ou.test.model.Foo> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first foo in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching foo
    * @throws nl.ou.test.NoSuchFooException if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo findByUuid_First(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.ou.test.NoSuchFooException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first foo in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching foo, or <code>null</code> if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last foo in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching foo
    * @throws nl.ou.test.NoSuchFooException if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo findByUuid_Last(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.ou.test.NoSuchFooException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last foo in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching foo, or <code>null</code> if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo fetchByUuid_Last(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the foos before and after the current foo in the ordered set where uuid = &#63;.
    *
    * @param fooId the primary key of the current foo
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next foo
    * @throws nl.ou.test.NoSuchFooException if a foo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo[] findByUuid_PrevAndNext(long fooId,
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.ou.test.NoSuchFooException {
        return getPersistence()
                   .findByUuid_PrevAndNext(fooId, uuid, orderByComparator);
    }

    /**
    * Removes all the foos where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of foos where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching foos
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the foo where uuid = &#63; and groupId = &#63; or throws a {@link nl.ou.test.NoSuchFooException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching foo
    * @throws nl.ou.test.NoSuchFooException if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo findByUUID_G(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.ou.test.NoSuchFooException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the foo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching foo, or <code>null</code> if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo fetchByUUID_G(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the foo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching foo, or <code>null</code> if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo fetchByUUID_G(java.lang.String uuid,
        long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the foo where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the foo that was removed
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo removeByUUID_G(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.ou.test.NoSuchFooException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of foos where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching foos
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the foos where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.ou.test.model.Foo> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the foos where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.ou.test.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @return the range of matching foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.ou.test.model.Foo> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the foos where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.ou.test.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.ou.test.model.Foo> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first foo in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching foo
    * @throws nl.ou.test.NoSuchFooException if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.ou.test.NoSuchFooException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first foo in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching foo, or <code>null</code> if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last foo in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching foo
    * @throws nl.ou.test.NoSuchFooException if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.ou.test.NoSuchFooException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last foo in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching foo, or <code>null</code> if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the foos before and after the current foo in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param fooId the primary key of the current foo
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next foo
    * @throws nl.ou.test.NoSuchFooException if a foo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo[] findByUuid_C_PrevAndNext(long fooId,
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.ou.test.NoSuchFooException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(fooId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the foos where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid_C(uuid, companyId);
    }

    /**
    * Returns the number of foos where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching foos
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the foos where booleanField = &#63;.
    *
    * @param booleanField the boolean field
    * @return the matching foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.ou.test.model.Foo> findBybooleanField(
        boolean booleanField)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBybooleanField(booleanField);
    }

    /**
    * Returns a range of all the foos where booleanField = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.ou.test.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param booleanField the boolean field
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @return the range of matching foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.ou.test.model.Foo> findBybooleanField(
        boolean booleanField, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBybooleanField(booleanField, start, end);
    }

    /**
    * Returns an ordered range of all the foos where booleanField = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.ou.test.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param booleanField the boolean field
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.ou.test.model.Foo> findBybooleanField(
        boolean booleanField, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBybooleanField(booleanField, start, end,
            orderByComparator);
    }

    /**
    * Returns the first foo in the ordered set where booleanField = &#63;.
    *
    * @param booleanField the boolean field
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching foo
    * @throws nl.ou.test.NoSuchFooException if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo findBybooleanField_First(
        boolean booleanField,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.ou.test.NoSuchFooException {
        return getPersistence()
                   .findBybooleanField_First(booleanField, orderByComparator);
    }

    /**
    * Returns the first foo in the ordered set where booleanField = &#63;.
    *
    * @param booleanField the boolean field
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching foo, or <code>null</code> if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo fetchBybooleanField_First(
        boolean booleanField,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBybooleanField_First(booleanField, orderByComparator);
    }

    /**
    * Returns the last foo in the ordered set where booleanField = &#63;.
    *
    * @param booleanField the boolean field
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching foo
    * @throws nl.ou.test.NoSuchFooException if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo findBybooleanField_Last(
        boolean booleanField,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.ou.test.NoSuchFooException {
        return getPersistence()
                   .findBybooleanField_Last(booleanField, orderByComparator);
    }

    /**
    * Returns the last foo in the ordered set where booleanField = &#63;.
    *
    * @param booleanField the boolean field
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching foo, or <code>null</code> if a matching foo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo fetchBybooleanField_Last(
        boolean booleanField,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBybooleanField_Last(booleanField, orderByComparator);
    }

    /**
    * Returns the foos before and after the current foo in the ordered set where booleanField = &#63;.
    *
    * @param fooId the primary key of the current foo
    * @param booleanField the boolean field
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next foo
    * @throws nl.ou.test.NoSuchFooException if a foo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo[] findBybooleanField_PrevAndNext(
        long fooId, boolean booleanField,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.ou.test.NoSuchFooException {
        return getPersistence()
                   .findBybooleanField_PrevAndNext(fooId, booleanField,
            orderByComparator);
    }

    /**
    * Removes all the foos where booleanField = &#63; from the database.
    *
    * @param booleanField the boolean field
    * @throws SystemException if a system exception occurred
    */
    public static void removeBybooleanField(boolean booleanField)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBybooleanField(booleanField);
    }

    /**
    * Returns the number of foos where booleanField = &#63;.
    *
    * @param booleanField the boolean field
    * @return the number of matching foos
    * @throws SystemException if a system exception occurred
    */
    public static int countBybooleanField(boolean booleanField)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBybooleanField(booleanField);
    }

    /**
    * Caches the foo in the entity cache if it is enabled.
    *
    * @param foo the foo
    */
    public static void cacheResult(nl.ou.test.model.Foo foo) {
        getPersistence().cacheResult(foo);
    }

    /**
    * Caches the foos in the entity cache if it is enabled.
    *
    * @param foos the foos
    */
    public static void cacheResult(java.util.List<nl.ou.test.model.Foo> foos) {
        getPersistence().cacheResult(foos);
    }

    /**
    * Creates a new foo with the primary key. Does not add the foo to the database.
    *
    * @param fooId the primary key for the new foo
    * @return the new foo
    */
    public static nl.ou.test.model.Foo create(long fooId) {
        return getPersistence().create(fooId);
    }

    /**
    * Removes the foo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fooId the primary key of the foo
    * @return the foo that was removed
    * @throws nl.ou.test.NoSuchFooException if a foo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo remove(long fooId)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.ou.test.NoSuchFooException {
        return getPersistence().remove(fooId);
    }

    public static nl.ou.test.model.Foo updateImpl(nl.ou.test.model.Foo foo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(foo);
    }

    /**
    * Returns the foo with the primary key or throws a {@link nl.ou.test.NoSuchFooException} if it could not be found.
    *
    * @param fooId the primary key of the foo
    * @return the foo
    * @throws nl.ou.test.NoSuchFooException if a foo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo findByPrimaryKey(long fooId)
        throws com.liferay.portal.kernel.exception.SystemException,
            nl.ou.test.NoSuchFooException {
        return getPersistence().findByPrimaryKey(fooId);
    }

    /**
    * Returns the foo with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param fooId the primary key of the foo
    * @return the foo, or <code>null</code> if a foo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static nl.ou.test.model.Foo fetchByPrimaryKey(long fooId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(fooId);
    }

    /**
    * Returns all the foos.
    *
    * @return the foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.ou.test.model.Foo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the foos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.ou.test.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @return the range of foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.ou.test.model.Foo> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the foos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.ou.test.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of foos
    * @param end the upper bound of the range of foos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of foos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<nl.ou.test.model.Foo> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the foos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of foos.
    *
    * @return the number of foos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static FooPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (FooPersistence) PortletBeanLocatorUtil.locate(nl.ou.test.service.ClpSerializer.getServletContextName(),
                    FooPersistence.class.getName());

            ReferenceRegistry.registerReference(FooUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(FooPersistence persistence) {
    }
}
