package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InvoiceItemLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceItemLocalService
 * @generated
 */
public class InvoiceItemLocalServiceWrapper implements InvoiceItemLocalService,
    ServiceWrapper<InvoiceItemLocalService> {
    private InvoiceItemLocalService _invoiceItemLocalService;

    public InvoiceItemLocalServiceWrapper(
        InvoiceItemLocalService invoiceItemLocalService) {
        _invoiceItemLocalService = invoiceItemLocalService;
    }

    /**
    * Adds the invoice item to the database. Also notifies the appropriate model listeners.
    *
    * @param invoiceItem the invoice item
    * @return the invoice item that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.InvoiceItem addInvoiceItem(
        com.arman.csb.modules.model.InvoiceItem invoiceItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemLocalService.addInvoiceItem(invoiceItem);
    }

    /**
    * Creates a new invoice item with the primary key. Does not add the invoice item to the database.
    *
    * @param id the primary key for the new invoice item
    * @return the new invoice item
    */
    @Override
    public com.arman.csb.modules.model.InvoiceItem createInvoiceItem(long id) {
        return _invoiceItemLocalService.createInvoiceItem(id);
    }

    /**
    * Deletes the invoice item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the invoice item
    * @return the invoice item that was removed
    * @throws PortalException if a invoice item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.InvoiceItem deleteInvoiceItem(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemLocalService.deleteInvoiceItem(id);
    }

    /**
    * Deletes the invoice item from the database. Also notifies the appropriate model listeners.
    *
    * @param invoiceItem the invoice item
    * @return the invoice item that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.InvoiceItem deleteInvoiceItem(
        com.arman.csb.modules.model.InvoiceItem invoiceItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemLocalService.deleteInvoiceItem(invoiceItem);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _invoiceItemLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arman.csb.modules.model.InvoiceItem fetchInvoiceItem(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemLocalService.fetchInvoiceItem(id);
    }

    /**
    * Returns the invoice item with the primary key.
    *
    * @param id the primary key of the invoice item
    * @return the invoice item
    * @throws PortalException if a invoice item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.InvoiceItem getInvoiceItem(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemLocalService.getInvoiceItem(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<com.arman.csb.modules.model.InvoiceItem> getInvoiceItems(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemLocalService.getInvoiceItems(start, end);
    }

    /**
    * Returns the number of invoice items.
    *
    * @return the number of invoice items
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getInvoiceItemsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemLocalService.getInvoiceItemsCount();
    }

    /**
    * Updates the invoice item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param invoiceItem the invoice item
    * @return the invoice item that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.InvoiceItem updateInvoiceItem(
        com.arman.csb.modules.model.InvoiceItem invoiceItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemLocalService.updateInvoiceItem(invoiceItem);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _invoiceItemLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _invoiceItemLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _invoiceItemLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public InvoiceItemLocalService getWrappedInvoiceItemLocalService() {
        return _invoiceItemLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedInvoiceItemLocalService(
        InvoiceItemLocalService invoiceItemLocalService) {
        _invoiceItemLocalService = invoiceItemLocalService;
    }

    @Override
    public InvoiceItemLocalService getWrappedService() {
        return _invoiceItemLocalService;
    }

    @Override
    public void setWrappedService(
        InvoiceItemLocalService invoiceItemLocalService) {
        _invoiceItemLocalService = invoiceItemLocalService;
    }
}
