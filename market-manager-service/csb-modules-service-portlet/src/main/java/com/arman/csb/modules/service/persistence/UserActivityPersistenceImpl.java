package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.NoSuchUserActivityException;
import com.arman.csb.modules.model.UserActivity;
import com.arman.csb.modules.model.impl.UserActivityImpl;
import com.arman.csb.modules.model.impl.UserActivityModelImpl;
import com.arman.csb.modules.service.persistence.UserActivityPersistence;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the user activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserActivityPersistence
 * @see UserActivityUtil
 * @generated
 */
public class UserActivityPersistenceImpl extends BasePersistenceImpl<UserActivity>
    implements UserActivityPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link UserActivityUtil} to access the user activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = UserActivityImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, UserActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, UserActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, UserActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, UserActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            UserActivityModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "userActivity.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "userActivity.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(userActivity.uuid IS NULL OR userActivity.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, UserActivityImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            UserActivityModelImpl.UUID_COLUMN_BITMASK |
            UserActivityModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "userActivity.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "userActivity.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(userActivity.uuid IS NULL OR userActivity.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "userActivity.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, UserActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, UserActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            UserActivityModelImpl.UUID_COLUMN_BITMASK |
            UserActivityModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "userActivity.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "userActivity.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(userActivity.uuid IS NULL OR userActivity.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "userActivity.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, UserActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, UserActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
            new String[] { Long.class.getName() },
            UserActivityModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "userActivity.userId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTITY = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, UserActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEntity",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITY =
        new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, UserActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEntity",
            new String[] { String.class.getName() },
            UserActivityModelImpl.ENTITY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ENTITY = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEntity",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_ENTITY_ENTITY_1 = "userActivity.entity IS NULL";
    private static final String _FINDER_COLUMN_ENTITY_ENTITY_2 = "userActivity.entity = ?";
    private static final String _FINDER_COLUMN_ENTITY_ENTITY_3 = "(userActivity.entity IS NULL OR userActivity.entity = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTION = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, UserActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAction",
            new String[] {
                Short.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTION =
        new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, UserActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAction",
            new String[] { Short.class.getName() },
            UserActivityModelImpl.ACTION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTION = new FinderPath(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAction",
            new String[] { Short.class.getName() });
    private static final String _FINDER_COLUMN_ACTION_ACTION_2 = "userActivity.action = ?";
    private static final String _SQL_SELECT_USERACTIVITY = "SELECT userActivity FROM UserActivity userActivity";
    private static final String _SQL_SELECT_USERACTIVITY_WHERE = "SELECT userActivity FROM UserActivity userActivity WHERE ";
    private static final String _SQL_COUNT_USERACTIVITY = "SELECT COUNT(userActivity) FROM UserActivity userActivity";
    private static final String _SQL_COUNT_USERACTIVITY_WHERE = "SELECT COUNT(userActivity) FROM UserActivity userActivity WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "userActivity.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserActivity exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserActivity exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(UserActivityPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid", "id", "data"
            });
    private static UserActivity _nullUserActivity = new UserActivityImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<UserActivity> toCacheModel() {
                return _nullUserActivityCacheModel;
            }
        };

    private static CacheModel<UserActivity> _nullUserActivityCacheModel = new CacheModel<UserActivity>() {
            @Override
            public UserActivity toEntityModel() {
                return _nullUserActivity;
            }
        };

    public UserActivityPersistenceImpl() {
        setModelClass(UserActivity.class);
    }

    /**
     * Returns all the user activities where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the user activities where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of user activities
     * @param end the upper bound of the range of user activities (not inclusive)
     * @return the range of matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the user activities where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of user activities
     * @param end the upper bound of the range of user activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByUuid(String uuid, int start, int end,
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

        List<UserActivity> list = (List<UserActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (UserActivity userActivity : list) {
                if (!Validator.equals(uuid, userActivity.getUuid())) {
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

            query.append(_SQL_SELECT_USERACTIVITY_WHERE);

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
                query.append(UserActivityModelImpl.ORDER_BY_JPQL);
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
                    list = (List<UserActivity>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<UserActivity>(list);
                } else {
                    list = (List<UserActivity>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first user activity in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = fetchByUuid_First(uuid, orderByComparator);

        if (userActivity != null) {
            return userActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUserActivityException(msg.toString());
    }

    /**
     * Returns the first user activity in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching user activity, or <code>null</code> if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<UserActivity> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last user activity in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = fetchByUuid_Last(uuid, orderByComparator);

        if (userActivity != null) {
            return userActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUserActivityException(msg.toString());
    }

    /**
     * Returns the last user activity in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching user activity, or <code>null</code> if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<UserActivity> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the user activities before and after the current user activity in the ordered set where uuid = &#63;.
     *
     * @param id the primary key of the current user activity
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity[] findByUuid_PrevAndNext(long id, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            UserActivity[] array = new UserActivityImpl[3];

            array[0] = getByUuid_PrevAndNext(session, userActivity, uuid,
                    orderByComparator, true);

            array[1] = userActivity;

            array[2] = getByUuid_PrevAndNext(session, userActivity, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected UserActivity getByUuid_PrevAndNext(Session session,
        UserActivity userActivity, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_USERACTIVITY_WHERE);

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
            query.append(UserActivityModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(userActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<UserActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the user activities where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (UserActivity userActivity : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(userActivity);
        }
    }

    /**
     * Returns the number of user activities where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching user activities
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

            query.append(_SQL_COUNT_USERACTIVITY_WHERE);

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
     * Returns the user activity where uuid = &#63; and groupId = &#63; or throws a {@link com.arman.csb.modules.NoSuchUserActivityException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity findByUUID_G(String uuid, long groupId)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = fetchByUUID_G(uuid, groupId);

        if (userActivity == null) {
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

            throw new NoSuchUserActivityException(msg.toString());
        }

        return userActivity;
    }

    /**
     * Returns the user activity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching user activity, or <code>null</code> if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the user activity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching user activity, or <code>null</code> if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof UserActivity) {
            UserActivity userActivity = (UserActivity) result;

            if (!Validator.equals(uuid, userActivity.getUuid()) ||
                    (groupId != userActivity.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_USERACTIVITY_WHERE);

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

                List<UserActivity> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    UserActivity userActivity = list.get(0);

                    result = userActivity;

                    cacheResult(userActivity);

                    if ((userActivity.getUuid() == null) ||
                            !userActivity.getUuid().equals(uuid) ||
                            (userActivity.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, userActivity);
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
            return (UserActivity) result;
        }
    }

    /**
     * Removes the user activity where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the user activity that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity removeByUUID_G(String uuid, long groupId)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = findByUUID_G(uuid, groupId);

        return remove(userActivity);
    }

    /**
     * Returns the number of user activities where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching user activities
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

            query.append(_SQL_COUNT_USERACTIVITY_WHERE);

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
     * Returns all the user activities where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the user activities where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of user activities
     * @param end the upper bound of the range of user activities (not inclusive)
     * @return the range of matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByUuid_C(String uuid, long companyId,
        int start, int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the user activities where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of user activities
     * @param end the upper bound of the range of user activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByUuid_C(String uuid, long companyId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
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

        List<UserActivity> list = (List<UserActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (UserActivity userActivity : list) {
                if (!Validator.equals(uuid, userActivity.getUuid()) ||
                        (companyId != userActivity.getCompanyId())) {
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

            query.append(_SQL_SELECT_USERACTIVITY_WHERE);

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
                query.append(UserActivityModelImpl.ORDER_BY_JPQL);
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
                    list = (List<UserActivity>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<UserActivity>(list);
                } else {
                    list = (List<UserActivity>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first user activity in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (userActivity != null) {
            return userActivity;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUserActivityException(msg.toString());
    }

    /**
     * Returns the first user activity in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching user activity, or <code>null</code> if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<UserActivity> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last user activity in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (userActivity != null) {
            return userActivity;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUserActivityException(msg.toString());
    }

    /**
     * Returns the last user activity in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching user activity, or <code>null</code> if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<UserActivity> list = findByUuid_C(uuid, companyId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the user activities before and after the current user activity in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param id the primary key of the current user activity
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity[] findByUuid_C_PrevAndNext(long id, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            UserActivity[] array = new UserActivityImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, userActivity, uuid,
                    companyId, orderByComparator, true);

            array[1] = userActivity;

            array[2] = getByUuid_C_PrevAndNext(session, userActivity, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected UserActivity getByUuid_C_PrevAndNext(Session session,
        UserActivity userActivity, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_USERACTIVITY_WHERE);

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
            query.append(UserActivityModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(userActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<UserActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the user activities where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (UserActivity userActivity : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(userActivity);
        }
    }

    /**
     * Returns the number of user activities where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching user activities
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

            query.append(_SQL_COUNT_USERACTIVITY_WHERE);

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
     * Returns all the user activities where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByUserId(long userId)
        throws SystemException {
        return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the user activities where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of user activities
     * @param end the upper bound of the range of user activities (not inclusive)
     * @return the range of matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    /**
     * Returns an ordered range of all the user activities where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of user activities
     * @param end the upper bound of the range of user activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByUserId(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<UserActivity> list = (List<UserActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (UserActivity userActivity : list) {
                if ((userId != userActivity.getUserId())) {
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

            query.append(_SQL_SELECT_USERACTIVITY_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(UserActivityModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<UserActivity>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<UserActivity>(list);
                } else {
                    list = (List<UserActivity>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first user activity in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity findByUserId_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = fetchByUserId_First(userId,
                orderByComparator);

        if (userActivity != null) {
            return userActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUserActivityException(msg.toString());
    }

    /**
     * Returns the first user activity in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching user activity, or <code>null</code> if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity fetchByUserId_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<UserActivity> list = findByUserId(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last user activity in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity findByUserId_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = fetchByUserId_Last(userId, orderByComparator);

        if (userActivity != null) {
            return userActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUserActivityException(msg.toString());
    }

    /**
     * Returns the last user activity in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching user activity, or <code>null</code> if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity fetchByUserId_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserId(userId);

        if (count == 0) {
            return null;
        }

        List<UserActivity> list = findByUserId(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the user activities before and after the current user activity in the ordered set where userId = &#63;.
     *
     * @param id the primary key of the current user activity
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity[] findByUserId_PrevAndNext(long id, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            UserActivity[] array = new UserActivityImpl[3];

            array[0] = getByUserId_PrevAndNext(session, userActivity, userId,
                    orderByComparator, true);

            array[1] = userActivity;

            array[2] = getByUserId_PrevAndNext(session, userActivity, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected UserActivity getByUserId_PrevAndNext(Session session,
        UserActivity userActivity, long userId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_USERACTIVITY_WHERE);

        query.append(_FINDER_COLUMN_USERID_USERID_2);

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
            query.append(UserActivityModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(userActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<UserActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the user activities where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserId(long userId) throws SystemException {
        for (UserActivity userActivity : findByUserId(userId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(userActivity);
        }
    }

    /**
     * Returns the number of user activities where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserId(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_USERACTIVITY_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

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
     * Returns all the user activities where entity = &#63;.
     *
     * @param entity the entity
     * @return the matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByEntity(String entity)
        throws SystemException {
        return findByEntity(entity, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the user activities where entity = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param entity the entity
     * @param start the lower bound of the range of user activities
     * @param end the upper bound of the range of user activities (not inclusive)
     * @return the range of matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByEntity(String entity, int start, int end)
        throws SystemException {
        return findByEntity(entity, start, end, null);
    }

    /**
     * Returns an ordered range of all the user activities where entity = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param entity the entity
     * @param start the lower bound of the range of user activities
     * @param end the upper bound of the range of user activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByEntity(String entity, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITY;
            finderArgs = new Object[] { entity };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTITY;
            finderArgs = new Object[] { entity, start, end, orderByComparator };
        }

        List<UserActivity> list = (List<UserActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (UserActivity userActivity : list) {
                if (!Validator.equals(entity, userActivity.getEntity())) {
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

            query.append(_SQL_SELECT_USERACTIVITY_WHERE);

            boolean bindEntity = false;

            if (entity == null) {
                query.append(_FINDER_COLUMN_ENTITY_ENTITY_1);
            } else if (entity.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ENTITY_ENTITY_3);
            } else {
                bindEntity = true;

                query.append(_FINDER_COLUMN_ENTITY_ENTITY_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(UserActivityModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEntity) {
                    qPos.add(entity);
                }

                if (!pagination) {
                    list = (List<UserActivity>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<UserActivity>(list);
                } else {
                    list = (List<UserActivity>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first user activity in the ordered set where entity = &#63;.
     *
     * @param entity the entity
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity findByEntity_First(String entity,
        OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = fetchByEntity_First(entity,
                orderByComparator);

        if (userActivity != null) {
            return userActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("entity=");
        msg.append(entity);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUserActivityException(msg.toString());
    }

    /**
     * Returns the first user activity in the ordered set where entity = &#63;.
     *
     * @param entity the entity
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching user activity, or <code>null</code> if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity fetchByEntity_First(String entity,
        OrderByComparator orderByComparator) throws SystemException {
        List<UserActivity> list = findByEntity(entity, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last user activity in the ordered set where entity = &#63;.
     *
     * @param entity the entity
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity findByEntity_Last(String entity,
        OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = fetchByEntity_Last(entity, orderByComparator);

        if (userActivity != null) {
            return userActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("entity=");
        msg.append(entity);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUserActivityException(msg.toString());
    }

    /**
     * Returns the last user activity in the ordered set where entity = &#63;.
     *
     * @param entity the entity
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching user activity, or <code>null</code> if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity fetchByEntity_Last(String entity,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByEntity(entity);

        if (count == 0) {
            return null;
        }

        List<UserActivity> list = findByEntity(entity, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the user activities before and after the current user activity in the ordered set where entity = &#63;.
     *
     * @param id the primary key of the current user activity
     * @param entity the entity
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity[] findByEntity_PrevAndNext(long id, String entity,
        OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            UserActivity[] array = new UserActivityImpl[3];

            array[0] = getByEntity_PrevAndNext(session, userActivity, entity,
                    orderByComparator, true);

            array[1] = userActivity;

            array[2] = getByEntity_PrevAndNext(session, userActivity, entity,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected UserActivity getByEntity_PrevAndNext(Session session,
        UserActivity userActivity, String entity,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_USERACTIVITY_WHERE);

        boolean bindEntity = false;

        if (entity == null) {
            query.append(_FINDER_COLUMN_ENTITY_ENTITY_1);
        } else if (entity.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_ENTITY_ENTITY_3);
        } else {
            bindEntity = true;

            query.append(_FINDER_COLUMN_ENTITY_ENTITY_2);
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
            query.append(UserActivityModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindEntity) {
            qPos.add(entity);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(userActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<UserActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the user activities where entity = &#63; from the database.
     *
     * @param entity the entity
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByEntity(String entity) throws SystemException {
        for (UserActivity userActivity : findByEntity(entity,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(userActivity);
        }
    }

    /**
     * Returns the number of user activities where entity = &#63;.
     *
     * @param entity the entity
     * @return the number of matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByEntity(String entity) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTITY;

        Object[] finderArgs = new Object[] { entity };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_USERACTIVITY_WHERE);

            boolean bindEntity = false;

            if (entity == null) {
                query.append(_FINDER_COLUMN_ENTITY_ENTITY_1);
            } else if (entity.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ENTITY_ENTITY_3);
            } else {
                bindEntity = true;

                query.append(_FINDER_COLUMN_ENTITY_ENTITY_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEntity) {
                    qPos.add(entity);
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
     * Returns all the user activities where action = &#63;.
     *
     * @param action the action
     * @return the matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByAction(Short action)
        throws SystemException {
        return findByAction(action, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the user activities where action = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param action the action
     * @param start the lower bound of the range of user activities
     * @param end the upper bound of the range of user activities (not inclusive)
     * @return the range of matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByAction(Short action, int start, int end)
        throws SystemException {
        return findByAction(action, start, end, null);
    }

    /**
     * Returns an ordered range of all the user activities where action = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param action the action
     * @param start the lower bound of the range of user activities
     * @param end the upper bound of the range of user activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findByAction(Short action, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTION;
            finderArgs = new Object[] { action };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTION;
            finderArgs = new Object[] { action, start, end, orderByComparator };
        }

        List<UserActivity> list = (List<UserActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (UserActivity userActivity : list) {
                if (!Validator.equals(action, userActivity.getAction())) {
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

            query.append(_SQL_SELECT_USERACTIVITY_WHERE);

            query.append(_FINDER_COLUMN_ACTION_ACTION_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(UserActivityModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(action.shortValue());

                if (!pagination) {
                    list = (List<UserActivity>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<UserActivity>(list);
                } else {
                    list = (List<UserActivity>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first user activity in the ordered set where action = &#63;.
     *
     * @param action the action
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity findByAction_First(Short action,
        OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = fetchByAction_First(action,
                orderByComparator);

        if (userActivity != null) {
            return userActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("action=");
        msg.append(action);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUserActivityException(msg.toString());
    }

    /**
     * Returns the first user activity in the ordered set where action = &#63;.
     *
     * @param action the action
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching user activity, or <code>null</code> if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity fetchByAction_First(Short action,
        OrderByComparator orderByComparator) throws SystemException {
        List<UserActivity> list = findByAction(action, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last user activity in the ordered set where action = &#63;.
     *
     * @param action the action
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity findByAction_Last(Short action,
        OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = fetchByAction_Last(action, orderByComparator);

        if (userActivity != null) {
            return userActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("action=");
        msg.append(action);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchUserActivityException(msg.toString());
    }

    /**
     * Returns the last user activity in the ordered set where action = &#63;.
     *
     * @param action the action
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching user activity, or <code>null</code> if a matching user activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity fetchByAction_Last(Short action,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByAction(action);

        if (count == 0) {
            return null;
        }

        List<UserActivity> list = findByAction(action, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the user activities before and after the current user activity in the ordered set where action = &#63;.
     *
     * @param id the primary key of the current user activity
     * @param action the action
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity[] findByAction_PrevAndNext(long id, Short action,
        OrderByComparator orderByComparator)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            UserActivity[] array = new UserActivityImpl[3];

            array[0] = getByAction_PrevAndNext(session, userActivity, action,
                    orderByComparator, true);

            array[1] = userActivity;

            array[2] = getByAction_PrevAndNext(session, userActivity, action,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected UserActivity getByAction_PrevAndNext(Session session,
        UserActivity userActivity, Short action,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_USERACTIVITY_WHERE);

        query.append(_FINDER_COLUMN_ACTION_ACTION_2);

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
            query.append(UserActivityModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(action.shortValue());

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(userActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<UserActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the user activities where action = &#63; from the database.
     *
     * @param action the action
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAction(Short action) throws SystemException {
        for (UserActivity userActivity : findByAction(action,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(userActivity);
        }
    }

    /**
     * Returns the number of user activities where action = &#63;.
     *
     * @param action the action
     * @return the number of matching user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAction(Short action) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTION;

        Object[] finderArgs = new Object[] { action };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_USERACTIVITY_WHERE);

            query.append(_FINDER_COLUMN_ACTION_ACTION_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(action.shortValue());

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
     * Caches the user activity in the entity cache if it is enabled.
     *
     * @param userActivity the user activity
     */
    @Override
    public void cacheResult(UserActivity userActivity) {
        EntityCacheUtil.putResult(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityImpl.class, userActivity.getPrimaryKey(), userActivity);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { userActivity.getUuid(), userActivity.getGroupId() },
            userActivity);

        userActivity.resetOriginalValues();
    }

    /**
     * Caches the user activities in the entity cache if it is enabled.
     *
     * @param userActivities the user activities
     */
    @Override
    public void cacheResult(List<UserActivity> userActivities) {
        for (UserActivity userActivity : userActivities) {
            if (EntityCacheUtil.getResult(
                        UserActivityModelImpl.ENTITY_CACHE_ENABLED,
                        UserActivityImpl.class, userActivity.getPrimaryKey()) == null) {
                cacheResult(userActivity);
            } else {
                userActivity.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all user activities.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(UserActivityImpl.class.getName());
        }

        EntityCacheUtil.clearCache(UserActivityImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the user activity.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(UserActivity userActivity) {
        EntityCacheUtil.removeResult(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityImpl.class, userActivity.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(userActivity);
    }

    @Override
    public void clearCache(List<UserActivity> userActivities) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (UserActivity userActivity : userActivities) {
            EntityCacheUtil.removeResult(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
                UserActivityImpl.class, userActivity.getPrimaryKey());

            clearUniqueFindersCache(userActivity);
        }
    }

    protected void cacheUniqueFindersCache(UserActivity userActivity) {
        if (userActivity.isNew()) {
            Object[] args = new Object[] {
                    userActivity.getUuid(), userActivity.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                userActivity);
        } else {
            UserActivityModelImpl userActivityModelImpl = (UserActivityModelImpl) userActivity;

            if ((userActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        userActivity.getUuid(), userActivity.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    userActivity);
            }
        }
    }

    protected void clearUniqueFindersCache(UserActivity userActivity) {
        UserActivityModelImpl userActivityModelImpl = (UserActivityModelImpl) userActivity;

        Object[] args = new Object[] {
                userActivity.getUuid(), userActivity.getGroupId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((userActivityModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    userActivityModelImpl.getOriginalUuid(),
                    userActivityModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new user activity with the primary key. Does not add the user activity to the database.
     *
     * @param id the primary key for the new user activity
     * @return the new user activity
     */
    @Override
    public UserActivity create(long id) {
        UserActivity userActivity = new UserActivityImpl();

        userActivity.setNew(true);
        userActivity.setPrimaryKey(id);

        String uuid = PortalUUIDUtil.generate();

        userActivity.setUuid(uuid);

        return userActivity;
    }

    /**
     * Removes the user activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the user activity
     * @return the user activity that was removed
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity remove(long id)
        throws NoSuchUserActivityException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the user activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the user activity
     * @return the user activity that was removed
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity remove(Serializable primaryKey)
        throws NoSuchUserActivityException, SystemException {
        Session session = null;

        try {
            session = openSession();

            UserActivity userActivity = (UserActivity) session.get(UserActivityImpl.class,
                    primaryKey);

            if (userActivity == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchUserActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(userActivity);
        } catch (NoSuchUserActivityException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected UserActivity removeImpl(UserActivity userActivity)
        throws SystemException {
        userActivity = toUnwrappedModel(userActivity);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(userActivity)) {
                userActivity = (UserActivity) session.get(UserActivityImpl.class,
                        userActivity.getPrimaryKeyObj());
            }

            if (userActivity != null) {
                session.delete(userActivity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (userActivity != null) {
            clearCache(userActivity);
        }

        return userActivity;
    }

    @Override
    public UserActivity updateImpl(
        com.arman.csb.modules.model.UserActivity userActivity)
        throws SystemException {
        userActivity = toUnwrappedModel(userActivity);

        boolean isNew = userActivity.isNew();

        UserActivityModelImpl userActivityModelImpl = (UserActivityModelImpl) userActivity;

        if (Validator.isNull(userActivity.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            userActivity.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (userActivity.isNew()) {
                session.save(userActivity);

                userActivity.setNew(false);
            } else {
                session.merge(userActivity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !UserActivityModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((userActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        userActivityModelImpl.getOriginalUuid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { userActivityModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((userActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        userActivityModelImpl.getOriginalUuid(),
                        userActivityModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        userActivityModelImpl.getUuid(),
                        userActivityModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((userActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        userActivityModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { userActivityModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }

            if ((userActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        userActivityModelImpl.getOriginalEntity()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITY, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITY,
                    args);

                args = new Object[] { userActivityModelImpl.getEntity() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITY, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITY,
                    args);
            }

            if ((userActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        userActivityModelImpl.getOriginalAction()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTION, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTION,
                    args);

                args = new Object[] { userActivityModelImpl.getAction() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTION, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTION,
                    args);
            }
        }

        EntityCacheUtil.putResult(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
            UserActivityImpl.class, userActivity.getPrimaryKey(), userActivity);

        clearUniqueFindersCache(userActivity);
        cacheUniqueFindersCache(userActivity);

        return userActivity;
    }

    protected UserActivity toUnwrappedModel(UserActivity userActivity) {
        if (userActivity instanceof UserActivityImpl) {
            return userActivity;
        }

        UserActivityImpl userActivityImpl = new UserActivityImpl();

        userActivityImpl.setNew(userActivity.isNew());
        userActivityImpl.setPrimaryKey(userActivity.getPrimaryKey());

        userActivityImpl.setUuid(userActivity.getUuid());
        userActivityImpl.setId(userActivity.getId());
        userActivityImpl.setGroupId(userActivity.getGroupId());
        userActivityImpl.setCompanyId(userActivity.getCompanyId());
        userActivityImpl.setUserId(userActivity.getUserId());
        userActivityImpl.setUserName(userActivity.getUserName());
        userActivityImpl.setCreateDate(userActivity.getCreateDate());
        userActivityImpl.setEntity(userActivity.getEntity());
        userActivityImpl.setAction(userActivity.getAction());
        userActivityImpl.setImportance(userActivity.getImportance());
        userActivityImpl.setData(userActivity.getData());

        return userActivityImpl;
    }

    /**
     * Returns the user activity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the user activity
     * @return the user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity findByPrimaryKey(Serializable primaryKey)
        throws NoSuchUserActivityException, SystemException {
        UserActivity userActivity = fetchByPrimaryKey(primaryKey);

        if (userActivity == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchUserActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return userActivity;
    }

    /**
     * Returns the user activity with the primary key or throws a {@link com.arman.csb.modules.NoSuchUserActivityException} if it could not be found.
     *
     * @param id the primary key of the user activity
     * @return the user activity
     * @throws com.arman.csb.modules.NoSuchUserActivityException if a user activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity findByPrimaryKey(long id)
        throws NoSuchUserActivityException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the user activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the user activity
     * @return the user activity, or <code>null</code> if a user activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        UserActivity userActivity = (UserActivity) EntityCacheUtil.getResult(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
                UserActivityImpl.class, primaryKey);

        if (userActivity == _nullUserActivity) {
            return null;
        }

        if (userActivity == null) {
            Session session = null;

            try {
                session = openSession();

                userActivity = (UserActivity) session.get(UserActivityImpl.class,
                        primaryKey);

                if (userActivity != null) {
                    cacheResult(userActivity);
                } else {
                    EntityCacheUtil.putResult(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
                        UserActivityImpl.class, primaryKey, _nullUserActivity);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(UserActivityModelImpl.ENTITY_CACHE_ENABLED,
                    UserActivityImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return userActivity;
    }

    /**
     * Returns the user activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the user activity
     * @return the user activity, or <code>null</code> if a user activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserActivity fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the user activities.
     *
     * @return the user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the user activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of user activities
     * @param end the upper bound of the range of user activities (not inclusive)
     * @return the range of user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the user activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.UserActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of user activities
     * @param end the upper bound of the range of user activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of user activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserActivity> findAll(int start, int end,
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

        List<UserActivity> list = (List<UserActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_USERACTIVITY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_USERACTIVITY;

                if (pagination) {
                    sql = sql.concat(UserActivityModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<UserActivity>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<UserActivity>(list);
                } else {
                    list = (List<UserActivity>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the user activities from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (UserActivity userActivity : findAll()) {
            remove(userActivity);
        }
    }

    /**
     * Returns the number of user activities.
     *
     * @return the number of user activities
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

                Query q = session.createQuery(_SQL_COUNT_USERACTIVITY);

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
     * Initializes the user activity persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arman.csb.modules.model.UserActivity")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<UserActivity>> listenersList = new ArrayList<ModelListener<UserActivity>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<UserActivity>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(UserActivityImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
