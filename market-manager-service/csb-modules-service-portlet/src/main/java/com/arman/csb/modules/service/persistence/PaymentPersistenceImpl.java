package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.NoSuchPaymentException;
import com.arman.csb.modules.model.Payment;
import com.arman.csb.modules.model.impl.PaymentImpl;
import com.arman.csb.modules.model.impl.PaymentModelImpl;
import com.arman.csb.modules.service.persistence.PaymentPersistence;

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
 * The persistence implementation for the payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PaymentPersistence
 * @see PaymentUtil
 * @generated
 */
public class PaymentPersistenceImpl extends BasePersistenceImpl<Payment>
    implements PaymentPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PaymentUtil} to access the payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PaymentImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            PaymentModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "payment.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "payment.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(payment.uuid IS NULL OR payment.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            PaymentModelImpl.UUID_COLUMN_BITMASK |
            PaymentModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "payment.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "payment.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(payment.uuid IS NULL OR payment.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "payment.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            PaymentModelImpl.UUID_COLUMN_BITMASK |
            PaymentModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "payment.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "payment.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(payment.uuid IS NULL OR payment.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "payment.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMER = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCustomer",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMER =
        new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCustomer",
            new String[] { Long.class.getName() },
            PaymentModelImpl.CUSTOMERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CUSTOMER = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCustomer",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_CUSTOMER_CUSTOMERID_2 = "payment.customerId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FACTOR = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFactor",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACTOR =
        new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFactor",
            new String[] { Long.class.getName() },
            PaymentModelImpl.FACTORID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_FACTOR = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFactor",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_FACTOR_FACTORID_2 = "payment.factorId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
        new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
            new String[] { Integer.class.getName() },
            PaymentModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "payment.status = ?";
    private static final String _SQL_SELECT_PAYMENT = "SELECT payment FROM Payment payment";
    private static final String _SQL_SELECT_PAYMENT_WHERE = "SELECT payment FROM Payment payment WHERE ";
    private static final String _SQL_COUNT_PAYMENT = "SELECT COUNT(payment) FROM Payment payment";
    private static final String _SQL_COUNT_PAYMENT_WHERE = "SELECT COUNT(payment) FROM Payment payment WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "payment.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Payment exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Payment exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PaymentPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid", "id"
            });
    private static Payment _nullPayment = new PaymentImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Payment> toCacheModel() {
                return _nullPaymentCacheModel;
            }
        };

    private static CacheModel<Payment> _nullPaymentCacheModel = new CacheModel<Payment>() {
            @Override
            public Payment toEntityModel() {
                return _nullPayment;
            }
        };

    public PaymentPersistenceImpl() {
        setModelClass(Payment.class);
    }

    /**
     * Returns all the payments where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the payments where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of payments
     * @param end the upper bound of the range of payments (not inclusive)
     * @return the range of matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the payments where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of payments
     * @param end the upper bound of the range of payments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByUuid(String uuid, int start, int end,
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

        List<Payment> list = (List<Payment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Payment payment : list) {
                if (!Validator.equals(uuid, payment.getUuid())) {
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

            query.append(_SQL_SELECT_PAYMENT_WHERE);

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
                query.append(PaymentModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Payment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Payment>(list);
                } else {
                    list = (List<Payment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first payment in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = fetchByUuid_First(uuid, orderByComparator);

        if (payment != null) {
            return payment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPaymentException(msg.toString());
    }

    /**
     * Returns the first payment in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching payment, or <code>null</code> if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Payment> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last payment in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = fetchByUuid_Last(uuid, orderByComparator);

        if (payment != null) {
            return payment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPaymentException(msg.toString());
    }

    /**
     * Returns the last payment in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching payment, or <code>null</code> if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Payment> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the payments before and after the current payment in the ordered set where uuid = &#63;.
     *
     * @param id the primary key of the current payment
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a payment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment[] findByUuid_PrevAndNext(long id, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Payment[] array = new PaymentImpl[3];

            array[0] = getByUuid_PrevAndNext(session, payment, uuid,
                    orderByComparator, true);

            array[1] = payment;

            array[2] = getByUuid_PrevAndNext(session, payment, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Payment getByUuid_PrevAndNext(Session session, Payment payment,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PAYMENT_WHERE);

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
            query.append(PaymentModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(payment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Payment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the payments where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Payment payment : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(payment);
        }
    }

    /**
     * Returns the number of payments where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching payments
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

            query.append(_SQL_COUNT_PAYMENT_WHERE);

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
     * Returns the payment where uuid = &#63; and groupId = &#63; or throws a {@link com.arman.csb.modules.NoSuchPaymentException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment findByUUID_G(String uuid, long groupId)
        throws NoSuchPaymentException, SystemException {
        Payment payment = fetchByUUID_G(uuid, groupId);

        if (payment == null) {
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

            throw new NoSuchPaymentException(msg.toString());
        }

        return payment;
    }

    /**
     * Returns the payment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching payment, or <code>null</code> if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the payment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching payment, or <code>null</code> if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Payment) {
            Payment payment = (Payment) result;

            if (!Validator.equals(uuid, payment.getUuid()) ||
                    (groupId != payment.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_PAYMENT_WHERE);

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

                List<Payment> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Payment payment = list.get(0);

                    result = payment;

                    cacheResult(payment);

                    if ((payment.getUuid() == null) ||
                            !payment.getUuid().equals(uuid) ||
                            (payment.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, payment);
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
            return (Payment) result;
        }
    }

    /**
     * Removes the payment where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the payment that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment removeByUUID_G(String uuid, long groupId)
        throws NoSuchPaymentException, SystemException {
        Payment payment = findByUUID_G(uuid, groupId);

        return remove(payment);
    }

    /**
     * Returns the number of payments where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching payments
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

            query.append(_SQL_COUNT_PAYMENT_WHERE);

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
     * Returns all the payments where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the payments where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of payments
     * @param end the upper bound of the range of payments (not inclusive)
     * @return the range of matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the payments where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of payments
     * @param end the upper bound of the range of payments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByUuid_C(String uuid, long companyId, int start,
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

        List<Payment> list = (List<Payment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Payment payment : list) {
                if (!Validator.equals(uuid, payment.getUuid()) ||
                        (companyId != payment.getCompanyId())) {
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

            query.append(_SQL_SELECT_PAYMENT_WHERE);

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
                query.append(PaymentModelImpl.ORDER_BY_JPQL);
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
                    list = (List<Payment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Payment>(list);
                } else {
                    list = (List<Payment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first payment in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = fetchByUuid_C_First(uuid, companyId, orderByComparator);

        if (payment != null) {
            return payment;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPaymentException(msg.toString());
    }

    /**
     * Returns the first payment in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching payment, or <code>null</code> if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Payment> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last payment in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

        if (payment != null) {
            return payment;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPaymentException(msg.toString());
    }

    /**
     * Returns the last payment in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching payment, or <code>null</code> if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Payment> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the payments before and after the current payment in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param id the primary key of the current payment
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a payment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment[] findByUuid_C_PrevAndNext(long id, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Payment[] array = new PaymentImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, payment, uuid,
                    companyId, orderByComparator, true);

            array[1] = payment;

            array[2] = getByUuid_C_PrevAndNext(session, payment, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Payment getByUuid_C_PrevAndNext(Session session, Payment payment,
        String uuid, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PAYMENT_WHERE);

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
            query.append(PaymentModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(payment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Payment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the payments where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Payment payment : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(payment);
        }
    }

    /**
     * Returns the number of payments where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching payments
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

            query.append(_SQL_COUNT_PAYMENT_WHERE);

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
     * Returns all the payments where customerId = &#63;.
     *
     * @param customerId the customer ID
     * @return the matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByCustomer(long customerId)
        throws SystemException {
        return findByCustomer(customerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the payments where customerId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param customerId the customer ID
     * @param start the lower bound of the range of payments
     * @param end the upper bound of the range of payments (not inclusive)
     * @return the range of matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByCustomer(long customerId, int start, int end)
        throws SystemException {
        return findByCustomer(customerId, start, end, null);
    }

    /**
     * Returns an ordered range of all the payments where customerId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param customerId the customer ID
     * @param start the lower bound of the range of payments
     * @param end the upper bound of the range of payments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByCustomer(long customerId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMER;
            finderArgs = new Object[] { customerId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMER;
            finderArgs = new Object[] { customerId, start, end, orderByComparator };
        }

        List<Payment> list = (List<Payment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Payment payment : list) {
                if ((customerId != payment.getCustomerId())) {
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

            query.append(_SQL_SELECT_PAYMENT_WHERE);

            query.append(_FINDER_COLUMN_CUSTOMER_CUSTOMERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PaymentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(customerId);

                if (!pagination) {
                    list = (List<Payment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Payment>(list);
                } else {
                    list = (List<Payment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first payment in the ordered set where customerId = &#63;.
     *
     * @param customerId the customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment findByCustomer_First(long customerId,
        OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = fetchByCustomer_First(customerId, orderByComparator);

        if (payment != null) {
            return payment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("customerId=");
        msg.append(customerId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPaymentException(msg.toString());
    }

    /**
     * Returns the first payment in the ordered set where customerId = &#63;.
     *
     * @param customerId the customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching payment, or <code>null</code> if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment fetchByCustomer_First(long customerId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Payment> list = findByCustomer(customerId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last payment in the ordered set where customerId = &#63;.
     *
     * @param customerId the customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment findByCustomer_Last(long customerId,
        OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = fetchByCustomer_Last(customerId, orderByComparator);

        if (payment != null) {
            return payment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("customerId=");
        msg.append(customerId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPaymentException(msg.toString());
    }

    /**
     * Returns the last payment in the ordered set where customerId = &#63;.
     *
     * @param customerId the customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching payment, or <code>null</code> if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment fetchByCustomer_Last(long customerId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCustomer(customerId);

        if (count == 0) {
            return null;
        }

        List<Payment> list = findByCustomer(customerId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the payments before and after the current payment in the ordered set where customerId = &#63;.
     *
     * @param id the primary key of the current payment
     * @param customerId the customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a payment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment[] findByCustomer_PrevAndNext(long id, long customerId,
        OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Payment[] array = new PaymentImpl[3];

            array[0] = getByCustomer_PrevAndNext(session, payment, customerId,
                    orderByComparator, true);

            array[1] = payment;

            array[2] = getByCustomer_PrevAndNext(session, payment, customerId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Payment getByCustomer_PrevAndNext(Session session,
        Payment payment, long customerId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PAYMENT_WHERE);

        query.append(_FINDER_COLUMN_CUSTOMER_CUSTOMERID_2);

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
            query.append(PaymentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(customerId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(payment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Payment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the payments where customerId = &#63; from the database.
     *
     * @param customerId the customer ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCustomer(long customerId) throws SystemException {
        for (Payment payment : findByCustomer(customerId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(payment);
        }
    }

    /**
     * Returns the number of payments where customerId = &#63;.
     *
     * @param customerId the customer ID
     * @return the number of matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCustomer(long customerId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CUSTOMER;

        Object[] finderArgs = new Object[] { customerId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PAYMENT_WHERE);

            query.append(_FINDER_COLUMN_CUSTOMER_CUSTOMERID_2);

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
     * Returns all the payments where factorId = &#63;.
     *
     * @param factorId the factor ID
     * @return the matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByFactor(long factorId) throws SystemException {
        return findByFactor(factorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the payments where factorId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param factorId the factor ID
     * @param start the lower bound of the range of payments
     * @param end the upper bound of the range of payments (not inclusive)
     * @return the range of matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByFactor(long factorId, int start, int end)
        throws SystemException {
        return findByFactor(factorId, start, end, null);
    }

    /**
     * Returns an ordered range of all the payments where factorId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param factorId the factor ID
     * @param start the lower bound of the range of payments
     * @param end the upper bound of the range of payments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByFactor(long factorId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACTOR;
            finderArgs = new Object[] { factorId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FACTOR;
            finderArgs = new Object[] { factorId, start, end, orderByComparator };
        }

        List<Payment> list = (List<Payment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Payment payment : list) {
                if ((factorId != payment.getFactorId())) {
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

            query.append(_SQL_SELECT_PAYMENT_WHERE);

            query.append(_FINDER_COLUMN_FACTOR_FACTORID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PaymentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(factorId);

                if (!pagination) {
                    list = (List<Payment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Payment>(list);
                } else {
                    list = (List<Payment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first payment in the ordered set where factorId = &#63;.
     *
     * @param factorId the factor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment findByFactor_First(long factorId,
        OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = fetchByFactor_First(factorId, orderByComparator);

        if (payment != null) {
            return payment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("factorId=");
        msg.append(factorId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPaymentException(msg.toString());
    }

    /**
     * Returns the first payment in the ordered set where factorId = &#63;.
     *
     * @param factorId the factor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching payment, or <code>null</code> if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment fetchByFactor_First(long factorId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Payment> list = findByFactor(factorId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last payment in the ordered set where factorId = &#63;.
     *
     * @param factorId the factor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment findByFactor_Last(long factorId,
        OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = fetchByFactor_Last(factorId, orderByComparator);

        if (payment != null) {
            return payment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("factorId=");
        msg.append(factorId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPaymentException(msg.toString());
    }

    /**
     * Returns the last payment in the ordered set where factorId = &#63;.
     *
     * @param factorId the factor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching payment, or <code>null</code> if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment fetchByFactor_Last(long factorId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByFactor(factorId);

        if (count == 0) {
            return null;
        }

        List<Payment> list = findByFactor(factorId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the payments before and after the current payment in the ordered set where factorId = &#63;.
     *
     * @param id the primary key of the current payment
     * @param factorId the factor ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a payment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment[] findByFactor_PrevAndNext(long id, long factorId,
        OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Payment[] array = new PaymentImpl[3];

            array[0] = getByFactor_PrevAndNext(session, payment, factorId,
                    orderByComparator, true);

            array[1] = payment;

            array[2] = getByFactor_PrevAndNext(session, payment, factorId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Payment getByFactor_PrevAndNext(Session session, Payment payment,
        long factorId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PAYMENT_WHERE);

        query.append(_FINDER_COLUMN_FACTOR_FACTORID_2);

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
            query.append(PaymentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(factorId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(payment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Payment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the payments where factorId = &#63; from the database.
     *
     * @param factorId the factor ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByFactor(long factorId) throws SystemException {
        for (Payment payment : findByFactor(factorId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(payment);
        }
    }

    /**
     * Returns the number of payments where factorId = &#63;.
     *
     * @param factorId the factor ID
     * @return the number of matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByFactor(long factorId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_FACTOR;

        Object[] finderArgs = new Object[] { factorId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PAYMENT_WHERE);

            query.append(_FINDER_COLUMN_FACTOR_FACTORID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(factorId);

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
     * Returns all the payments where status = &#63;.
     *
     * @param status the status
     * @return the matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByStatus(int status) throws SystemException {
        return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the payments where status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param status the status
     * @param start the lower bound of the range of payments
     * @param end the upper bound of the range of payments (not inclusive)
     * @return the range of matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByStatus(int status, int start, int end)
        throws SystemException {
        return findByStatus(status, start, end, null);
    }

    /**
     * Returns an ordered range of all the payments where status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param status the status
     * @param start the lower bound of the range of payments
     * @param end the upper bound of the range of payments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findByStatus(int status, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
            finderArgs = new Object[] { status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
            finderArgs = new Object[] { status, start, end, orderByComparator };
        }

        List<Payment> list = (List<Payment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Payment payment : list) {
                if ((status != payment.getStatus())) {
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

            query.append(_SQL_SELECT_PAYMENT_WHERE);

            query.append(_FINDER_COLUMN_STATUS_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PaymentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(status);

                if (!pagination) {
                    list = (List<Payment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Payment>(list);
                } else {
                    list = (List<Payment>) QueryUtil.list(q, getDialect(),
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
     * Returns the first payment in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment findByStatus_First(int status,
        OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = fetchByStatus_First(status, orderByComparator);

        if (payment != null) {
            return payment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPaymentException(msg.toString());
    }

    /**
     * Returns the first payment in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching payment, or <code>null</code> if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment fetchByStatus_First(int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<Payment> list = findByStatus(status, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last payment in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment findByStatus_Last(int status,
        OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = fetchByStatus_Last(status, orderByComparator);

        if (payment != null) {
            return payment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPaymentException(msg.toString());
    }

    /**
     * Returns the last payment in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching payment, or <code>null</code> if a matching payment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment fetchByStatus_Last(int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByStatus(status);

        if (count == 0) {
            return null;
        }

        List<Payment> list = findByStatus(status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the payments before and after the current payment in the ordered set where status = &#63;.
     *
     * @param id the primary key of the current payment
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a payment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment[] findByStatus_PrevAndNext(long id, int status,
        OrderByComparator orderByComparator)
        throws NoSuchPaymentException, SystemException {
        Payment payment = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Payment[] array = new PaymentImpl[3];

            array[0] = getByStatus_PrevAndNext(session, payment, status,
                    orderByComparator, true);

            array[1] = payment;

            array[2] = getByStatus_PrevAndNext(session, payment, status,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Payment getByStatus_PrevAndNext(Session session, Payment payment,
        int status, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PAYMENT_WHERE);

        query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
            query.append(PaymentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(payment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Payment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the payments where status = &#63; from the database.
     *
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByStatus(int status) throws SystemException {
        for (Payment payment : findByStatus(status, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(payment);
        }
    }

    /**
     * Returns the number of payments where status = &#63;.
     *
     * @param status the status
     * @return the number of matching payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByStatus(int status) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

        Object[] finderArgs = new Object[] { status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PAYMENT_WHERE);

            query.append(_FINDER_COLUMN_STATUS_STATUS_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(status);

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
     * Caches the payment in the entity cache if it is enabled.
     *
     * @param payment the payment
     */
    @Override
    public void cacheResult(Payment payment) {
        EntityCacheUtil.putResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentImpl.class, payment.getPrimaryKey(), payment);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { payment.getUuid(), payment.getGroupId() }, payment);

        payment.resetOriginalValues();
    }

    /**
     * Caches the payments in the entity cache if it is enabled.
     *
     * @param payments the payments
     */
    @Override
    public void cacheResult(List<Payment> payments) {
        for (Payment payment : payments) {
            if (EntityCacheUtil.getResult(
                        PaymentModelImpl.ENTITY_CACHE_ENABLED,
                        PaymentImpl.class, payment.getPrimaryKey()) == null) {
                cacheResult(payment);
            } else {
                payment.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all payments.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PaymentImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PaymentImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the payment.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Payment payment) {
        EntityCacheUtil.removeResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentImpl.class, payment.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(payment);
    }

    @Override
    public void clearCache(List<Payment> payments) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Payment payment : payments) {
            EntityCacheUtil.removeResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
                PaymentImpl.class, payment.getPrimaryKey());

            clearUniqueFindersCache(payment);
        }
    }

    protected void cacheUniqueFindersCache(Payment payment) {
        if (payment.isNew()) {
            Object[] args = new Object[] { payment.getUuid(), payment.getGroupId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, payment);
        } else {
            PaymentModelImpl paymentModelImpl = (PaymentModelImpl) payment;

            if ((paymentModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        payment.getUuid(), payment.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    payment);
            }
        }
    }

    protected void clearUniqueFindersCache(Payment payment) {
        PaymentModelImpl paymentModelImpl = (PaymentModelImpl) payment;

        Object[] args = new Object[] { payment.getUuid(), payment.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((paymentModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    paymentModelImpl.getOriginalUuid(),
                    paymentModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new payment with the primary key. Does not add the payment to the database.
     *
     * @param id the primary key for the new payment
     * @return the new payment
     */
    @Override
    public Payment create(long id) {
        Payment payment = new PaymentImpl();

        payment.setNew(true);
        payment.setPrimaryKey(id);

        String uuid = PortalUUIDUtil.generate();

        payment.setUuid(uuid);

        return payment;
    }

    /**
     * Removes the payment with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the payment
     * @return the payment that was removed
     * @throws com.arman.csb.modules.NoSuchPaymentException if a payment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment remove(long id)
        throws NoSuchPaymentException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the payment with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the payment
     * @return the payment that was removed
     * @throws com.arman.csb.modules.NoSuchPaymentException if a payment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment remove(Serializable primaryKey)
        throws NoSuchPaymentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Payment payment = (Payment) session.get(PaymentImpl.class,
                    primaryKey);

            if (payment == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchPaymentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(payment);
        } catch (NoSuchPaymentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Payment removeImpl(Payment payment) throws SystemException {
        payment = toUnwrappedModel(payment);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(payment)) {
                payment = (Payment) session.get(PaymentImpl.class,
                        payment.getPrimaryKeyObj());
            }

            if (payment != null) {
                session.delete(payment);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (payment != null) {
            clearCache(payment);
        }

        return payment;
    }

    @Override
    public Payment updateImpl(com.arman.csb.modules.model.Payment payment)
        throws SystemException {
        payment = toUnwrappedModel(payment);

        boolean isNew = payment.isNew();

        PaymentModelImpl paymentModelImpl = (PaymentModelImpl) payment;

        if (Validator.isNull(payment.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            payment.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (payment.isNew()) {
                session.save(payment);

                payment.setNew(false);
            } else {
                session.merge(payment);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !PaymentModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((paymentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { paymentModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { paymentModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((paymentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        paymentModelImpl.getOriginalUuid(),
                        paymentModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        paymentModelImpl.getUuid(),
                        paymentModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((paymentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMER.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        paymentModelImpl.getOriginalCustomerId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUSTOMER, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMER,
                    args);

                args = new Object[] { paymentModelImpl.getCustomerId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUSTOMER, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMER,
                    args);
            }

            if ((paymentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACTOR.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        paymentModelImpl.getOriginalFactorId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACTOR, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACTOR,
                    args);

                args = new Object[] { paymentModelImpl.getFactorId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FACTOR, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FACTOR,
                    args);
            }

            if ((paymentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        paymentModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
                    args);

                args = new Object[] { paymentModelImpl.getStatus() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
                    args);
            }
        }

        EntityCacheUtil.putResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
            PaymentImpl.class, payment.getPrimaryKey(), payment);

        clearUniqueFindersCache(payment);
        cacheUniqueFindersCache(payment);

        return payment;
    }

    protected Payment toUnwrappedModel(Payment payment) {
        if (payment instanceof PaymentImpl) {
            return payment;
        }

        PaymentImpl paymentImpl = new PaymentImpl();

        paymentImpl.setNew(payment.isNew());
        paymentImpl.setPrimaryKey(payment.getPrimaryKey());

        paymentImpl.setUuid(payment.getUuid());
        paymentImpl.setId(payment.getId());
        paymentImpl.setGroupId(payment.getGroupId());
        paymentImpl.setCompanyId(payment.getCompanyId());
        paymentImpl.setUserId(payment.getUserId());
        paymentImpl.setCreateDate(payment.getCreateDate());
        paymentImpl.setModifiedDate(payment.getModifiedDate());
        paymentImpl.setDescription(payment.getDescription());
        paymentImpl.setCard(payment.getCard());
        paymentImpl.setAmount(payment.getAmount());
        paymentImpl.setStatus(payment.getStatus());
        paymentImpl.setPaymentDate(payment.getPaymentDate());
        paymentImpl.setCustomerId(payment.getCustomerId());
        paymentImpl.setFactorId(payment.getFactorId());

        return paymentImpl;
    }

    /**
     * Returns the payment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the payment
     * @return the payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a payment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment findByPrimaryKey(Serializable primaryKey)
        throws NoSuchPaymentException, SystemException {
        Payment payment = fetchByPrimaryKey(primaryKey);

        if (payment == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchPaymentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return payment;
    }

    /**
     * Returns the payment with the primary key or throws a {@link com.arman.csb.modules.NoSuchPaymentException} if it could not be found.
     *
     * @param id the primary key of the payment
     * @return the payment
     * @throws com.arman.csb.modules.NoSuchPaymentException if a payment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment findByPrimaryKey(long id)
        throws NoSuchPaymentException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the payment with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the payment
     * @return the payment, or <code>null</code> if a payment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Payment payment = (Payment) EntityCacheUtil.getResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
                PaymentImpl.class, primaryKey);

        if (payment == _nullPayment) {
            return null;
        }

        if (payment == null) {
            Session session = null;

            try {
                session = openSession();

                payment = (Payment) session.get(PaymentImpl.class, primaryKey);

                if (payment != null) {
                    cacheResult(payment);
                } else {
                    EntityCacheUtil.putResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
                        PaymentImpl.class, primaryKey, _nullPayment);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
                    PaymentImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return payment;
    }

    /**
     * Returns the payment with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the payment
     * @return the payment, or <code>null</code> if a payment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Payment fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the payments.
     *
     * @return the payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the payments.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of payments
     * @param end the upper bound of the range of payments (not inclusive)
     * @return the range of payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the payments.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of payments
     * @param end the upper bound of the range of payments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of payments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Payment> findAll(int start, int end,
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

        List<Payment> list = (List<Payment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PAYMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PAYMENT;

                if (pagination) {
                    sql = sql.concat(PaymentModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Payment>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Payment>(list);
                } else {
                    list = (List<Payment>) QueryUtil.list(q, getDialect(),
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
     * Removes all the payments from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Payment payment : findAll()) {
            remove(payment);
        }
    }

    /**
     * Returns the number of payments.
     *
     * @return the number of payments
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

                Query q = session.createQuery(_SQL_COUNT_PAYMENT);

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
     * Initializes the payment persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arman.csb.modules.model.Payment")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Payment>> listenersList = new ArrayList<ModelListener<Payment>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Payment>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PaymentImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
