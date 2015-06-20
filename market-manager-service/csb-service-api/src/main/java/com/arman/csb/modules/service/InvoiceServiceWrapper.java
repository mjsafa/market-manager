package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InvoiceService}.
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceService
 * @generated
 */
public class InvoiceServiceWrapper implements InvoiceService,
    ServiceWrapper<InvoiceService> {
    private InvoiceService _invoiceService;

    public InvoiceServiceWrapper(InvoiceService invoiceService) {
        _invoiceService = invoiceService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _invoiceService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _invoiceService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _invoiceService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject addInvoice(
        java.util.Map<java.lang.String, java.lang.Object> invoice,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _invoiceService.addInvoice(invoice, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject updateInvoice(
        java.util.Map<java.lang.String, java.lang.Object> invoice,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _invoiceService.updateInvoice(invoice, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject search(
        java.lang.String text, java.lang.String status, long customerId,
        java.util.Date fromDate, java.util.Date toDate, int start,
        int maxResult, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _invoiceService.search(text, status, customerId, fromDate,
            toDate, start, maxResult, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject getById(long invoiceId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _invoiceService.getById(invoiceId, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject updateInvoiceStatus(
        long invoiceId, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _invoiceService.updateInvoiceStatus(invoiceId, status,
            serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public InvoiceService getWrappedInvoiceService() {
        return _invoiceService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedInvoiceService(InvoiceService invoiceService) {
        _invoiceService = invoiceService;
    }

    @Override
    public InvoiceService getWrappedService() {
        return _invoiceService;
    }

    @Override
    public void setWrappedService(InvoiceService invoiceService) {
        _invoiceService = invoiceService;
    }
}
