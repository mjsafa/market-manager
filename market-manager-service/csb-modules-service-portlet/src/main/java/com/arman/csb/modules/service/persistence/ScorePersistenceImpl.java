package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.NoSuchScoreException;
import com.arman.csb.modules.model.Score;
import com.arman.csb.modules.model.impl.ScoreImpl;
import com.arman.csb.modules.model.impl.ScoreModelImpl;
import com.arman.csb.modules.service.persistence.ScorePersistence;

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
 * The persistence implementation for the score service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScorePersistence
 * @see ScoreUtil
 * @generated
 */
public class ScorePersistenceImpl extends BasePersistenceImpl<Score>
    implements ScorePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ScoreUtil} to access the score persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ScoreImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, ScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, ScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, ScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, ScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            ScoreModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "score.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "score.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(score.uuid IS NULL OR score.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, ScoreImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            ScoreModelImpl.UUID_COLUMN_BITMASK |
            ScoreModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "score.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "score.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(score.uuid IS NULL OR score.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "score.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, ScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, ScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            ScoreModelImpl.UUID_COLUMN_BITMASK |
            ScoreModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "score.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "score.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(score.uuid IS NULL OR score.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "score.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMERID =
        new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, ScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCustomerId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID =
        new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, ScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCustomerId",
            new String[] { Long.class.getName() },
            ScoreModelImpl.CUSTOMERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CUSTOMERID = new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCustomerId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2 = "score.customerId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMERIDANDTYPE =
        new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, ScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCustomerIdAndType",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERIDANDTYPE =
        new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, ScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCustomerIdAndType",
            new String[] { Long.class.getName(), Integer.class.getName() },
            ScoreModelImpl.CUSTOMERID_COLUMN_BITMASK |
            ScoreModelImpl.TYPE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CUSTOMERIDANDTYPE = new FinderPath(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCustomerIdAndType",
            new String[] { Long.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_CUSTOMERIDANDTYPE_CUSTOMERID_2 = "score.customerId = ? AND ";
    private static final String _FINDER_COLUMN_CUSTOMERIDANDTYPE_TYPE_2 = "score.type = ?";
    private static final String _SQL_SELECT_SCORE = "SELECT score FROM Score score";
    private static final String _SQL_SELECT_SCORE_WHERE = "SELECT score FROM Score score WHERE ";
    private static final String _SQL_COUNT_SCORE = "SELECT COUNT(score) FROM Score score";
    private static final String _SQL_COUNT_SCORE_WHERE = "SELECT COUNT(score) FROM Score score WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "score.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Score exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Score exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ScorePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid", "id", "type"
            });
    private static Score _nullScore = new ScoreImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Score> toCacheModel() {
                return _nullScoreCacheModel;
            }
        };

    private static CacheModel<Score> _nullScoreCacheModel = new CacheModel<Score>() {
            @Override
            public Score toEntityModel() {
                return _nullScore;
            }
        };

    public ScorePersistenceImpl() {
        setModelClass(Score.class);
    }

    /**
     * Returns all the scores where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the scores where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of scores
     * @param end the upper bound of the range of scores (not inclusive)
     * @return the range of matching scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the scores where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of scores
     * @param end the upper bound of the range of scores (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findByUuid(String uuid, int start, int end,
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

        List<Score> list = (List<Score>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Score score : list) {
                if (!Validator.equals(uuid, score.getUuid())) {
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

            query.append(_SQL_SELECT_SCORE_WHERE);

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
                query.append(ScoreModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Score>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Score>(list);
                } else {
                    list = (List<Score>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first score in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching score
     * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchScoreException, SystemException {
        Score score = fetchByUuid_First(uuid, orderByComparator);

        if (score != null) {
            return score;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchScoreException(msg.toString());
    }

    /**
     * Returns the first score in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching score, or <code>null</code> if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Score> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last score in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching score
     * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchScoreException, SystemException {
        Score score = fetchByUuid_Last(uuid, orderByComparator);

        if (score != null) {
            return score;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchScoreException(msg.toString());
    }

    /**
     * Returns the last score in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching score, or <code>null</code> if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Score> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the scores before and after the current score in the ordered set where uuid = &#63;.
     *
     * @param id the primary key of the current score
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next score
     * @throws com.arman.csb.modules.NoSuchScoreException if a score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score[] findByUuid_PrevAndNext(long id, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchScoreException, SystemException {
        Score score = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Score[] array = new ScoreImpl[3];

            array[0] = getByUuid_PrevAndNext(session, score, uuid,
                    orderByComparator, true);

            array[1] = score;

            array[2] = getByUuid_PrevAndNext(session, score, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Score getByUuid_PrevAndNext(Session session, Score score,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SCORE_WHERE);

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
            query.append(ScoreModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(score);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Score> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the scores where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Score score : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(score);
        }
    }

    /**
     * Returns the number of scores where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching scores
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

            query.append(_SQL_COUNT_SCORE_WHERE);

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
     * Returns the score where uuid = &#63; and groupId = &#63; or throws a {@link com.arman.csb.modules.NoSuchScoreException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching score
     * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score findByUUID_G(String uuid, long groupId)
        throws NoSuchScoreException, SystemException {
        Score score = fetchByUUID_G(uuid, groupId);

        if (score == null) {
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

            throw new NoSuchScoreException(msg.toString());
        }

        return score;
    }

    /**
     * Returns the score where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching score, or <code>null</code> if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the score where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching score, or <code>null</code> if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Score) {
            Score score = (Score) result;

            if (!Validator.equals(uuid, score.getUuid()) ||
                    (groupId != score.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_SCORE_WHERE);

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

                List<Score> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Score score = list.get(0);

                    result = score;

                    cacheResult(score);

                    if ((score.getUuid() == null) ||
                            !score.getUuid().equals(uuid) ||
                            (score.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, score);
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
            return (Score) result;
        }
    }

    /**
     * Removes the score where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the score that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score removeByUUID_G(String uuid, long groupId)
        throws NoSuchScoreException, SystemException {
        Score score = findByUUID_G(uuid, groupId);

        return remove(score);
    }

    /**
     * Returns the number of scores where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching scores
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

            query.append(_SQL_COUNT_SCORE_WHERE);

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
     * Returns all the scores where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the scores where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of scores
     * @param end the upper bound of the range of scores (not inclusive)
     * @return the range of matching scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the scores where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of scores
     * @param end the upper bound of the range of scores (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findByUuid_C(String uuid, long companyId, int start,
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

        List<Score> list = (List<Score>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Score score : list) {
                if (!Validator.equals(uuid, score.getUuid()) ||
                        (companyId != score.getCompanyId())) {
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

            query.append(_SQL_SELECT_SCORE_WHERE);

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
                query.append(ScoreModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Score>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Score>(list);
                } else {
                    list = (List<Score>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first score in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching score
     * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchScoreException, SystemException {
        Score score = fetchByUuid_C_First(uuid, companyId, orderByComparator);

        if (score != null) {
            return score;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchScoreException(msg.toString());
    }

    /**
     * Returns the first score in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching score, or <code>null</code> if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Score> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last score in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching score
     * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchScoreException, SystemException {
        Score score = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

        if (score != null) {
            return score;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchScoreException(msg.toString());
    }

    /**
     * Returns the last score in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching score, or <code>null</code> if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Score> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the scores before and after the current score in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param id the primary key of the current score
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next score
     * @throws com.arman.csb.modules.NoSuchScoreException if a score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score[] findByUuid_C_PrevAndNext(long id, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchScoreException, SystemException {
        Score score = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Score[] array = new ScoreImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, score, uuid, companyId,
                    orderByComparator, true);

            array[1] = score;

            array[2] = getByUuid_C_PrevAndNext(session, score, uuid, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Score getByUuid_C_PrevAndNext(Session session, Score score,
        String uuid, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SCORE_WHERE);

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
            query.append(ScoreModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(score);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Score> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the scores where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Score score : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(score);
        }
    }

    /**
     * Returns the number of scores where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching scores
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

            query.append(_SQL_COUNT_SCORE_WHERE);

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
     * Returns all the scores where customerId = &#63;.
     *
     * @param customerId the customer ID
     * @return the matching scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findByCustomerId(long customerId)
        throws SystemException {
        return findByCustomerId(customerId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the scores where customerId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param customerId the customer ID
     * @param start the lower bound of the range of scores
     * @param end the upper bound of the range of scores (not inclusive)
     * @return the range of matching scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findByCustomerId(long customerId, int start, int end)
        throws SystemException {
        return findByCustomerId(customerId, start, end, null);
    }

    /**
     * Returns an ordered range of all the scores where customerId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param customerId the customer ID
     * @param start the lower bound of the range of scores
     * @param end the upper bound of the range of scores (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findByCustomerId(long customerId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID;
            finderArgs = new Object[] { customerId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMERID;
            finderArgs = new Object[] { customerId, start, end, orderByComparator };
        }

        List<Score> list = (List<Score>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Score score : list) {
                if ((customerId != score.getCustomerId())) {
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

            query.append(_SQL_SELECT_SCORE_WHERE);

            query.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ScoreModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(customerId);

                if (!pagination) {
                    list = (List<Score>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Score>(list);
                } else {
                    list = (List<Score>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first score in the ordered set where customerId = &#63;.
     *
     * @param customerId the customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching score
     * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score findByCustomerId_First(long customerId,
        OrderByComparator orderByComparator)
        throws NoSuchScoreException, SystemException {
        Score score = fetchByCustomerId_First(customerId, orderByComparator);

        if (score != null) {
            return score;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("customerId=");
        msg.append(customerId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchScoreException(msg.toString());
    }

    /**
     * Returns the first score in the ordered set where customerId = &#63;.
     *
     * @param customerId the customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching score, or <code>null</code> if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score fetchByCustomerId_First(long customerId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Score> list = findByCustomerId(customerId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last score in the ordered set where customerId = &#63;.
     *
     * @param customerId the customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching score
     * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score findByCustomerId_Last(long customerId,
        OrderByComparator orderByComparator)
        throws NoSuchScoreException, SystemException {
        Score score = fetchByCustomerId_Last(customerId, orderByComparator);

        if (score != null) {
            return score;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("customerId=");
        msg.append(customerId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchScoreException(msg.toString());
    }

    /**
     * Returns the last score in the ordered set where customerId = &#63;.
     *
     * @param customerId the customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching score, or <code>null</code> if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score fetchByCustomerId_Last(long customerId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCustomerId(customerId);

        if (count == 0) {
            return null;
        }

        List<Score> list = findByCustomerId(customerId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the scores before and after the current score in the ordered set where customerId = &#63;.
     *
     * @param id the primary key of the current score
     * @param customerId the customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next score
     * @throws com.arman.csb.modules.NoSuchScoreException if a score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score[] findByCustomerId_PrevAndNext(long id, long customerId,
        OrderByComparator orderByComparator)
        throws NoSuchScoreException, SystemException {
        Score score = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Score[] array = new ScoreImpl[3];

            array[0] = getByCustomerId_PrevAndNext(session, score, customerId,
                    orderByComparator, true);

            array[1] = score;

            array[2] = getByCustomerId_PrevAndNext(session, score, customerId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Score getByCustomerId_PrevAndNext(Session session, Score score,
        long customerId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SCORE_WHERE);

        query.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

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
            query.append(ScoreModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(customerId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(score);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Score> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the scores where customerId = &#63; from the database.
     *
     * @param customerId the customer ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCustomerId(long customerId) throws SystemException {
        for (Score score : findByCustomerId(customerId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(score);
        }
    }

    /**
     * Returns the number of scores where customerId = &#63;.
     *
     * @param customerId the customer ID
     * @return the number of matching scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCustomerId(long customerId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CUSTOMERID;

        Object[] finderArgs = new Object[] { customerId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SCORE_WHERE);

            query.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(customerId);

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
     * Returns all the scores where customerId = &#63; and type = &#63;.
     *
     * @param customerId the customer ID
     * @param type the type
     * @return the matching scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findByCustomerIdAndType(long customerId, int type)
        throws SystemException {
        return findByCustomerIdAndType(customerId, type, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the scores where customerId = &#63; and type = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param customerId the customer ID
     * @param type the type
     * @param start the lower bound of the range of scores
     * @param end the upper bound of the range of scores (not inclusive)
     * @return the range of matching scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findByCustomerIdAndType(long customerId, int type,
        int start, int end) throws SystemException {
        return findByCustomerIdAndType(customerId, type, start, end, null);
    }

    /**
     * Returns an ordered range of all the scores where customerId = &#63; and type = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param customerId the customer ID
     * @param type the type
     * @param start the lower bound of the range of scores
     * @param end the upper bound of the range of scores (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findByCustomerIdAndType(long customerId, int type,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERIDANDTYPE;
            finderArgs = new Object[] { customerId, type };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMERIDANDTYPE;
            finderArgs = new Object[] {
                    customerId, type,
                    
                    start, end, orderByComparator
                };
        }

        List<Score> list = (List<Score>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Score score : list) {
                if ((customerId != score.getCustomerId()) ||
                        (type != score.getType())) {
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

            query.append(_SQL_SELECT_SCORE_WHERE);

            query.append(_FINDER_COLUMN_CUSTOMERIDANDTYPE_CUSTOMERID_2);

            query.append(_FINDER_COLUMN_CUSTOMERIDANDTYPE_TYPE_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ScoreModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(customerId);

                qPos.add(type);

                if (!pagination) {
                    list = (List<Score>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Score>(list);
                } else {
                    list = (List<Score>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first score in the ordered set where customerId = &#63; and type = &#63;.
     *
     * @param customerId the customer ID
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching score
     * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score findByCustomerIdAndType_First(long customerId, int type,
        OrderByComparator orderByComparator)
        throws NoSuchScoreException, SystemException {
        Score score = fetchByCustomerIdAndType_First(customerId, type,
                orderByComparator);

        if (score != null) {
            return score;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("customerId=");
        msg.append(customerId);

        msg.append(", type=");
        msg.append(type);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchScoreException(msg.toString());
    }

    /**
     * Returns the first score in the ordered set where customerId = &#63; and type = &#63;.
     *
     * @param customerId the customer ID
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching score, or <code>null</code> if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score fetchByCustomerIdAndType_First(long customerId, int type,
        OrderByComparator orderByComparator) throws SystemException {
        List<Score> list = findByCustomerIdAndType(customerId, type, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last score in the ordered set where customerId = &#63; and type = &#63;.
     *
     * @param customerId the customer ID
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching score
     * @throws com.arman.csb.modules.NoSuchScoreException if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score findByCustomerIdAndType_Last(long customerId, int type,
        OrderByComparator orderByComparator)
        throws NoSuchScoreException, SystemException {
        Score score = fetchByCustomerIdAndType_Last(customerId, type,
                orderByComparator);

        if (score != null) {
            return score;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("customerId=");
        msg.append(customerId);

        msg.append(", type=");
        msg.append(type);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchScoreException(msg.toString());
    }

    /**
     * Returns the last score in the ordered set where customerId = &#63; and type = &#63;.
     *
     * @param customerId the customer ID
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching score, or <code>null</code> if a matching score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score fetchByCustomerIdAndType_Last(long customerId, int type,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCustomerIdAndType(customerId, type);

        if (count == 0) {
            return null;
        }

        List<Score> list = findByCustomerIdAndType(customerId, type, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the scores before and after the current score in the ordered set where customerId = &#63; and type = &#63;.
     *
     * @param id the primary key of the current score
     * @param customerId the customer ID
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next score
     * @throws com.arman.csb.modules.NoSuchScoreException if a score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score[] findByCustomerIdAndType_PrevAndNext(long id,
        long customerId, int type, OrderByComparator orderByComparator)
        throws NoSuchScoreException, SystemException {
        Score score = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Score[] array = new ScoreImpl[3];

            array[0] = getByCustomerIdAndType_PrevAndNext(session, score,
                    customerId, type, orderByComparator, true);

            array[1] = score;

            array[2] = getByCustomerIdAndType_PrevAndNext(session, score,
                    customerId, type, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Score getByCustomerIdAndType_PrevAndNext(Session session,
        Score score, long customerId, int type,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SCORE_WHERE);

        query.append(_FINDER_COLUMN_CUSTOMERIDANDTYPE_CUSTOMERID_2);

        query.append(_FINDER_COLUMN_CUSTOMERIDANDTYPE_TYPE_2);

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
            query.append(ScoreModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(customerId);

        qPos.add(type);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(score);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Score> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the scores where customerId = &#63; and type = &#63; from the database.
     *
     * @param customerId the customer ID
     * @param type the type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCustomerIdAndType(long customerId, int type)
        throws SystemException {
        for (Score score : findByCustomerIdAndType(customerId, type,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(score);
        }
    }

    /**
     * Returns the number of scores where customerId = &#63; and type = &#63;.
     *
     * @param customerId the customer ID
     * @param type the type
     * @return the number of matching scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCustomerIdAndType(long customerId, int type)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CUSTOMERIDANDTYPE;

        Object[] finderArgs = new Object[] { customerId, type };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SCORE_WHERE);

            query.append(_FINDER_COLUMN_CUSTOMERIDANDTYPE_CUSTOMERID_2);

            query.append(_FINDER_COLUMN_CUSTOMERIDANDTYPE_TYPE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(customerId);

                qPos.add(type);

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
     * Caches the score in the entity cache if it is enabled.
     *
     * @param score the score
     */
    @Override
    public void cacheResult(Score score) {
        EntityCacheUtil.putResult(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreImpl.class, score.getPrimaryKey(), score);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { score.getUuid(), score.getGroupId() }, score);

        score.resetOriginalValues();
    }

    /**
     * Caches the scores in the entity cache if it is enabled.
     *
     * @param scores the scores
     */
    @Override
    public void cacheResult(List<Score> scores) {
        for (Score score : scores) {
            if (EntityCacheUtil.getResult(ScoreModelImpl.ENTITY_CACHE_ENABLED,
                        ScoreImpl.class, score.getPrimaryKey()) == null) {
                cacheResult(score);
            } else {
                score.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all scores.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ScoreImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ScoreImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the score.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Score score) {
        EntityCacheUtil.removeResult(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreImpl.class, score.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(score);
    }

    @Override
    public void clearCache(List<Score> scores) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Score score : scores) {
            EntityCacheUtil.removeResult(ScoreModelImpl.ENTITY_CACHE_ENABLED,
                ScoreImpl.class, score.getPrimaryKey());

            clearUniqueFindersCache(score);
        }
    }

    protected void cacheUniqueFindersCache(Score score) {
        if (score.isNew()) {
            Object[] args = new Object[] { score.getUuid(), score.getGroupId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, score);
        } else {
            ScoreModelImpl scoreModelImpl = (ScoreModelImpl) score;

            if ((scoreModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { score.getUuid(), score.getGroupId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    score);
            }
        }
    }

    protected void clearUniqueFindersCache(Score score) {
        ScoreModelImpl scoreModelImpl = (ScoreModelImpl) score;

        Object[] args = new Object[] { score.getUuid(), score.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((scoreModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    scoreModelImpl.getOriginalUuid(),
                    scoreModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new score with the primary key. Does not add the score to the database.
     *
     * @param id the primary key for the new score
     * @return the new score
     */
    @Override
    public Score create(long id) {
        Score score = new ScoreImpl();

        score.setNew(true);
        score.setPrimaryKey(id);

        String uuid = PortalUUIDUtil.generate();

        score.setUuid(uuid);

        return score;
    }

    /**
     * Removes the score with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the score
     * @return the score that was removed
     * @throws com.arman.csb.modules.NoSuchScoreException if a score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score remove(long id) throws NoSuchScoreException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the score with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the score
     * @return the score that was removed
     * @throws com.arman.csb.modules.NoSuchScoreException if a score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score remove(Serializable primaryKey)
        throws NoSuchScoreException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Score score = (Score) session.get(ScoreImpl.class, primaryKey);

            if (score == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchScoreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(score);
        } catch (NoSuchScoreException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Score removeImpl(Score score) throws SystemException {
        score = toUnwrappedModel(score);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(score)) {
                score = (Score) session.get(ScoreImpl.class,
                        score.getPrimaryKeyObj());
            }

            if (score != null) {
                session.delete(score);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (score != null) {
            clearCache(score);
        }

        return score;
    }

    @Override
    public Score updateImpl(com.arman.csb.modules.model.Score score)
        throws SystemException {
        score = toUnwrappedModel(score);

        boolean isNew = score.isNew();

        ScoreModelImpl scoreModelImpl = (ScoreModelImpl) score;

        if (Validator.isNull(score.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            score.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (score.isNew()) {
                session.save(score);

                score.setNew(false);
            } else {
                session.merge(score);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ScoreModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((scoreModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { scoreModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { scoreModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((scoreModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        scoreModelImpl.getOriginalUuid(),
                        scoreModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        scoreModelImpl.getUuid(), scoreModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((scoreModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        scoreModelImpl.getOriginalCustomerId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUSTOMERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID,
                    args);

                args = new Object[] { scoreModelImpl.getCustomerId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUSTOMERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID,
                    args);
            }

            if ((scoreModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERIDANDTYPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        scoreModelImpl.getOriginalCustomerId(),
                        scoreModelImpl.getOriginalType()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUSTOMERIDANDTYPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERIDANDTYPE,
                    args);

                args = new Object[] {
                        scoreModelImpl.getCustomerId(), scoreModelImpl.getType()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUSTOMERIDANDTYPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERIDANDTYPE,
                    args);
            }
        }

        EntityCacheUtil.putResult(ScoreModelImpl.ENTITY_CACHE_ENABLED,
            ScoreImpl.class, score.getPrimaryKey(), score);

        clearUniqueFindersCache(score);
        cacheUniqueFindersCache(score);

        return score;
    }

    protected Score toUnwrappedModel(Score score) {
        if (score instanceof ScoreImpl) {
            return score;
        }

        ScoreImpl scoreImpl = new ScoreImpl();

        scoreImpl.setNew(score.isNew());
        scoreImpl.setPrimaryKey(score.getPrimaryKey());

        scoreImpl.setUuid(score.getUuid());
        scoreImpl.setId(score.getId());
        scoreImpl.setGroupId(score.getGroupId());
        scoreImpl.setCompanyId(score.getCompanyId());
        scoreImpl.setUserId(score.getUserId());
        scoreImpl.setUserName(score.getUserName());
        scoreImpl.setCreateDate(score.getCreateDate());
        scoreImpl.setModifiedDate(score.getModifiedDate());
        scoreImpl.setValue(score.getValue());
        scoreImpl.setCustomerId(score.getCustomerId());
        scoreImpl.setOriginCustomerId(score.getOriginCustomerId());
        scoreImpl.setType(score.getType());

        return scoreImpl;
    }

    /**
     * Returns the score with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the score
     * @return the score
     * @throws com.arman.csb.modules.NoSuchScoreException if a score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score findByPrimaryKey(Serializable primaryKey)
        throws NoSuchScoreException, SystemException {
        Score score = fetchByPrimaryKey(primaryKey);

        if (score == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchScoreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return score;
    }

    /**
     * Returns the score with the primary key or throws a {@link com.arman.csb.modules.NoSuchScoreException} if it could not be found.
     *
     * @param id the primary key of the score
     * @return the score
     * @throws com.arman.csb.modules.NoSuchScoreException if a score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score findByPrimaryKey(long id)
        throws NoSuchScoreException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the score with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the score
     * @return the score, or <code>null</code> if a score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Score score = (Score) EntityCacheUtil.getResult(ScoreModelImpl.ENTITY_CACHE_ENABLED,
                ScoreImpl.class, primaryKey);

        if (score == _nullScore) {
            return null;
        }

        if (score == null) {
            Session session = null;

            try {
                session = openSession();

                score = (Score) session.get(ScoreImpl.class, primaryKey);

                if (score != null) {
                    cacheResult(score);
                } else {
                    EntityCacheUtil.putResult(ScoreModelImpl.ENTITY_CACHE_ENABLED,
                        ScoreImpl.class, primaryKey, _nullScore);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ScoreModelImpl.ENTITY_CACHE_ENABLED,
                    ScoreImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return score;
    }

    /**
     * Returns the score with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the score
     * @return the score, or <code>null</code> if a score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Score fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the scores.
     *
     * @return the scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the scores.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of scores
     * @param end the upper bound of the range of scores (not inclusive)
     * @return the range of scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the scores.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.ScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of scores
     * @param end the upper bound of the range of scores (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Score> findAll(int start, int end,
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

        List<Score> list = (List<Score>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SCORE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SCORE;

                if (pagination) {
                    sql = sql.concat(ScoreModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Score>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Score>(list);
                } else {
                    list = (List<Score>) QueryUtil.list(q, getDialect(), start,
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
     * Removes all the scores from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Score score : findAll()) {
            remove(score);
        }
    }

    /**
     * Returns the number of scores.
     *
     * @return the number of scores
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

                Query q = session.createQuery(_SQL_COUNT_SCORE);

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
     * Initializes the score persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arman.csb.modules.model.Score")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Score>> listenersList = new ArrayList<ModelListener<Score>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Score>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ScoreImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
