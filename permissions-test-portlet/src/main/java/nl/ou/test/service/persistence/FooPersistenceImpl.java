package nl.ou.test.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import nl.ou.test.NoSuchFooException;
import nl.ou.test.model.Foo;
import nl.ou.test.model.impl.FooImpl;
import nl.ou.test.model.impl.FooModelImpl;
import nl.ou.test.service.persistence.FooPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the foo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FooPersistence
 * @see FooUtil
 * @generated
 */
public class FooPersistenceImpl extends BasePersistenceImpl<Foo>
    implements FooPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link FooUtil} to access the foo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = FooImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            FooModelImpl.UUID_COLUMN_BITMASK |
            FooModelImpl.STRINGFIELD_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "foo.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "foo.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(foo.uuid IS NULL OR foo.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            FooModelImpl.UUID_COLUMN_BITMASK |
            FooModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "foo.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "foo.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(foo.uuid IS NULL OR foo.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "foo.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            FooModelImpl.UUID_COLUMN_BITMASK |
            FooModelImpl.COMPANYID_COLUMN_BITMASK |
            FooModelImpl.STRINGFIELD_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "foo.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "foo.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(foo.uuid IS NULL OR foo.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "foo.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOLEANFIELD =
        new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybooleanField",
            new String[] {
                Boolean.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOLEANFIELD =
        new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybooleanField",
            new String[] { Boolean.class.getName() },
            FooModelImpl.BOOLEANFIELD_COLUMN_BITMASK |
            FooModelImpl.STRINGFIELD_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_BOOLEANFIELD = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybooleanField",
            new String[] { Boolean.class.getName() });
    private static final String _FINDER_COLUMN_BOOLEANFIELD_BOOLEANFIELD_2 = "foo.booleanField = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygroup",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygroup",
            new String[] { Long.class.getName() },
            FooModelImpl.GROUPID_COLUMN_BITMASK |
            FooModelImpl.STRINGFIELD_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygroup",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "foo.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYANDGROUP =
        new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycompanyAndGroup",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDGROUP =
        new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, FooImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycompanyAndGroup",
            new String[] { Long.class.getName(), Long.class.getName() },
            FooModelImpl.COMPANYID_COLUMN_BITMASK |
            FooModelImpl.GROUPID_COLUMN_BITMASK |
            FooModelImpl.STRINGFIELD_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYANDGROUP = new FinderPath(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBycompanyAndGroup",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYANDGROUP_COMPANYID_2 = "foo.companyId = ? AND ";
    private static final String _FINDER_COLUMN_COMPANYANDGROUP_GROUPID_2 = "foo.groupId = ?";
    private static final String _SQL_SELECT_FOO = "SELECT foo FROM Foo foo";
    private static final String _SQL_SELECT_FOO_WHERE = "SELECT foo FROM Foo foo WHERE ";
    private static final String _SQL_COUNT_FOO = "SELECT COUNT(foo) FROM Foo foo";
    private static final String _SQL_COUNT_FOO_WHERE = "SELECT COUNT(foo) FROM Foo foo WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "foo.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Foo exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Foo exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(FooPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Foo _nullFoo = new FooImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Foo> toCacheModel() {
                return _nullFooCacheModel;
            }
        };

    private static CacheModel<Foo> _nullFooCacheModel = new CacheModel<Foo>() {
            @Override
            public Foo toEntityModel() {
                return _nullFoo;
            }
        };

    public FooPersistenceImpl() {
        setModelClass(Foo.class);
    }

    /**
     * Returns all the foos where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Foo> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
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
    @Override
    public List<Foo> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Foo> list = (List<Foo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Foo foo : list) {
                if (!Validator.equals(uuid, foo.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_FOO_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FooModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Foo>(list);
                } else {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Foo findByUuid_First(String uuid, OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchByUuid_First(uuid, orderByComparator);

        if (foo != null) {
            return foo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFooException(msg.toString());
    }

    /**
     * Returns the first foo in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching foo, or <code>null</code> if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Foo> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Foo findByUuid_Last(String uuid, OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchByUuid_Last(uuid, orderByComparator);

        if (foo != null) {
            return foo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFooException(msg.toString());
    }

    /**
     * Returns the last foo in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching foo, or <code>null</code> if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchByUuid_Last(String uuid, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Foo> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Foo[] findByUuid_PrevAndNext(long fooId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = findByPrimaryKey(fooId);

        Session session = null;

        try {
            session = openSession();

            Foo[] array = new FooImpl[3];

            array[0] = getByUuid_PrevAndNext(session, foo, uuid,
                    orderByComparator, true);

            array[1] = foo;

            array[2] = getByUuid_PrevAndNext(session, foo, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Foo getByUuid_PrevAndNext(Session session, Foo foo, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FOO_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(FooModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(foo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Foo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the foos where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Foo foo : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(foo);
        }
    }

    /**
     * Returns the number of foos where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_FOO_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
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
    @Override
    public Foo findByUUID_G(String uuid, long groupId)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchByUUID_G(uuid, groupId);

        if (foo == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchFooException(msg.toString());
        }

        return foo;
    }

    /**
     * Returns the foo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching foo, or <code>null</code> if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
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
    @Override
    public Foo fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Foo) {
            Foo foo = (Foo) result;

            if (!Validator.equals(uuid, foo.getUuid()) ||
                    (groupId != foo.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_FOO_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<Foo> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Foo foo = list.get(0);

                    result = foo;

                    cacheResult(foo);

                    if ((foo.getUuid() == null) || !foo.getUuid().equals(uuid) ||
                            (foo.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, foo);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Foo) result;
        }
    }

    /**
     * Removes the foo where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the foo that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo removeByUUID_G(String uuid, long groupId)
        throws NoSuchFooException, SystemException {
        Foo foo = findByUUID_G(uuid, groupId);

        return remove(foo);
    }

    /**
     * Returns the number of foos where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_FOO_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the foos where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Foo> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
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
    @Override
    public List<Foo> findByUuid_C(String uuid, long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] { uuid, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] {
                    uuid, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<Foo> list = (List<Foo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Foo foo : list) {
                if (!Validator.equals(uuid, foo.getUuid()) ||
                        (companyId != foo.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_FOO_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FooModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Foo>(list);
                } else {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Foo findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchByUuid_C_First(uuid, companyId, orderByComparator);

        if (foo != null) {
            return foo;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFooException(msg.toString());
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
    @Override
    public Foo fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Foo> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Foo findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

        if (foo != null) {
            return foo;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFooException(msg.toString());
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
    @Override
    public Foo fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Foo> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Foo[] findByUuid_C_PrevAndNext(long fooId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = findByPrimaryKey(fooId);

        Session session = null;

        try {
            session = openSession();

            Foo[] array = new FooImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, foo, uuid, companyId,
                    orderByComparator, true);

            array[1] = foo;

            array[2] = getByUuid_C_PrevAndNext(session, foo, uuid, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Foo getByUuid_C_PrevAndNext(Session session, Foo foo,
        String uuid, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FOO_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_C_UUID_2);
        }

        query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(FooModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(foo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Foo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the foos where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Foo foo : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(foo);
        }
    }

    /**
     * Returns the number of foos where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid_C(String uuid, long companyId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

        Object[] finderArgs = new Object[] { uuid, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_FOO_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the foos where booleanField = &#63;.
     *
     * @param booleanField the boolean field
     * @return the matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findBybooleanField(boolean booleanField)
        throws SystemException {
        return findBybooleanField(booleanField, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Foo> findBybooleanField(boolean booleanField, int start, int end)
        throws SystemException {
        return findBybooleanField(booleanField, start, end, null);
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
    @Override
    public List<Foo> findBybooleanField(boolean booleanField, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOLEANFIELD;
            finderArgs = new Object[] { booleanField };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOLEANFIELD;
            finderArgs = new Object[] {
                    booleanField,
                    
                    start, end, orderByComparator
                };
        }

        List<Foo> list = (List<Foo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Foo foo : list) {
                if ((booleanField != foo.getBooleanField())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_FOO_WHERE);

            query.append(_FINDER_COLUMN_BOOLEANFIELD_BOOLEANFIELD_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FooModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(booleanField);

                if (!pagination) {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Foo>(list);
                } else {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Foo findBybooleanField_First(boolean booleanField,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchBybooleanField_First(booleanField, orderByComparator);

        if (foo != null) {
            return foo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("booleanField=");
        msg.append(booleanField);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFooException(msg.toString());
    }

    /**
     * Returns the first foo in the ordered set where booleanField = &#63;.
     *
     * @param booleanField the boolean field
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching foo, or <code>null</code> if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchBybooleanField_First(boolean booleanField,
        OrderByComparator orderByComparator) throws SystemException {
        List<Foo> list = findBybooleanField(booleanField, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Foo findBybooleanField_Last(boolean booleanField,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchBybooleanField_Last(booleanField, orderByComparator);

        if (foo != null) {
            return foo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("booleanField=");
        msg.append(booleanField);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFooException(msg.toString());
    }

    /**
     * Returns the last foo in the ordered set where booleanField = &#63;.
     *
     * @param booleanField the boolean field
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching foo, or <code>null</code> if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchBybooleanField_Last(boolean booleanField,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBybooleanField(booleanField);

        if (count == 0) {
            return null;
        }

        List<Foo> list = findBybooleanField(booleanField, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Foo[] findBybooleanField_PrevAndNext(long fooId,
        boolean booleanField, OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = findByPrimaryKey(fooId);

        Session session = null;

        try {
            session = openSession();

            Foo[] array = new FooImpl[3];

            array[0] = getBybooleanField_PrevAndNext(session, foo,
                    booleanField, orderByComparator, true);

            array[1] = foo;

            array[2] = getBybooleanField_PrevAndNext(session, foo,
                    booleanField, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Foo getBybooleanField_PrevAndNext(Session session, Foo foo,
        boolean booleanField, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FOO_WHERE);

        query.append(_FINDER_COLUMN_BOOLEANFIELD_BOOLEANFIELD_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(FooModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(booleanField);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(foo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Foo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the foos where booleanField = &#63; from the database.
     *
     * @param booleanField the boolean field
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBybooleanField(boolean booleanField)
        throws SystemException {
        for (Foo foo : findBybooleanField(booleanField, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(foo);
        }
    }

    /**
     * Returns the number of foos where booleanField = &#63;.
     *
     * @param booleanField the boolean field
     * @return the number of matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBybooleanField(boolean booleanField)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_BOOLEANFIELD;

        Object[] finderArgs = new Object[] { booleanField };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_FOO_WHERE);

            query.append(_FINDER_COLUMN_BOOLEANFIELD_BOOLEANFIELD_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(booleanField);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the foos where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findBygroup(long groupId) throws SystemException {
        return findBygroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the foos where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.ou.test.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of foos
     * @param end the upper bound of the range of foos (not inclusive)
     * @return the range of matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findBygroup(long groupId, int start, int end)
        throws SystemException {
        return findBygroup(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the foos where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.ou.test.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of foos
     * @param end the upper bound of the range of foos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findBygroup(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<Foo> list = (List<Foo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Foo foo : list) {
                if ((groupId != foo.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_FOO_WHERE);

            query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FooModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Foo>(list);
                } else {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first foo in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching foo
     * @throws nl.ou.test.NoSuchFooException if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo findBygroup_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchBygroup_First(groupId, orderByComparator);

        if (foo != null) {
            return foo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFooException(msg.toString());
    }

    /**
     * Returns the first foo in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching foo, or <code>null</code> if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchBygroup_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Foo> list = findBygroup(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last foo in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching foo
     * @throws nl.ou.test.NoSuchFooException if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo findBygroup_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchBygroup_Last(groupId, orderByComparator);

        if (foo != null) {
            return foo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFooException(msg.toString());
    }

    /**
     * Returns the last foo in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching foo, or <code>null</code> if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchBygroup_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBygroup(groupId);

        if (count == 0) {
            return null;
        }

        List<Foo> list = findBygroup(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the foos before and after the current foo in the ordered set where groupId = &#63;.
     *
     * @param fooId the primary key of the current foo
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next foo
     * @throws nl.ou.test.NoSuchFooException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo[] findBygroup_PrevAndNext(long fooId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = findByPrimaryKey(fooId);

        Session session = null;

        try {
            session = openSession();

            Foo[] array = new FooImpl[3];

            array[0] = getBygroup_PrevAndNext(session, foo, groupId,
                    orderByComparator, true);

            array[1] = foo;

            array[2] = getBygroup_PrevAndNext(session, foo, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Foo getBygroup_PrevAndNext(Session session, Foo foo,
        long groupId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FOO_WHERE);

        query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(FooModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(foo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Foo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the foos where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBygroup(long groupId) throws SystemException {
        for (Foo foo : findBygroup(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(foo);
        }
    }

    /**
     * Returns the number of foos where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBygroup(long groupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUP;

        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_FOO_WHERE);

            query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the foos where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findBycompanyAndGroup(long companyId, long groupId)
        throws SystemException {
        return findBycompanyAndGroup(companyId, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the foos where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.ou.test.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of foos
     * @param end the upper bound of the range of foos (not inclusive)
     * @return the range of matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findBycompanyAndGroup(long companyId, long groupId,
        int start, int end) throws SystemException {
        return findBycompanyAndGroup(companyId, groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the foos where companyId = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link nl.ou.test.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param start the lower bound of the range of foos
     * @param end the upper bound of the range of foos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findBycompanyAndGroup(long companyId, long groupId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDGROUP;
            finderArgs = new Object[] { companyId, groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYANDGROUP;
            finderArgs = new Object[] {
                    companyId, groupId,
                    
                    start, end, orderByComparator
                };
        }

        List<Foo> list = (List<Foo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Foo foo : list) {
                if ((companyId != foo.getCompanyId()) ||
                        (groupId != foo.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_FOO_WHERE);

            query.append(_FINDER_COLUMN_COMPANYANDGROUP_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYANDGROUP_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(FooModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Foo>(list);
                } else {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first foo in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching foo
     * @throws nl.ou.test.NoSuchFooException if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo findBycompanyAndGroup_First(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchBycompanyAndGroup_First(companyId, groupId,
                orderByComparator);

        if (foo != null) {
            return foo;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFooException(msg.toString());
    }

    /**
     * Returns the first foo in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching foo, or <code>null</code> if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchBycompanyAndGroup_First(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Foo> list = findBycompanyAndGroup(companyId, groupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last foo in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching foo
     * @throws nl.ou.test.NoSuchFooException if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo findBycompanyAndGroup_Last(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchBycompanyAndGroup_Last(companyId, groupId,
                orderByComparator);

        if (foo != null) {
            return foo;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFooException(msg.toString());
    }

    /**
     * Returns the last foo in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching foo, or <code>null</code> if a matching foo could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchBycompanyAndGroup_Last(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBycompanyAndGroup(companyId, groupId);

        if (count == 0) {
            return null;
        }

        List<Foo> list = findBycompanyAndGroup(companyId, groupId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the foos before and after the current foo in the ordered set where companyId = &#63; and groupId = &#63;.
     *
     * @param fooId the primary key of the current foo
     * @param companyId the company ID
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next foo
     * @throws nl.ou.test.NoSuchFooException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo[] findBycompanyAndGroup_PrevAndNext(long fooId, long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchFooException, SystemException {
        Foo foo = findByPrimaryKey(fooId);

        Session session = null;

        try {
            session = openSession();

            Foo[] array = new FooImpl[3];

            array[0] = getBycompanyAndGroup_PrevAndNext(session, foo,
                    companyId, groupId, orderByComparator, true);

            array[1] = foo;

            array[2] = getBycompanyAndGroup_PrevAndNext(session, foo,
                    companyId, groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Foo getBycompanyAndGroup_PrevAndNext(Session session, Foo foo,
        long companyId, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FOO_WHERE);

        query.append(_FINDER_COLUMN_COMPANYANDGROUP_COMPANYID_2);

        query.append(_FINDER_COLUMN_COMPANYANDGROUP_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(FooModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(foo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Foo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the foos where companyId = &#63; and groupId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBycompanyAndGroup(long companyId, long groupId)
        throws SystemException {
        for (Foo foo : findBycompanyAndGroup(companyId, groupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(foo);
        }
    }

    /**
     * Returns the number of foos where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the number of matching foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBycompanyAndGroup(long companyId, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYANDGROUP;

        Object[] finderArgs = new Object[] { companyId, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_FOO_WHERE);

            query.append(_FINDER_COLUMN_COMPANYANDGROUP_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYANDGROUP_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the foo in the entity cache if it is enabled.
     *
     * @param foo the foo
     */
    @Override
    public void cacheResult(Foo foo) {
        EntityCacheUtil.putResult(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooImpl.class, foo.getPrimaryKey(), foo);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { foo.getUuid(), foo.getGroupId() }, foo);

        foo.resetOriginalValues();
    }

    /**
     * Caches the foos in the entity cache if it is enabled.
     *
     * @param foos the foos
     */
    @Override
    public void cacheResult(List<Foo> foos) {
        for (Foo foo : foos) {
            if (EntityCacheUtil.getResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                        FooImpl.class, foo.getPrimaryKey()) == null) {
                cacheResult(foo);
            } else {
                foo.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all foos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(FooImpl.class.getName());
        }

        EntityCacheUtil.clearCache(FooImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the foo.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Foo foo) {
        EntityCacheUtil.removeResult(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooImpl.class, foo.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(foo);
    }

    @Override
    public void clearCache(List<Foo> foos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Foo foo : foos) {
            EntityCacheUtil.removeResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                FooImpl.class, foo.getPrimaryKey());

            clearUniqueFindersCache(foo);
        }
    }

    protected void cacheUniqueFindersCache(Foo foo) {
        if (foo.isNew()) {
            Object[] args = new Object[] { foo.getUuid(), foo.getGroupId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, foo);
        } else {
            FooModelImpl fooModelImpl = (FooModelImpl) foo;

            if ((fooModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { foo.getUuid(), foo.getGroupId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, foo);
            }
        }
    }

    protected void clearUniqueFindersCache(Foo foo) {
        FooModelImpl fooModelImpl = (FooModelImpl) foo;

        Object[] args = new Object[] { foo.getUuid(), foo.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((fooModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    fooModelImpl.getOriginalUuid(),
                    fooModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new foo with the primary key. Does not add the foo to the database.
     *
     * @param fooId the primary key for the new foo
     * @return the new foo
     */
    @Override
    public Foo create(long fooId) {
        Foo foo = new FooImpl();

        foo.setNew(true);
        foo.setPrimaryKey(fooId);

        String uuid = PortalUUIDUtil.generate();

        foo.setUuid(uuid);

        return foo;
    }

    /**
     * Removes the foo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param fooId the primary key of the foo
     * @return the foo that was removed
     * @throws nl.ou.test.NoSuchFooException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo remove(long fooId) throws NoSuchFooException, SystemException {
        return remove((Serializable) fooId);
    }

    /**
     * Removes the foo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the foo
     * @return the foo that was removed
     * @throws nl.ou.test.NoSuchFooException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo remove(Serializable primaryKey)
        throws NoSuchFooException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Foo foo = (Foo) session.get(FooImpl.class, primaryKey);

            if (foo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchFooException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(foo);
        } catch (NoSuchFooException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Foo removeImpl(Foo foo) throws SystemException {
        foo = toUnwrappedModel(foo);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(foo)) {
                foo = (Foo) session.get(FooImpl.class, foo.getPrimaryKeyObj());
            }

            if (foo != null) {
                session.delete(foo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (foo != null) {
            clearCache(foo);
        }

        return foo;
    }

    @Override
    public Foo updateImpl(nl.ou.test.model.Foo foo) throws SystemException {
        foo = toUnwrappedModel(foo);

        boolean isNew = foo.isNew();

        FooModelImpl fooModelImpl = (FooModelImpl) foo;

        if (Validator.isNull(foo.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            foo.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (foo.isNew()) {
                session.save(foo);

                foo.setNew(false);
            } else {
                session.merge(foo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !FooModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((fooModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { fooModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { fooModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((fooModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        fooModelImpl.getOriginalUuid(),
                        fooModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        fooModelImpl.getUuid(), fooModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((fooModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOLEANFIELD.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        fooModelImpl.getOriginalBooleanField()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOLEANFIELD,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOLEANFIELD,
                    args);

                args = new Object[] { fooModelImpl.getBooleanField() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BOOLEANFIELD,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOLEANFIELD,
                    args);
            }

            if ((fooModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { fooModelImpl.getOriginalGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
                    args);

                args = new Object[] { fooModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
                    args);
            }

            if ((fooModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDGROUP.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        fooModelImpl.getOriginalCompanyId(),
                        fooModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDGROUP,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDGROUP,
                    args);

                args = new Object[] {
                        fooModelImpl.getCompanyId(), fooModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDGROUP,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDGROUP,
                    args);
            }
        }

        EntityCacheUtil.putResult(FooModelImpl.ENTITY_CACHE_ENABLED,
            FooImpl.class, foo.getPrimaryKey(), foo);

        clearUniqueFindersCache(foo);
        cacheUniqueFindersCache(foo);

        return foo;
    }

    protected Foo toUnwrappedModel(Foo foo) {
        if (foo instanceof FooImpl) {
            return foo;
        }

        FooImpl fooImpl = new FooImpl();

        fooImpl.setNew(foo.isNew());
        fooImpl.setPrimaryKey(foo.getPrimaryKey());

        fooImpl.setUuid(foo.getUuid());
        fooImpl.setFooId(foo.getFooId());
        fooImpl.setGroupId(foo.getGroupId());
        fooImpl.setCompanyId(foo.getCompanyId());
        fooImpl.setUserId(foo.getUserId());
        fooImpl.setUserName(foo.getUserName());
        fooImpl.setCreateDate(foo.getCreateDate());
        fooImpl.setModifiedDate(foo.getModifiedDate());
        fooImpl.setStringField(foo.getStringField());
        fooImpl.setBooleanField(foo.isBooleanField());
        fooImpl.setIntField(foo.getIntField());
        fooImpl.setDateField(foo.getDateField());

        return fooImpl;
    }

    /**
     * Returns the foo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the foo
     * @return the foo
     * @throws nl.ou.test.NoSuchFooException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo findByPrimaryKey(Serializable primaryKey)
        throws NoSuchFooException, SystemException {
        Foo foo = fetchByPrimaryKey(primaryKey);

        if (foo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchFooException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return foo;
    }

    /**
     * Returns the foo with the primary key or throws a {@link nl.ou.test.NoSuchFooException} if it could not be found.
     *
     * @param fooId the primary key of the foo
     * @return the foo
     * @throws nl.ou.test.NoSuchFooException if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo findByPrimaryKey(long fooId)
        throws NoSuchFooException, SystemException {
        return findByPrimaryKey((Serializable) fooId);
    }

    /**
     * Returns the foo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the foo
     * @return the foo, or <code>null</code> if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Foo foo = (Foo) EntityCacheUtil.getResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                FooImpl.class, primaryKey);

        if (foo == _nullFoo) {
            return null;
        }

        if (foo == null) {
            Session session = null;

            try {
                session = openSession();

                foo = (Foo) session.get(FooImpl.class, primaryKey);

                if (foo != null) {
                    cacheResult(foo);
                } else {
                    EntityCacheUtil.putResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                        FooImpl.class, primaryKey, _nullFoo);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(FooModelImpl.ENTITY_CACHE_ENABLED,
                    FooImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return foo;
    }

    /**
     * Returns the foo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param fooId the primary key of the foo
     * @return the foo, or <code>null</code> if a foo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Foo fetchByPrimaryKey(long fooId) throws SystemException {
        return fetchByPrimaryKey((Serializable) fooId);
    }

    /**
     * Returns all the foos.
     *
     * @return the foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Foo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Foo> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Foo> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Foo> list = (List<Foo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_FOO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_FOO;

                if (pagination) {
                    sql = sql.concat(FooModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Foo>(list);
                } else {
                    list = (List<Foo>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the foos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Foo foo : findAll()) {
            remove(foo);
        }
    }

    /**
     * Returns the number of foos.
     *
     * @return the number of foos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_FOO);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the foo persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.nl.ou.test.model.Foo")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Foo>> listenersList = new ArrayList<ModelListener<Foo>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Foo>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(FooImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
