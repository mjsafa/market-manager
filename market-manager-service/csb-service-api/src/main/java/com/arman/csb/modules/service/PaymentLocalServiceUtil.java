package com.arman.csb.modules.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Payment. This utility wraps
 * {@link com.arman.csb.modules.service.impl.PaymentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PaymentLocalService
 * @see com.arman.csb.modules.service.base.PaymentLocalServiceBaseImpl
 * @see com.arman.csb.modules.service.impl.PaymentLocalServiceImpl
 * @generated
 */
public class PaymentLocalServiceUtil {
    private static PaymentLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arman.csb.modules.service.impl.PaymentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the payment to the database. Also notifies the appropriate model listeners.
    *
    * @param payment the payment
    * @return the payment that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment addPayment(
        com.arman.csb.modules.model.Payment payment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addPayment(payment);
    }

    /**
    * Creates a new payment with the primary key. Does not add the payment to the database.
    *
    * @param id the primary key for the new payment
    * @return the new payment
    */
    public static com.arman.csb.modules.model.Payment createPayment(long id) {
        return getService().createPayment(id);
    }

    /**
    * Deletes the payment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the payment
    * @return the payment that was removed
    * @throws PortalException if a payment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment deletePayment(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deletePayment(id);
    }

    /**
    * Deletes the payment from the database. Also notifies the appropriate model listeners.
    *
    * @param payment the payment
    * @return the payment that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment deletePayment(
        com.arman.csb.modules.model.Payment payment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deletePayment(payment);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.arman.csb.modules.model.Payment fetchPayment(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchPayment(id);
    }

    /**
    * Returns the payment with the matching UUID and company.
    *
    * @param uuid the payment's UUID
    * @param companyId the primary key of the company
    * @return the matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment fetchPaymentByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchPaymentByUuidAndCompanyId(uuid, companyId);
    }

    /**
    * Returns the payment matching the UUID and group.
    *
    * @param uuid the payment's UUID
    * @param groupId the primary key of the group
    * @return the matching payment, or <code>null</code> if a matching payment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment fetchPaymentByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchPaymentByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the payment with the primary key.
    *
    * @param id the primary key of the payment
    * @return the payment
    * @throws PortalException if a payment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment getPayment(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPayment(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static com.arman.csb.modules.model.Payment getPaymentByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPaymentByUuidAndCompanyId(uuid, companyId);
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
    public static com.arman.csb.modules.model.Payment getPaymentByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPaymentByUuidAndGroupId(uuid, groupId);
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
    public static java.util.List<com.arman.csb.modules.model.Payment> getPayments(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPayments(start, end);
    }

    /**
    * Returns the number of payments.
    *
    * @return the number of payments
    * @throws SystemException if a system exception occurred
    */
    public static int getPaymentsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPaymentsCount();
    }

    /**
    * Updates the payment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param payment the payment
    * @return the payment that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arman.csb.modules.model.Payment updatePayment(
        com.arman.csb.modules.model.Payment payment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updatePayment(payment);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.arman.csb.modules.model.Payment addPayment(long amount,
        java.lang.Long customerId, java.util.Date paymentDate, int status,
        java.lang.Long factorId, java.lang.String description,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addPayment(amount, customerId, paymentDate, status,
            factorId, description, serviceContext);
    }

    public static long totalPayedAmount(java.lang.Long customerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().totalPayedAmount(customerId);
    }

    public static java.util.List<com.arman.csb.modules.model.Payment> find(
        java.lang.Long customerId, java.util.Date fromDate,
        java.util.Date toDate, long amountFrom, long amountTo, int first,
        int maxResult, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .find(customerId, fromDate, toDate, amountFrom, amountTo,
            first, maxResult, serviceContext);
    }

    public static long totalPaymentAmount(java.lang.Long customerId,
        java.util.Date fromDate, java.util.Date toDate)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().totalPaymentAmount(customerId, fromDate, toDate);
    }

    public static void clearService() {
        _service = null;
    }

    public static PaymentLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PaymentLocalService.class.getName());

            if (invokableLocalService instanceof PaymentLocalService) {
                _service = (PaymentLocalService) invokableLocalService;
            } else {
                _service = new PaymentLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(PaymentLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(PaymentLocalService service) {
    }
}
