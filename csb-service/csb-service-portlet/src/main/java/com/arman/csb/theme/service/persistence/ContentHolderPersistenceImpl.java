package com.arman.csb.theme.service.persistence;

import com.arman.csb.theme.NoSuchContentHolderException;
import com.arman.csb.theme.model.ContentHolder;
import com.arman.csb.theme.model.impl.ContentHolderImpl;
import com.arman.csb.theme.model.impl.ContentHolderModelImpl;
import com.arman.csb.theme.service.persistence.ContentHolderPersistence;

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
 * The persistence implementation for the content holder service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContentHolderPersistence
 * @see ContentHolderUtil
 * @generated
 */
public class ContentHolderPersistenceImpl extends BasePersistenceImpl<ContentHolder>
    implements ContentHolderPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ContentHolderUtil} to access the content holder persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ContentHolderImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderModelImpl.FINDER_CACHE_ENABLED,
            ContentHolderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderModelImpl.FINDER_CACHE_ENABLED,
            ContentHolderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderModelImpl.FINDER_CACHE_ENABLED,
            ContentHolderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderModelImpl.FINDER_CACHE_ENABLED,
            ContentHolderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByUuid", new String[] { String.class.getName() },
            ContentHolderModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "contentHolder.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "contentHolder.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(contentHolder.uuid IS NULL OR contentHolder.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderModelImpl.FINDER_CACHE_ENABLED,
            ContentHolderImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            ContentHolderModelImpl.UUID_COLUMN_BITMASK |
            ContentHolderModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "contentHolder.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "contentHolder.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(contentHolder.uuid IS NULL OR contentHolder.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "contentHolder.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderModelImpl.FINDER_CACHE_ENABLED,
            ContentHolderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderModelImpl.FINDER_CACHE_ENABLED,
            ContentHolderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            ContentHolderModelImpl.UUID_COLUMN_BITMASK |
            ContentHolderModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "contentHolder.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "contentHolder.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(contentHolder.uuid IS NULL OR contentHolder.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "contentHolder.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDNAME =
        new FinderPath(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderModelImpl.FINDER_CACHE_ENABLED,
            ContentHolderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCompanyIdAndName",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDNAME =
        new FinderPath(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderModelImpl.FINDER_CACHE_ENABLED,
            ContentHolderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCompanyIdAndName",
            new String[] { Long.class.getName(), String.class.getName() },
            ContentHolderModelImpl.COMPANYID_COLUMN_BITMASK |
            ContentHolderModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDNAME = new FinderPath(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCompanyIdAndName",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYIDANDNAME_COMPANYID_2 = "contentHolder.companyId = ? AND ";
    private static final String _FINDER_COLUMN_COMPANYIDANDNAME_NAME_1 = "contentHolder.name IS NULL";
    private static final String _FINDER_COLUMN_COMPANYIDANDNAME_NAME_2 = "contentHolder.name = ?";
    private static final String _FINDER_COLUMN_COMPANYIDANDNAME_NAME_3 = "(contentHolder.name IS NULL OR contentHolder.name = '')";
    private static final String _SQL_SELECT_CONTENTHOLDER = "SELECT contentHolder FROM ContentHolder contentHolder";
    private static final String _SQL_SELECT_CONTENTHOLDER_WHERE = "SELECT contentHolder FROM ContentHolder contentHolder WHERE ";
    private static final String _SQL_COUNT_CONTENTHOLDER = "SELECT COUNT(contentHolder) FROM ContentHolder contentHolder";
    private static final String _SQL_COUNT_CONTENTHOLDER_WHERE = "SELECT COUNT(contentHolder) FROM ContentHolder contentHolder WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "contentHolder.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContentHolder exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContentHolder exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ContentHolderPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid", "id"
            });
    private static ContentHolder _nullContentHolder = new ContentHolderImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ContentHolder> toCacheModel() {
                return _nullContentHolderCacheModel;
            }
        };

    private static CacheModel<ContentHolder> _nullContentHolderCacheModel = new CacheModel<ContentHolder>() {
            @Override
            public ContentHolder toEntityModel() {
                return _nullContentHolder;
            }
        };

    public ContentHolderPersistenceImpl() {
        setModelClass(ContentHolder.class);
    }

    /**
     * Returns all the content holders where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching content holders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ContentHolder> findByUuid(String uuid)
        throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the content holders where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of content holders
     * @param end the upper bound of the range of content holders (not inclusive)
     * @return the range of matching content holders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ContentHolder> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the content holders where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of content holders
     * @param end the upper bound of the range of content holders (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching content holders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ContentHolder> findByUuid(String uuid, int start, int end,
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

        List<ContentHolder> list = (List<ContentHolder>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ContentHolder contentHolder : list) {
                if (!Validator.equals(uuid, contentHolder.getUuid())) {
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

            query.append(_SQL_SELECT_CONTENTHOLDER_WHERE);

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
                query.append(ContentHolderModelImpl.ORDER_BY_JPQL);
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
                    list = (List<ContentHolder>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ContentHolder>(list);
                } else {
                    list = (List<ContentHolder>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Returns the first content holder in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching content holder
     * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchContentHolderException, SystemException {
        ContentHolder contentHolder = fetchByUuid_First(uuid, orderByComparator);

        if (contentHolder != null) {
            return contentHolder;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContentHolderException(msg.toString());
    }

    /**
     * Returns the first content holder in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching content holder, or <code>null</code> if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<ContentHolder> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last content holder in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching content holder
     * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchContentHolderException, SystemException {
        ContentHolder contentHolder = fetchByUuid_Last(uuid, orderByComparator);

        if (contentHolder != null) {
            return contentHolder;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContentHolderException(msg.toString());
    }

    /**
     * Returns the last content holder in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching content holder, or <code>null</code> if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<ContentHolder> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the content holders before and after the current content holder in the ordered set where uuid = &#63;.
     *
     * @param id the primary key of the current content holder
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next content holder
     * @throws com.arman.csb.theme.NoSuchContentHolderException if a content holder with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder[] findByUuid_PrevAndNext(long id, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchContentHolderException, SystemException {
        ContentHolder contentHolder = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            ContentHolder[] array = new ContentHolderImpl[3];

            array[0] = getByUuid_PrevAndNext(session, contentHolder, uuid,
                    orderByComparator, true);

            array[1] = contentHolder;

            array[2] = getByUuid_PrevAndNext(session, contentHolder, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ContentHolder getByUuid_PrevAndNext(Session session,
        ContentHolder contentHolder, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONTENTHOLDER_WHERE);

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
            query.append(ContentHolderModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(contentHolder);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ContentHolder> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the content holders where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (ContentHolder contentHolder : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(contentHolder);
        }
    }

    /**
     * Returns the number of content holders where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching content holders
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

            query.append(_SQL_COUNT_CONTENTHOLDER_WHERE);

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
     * Returns the content holder where uuid = &#63; and groupId = &#63; or throws a {@link com.arman.csb.theme.NoSuchContentHolderException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching content holder
     * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder findByUUID_G(String uuid, long groupId)
        throws NoSuchContentHolderException, SystemException {
        ContentHolder contentHolder = fetchByUUID_G(uuid, groupId);

        if (contentHolder == null) {
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

            throw new NoSuchContentHolderException(msg.toString());
        }

        return contentHolder;
    }

    /**
     * Returns the content holder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching content holder, or <code>null</code> if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the content holder where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching content holder, or <code>null</code> if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof ContentHolder) {
            ContentHolder contentHolder = (ContentHolder) result;

            if (!Validator.equals(uuid, contentHolder.getUuid()) ||
                    (groupId != contentHolder.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_CONTENTHOLDER_WHERE);

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

                List<ContentHolder> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    ContentHolder contentHolder = list.get(0);

                    result = contentHolder;

                    cacheResult(contentHolder);

                    if ((contentHolder.getUuid() == null) ||
                            !contentHolder.getUuid().equals(uuid) ||
                            (contentHolder.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, contentHolder);
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
            return (ContentHolder) result;
        }
    }

    /**
     * Removes the content holder where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the content holder that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder removeByUUID_G(String uuid, long groupId)
        throws NoSuchContentHolderException, SystemException {
        ContentHolder contentHolder = findByUUID_G(uuid, groupId);

        return remove(contentHolder);
    }

    /**
     * Returns the number of content holders where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching content holders
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

            query.append(_SQL_COUNT_CONTENTHOLDER_WHERE);

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
     * Returns all the content holders where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching content holders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ContentHolder> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the content holders where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of content holders
     * @param end the upper bound of the range of content holders (not inclusive)
     * @return the range of matching content holders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ContentHolder> findByUuid_C(String uuid, long companyId,
        int start, int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the content holders where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of content holders
     * @param end the upper bound of the range of content holders (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching content holders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ContentHolder> findByUuid_C(String uuid, long companyId,
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

        List<ContentHolder> list = (List<ContentHolder>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ContentHolder contentHolder : list) {
                if (!Validator.equals(uuid, contentHolder.getUuid()) ||
                        (companyId != contentHolder.getCompanyId())) {
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

            query.append(_SQL_SELECT_CONTENTHOLDER_WHERE);

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
                query.append(ContentHolderModelImpl.ORDER_BY_JPQL);
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
                    list = (List<ContentHolder>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ContentHolder>(list);
                } else {
                    list = (List<ContentHolder>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Returns the first content holder in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching content holder
     * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchContentHolderException, SystemException {
        ContentHolder contentHolder = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (contentHolder != null) {
            return contentHolder;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContentHolderException(msg.toString());
    }

    /**
     * Returns the first content holder in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching content holder, or <code>null</code> if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ContentHolder> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last content holder in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching content holder
     * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchContentHolderException, SystemException {
        ContentHolder contentHolder = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (contentHolder != null) {
            return contentHolder;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContentHolderException(msg.toString());
    }

    /**
     * Returns the last content holder in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching content holder, or <code>null</code> if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<ContentHolder> list = findByUuid_C(uuid, companyId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the content holders before and after the current content holder in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param id the primary key of the current content holder
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next content holder
     * @throws com.arman.csb.theme.NoSuchContentHolderException if a content holder with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder[] findByUuid_C_PrevAndNext(long id, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchContentHolderException, SystemException {
        ContentHolder contentHolder = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            ContentHolder[] array = new ContentHolderImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, contentHolder, uuid,
                    companyId, orderByComparator, true);

            array[1] = contentHolder;

            array[2] = getByUuid_C_PrevAndNext(session, contentHolder, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ContentHolder getByUuid_C_PrevAndNext(Session session,
        ContentHolder contentHolder, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONTENTHOLDER_WHERE);

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
            query.append(ContentHolderModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(contentHolder);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ContentHolder> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the content holders where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (ContentHolder contentHolder : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(contentHolder);
        }
    }

    /**
     * Returns the number of content holders where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching content holders
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

            query.append(_SQL_COUNT_CONTENTHOLDER_WHERE);

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
     * Returns all the content holders where companyId = &#63; and name = &#63;.
     *
     * @param companyId the company ID
     * @param name the name
     * @return the matching content holders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ContentHolder> findByCompanyIdAndName(long companyId,
        String name) throws SystemException {
        return findByCompanyIdAndName(companyId, name, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the content holders where companyId = &#63; and name = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param name the name
     * @param start the lower bound of the range of content holders
     * @param end the upper bound of the range of content holders (not inclusive)
     * @return the range of matching content holders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ContentHolder> findByCompanyIdAndName(long companyId,
        String name, int start, int end) throws SystemException {
        return findByCompanyIdAndName(companyId, name, start, end, null);
    }

    /**
     * Returns an ordered range of all the content holders where companyId = &#63; and name = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param name the name
     * @param start the lower bound of the range of content holders
     * @param end the upper bound of the range of content holders (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching content holders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ContentHolder> findByCompanyIdAndName(long companyId,
        String name, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDNAME;
            finderArgs = new Object[] { companyId, name };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDNAME;
            finderArgs = new Object[] {
                    companyId, name,
                    
                    start, end, orderByComparator
                };
        }

        List<ContentHolder> list = (List<ContentHolder>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ContentHolder contentHolder : list) {
                if ((companyId != contentHolder.getCompanyId()) ||
                        !Validator.equals(name, contentHolder.getName())) {
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

            query.append(_SQL_SELECT_CONTENTHOLDER_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDNAME_COMPANYID_2);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_COMPANYIDANDNAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COMPANYIDANDNAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_COMPANYIDANDNAME_NAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ContentHolderModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (bindName) {
                    qPos.add(name);
                }

                if (!pagination) {
                    list = (List<ContentHolder>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ContentHolder>(list);
                } else {
                    list = (List<ContentHolder>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Returns the first content holder in the ordered set where companyId = &#63; and name = &#63;.
     *
     * @param companyId the company ID
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching content holder
     * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder findByCompanyIdAndName_First(long companyId,
        String name, OrderByComparator orderByComparator)
        throws NoSuchContentHolderException, SystemException {
        ContentHolder contentHolder = fetchByCompanyIdAndName_First(companyId,
                name, orderByComparator);

        if (contentHolder != null) {
            return contentHolder;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", name=");
        msg.append(name);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContentHolderException(msg.toString());
    }

    /**
     * Returns the first content holder in the ordered set where companyId = &#63; and name = &#63;.
     *
     * @param companyId the company ID
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching content holder, or <code>null</code> if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder fetchByCompanyIdAndName_First(long companyId,
        String name, OrderByComparator orderByComparator)
        throws SystemException {
        List<ContentHolder> list = findByCompanyIdAndName(companyId, name, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last content holder in the ordered set where companyId = &#63; and name = &#63;.
     *
     * @param companyId the company ID
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching content holder
     * @throws com.arman.csb.theme.NoSuchContentHolderException if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder findByCompanyIdAndName_Last(long companyId,
        String name, OrderByComparator orderByComparator)
        throws NoSuchContentHolderException, SystemException {
        ContentHolder contentHolder = fetchByCompanyIdAndName_Last(companyId,
                name, orderByComparator);

        if (contentHolder != null) {
            return contentHolder;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", name=");
        msg.append(name);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContentHolderException(msg.toString());
    }

    /**
     * Returns the last content holder in the ordered set where companyId = &#63; and name = &#63;.
     *
     * @param companyId the company ID
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching content holder, or <code>null</code> if a matching content holder could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder fetchByCompanyIdAndName_Last(long companyId,
        String name, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByCompanyIdAndName(companyId, name);

        if (count == 0) {
            return null;
        }

        List<ContentHolder> list = findByCompanyIdAndName(companyId, name,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the content holders before and after the current content holder in the ordered set where companyId = &#63; and name = &#63;.
     *
     * @param id the primary key of the current content holder
     * @param companyId the company ID
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next content holder
     * @throws com.arman.csb.theme.NoSuchContentHolderException if a content holder with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder[] findByCompanyIdAndName_PrevAndNext(long id,
        long companyId, String name, OrderByComparator orderByComparator)
        throws NoSuchContentHolderException, SystemException {
        ContentHolder contentHolder = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            ContentHolder[] array = new ContentHolderImpl[3];

            array[0] = getByCompanyIdAndName_PrevAndNext(session,
                    contentHolder, companyId, name, orderByComparator, true);

            array[1] = contentHolder;

            array[2] = getByCompanyIdAndName_PrevAndNext(session,
                    contentHolder, companyId, name, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ContentHolder getByCompanyIdAndName_PrevAndNext(Session session,
        ContentHolder contentHolder, long companyId, String name,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONTENTHOLDER_WHERE);

        query.append(_FINDER_COLUMN_COMPANYIDANDNAME_COMPANYID_2);

        boolean bindName = false;

        if (name == null) {
            query.append(_FINDER_COLUMN_COMPANYIDANDNAME_NAME_1);
        } else if (name.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_COMPANYIDANDNAME_NAME_3);
        } else {
            bindName = true;

            query.append(_FINDER_COLUMN_COMPANYIDANDNAME_NAME_2);
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
            query.append(ContentHolderModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (bindName) {
            qPos.add(name);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(contentHolder);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ContentHolder> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the content holders where companyId = &#63; and name = &#63; from the database.
     *
     * @param companyId the company ID
     * @param name the name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyIdAndName(long companyId, String name)
        throws SystemException {
        for (ContentHolder contentHolder : findByCompanyIdAndName(companyId,
                name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(contentHolder);
        }
    }

    /**
     * Returns the number of content holders where companyId = &#63; and name = &#63;.
     *
     * @param companyId the company ID
     * @param name the name
     * @return the number of matching content holders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCompanyIdAndName(long companyId, String name)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYIDANDNAME;

        Object[] finderArgs = new Object[] { companyId, name };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_CONTENTHOLDER_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDNAME_COMPANYID_2);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_COMPANYIDANDNAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COMPANYIDANDNAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_COMPANYIDANDNAME_NAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (bindName) {
                    qPos.add(name);
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
     * Caches the content holder in the entity cache if it is enabled.
     *
     * @param contentHolder the content holder
     */
    @Override
    public void cacheResult(ContentHolder contentHolder) {
        EntityCacheUtil.putResult(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderImpl.class, contentHolder.getPrimaryKey(),
            contentHolder);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { contentHolder.getUuid(), contentHolder.getGroupId() },
            contentHolder);

        contentHolder.resetOriginalValues();
    }

    /**
     * Caches the content holders in the entity cache if it is enabled.
     *
     * @param contentHolders the content holders
     */
    @Override
    public void cacheResult(List<ContentHolder> contentHolders) {
        for (ContentHolder contentHolder : contentHolders) {
            if (EntityCacheUtil.getResult(
                        ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
                        ContentHolderImpl.class, contentHolder.getPrimaryKey()) == null) {
                cacheResult(contentHolder);
            } else {
                contentHolder.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all content holders.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ContentHolderImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ContentHolderImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the content holder.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ContentHolder contentHolder) {
        EntityCacheUtil.removeResult(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderImpl.class, contentHolder.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(contentHolder);
    }

    @Override
    public void clearCache(List<ContentHolder> contentHolders) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ContentHolder contentHolder : contentHolders) {
            EntityCacheUtil.removeResult(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
                ContentHolderImpl.class, contentHolder.getPrimaryKey());

            clearUniqueFindersCache(contentHolder);
        }
    }

    protected void cacheUniqueFindersCache(ContentHolder contentHolder) {
        if (contentHolder.isNew()) {
            Object[] args = new Object[] {
                    contentHolder.getUuid(), contentHolder.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                contentHolder);
        } else {
            ContentHolderModelImpl contentHolderModelImpl = (ContentHolderModelImpl) contentHolder;

            if ((contentHolderModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        contentHolder.getUuid(), contentHolder.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    contentHolder);
            }
        }
    }

    protected void clearUniqueFindersCache(ContentHolder contentHolder) {
        ContentHolderModelImpl contentHolderModelImpl = (ContentHolderModelImpl) contentHolder;

        Object[] args = new Object[] {
                contentHolder.getUuid(), contentHolder.getGroupId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((contentHolderModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    contentHolderModelImpl.getOriginalUuid(),
                    contentHolderModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new content holder with the primary key. Does not add the content holder to the database.
     *
     * @param id the primary key for the new content holder
     * @return the new content holder
     */
    @Override
    public ContentHolder create(long id) {
        ContentHolder contentHolder = new ContentHolderImpl();

        contentHolder.setNew(true);
        contentHolder.setPrimaryKey(id);

        String uuid = PortalUUIDUtil.generate();

        contentHolder.setUuid(uuid);

        return contentHolder;
    }

    /**
     * Removes the content holder with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the content holder
     * @return the content holder that was removed
     * @throws com.arman.csb.theme.NoSuchContentHolderException if a content holder with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder remove(long id)
        throws NoSuchContentHolderException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the content holder with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the content holder
     * @return the content holder that was removed
     * @throws com.arman.csb.theme.NoSuchContentHolderException if a content holder with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder remove(Serializable primaryKey)
        throws NoSuchContentHolderException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ContentHolder contentHolder = (ContentHolder) session.get(ContentHolderImpl.class,
                    primaryKey);

            if (contentHolder == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchContentHolderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(contentHolder);
        } catch (NoSuchContentHolderException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ContentHolder removeImpl(ContentHolder contentHolder)
        throws SystemException {
        contentHolder = toUnwrappedModel(contentHolder);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(contentHolder)) {
                contentHolder = (ContentHolder) session.get(ContentHolderImpl.class,
                        contentHolder.getPrimaryKeyObj());
            }

            if (contentHolder != null) {
                session.delete(contentHolder);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (contentHolder != null) {
            clearCache(contentHolder);
        }

        return contentHolder;
    }

    @Override
    public ContentHolder updateImpl(
        com.arman.csb.theme.model.ContentHolder contentHolder)
        throws SystemException {
        contentHolder = toUnwrappedModel(contentHolder);

        boolean isNew = contentHolder.isNew();

        ContentHolderModelImpl contentHolderModelImpl = (ContentHolderModelImpl) contentHolder;

        if (Validator.isNull(contentHolder.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            contentHolder.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (contentHolder.isNew()) {
                session.save(contentHolder);

                contentHolder.setNew(false);
            } else {
                session.merge(contentHolder);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ContentHolderModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((contentHolderModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        contentHolderModelImpl.getOriginalUuid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { contentHolderModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((contentHolderModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        contentHolderModelImpl.getOriginalUuid(),
                        contentHolderModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        contentHolderModelImpl.getUuid(),
                        contentHolderModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((contentHolderModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        contentHolderModelImpl.getOriginalCompanyId(),
                        contentHolderModelImpl.getOriginalName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDNAME,
                    args);

                args = new Object[] {
                        contentHolderModelImpl.getCompanyId(),
                        contentHolderModelImpl.getName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDNAME,
                    args);
            }
        }

        EntityCacheUtil.putResult(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
            ContentHolderImpl.class, contentHolder.getPrimaryKey(),
            contentHolder);

        clearUniqueFindersCache(contentHolder);
        cacheUniqueFindersCache(contentHolder);

        return contentHolder;
    }

    protected ContentHolder toUnwrappedModel(ContentHolder contentHolder) {
        if (contentHolder instanceof ContentHolderImpl) {
            return contentHolder;
        }

        ContentHolderImpl contentHolderImpl = new ContentHolderImpl();

        contentHolderImpl.setNew(contentHolder.isNew());
        contentHolderImpl.setPrimaryKey(contentHolder.getPrimaryKey());

        contentHolderImpl.setUuid(contentHolder.getUuid());
        contentHolderImpl.setId(contentHolder.getId());
        contentHolderImpl.setGroupId(contentHolder.getGroupId());
        contentHolderImpl.setCompanyId(contentHolder.getCompanyId());
        contentHolderImpl.setUserId(contentHolder.getUserId());
        contentHolderImpl.setUserName(contentHolder.getUserName());
        contentHolderImpl.setCreateDate(contentHolder.getCreateDate());
        contentHolderImpl.setModifiedDate(contentHolder.getModifiedDate());
        contentHolderImpl.setName(contentHolder.getName());
        contentHolderImpl.setHead(contentHolder.getHead());
        contentHolderImpl.setBottom(contentHolder.getBottom());
        contentHolderImpl.setHtmlContent(contentHolder.getHtmlContent());

        return contentHolderImpl;
    }

    /**
     * Returns the content holder with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the content holder
     * @return the content holder
     * @throws com.arman.csb.theme.NoSuchContentHolderException if a content holder with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder findByPrimaryKey(Serializable primaryKey)
        throws NoSuchContentHolderException, SystemException {
        ContentHolder contentHolder = fetchByPrimaryKey(primaryKey);

        if (contentHolder == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchContentHolderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return contentHolder;
    }

    /**
     * Returns the content holder with the primary key or throws a {@link com.arman.csb.theme.NoSuchContentHolderException} if it could not be found.
     *
     * @param id the primary key of the content holder
     * @return the content holder
     * @throws com.arman.csb.theme.NoSuchContentHolderException if a content holder with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder findByPrimaryKey(long id)
        throws NoSuchContentHolderException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the content holder with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the content holder
     * @return the content holder, or <code>null</code> if a content holder with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ContentHolder contentHolder = (ContentHolder) EntityCacheUtil.getResult(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
                ContentHolderImpl.class, primaryKey);

        if (contentHolder == _nullContentHolder) {
            return null;
        }

        if (contentHolder == null) {
            Session session = null;

            try {
                session = openSession();

                contentHolder = (ContentHolder) session.get(ContentHolderImpl.class,
                        primaryKey);

                if (contentHolder != null) {
                    cacheResult(contentHolder);
                } else {
                    EntityCacheUtil.putResult(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
                        ContentHolderImpl.class, primaryKey, _nullContentHolder);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ContentHolderModelImpl.ENTITY_CACHE_ENABLED,
                    ContentHolderImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return contentHolder;
    }

    /**
     * Returns the content holder with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the content holder
     * @return the content holder, or <code>null</code> if a content holder with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContentHolder fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the content holders.
     *
     * @return the content holders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ContentHolder> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the content holders.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of content holders
     * @param end the upper bound of the range of content holders (not inclusive)
     * @return the range of content holders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ContentHolder> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the content holders.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.theme.model.impl.ContentHolderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of content holders
     * @param end the upper bound of the range of content holders (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of content holders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ContentHolder> findAll(int start, int end,
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

        List<ContentHolder> list = (List<ContentHolder>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CONTENTHOLDER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CONTENTHOLDER;

                if (pagination) {
                    sql = sql.concat(ContentHolderModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ContentHolder>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ContentHolder>(list);
                } else {
                    list = (List<ContentHolder>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the content holders from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ContentHolder contentHolder : findAll()) {
            remove(contentHolder);
        }
    }

    /**
     * Returns the number of content holders.
     *
     * @return the number of content holders
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

                Query q = session.createQuery(_SQL_COUNT_CONTENTHOLDER);

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
     * Initializes the content holder persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arman.csb.theme.model.ContentHolder")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ContentHolder>> listenersList = new ArrayList<ModelListener<ContentHolder>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ContentHolder>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ContentHolderImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
