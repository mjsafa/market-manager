package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InvoiceItemService}.
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceItemService
 * @generated
 */
public class InvoiceItemServiceWrapper implements InvoiceItemService,
    ServiceWrapper<InvoiceItemService> {
    private InvoiceItemService _invoiceItemService;

    public InvoiceItemServiceWrapper(InvoiceItemService invoiceItemService) {
        _invoiceItemService = invoiceItemService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _invoiceItemService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _invoiceItemService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _invoiceItemService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject addInvoiceItem(
        java.util.Map<java.lang.String, java.lang.Object> invoiceItem,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemService.addInvoiceItem(invoiceItem, serviceContext);
    }

    @Override
    public java.lang.Long deleteInvoiceItem(long invoiceItemId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemService.deleteInvoiceItem(invoiceItemId,
            serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONArray search(
        java.lang.String filter, long invoiceId, int start, int maxResult,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _invoiceItemService.search(filter, invoiceId, start, maxResult,
            serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public InvoiceItemService getWrappedInvoiceItemService() {
        return _invoiceItemService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedInvoiceItemService(
        InvoiceItemService invoiceItemService) {
        _invoiceItemService = invoiceItemService;
    }

    @Override
    public InvoiceItemService getWrappedService() {
        return _invoiceItemService;
    }

    @Override
    public void setWrappedService(InvoiceItemService invoiceItemService) {
        _invoiceItemService = invoiceItemService;
    }
}
