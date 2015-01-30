package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.InvoiceItem;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the invoice item service. This utility wraps {@link InvoiceItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceItemPersistence
 * @see InvoiceItemPersistenceImpl
 * @generated
 */
public class InvoiceItemUtil {
    private static InvoiceItemPersistence _persistence;

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
    public static void clearCache(InvoiceItem invoiceItem) {
        getPersistence().clearCache(invoiceItem);
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
    public static List<InvoiceItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<InvoiceItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<InvoiceItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static InvoiceItem update(InvoiceItem invoiceItem)
        throws SystemException {
        return getPersistence().update(invoiceItem);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static InvoiceItem update(InvoiceItem invoiceItem,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(invoiceItem, serviceContext);
    }

    /**
    * Returns all the invoice items where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching invoice items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.InvoiceItem> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the invoice items where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of invoice items
    * @param end the upper bound of the range of invoice items (not inclusive)
    * @return the range of matching invoice items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.InvoiceItem> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the invoice items where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of invoice items
    * @param end the upper bound of the range of invoice items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching invoice items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.InvoiceItem> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first invoice item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching invoice item
    * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.InvoiceItem findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first invoice item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching invoice item, or <code>null</code> if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.InvoiceItem fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last invoice item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching invoice item
    * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.InvoiceItem findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last invoice item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching invoice item, or <code>null</code> if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.InvoiceItem fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the invoice items before and after the current invoice item in the ordered set where uuid = &#63;.
    *
    * @param id the primary key of the current invoice item
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next invoice item
    * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a invoice item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.InvoiceItem[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
    }

    /**
    * Removes all the invoice items where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of invoice items where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching invoice items
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns all the invoice items where invoiceId = &#63;.
    *
    * @param invoiceId the invoice ID
    * @return the matching invoice items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.InvoiceItem> findByInvoiceId(
        long invoiceId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByInvoiceId(invoiceId);
    }

    /**
    * Returns a range of all the invoice items where invoiceId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param invoiceId the invoice ID
    * @param start the lower bound of the range of invoice items
    * @param end the upper bound of the range of invoice items (not inclusive)
    * @return the range of matching invoice items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.InvoiceItem> findByInvoiceId(
        long invoiceId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByInvoiceId(invoiceId, start, end);
    }

    /**
    * Returns an ordered range of all the invoice items where invoiceId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param invoiceId the invoice ID
    * @param start the lower bound of the range of invoice items
    * @param end the upper bound of the range of invoice items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching invoice items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.InvoiceItem> findByInvoiceId(
        long invoiceId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByInvoiceId(invoiceId, start, end, orderByComparator);
    }

    /**
    * Returns the first invoice item in the ordered set where invoiceId = &#63;.
    *
    * @param invoiceId the invoice ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching invoice item
    * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.InvoiceItem findByInvoiceId_First(
        long invoiceId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByInvoiceId_First(invoiceId, orderByComparator);
    }

    /**
    * Returns the first invoice item in the ordered set where invoiceId = &#63;.
    *
    * @param invoiceId the invoice ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching invoice item, or <code>null</code> if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.InvoiceItem fetchByInvoiceId_First(
        long invoiceId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByInvoiceId_First(invoiceId, orderByComparator);
    }

    /**
    * Returns the last invoice item in the ordered set where invoiceId = &#63;.
    *
    * @param invoiceId the invoice ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching invoice item
    * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.InvoiceItem findByInvoiceId_Last(
        long invoiceId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByInvoiceId_Last(invoiceId, orderByComparator);
    }

    /**
    * Returns the last invoice item in the ordered set where invoiceId = &#63;.
    *
    * @param invoiceId the invoice ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching invoice item, or <code>null</code> if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.InvoiceItem fetchByInvoiceId_Last(
        long invoiceId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByInvoiceId_Last(invoiceId, orderByComparator);
    }

    /**
    * Returns the invoice items before and after the current invoice item in the ordered set where invoiceId = &#63;.
    *
    * @param id the primary key of the current invoice item
    * @param invoiceId the invoice ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next invoice item
    * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a invoice item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.InvoiceItem[] findByInvoiceId_PrevAndNext(
        long id, long invoiceId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByInvoiceId_PrevAndNext(id, invoiceId, orderByComparator);
    }

    /**
    * Removes all the invoice items where invoiceId = &#63; from the database.
    *
    * @param invoiceId the invoice ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByInvoiceId(long invoiceId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByInvoiceId(invoiceId);
    }

    /**
    * Returns the number of invoice items where invoiceId = &#63;.
    *
    * @param invoiceId the invoice ID
    * @return the number of matching invoice items
    * @throws SystemException if a system exception occurred
    */
    public static int countByInvoiceId(long invoiceId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByInvoiceId(invoiceId);
    }

    /**
    * Caches the invoice item in the entity cache if it is enabled.
    *
    * @param invoiceItem the invoice item
    */
    public static void cacheResult(
        com.arman.csb.modules.model.InvoiceItem invoiceItem) {
        getPersistence().cacheResult(invoiceItem);
    }

    /**
    * Caches the invoice items in the entity cache if it is enabled.
    *
    * @param invoiceItems the invoice items
    */
    public static void cacheResult(
        java.util.List<com.arman.csb.modules.model.InvoiceItem> invoiceItems) {
        getPersistence().cacheResult(invoiceItems);
    }

    /**
    * Creates a new invoice item with the primary key. Does not add the invoice item to the database.
    *
    * @param id the primary key for the new invoice item
    * @return the new invoice item
    */
    public static com.arman.csb.modules.model.InvoiceItem create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the invoice item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the invoice item
    * @return the invoice item that was removed
    * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a invoice item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.InvoiceItem remove(long id)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arman.csb.modules.model.InvoiceItem updateImpl(
        com.arman.csb.modules.model.InvoiceItem invoiceItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(invoiceItem);
    }

    /**
    * Returns the invoice item with the primary key or throws a {@link com.arman.csb.modules.NoSuchInvoiceItemException} if it could not be found.
    *
    * @param id the primary key of the invoice item
    * @return the invoice item
    * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a invoice item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.InvoiceItem findByPrimaryKey(
        long id)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the invoice item with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the invoice item
    * @return the invoice item, or <code>null</code> if a invoice item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.InvoiceItem fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the invoice items.
    *
    * @return the invoice items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.InvoiceItem> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the invoice items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of invoice items
    * @param end the upper bound of the range of invoice items (not inclusive)
    * @return the range of invoice items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.InvoiceItem> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the invoice items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of invoice items
    * @param end the upper bound of the range of invoice items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of invoice items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arman.csb.modules.model.InvoiceItem> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the invoice items from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of invoice items.
    *
    * @return the number of invoice items
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static InvoiceItemPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (InvoiceItemPersistence) PortletBeanLocatorUtil.locate(com.arman.csb.modules.service.ClpSerializer.getServletContextName(),
                    InvoiceItemPersistence.class.getName());

            ReferenceRegistry.registerReference(InvoiceItemUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(InvoiceItemPersistence persistence) {
    }
}
