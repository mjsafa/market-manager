package com.arman.csb.modules.service.impl;

import com.arman.csb.constant.UserActivityConstant;
import com.arman.csb.constants.ScoreConstants;
import com.arman.csb.modules.model.Customer;
import com.arman.csb.modules.model.Payment;
import com.arman.csb.modules.model.Score;
import com.arman.csb.modules.service.CustomerLocalServiceUtil;
import com.arman.csb.modules.service.PaymentLocalServiceUtil;
import com.arman.csb.modules.service.ScoreLocalServiceUtil;
import com.arman.csb.modules.service.UserActivityLocalServiceUtil;
import com.arman.csb.modules.service.base.PaymentServiceBaseImpl;
import com.arman.csb.modules.util.RoleEnum;
import com.arman.csb.modules.util.RoleUtil;
import com.arman.csb.util.DateUtil;
import com.arman.csb.util.MapUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.util.portlet.PortletProps;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the payment remote service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.PaymentService} interface.
 * <p/>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.PaymentServiceBaseImpl
 * @see com.arman.csb.modules.service.PaymentServiceUtil
 */
public class PaymentServiceImpl extends PaymentServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.PaymentServiceUtil} to access the payment remote service.
     */

    public JSONObject addPayment(Map<String, Object> paymentMap, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRolesOrSameCustomer(serviceContext.getUserId(), MapUtil.getLong(paymentMap, "customerId"), RoleEnum.PAYMENT_MANAGER.toString());


        long minimumPaymentRequest = Long.valueOf(PortletProps.get("market-manager.config.minimum-payment-request"));
        long amount = MapUtil.getLong(paymentMap, "amount");
        if (amount < minimumPaymentRequest) {
            throw new PortalException("minimum-payment-amount");
        }


        JSONObject result = JSONFactoryUtil.createJSONObject();
        Payment newPayment = PaymentLocalServiceUtil.addPayment(MapUtil.getLong(paymentMap, "amount"), MapUtil.getLong(paymentMap, "customerId")
                , null, WorkflowConstants.STATUS_PENDING, MapUtil.getLong(paymentMap, "factorId"), MapUtil.getString(paymentMap, "description")
                , serviceContext);

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_PAYMENT, UserActivityConstant.ACTION_ADD,
                UserActivityConstant.IMPORTANCE_HIGH, getPaymentActivityJSONObject(newPayment, CustomerLocalServiceUtil.fetchCustomer(newPayment.getCustomerId())).toString(), serviceContext);

        result.put("paymentId", newPayment.getId());
        return result;
    }

    public JSONObject totalPayedAmount(Long customerId, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.PAYMENT_MANAGER.toString());
        JSONObject result = JSONFactoryUtil.createJSONObject();
        result.put("customerTotalAmount", PaymentLocalServiceUtil.totalPayedAmount(customerId));
        return result;
    }

    public JSONArray search(Map<String, Object> filter, int first, int maxResult, ServiceContext serviceContext) throws PortalException, SystemException {
        if (!RoleUtil.isSameCustomer(serviceContext.getUserId(), MapUtil.getLong(filter, "customerId")) && !RoleUtil.hasAnyRoles(serviceContext.getUserId(), RoleEnum.PAYMENT_MANAGER.toString())) {
            throw new PrincipalException();
        }

        List<Payment> payments = PaymentLocalServiceUtil.find(MapUtil.getLong(filter, "customerId"), MapUtil.getDate(filter, "fromDate"), MapUtil.getDate(filter, "toDate")
                , MapUtil.getLong(filter, "fromAmount"), MapUtil.getLong(filter, "toAmount"), MapUtil.getInteger(filter, "status", WorkflowConstants.STATUS_ANY), first, maxResult, serviceContext);

        JSONArray result = JSONFactoryUtil.createJSONArray();
        for (Payment payment : payments) {
            JSONObject paymentJson = JSONFactoryUtil.createJSONObject();
            paymentJson.put("id", payment.getId());
            paymentJson.put("customerId", payment.getCustomerId());
            if (null != payment.getPaymentDate()) {
                paymentJson.put("paymentDate", payment.getPaymentDate().getTime());
            }
            paymentJson.put("amount", payment.getAmount());
            paymentJson.put("createDate", payment.getCreateDate().getTime());
            paymentJson.put("description", payment.getDescription());
            paymentJson.put("factorId", payment.getFactorId());
            paymentJson.put("status", payment.getStatus());
            paymentJson.put("isActive", payment.getStatus() == WorkflowConstants.STATUS_APPROVED ? true : false);
            paymentJson.put("card", payment.getCard());

            //prepare customer data
            Customer customer = CustomerLocalServiceUtil.fetchCustomer(payment.getCustomerId());
            JSONObject customerJson = JSONFactoryUtil.createJSONObject();
            customerJson.put("id", customer.getId());
            customerJson.put("firstName", customer.getFirstName());
            customerJson.put("lastName", customer.getLastName());
            customerJson.put("name", customer.getFirstName() + " " + customer.getLastName());
            paymentJson.put("customer", customerJson);

            result.put(paymentJson);
        }
        return result;
    }

    public JSONObject getTotalStats(ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.PAYMENT_MANAGER.toString());

        JSONObject result = JSONFactoryUtil.createJSONObject();
        long totalPayment = PaymentLocalServiceUtil.totalPaymentAmount(null, null, null);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        long lastWeekPayment = PaymentLocalServiceUtil.totalPaymentAmount(null, calendar.getTime(), new Date());

        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        long lastMonthPayment = PaymentLocalServiceUtil.totalPaymentAmount(null, calendar.getTime(), new Date());

        calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        long lastYearPayment = PaymentLocalServiceUtil.totalPaymentAmount(null, calendar.getTime(), new Date());

        result.put("lastYearPayment", lastYearPayment);
        result.put("lastMonthPayment", lastMonthPayment);
        result.put("lastWeekPayment", lastWeekPayment);
        result.put("totalPayment", totalPayment);
        return result;
    }

    public JSONObject isDownloaded(ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.PAYMENT_MANAGER.toString());
        JSONObject result = JSONFactoryUtil.createJSONObject();
        int totalDownloadStatus = paymentPersistence.countByStatus(com.arman.csb.constants.WorkflowConstants.STATUS_DOWNLOADED);
        result.put("isDownloaded", totalDownloadStatus <= 0 ? false : true);
        return result;
    }

    public JSONObject downloadPayments(ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.PAYMENT_MANAGER.toString());
        JSONObject result = JSONFactoryUtil.createJSONObject();
        List<Payment> payments = paymentLocalService.findByStatus(WorkflowConstants.STATUS_PENDING);
        for (Payment payment : payments) {
            PaymentLocalServiceUtil.updateStatus(payment, com.arman.csb.constants.WorkflowConstants.STATUS_DOWNLOADED);
        }

        result.put("paymentCount", payments.size());
        result.put("status", com.arman.csb.constants.WorkflowConstants.STATUS_DOWNLOADED);
        result.put("totalAmount", PaymentLocalServiceUtil.calculateMoneyInRials(payments));

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_PAYMENT, UserActivityConstant.ACTION_CHANGE_STATUS,
                UserActivityConstant.IMPORTANCE_MEDIUM, result.toString(), serviceContext);

        return result;
    }


    public JSONObject acceptPayments(ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.PAYMENT_MANAGER.toString());
        JSONObject result = JSONFactoryUtil.createJSONObject();
        List<Payment> payments = paymentLocalService.findByStatus(com.arman.csb.constants.WorkflowConstants.STATUS_DOWNLOADED);
        for (Payment payment : payments) {
            PaymentLocalServiceUtil.updateStatus(payment, com.arman.csb.constants.WorkflowConstants.STATUS_APPROVED);
        }

        result.put("paymentCount", payments.size());
        result.put("status", com.arman.csb.constants.WorkflowConstants.STATUS_APPROVED);
        result.put("totalAmount", PaymentLocalServiceUtil.calculateMoneyInRials(payments));

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_PAYMENT, UserActivityConstant.ACTION_CHANGE_STATUS,
                UserActivityConstant.IMPORTANCE_HIGH, result.toString(), serviceContext);

        return result;
    }


    public JSONObject cancelDownloadPayments(ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.PAYMENT_MANAGER.toString());
        JSONObject result = JSONFactoryUtil.createJSONObject();
        List<Payment> payments = paymentLocalService.findByStatus(com.arman.csb.constants.WorkflowConstants.STATUS_DOWNLOADED);
        for (Payment payment : payments) {
            PaymentLocalServiceUtil.updateStatus(payment, com.arman.csb.constants.WorkflowConstants.STATUS_PENDING);
        }

        result.put("paymentCount", payments.size());
        result.put("status", com.arman.csb.constants.WorkflowConstants.STATUS_PENDING);
        result.put("totalAmount", PaymentLocalServiceUtil.calculateMoneyInRials(payments));

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_PAYMENT, UserActivityConstant.ACTION_CHANGE_STATUS,
                UserActivityConstant.IMPORTANCE_LOW, result.toString(), serviceContext);

        return result;
    }

    public JSONObject rejectPayment(Long paymentId, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId(), RoleEnum.PAYMENT_MANAGER.toString());

        JSONObject result = JSONFactoryUtil.createJSONObject();
        Payment payment = PaymentLocalServiceUtil.fetchPayment(paymentId);
        result.put("previousStatus", payment.getStatus());
        PaymentLocalServiceUtil.updateStatus(payment, com.arman.csb.constants.WorkflowConstants.STATUS_DENIED);
        result.put("paymentId", paymentId);
        result.put("amount", payment.getAmount());
        result.put("status", WorkflowConstants.STATUS_DENIED);

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_PAYMENT, UserActivityConstant.ACTION_CHANGE_STATUS,
                UserActivityConstant.IMPORTANCE_HIGH, result.toString(), serviceContext);

        return result;
    }

    public JSONObject deletePayment(long paymentId, ServiceContext serviceContext) throws PortalException, SystemException {
        Payment payment = PaymentLocalServiceUtil.fetchPayment(paymentId);
        RoleUtil.checkAnyRolesOrSameCustomer(serviceContext.getUserId(), payment.getCustomerId());

        JSONObject result = JSONFactoryUtil.createJSONObject();
        PaymentLocalServiceUtil.deletePayment(paymentId);

        result.put("paymentId", paymentId);
        result.put("amount", payment.getAmount());

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_PAYMENT, UserActivityConstant.ACTION_DELETE,
                        UserActivityConstant.IMPORTANCE_MEDIUM, result.toString(), serviceContext);

        return result;
    }


    public JSONObject getStats(long customerId, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRolesOrSameCustomer(serviceContext.getUserId(), customerId, RoleEnum.PAYMENT_MANAGER.toString());
        JSONObject result = JSONFactoryUtil.createJSONObject();

        long totalPayedOrPending = paymentLocalService.sumPayedOrPending(customerId);
        long totalScore = ScoreLocalServiceUtil.sumByCustomerAndType(customerId, ScoreConstants.TYPE_DIRECT, null, null) + ScoreLocalServiceUtil.sumByCustomerAndType(customerId, ScoreConstants.TYPE_DIRECT, null, null);

        result.put("totalPayedOrPending", totalPayedOrPending);
        result.put("totalPayable", totalScore - totalPayedOrPending);
        result.put("totalScore", totalScore - totalPayedOrPending);
        result.put("totalApprovedPayment", paymentLocalService.totalPaymentAmount(customerId, null, null));

        return result;
    }


    public JSONObject getPaymentActivityJSONObject(Payment payment, Customer customer) {
        JSONObject paymentJson = JSONFactoryUtil.createJSONObject();
        paymentJson.put("firstName", customer.getFirstName());
        paymentJson.put("lastName", customer.getLastName());
        paymentJson.put("id", payment.getId());
        paymentJson.put("amount", payment.getAmount());
        paymentJson.put("cardNumber", payment.getCard());
        paymentJson.put("customerId", customer.getId());
        paymentJson.put("createDate", DateUtil.getString(payment.getPaymentDate()));

        return paymentJson;
    }


}
