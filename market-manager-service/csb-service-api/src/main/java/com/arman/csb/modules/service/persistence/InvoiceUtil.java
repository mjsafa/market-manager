package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.Invoice;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the invoice service. This utility wraps {@link InvoicePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvoicePersistence
 * @see InvoicePersistenceImpl
 * @generated
 */
public class InvoiceUtil {
    private static InvoicePersistence _persistence;

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
    public static void clearCache(Invoice invoice) {
        getPersistence().clearCache(invoice);
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
    public static List<Invoice> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Invoice> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Invoice> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Invoice update(Invoice invoice) throws SystemException {
        return getPersistence().update(invoice);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Invoice update(Invoice invoice, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(invoice, serviceContext);
    }

    /**
    * Returns all the invoices where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the invoices where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of invoices
    * @param end the upper bound of the range of invoices (not inclusive)
    * @return the range of matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the invoices where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of invoices
    * @param end the upper bound of the range of invoices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first invoice in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching invoice
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first invoice in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching invoice, or <code>null</code> if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last invoice in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching invoice
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last invoice in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching invoice, or <code>null</code> if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the invoices before and after the current invoice in the ordered set where uuid = &#63;.
    *
    * @param id the primary key of the current invoice
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next invoice
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a invoice with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
    }

    /**
    * Removes all the invoices where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of invoices where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the invoice where uuid = &#63; and groupId = &#63; or throws a {@link com.arman.csb.modules.NoSuchInvoiceException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching invoice
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the invoice where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching invoice, or <code>null</code> if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the invoice where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching invoice, or <code>null</code> if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the invoice where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the invoice that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of invoices where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the invoices where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the invoices where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of invoices
    * @param end the upper bound of the range of invoices (not inclusive)
    * @return the range of matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the invoices where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of invoices
    * @param end the upper bound of the range of invoices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first invoice in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching invoice
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first invoice in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching invoice, or <code>null</code> if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last invoice in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching invoice
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last invoice in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching invoice, or <code>null</code> if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the invoices before and after the current invoice in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param id the primary key of the current invoice
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next invoice
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a invoice with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice[] findByUuid_C_PrevAndNext(
        long id, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(id, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the invoices where uuid = &#63; and companyId = &#63; from the database.
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
    * Returns the number of invoices where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the invoices where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId);
    }

    /**
    * Returns a range of all the invoices where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of invoices
    * @param end the upper bound of the range of invoices (not inclusive)
    * @return the range of matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    /**
    * Returns an ordered range of all the invoices where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of invoices
    * @param end the upper bound of the range of invoices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first invoice in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching invoice
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice findByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first invoice in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching invoice, or <code>null</code> if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice fetchByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last invoice in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching invoice
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice findByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last invoice in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching invoice, or <code>null</code> if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice fetchByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the invoices before and after the current invoice in the ordered set where userId = &#63;.
    *
    * @param id the primary key of the current invoice
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next invoice
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a invoice with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice[] findByUserId_PrevAndNext(
        long id, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId_PrevAndNext(id, userId, orderByComparator);
    }

    /**
    * Removes all the invoices where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserId(userId);
    }

    /**
    * Returns the number of invoices where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserId(userId);
    }

    /**
    * Returns all the invoices where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @return the matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findByCustomerId(
        long customerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCustomerId(customerId);
    }

    /**
    * Returns a range of all the invoices where customerId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param customerId the customer ID
    * @param start the lower bound of the range of invoices
    * @param end the upper bound of the range of invoices (not inclusive)
    * @return the range of matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findByCustomerId(
        long customerId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCustomerId(customerId, start, end);
    }

    /**
    * Returns an ordered range of all the invoices where customerId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param customerId the customer ID
    * @param start the lower bound of the range of invoices
    * @param end the upper bound of the range of invoices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findByCustomerId(
        long customerId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCustomerId(customerId, start, end, orderByComparator);
    }

    /**
    * Returns the first invoice in the ordered set where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching invoice
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice findByCustomerId_First(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCustomerId_First(customerId, orderByComparator);
    }

    /**
    * Returns the first invoice in the ordered set where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching invoice, or <code>null</code> if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice fetchByCustomerId_First(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCustomerId_First(customerId, orderByComparator);
    }

    /**
    * Returns the last invoice in the ordered set where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching invoice
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice findByCustomerId_Last(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCustomerId_Last(customerId, orderByComparator);
    }

    /**
    * Returns the last invoice in the ordered set where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching invoice, or <code>null</code> if a matching invoice could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice fetchByCustomerId_Last(
        long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCustomerId_Last(customerId, orderByComparator);
    }

    /**
    * Returns the invoices before and after the current invoice in the ordered set where customerId = &#63;.
    *
    * @param id the primary key of the current invoice
    * @param customerId the customer ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next invoice
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a invoice with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice[] findByCustomerId_PrevAndNext(
        long id, long customerId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCustomerId_PrevAndNext(id, customerId,
            orderByComparator);
    }

    /**
    * Removes all the invoices where customerId = &#63; from the database.
    *
    * @param customerId the customer ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCustomerId(long customerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCustomerId(customerId);
    }

    /**
    * Returns the number of invoices where customerId = &#63;.
    *
    * @param customerId the customer ID
    * @return the number of matching invoices
    * @throws SystemException if a system exception occurred
    */
    public static int countByCustomerId(long customerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCustomerId(customerId);
    }

    /**
    * Caches the invoice in the entity cache if it is enabled.
    *
    * @param invoice the invoice
    */
    public static void cacheResult(com.arman.csb.modules.model.Invoice invoice) {
        getPersistence().cacheResult(invoice);
    }

    /**
    * Caches the invoices in the entity cache if it is enabled.
    *
    * @param invoices the invoices
    */
    public static void cacheResult(
        java.util.List<com.arman.csb.modules.model.Invoice> invoices) {
        getPersistence().cacheResult(invoices);
    }

    /**
    * Creates a new invoice with the primary key. Does not add the invoice to the database.
    *
    * @param id the primary key for the new invoice
    * @return the new invoice
    */
    public static com.arman.csb.modules.model.Invoice create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the invoice with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the invoice
    * @return the invoice that was removed
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a invoice with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice remove(long id)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arman.csb.modules.model.Invoice updateImpl(
        com.arman.csb.modules.model.Invoice invoice)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(invoice);
    }

    /**
    * Returns the invoice with the primary key or throws a {@link com.arman.csb.modules.NoSuchInvoiceException} if it could not be found.
    *
    * @param id the primary key of the invoice
    * @return the invoice
    * @throws com.arman.csb.modules.NoSuchInvoiceException if a invoice with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice findByPrimaryKey(long id)
        throws com.arman.csb.modules.NoSuchInvoiceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the invoice with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the invoice
    * @return the invoice, or <code>null</code> if a invoice with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Invoice fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the invoices.
    *
    * @return the invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the invoices.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of invoices
    * @param end the upper bound of the range of invoices (not inclusive)
    * @return the range of invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the invoices.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of invoices
    * @param end the upper bound of the range of invoices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of invoices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.Invoice> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the invoices from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of invoices.
    *
    * @return the number of invoices
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static InvoicePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (InvoicePersistence) PortletBeanLocatorUtil.locate(com.arman.csb.modules.service.ClpSerializer.getServletContextName(),
                    InvoicePersistence.class.getName());

            ReferenceRegistry.registerReference(InvoiceUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(InvoicePersistence persistence) {
    }
}
