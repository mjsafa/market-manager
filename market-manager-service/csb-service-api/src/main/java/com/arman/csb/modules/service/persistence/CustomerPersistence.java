package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.Customer;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerPersistenceImpl
 * @see CustomerUtil
 * @generated
 */
public interface CustomerPersistence extends BasePersistence<Customer> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CustomerUtil} to access the customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the customers where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching customers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Customer> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the customers where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of customers
    * @param end the upper bound of the range of customers (not inclusive)
    * @return the range of matching customers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Customer> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the customers where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of customers
    * @param end the upper bound of the range of customers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching customers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Customer> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first customer in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching customer
    * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first customer in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching customer, or <code>null</code> if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last customer in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching customer
    * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last customer in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching customer, or <code>null</code> if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the customers before and after the current customer in the ordered set where uuid = &#63;.
    *
    * @param id the primary key of the current customer
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next customer
    * @throws com.arman.csb.modules.NoSuchCustomerException if a customer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the customers where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of customers where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching customers
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the customer where uuid = &#63; and groupId = &#63; or throws a {@link com.arman.csb.modules.NoSuchCustomerException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching customer
    * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the customer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching customer, or <code>null</code> if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the customer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching customer, or <code>null</code> if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the customer where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the customer that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of customers where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching customers
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the customers where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching customers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Customer> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the customers where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of customers
    * @param end the upper bound of the range of customers (not inclusive)
    * @return the range of matching customers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Customer> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the customers where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of customers
    * @param end the upper bound of the range of customers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching customers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Customer> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first customer in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching customer
    * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first customer in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching customer, or <code>null</code> if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last customer in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching customer
    * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last customer in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching customer, or <code>null</code> if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the customers before and after the current customer in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param id the primary key of the current customer
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next customer
    * @throws com.arman.csb.modules.NoSuchCustomerException if a customer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer[] findByUuid_C_PrevAndNext(
        long id, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the customers where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of customers where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching customers
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the customers where mentorCustomerId = &#63;.
    *
    * @param mentorCustomerId the mentor customer ID
    * @return the matching customers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Customer> findByMentor(
        long mentorCustomerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the customers where mentorCustomerId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param mentorCustomerId the mentor customer ID
    * @param start the lower bound of the range of customers
    * @param end the upper bound of the range of customers (not inclusive)
    * @return the range of matching customers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Customer> findByMentor(
        long mentorCustomerId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the customers where mentorCustomerId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param mentorCustomerId the mentor customer ID
    * @param start the lower bound of the range of customers
    * @param end the upper bound of the range of customers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching customers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Customer> findByMentor(
        long mentorCustomerId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first customer in the ordered set where mentorCustomerId = &#63;.
    *
    * @param mentorCustomerId the mentor customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching customer
    * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer findByMentor_First(
        long mentorCustomerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first customer in the ordered set where mentorCustomerId = &#63;.
    *
    * @param mentorCustomerId the mentor customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching customer, or <code>null</code> if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer fetchByMentor_First(
        long mentorCustomerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last customer in the ordered set where mentorCustomerId = &#63;.
    *
    * @param mentorCustomerId the mentor customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching customer
    * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer findByMentor_Last(
        long mentorCustomerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last customer in the ordered set where mentorCustomerId = &#63;.
    *
    * @param mentorCustomerId the mentor customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching customer, or <code>null</code> if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer fetchByMentor_Last(
        long mentorCustomerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the customers before and after the current customer in the ordered set where mentorCustomerId = &#63;.
    *
    * @param id the primary key of the current customer
    * @param mentorCustomerId the mentor customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next customer
    * @throws com.arman.csb.modules.NoSuchCustomerException if a customer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer[] findByMentor_PrevAndNext(
        long id, long mentorCustomerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the customers where mentorCustomerId = &#63; from the database.
    *
    * @param mentorCustomerId the mentor customer ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByMentor(long mentorCustomerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of customers where mentorCustomerId = &#63;.
    *
    * @param mentorCustomerId the mentor customer ID
    * @return the number of matching customers
    * @throws SystemException if a system exception occurred
    */
    public int countByMentor(long mentorCustomerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the customer where customerUserId = &#63; or throws a {@link com.arman.csb.modules.NoSuchCustomerException} if it could not be found.
    *
    * @param customerUserId the customer user ID
    * @return the matching customer
    * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer findByUserId(
        long customerUserId)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the customer where customerUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param customerUserId the customer user ID
    * @return the matching customer, or <code>null</code> if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer fetchByUserId(
        long customerUserId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the customer where customerUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param customerUserId the customer user ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching customer, or <code>null</code> if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer fetchByUserId(
        long customerUserId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the customer where customerUserId = &#63; from the database.
    *
    * @param customerUserId the customer user ID
    * @return the customer that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer removeByUserId(
        long customerUserId)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of customers where customerUserId = &#63;.
    *
    * @param customerUserId the customer user ID
    * @return the number of matching customers
    * @throws SystemException if a system exception occurred
    */
    public int countByUserId(long customerUserId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the customer in the entity cache if it is enabled.
    *
    * @param customer the customer
    */
    public void cacheResult(com.arman.csb.modules.model.Customer customer);

    /**
    * Caches the customers in the entity cache if it is enabled.
    *
    * @param customers the customers
    */
    public void cacheResult(
        java.util.List<com.arman.csb.modules.model.Customer> customers);

    /**
    * Creates a new customer with the primary key. Does not add the customer to the database.
    *
    * @param id the primary key for the new customer
    * @return the new customer
    */
    public com.arman.csb.modules.model.Customer create(long id);

    /**
    * Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the customer
    * @return the customer that was removed
    * @throws com.arman.csb.modules.NoSuchCustomerException if a customer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer remove(long id)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arman.csb.modules.model.Customer updateImpl(
        com.arman.csb.modules.model.Customer customer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the customer with the primary key or throws a {@link com.arman.csb.modules.NoSuchCustomerException} if it could not be found.
    *
    * @param id the primary key of the customer
    * @return the customer
    * @throws com.arman.csb.modules.NoSuchCustomerException if a customer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer findByPrimaryKey(long id)
        throws com.arman.csb.modules.NoSuchCustomerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the customer with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the customer
    * @return the customer, or <code>null</code> if a customer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Customer fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the customers.
    *
    * @return the customers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Customer> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the customers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of customers
    * @param end the upper bound of the range of customers (not inclusive)
    * @return the range of customers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Customer> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the customers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of customers
    * @param end the upper bound of the range of customers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of customers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Customer> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the customers from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of customers.
    *
    * @return the number of customers
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
