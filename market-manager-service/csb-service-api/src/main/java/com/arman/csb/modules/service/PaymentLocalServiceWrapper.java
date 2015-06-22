package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PaymentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PaymentLocalService
 * @generated
 */
public class PaymentLocalServiceWrapper implements PaymentLocalService,
    ServiceWrapper<PaymentLocalService> {
    private PaymentLocalService _paymentLocalService;

    public PaymentLocalServiceWrapper(PaymentLocalService paymentLocalService) {
        _paymentLocalService = paymentLocalService;
    }

    /**
    * Adds the payment to the database. Also notifies the appropriate model listeners.
    *
    * @param payment the payment
    * @return the payment that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Payment addPayment(
        com.arman.csb.modules.model.Payment payment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.addPayment(payment);
    }

    /**
    * Creates a new payment with the primary key. Does not add the payment to the database.
    *
    * @param id the primary key for the new payment
    * @return the new payment
    */
    @Override
    public com.arman.csb.modules.model.Payment createPayment(long id) {
        return _paymentLocalService.createPayment(id);
    }

    /**
    * Deletes the payment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the payment
    * @return the payment that was removed
    * @throws PortalException if a payment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Payment deletePayment(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.deletePayment(id);
    }

    /**
    * Deletes the payment from the database. Also notifies the appropriate model listeners.
    *
    * @param payment the payment
    * @return the payment that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Payment deletePayment(
        com.arman.csb.modules.model.Payment payment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.deletePayment(payment);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _paymentLocalService.dynamicQuery();
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
        return _paymentLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _paymentLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _paymentLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _paymentLocalService.dynamicQueryCount(dynamicQuery);
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
        return _paymentLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.arman.csb.modules.model.Payment fetchPayment(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.fetchPayment(id);
    }

    /**
    * Returns the payment with the matching UUID and company.
    *
    * @param uuid the payment's UUID
    * @param companyId the primary key of the company
    * @return the matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Payment fetchPaymentByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.fetchPaymentByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the payment matching the UUID and group.
    *
    * @param uuid the payment's UUID
    * @param groupId the primary key of the group
    * @return the matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Payment fetchPaymentByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.fetchPaymentByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the payment with the primary key.
    *
    * @param id the primary key of the payment
    * @return the payment
    * @throws PortalException if a payment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Payment getPayment(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.getPayment(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the payment with the matching UUID and company.
    *
    * @param uuid the payment's UUID
    * @param companyId the primary key of the company
    * @return the matching payment
    * @throws PortalException if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Payment getPaymentByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.getPaymentByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the payment matching the UUID and group.
    *
    * @param uuid the payment's UUID
    * @param groupId the primary key of the group
    * @return the matching payment
    * @throws PortalException if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Payment getPaymentByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.getPaymentByUuidAndGroupId(uuid, groupId);
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
    public java.util.List<com.arman.csb.modules.model.Payment> getPayments(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.getPayments(start, end);
    }

    /**
    * Returns the number of payments.
    *
    * @return the number of payments
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getPaymentsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.getPaymentsCount();
    }

    /**
    * Updates the payment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param payment the payment
    * @return the payment that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Payment updatePayment(
        com.arman.csb.modules.model.Payment payment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.updatePayment(payment);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _paymentLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _paymentLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _paymentLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.arman.csb.modules.model.Payment addPayment(long amount,
        java.lang.Long customerId, java.util.Date paymentDate, int status,
        java.lang.Long factorId, java.lang.String description,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.addPayment(amount, customerId, paymentDate,
            status, factorId, description, serviceContext);
    }

    @Override
    public long totalPayedAmount(java.lang.Long customerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.totalPayedAmount(customerId);
    }

    @Override
    public java.util.List<com.arman.csb.modules.model.Payment> find(
        java.lang.Long customerId, java.util.Date fromDate,
        java.util.Date toDate, long amountFrom, long amountTo, int status,
        int first, int maxResult,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.find(customerId, fromDate, toDate,
            amountFrom, amountTo, status, first, maxResult, serviceContext);
    }

    @Override
    public long findCount(java.lang.Long customerId, java.util.Date fromDate,
        java.util.Date toDate, long amountFrom, long amountTo, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.findCount(customerId, fromDate, toDate,
            amountFrom, amountTo, status, serviceContext);
    }

    @Override
    public long totalPaymentAmount(java.lang.Long customerId,
        java.util.Date fromDate, java.util.Date toDate)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.totalPaymentAmount(customerId, fromDate,
            toDate);
    }

    @Override
    public java.util.List<com.arman.csb.modules.model.Payment> findByStatus(
        int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.findByStatus(status);
    }

    @Override
    public java.util.List<com.arman.csb.modules.model.Payment> findByGroupAndStatus(
        long groupId, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.findByGroupAndStatus(groupId, status);
    }

    @Override
    public com.arman.csb.modules.model.Payment updateStatus(
        com.arman.csb.modules.model.Payment payment, int status)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.updateStatus(payment, status);
    }

    @Override
    public long sumPayedOrPending(java.lang.Long customerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _paymentLocalService.sumPayedOrPending(customerId);
    }

    @Override
    public org.apache.poi.xssf.usermodel.XSSFWorkbook getExcelDocument(
        java.util.List<com.arman.csb.modules.model.Payment> payments) {
        return _paymentLocalService.getExcelDocument(payments);
    }

    @Override
    public long calculateMoneyInRials(
        com.arman.csb.modules.model.Payment payment) {
        return _paymentLocalService.calculateMoneyInRials(payment);
    }

    @Override
    public long calculateMoneyInRials(
        java.util.List<com.arman.csb.modules.model.Payment> payments) {
        return _paymentLocalService.calculateMoneyInRials(payments);
    }

    @Override
    public void subtractCommissionScore(
        com.arman.csb.modules.model.Payment payment) {
        _paymentLocalService.subtractCommissionScore(payment);
    }

    @Override
    public void subtractCommissionScore(
        java.util.List<com.arman.csb.modules.model.Payment> payments) {
        _paymentLocalService.subtractCommissionScore(payments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PaymentLocalService getWrappedPaymentLocalService() {
        return _paymentLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPaymentLocalService(
        PaymentLocalService paymentLocalService) {
        _paymentLocalService = paymentLocalService;
    }

    @Override
    public PaymentLocalService getWrappedService() {
        return _paymentLocalService;
    }

    @Override
    public void setWrappedService(PaymentLocalService paymentLocalService) {
        _paymentLocalService = paymentLocalService;
    }
}
