package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.Payment;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PaymentPersistenceImpl
 * @see PaymentUtil
 * @generated
 */
public interface PaymentPersistence extends BasePersistence<Payment> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PaymentUtil} to access the payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the payments where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching payments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Payment> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.modules.model.Payment> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.modules.model.Payment> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first payment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching payment
    * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first payment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last payment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching payment
    * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last payment in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arman.csb.modules.model.Payment[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the payments where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of payments where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching payments
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the payment where uuid = &#63; and groupId = &#63; or throws a {@link com.arman.csb.modules.NoSuchPaymentException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching payment
    * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the payment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the payment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the payment where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the payment that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of payments where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching payments
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the payments where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching payments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Payment> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.modules.model.Payment> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.modules.model.Payment> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arman.csb.modules.model.Payment findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first payment in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arman.csb.modules.model.Payment findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last payment in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arman.csb.modules.model.Payment[] findByUuid_C_PrevAndNext(
        long id, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the payments where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of payments where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching payments
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the payments where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @return the matching payments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Payment> findByCustomer(
        long customerId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.modules.model.Payment> findByCustomer(
        long customerId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.modules.model.Payment> findByCustomer(
        long customerId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first payment in the ordered set where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching payment
    * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment findByCustomer_First(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first payment in the ordered set where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByCustomer_First(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last payment in the ordered set where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching payment
    * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment findByCustomer_Last(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last payment in the ordered set where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByCustomer_Last(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arman.csb.modules.model.Payment[] findByCustomer_PrevAndNext(
        long id, long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the payments where customerId = &#63; from the database.
    *
    * @param customerId the customer ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCustomer(long customerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of payments where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @return the number of matching payments
    * @throws SystemException if a system exception occurred
    */
    public int countByCustomer(long customerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the payments where factorId = &#63;.
    *
    * @param factorId the factor ID
    * @return the matching payments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Payment> findByFactor(
        long factorId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.modules.model.Payment> findByFactor(
        long factorId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.modules.model.Payment> findByFactor(
        long factorId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first payment in the ordered set where factorId = &#63;.
    *
    * @param factorId the factor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching payment
    * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment findByFactor_First(
        long factorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first payment in the ordered set where factorId = &#63;.
    *
    * @param factorId the factor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByFactor_First(
        long factorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last payment in the ordered set where factorId = &#63;.
    *
    * @param factorId the factor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching payment
    * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment findByFactor_Last(
        long factorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last payment in the ordered set where factorId = &#63;.
    *
    * @param factorId the factor ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByFactor_Last(
        long factorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arman.csb.modules.model.Payment[] findByFactor_PrevAndNext(
        long id, long factorId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the payments where factorId = &#63; from the database.
    *
    * @param factorId the factor ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByFactor(long factorId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of payments where factorId = &#63;.
    *
    * @param factorId the factor ID
    * @return the number of matching payments
    * @throws SystemException if a system exception occurred
    */
    public int countByFactor(long factorId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the payments where status = &#63;.
    *
    * @param status the status
    * @return the matching payments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Payment> findByStatus(
        int status) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.modules.model.Payment> findByStatus(
        int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.modules.model.Payment> findByStatus(
        int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first payment in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching payment
    * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment findByStatus_First(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first payment in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByStatus_First(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last payment in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching payment
    * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment findByStatus_Last(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last payment in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByStatus_Last(int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arman.csb.modules.model.Payment[] findByStatus_PrevAndNext(
        long id, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the payments where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByStatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of payments where status = &#63;.
    *
    * @param status the status
    * @return the number of matching payments
    * @throws SystemException if a system exception occurred
    */
    public int countByStatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the payments where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the matching payments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Payment> findByStatusAndGroup(
        long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the payments where groupId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of payments
    * @param end the upper bound of the range of payments (not inclusive)
    * @return the range of matching payments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Payment> findByStatusAndGroup(
        long groupId, int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the payments where groupId = &#63; and status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param status the status
    * @param start the lower bound of the range of payments
    * @param end the upper bound of the range of payments (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching payments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Payment> findByStatusAndGroup(
        long groupId, int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first payment in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching payment
    * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment findByStatusAndGroup_First(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first payment in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByStatusAndGroup_First(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last payment in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching payment
    * @throws com.arman.csb.modules.NoSuchPaymentException if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment findByStatusAndGroup_Last(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last payment in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByStatusAndGroup_Last(
        long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the payments before and after the current payment in the ordered set where groupId = &#63; and status = &#63;.
    *
    * @param id the primary key of the current payment
    * @param groupId the group ID
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next payment
    * @throws com.arman.csb.modules.NoSuchPaymentException if a payment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment[] findByStatusAndGroup_PrevAndNext(
        long id, long groupId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the payments where groupId = &#63; and status = &#63; from the database.
    *
    * @param groupId the group ID
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByStatusAndGroup(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of payments where groupId = &#63; and status = &#63;.
    *
    * @param groupId the group ID
    * @param status the status
    * @return the number of matching payments
    * @throws SystemException if a system exception occurred
    */
    public int countByStatusAndGroup(long groupId, int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the payment in the entity cache if it is enabled.
    *
    * @param payment the payment
    */
    public void cacheResult(com.arman.csb.modules.model.Payment payment);

    /**
    * Caches the payments in the entity cache if it is enabled.
    *
    * @param payments the payments
    */
    public void cacheResult(
        java.util.List<com.arman.csb.modules.model.Payment> payments);

    /**
    * Creates a new payment with the primary key. Does not add the payment to the database.
    *
    * @param id the primary key for the new payment
    * @return the new payment
    */
    public com.arman.csb.modules.model.Payment create(long id);

    /**
    * Removes the payment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the payment
    * @return the payment that was removed
    * @throws com.arman.csb.modules.NoSuchPaymentException if a payment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment remove(long id)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arman.csb.modules.model.Payment updateImpl(
        com.arman.csb.modules.model.Payment payment)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the payment with the primary key or throws a {@link com.arman.csb.modules.NoSuchPaymentException} if it could not be found.
    *
    * @param id the primary key of the payment
    * @return the payment
    * @throws com.arman.csb.modules.NoSuchPaymentException if a payment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment findByPrimaryKey(long id)
        throws com.arman.csb.modules.NoSuchPaymentException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the payment with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the payment
    * @return the payment, or <code>null</code> if a payment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Payment fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the payments.
    *
    * @return the payments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Payment> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.modules.model.Payment> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arman.csb.modules.model.Payment> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the payments from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of payments.
    *
    * @return the number of payments
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
