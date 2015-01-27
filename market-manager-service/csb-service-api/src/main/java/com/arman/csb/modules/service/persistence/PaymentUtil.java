package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.Payment;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the payment service. This utility wraps {@link PaymentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PaymentPersistence
 * @see PaymentPersistenceImpl
 * @generated
 */
public class PaymentUtil {
    private static PaymentPersistence _persistence;

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
    public static void clearCache(Payment payment) {
        getPersistence().clearCache(payment);
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
    public static List<Payment> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Payment> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Payment> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Payment update(Payment payment) throws SystemException {
        return getPersistence().update(payment);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Payment update(Payment payment, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(payment, serviceContext);
    }

    /**
    * Returns all the payments where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching payments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Payment> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
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
    public static java.util.List<com.arman.csb.modules.model.Payment> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
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
    public static java.util.List<com.arman.csb.modules.model.Payment> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
    public static com.arman.csb.modules.model.Payment findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first payment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
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
    public static com.arman.csb.modules.model.Payment findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last payment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
    public static com.arman.csb.modules.model.Payment[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
    }

    /**
    * Removes all the payments where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of payments where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching payments
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
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
    public static com.arman.csb.modules.model.Payment findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the payment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
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
    public static com.arman.csb.modules.model.Payment fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the payment where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the payment that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of payments where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching payments
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the payments where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching payments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Payment> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
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
    public static java.util.List<com.arman.csb.modules.model.Payment> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
    public static java.util.List<com.arman.csb.modules.model.Payment> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
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
    public static com.arman.csb.modules.model.Payment findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
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
    public static com.arman.csb.modules.model.Payment fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
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
    public static com.arman.csb.modules.model.Payment findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
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
    public static com.arman.csb.modules.model.Payment fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
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
    public static com.arman.csb.modules.model.Payment[] findByUuid_C_PrevAndNext(
        long id, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(id, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the payments where uuid = &#63; and companyId = &#63; from the database.
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
    * Returns the number of payments where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching payments
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the payments where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @return the matching payments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Payment> findByCustomer(
        long customerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCustomer(customerId);
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
    public static java.util.List<com.arman.csb.modules.model.Payment> findByCustomer(
        long customerId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCustomer(customerId, start, end);
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
    public static java.util.List<com.arman.csb.modules.model.Payment> findByCustomer(
        long customerId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCustomer(customerId, start, end, orderByComparator);
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
    public static com.arman.csb.modules.model.Payment findByCustomer_First(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCustomer_First(customerId, orderByComparator);
    }

    /**
    * Returns the first payment in the ordered set where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment fetchByCustomer_First(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCustomer_First(customerId, orderByComparator);
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
    public static com.arman.csb.modules.model.Payment findByCustomer_Last(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCustomer_Last(customerId, orderByComparator);
    }

    /**
    * Returns the last payment in the ordered set where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment fetchByCustomer_Last(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCustomer_Last(customerId, orderByComparator);
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
    public static com.arman.csb.modules.model.Payment[] findByCustomer_PrevAndNext(
        long id, long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCustomer_PrevAndNext(id, customerId, orderByComparator);
    }

    /**
    * Removes all the payments where customerId = &#63; from the database.
    *
    * @param customerId the customer ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCustomer(long customerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCustomer(customerId);
    }

    /**
    * Returns the number of payments where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @return the number of matching payments
    * @throws SystemException if a system exception occurred
    */
    public static int countByCustomer(long customerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCustomer(customerId);
    }

    /**
    * Returns all the payments where factorId = &#63;.
    *
    * @param factorId the factor ID
    * @return the matching payments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Payment> findByFactor(
        long factorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFactor(factorId);
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
    public static java.util.List<com.arman.csb.modules.model.Payment> findByFactor(
        long factorId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFactor(factorId, start, end);
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
    public static java.util.List<com.arman.csb.modules.model.Payment> findByFactor(
        long factorId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFactor(factorId, start, end, orderByComparator);
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
    public static com.arman.csb.modules.model.Payment findByFactor_First(
        long factorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFactor_First(factorId, orderByComparator);
    }

    /**
    * Returns the first payment in the ordered set where factorId = &#63;.
    *
    * @param factorId the factor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment fetchByFactor_First(
        long factorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByFactor_First(factorId, orderByComparator);
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
    public static com.arman.csb.modules.model.Payment findByFactor_Last(
        long factorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFactor_Last(factorId, orderByComparator);
    }

    /**
    * Returns the last payment in the ordered set where factorId = &#63;.
    *
    * @param factorId the factor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment fetchByFactor_Last(
        long factorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByFactor_Last(factorId, orderByComparator);
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
    public static com.arman.csb.modules.model.Payment[] findByFactor_PrevAndNext(
        long id, long factorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFactor_PrevAndNext(id, factorId, orderByComparator);
    }

    /**
    * Removes all the payments where factorId = &#63; from the database.
    *
    * @param factorId the factor ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByFactor(long factorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByFactor(factorId);
    }

    /**
    * Returns the number of payments where factorId = &#63;.
    *
    * @param factorId the factor ID
    * @return the number of matching payments
    * @throws SystemException if a system exception occurred
    */
    public static int countByFactor(long factorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByFactor(factorId);
    }

    /**
    * Caches the payment in the entity cache if it is enabled.
    *
    * @param payment the payment
    */
    public static void cacheResult(com.arman.csb.modules.model.Payment payment) {
        getPersistence().cacheResult(payment);
    }

    /**
    * Caches the payments in the entity cache if it is enabled.
    *
    * @param payments the payments
    */
    public static void cacheResult(
        java.util.List<com.arman.csb.modules.model.Payment> payments) {
        getPersistence().cacheResult(payments);
    }

    /**
    * Creates a new payment with the primary key. Does not add the payment to the database.
    *
    * @param id the primary key for the new payment
    * @return the new payment
    */
    public static com.arman.csb.modules.model.Payment create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the payment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the payment
    * @return the payment that was removed
    * @throws com.arman.csb.modules.NoSuchPaymentException if a payment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment remove(long id)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arman.csb.modules.model.Payment updateImpl(
        com.arman.csb.modules.model.Payment payment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(payment);
    }

    /**
    * Returns the payment with the primary key or throws a {@link com.arman.csb.modules.NoSuchPaymentException} if it could not be found.
    *
    * @param id the primary key of the payment
    * @return the payment
    * @throws com.arman.csb.modules.NoSuchPaymentException if a payment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment findByPrimaryKey(long id)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the payment with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the payment
    * @return the payment, or <code>null</code> if a payment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the payments.
    *
    * @return the payments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Payment> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.arman.csb.modules.model.Payment> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.arman.csb.modules.model.Payment> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the payments from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of payments.
    *
    * @return the number of payments
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static PaymentPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (PaymentPersistence) PortletBeanLocatorUtil.locate(com.arman.csb.modules.service.ClpSerializer.getServletContextName(),
                    PaymentPersistence.class.getName());

            ReferenceRegistry.registerReference(PaymentUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(PaymentPersistence persistence) {
    }
}
