package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.model.Customer;
import com.arman.csb.modules.model.Payment;
import com.arman.csb.modules.service.CustomerLocalServiceUtil;
import com.arman.csb.modules.service.PaymentLocalServiceUtil;
import com.arman.csb.modules.service.base.PaymentServiceBaseImpl;
import com.arman.csb.util.MapUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;

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
        JSONObject result = JSONFactoryUtil.createJSONObject();
        Payment newPayment = PaymentLocalServiceUtil.addPayment(MapUtil.getLong(paymentMap, "amount"), MapUtil.getLong(paymentMap, "customerId")
                , new Date(), WorkflowConstants.STATUS_APPROVED, MapUtil.getLong(paymentMap, "factorId"), MapUtil.getString(paymentMap, "description")
                , serviceContext);

        result.put("paymentId", newPayment.getId());
        return result;
    }

    public JSONObject totalPayedAmount(Long customerId, ServiceContext serviceContext) throws PortalException, SystemException {
        JSONObject result = JSONFactoryUtil.createJSONObject();
        result.put("customerTotalAmount", PaymentLocalServiceUtil.totalPayedAmount(customerId));
        return result;
    }

    public JSONArray search(Map<String, Object> filter, int first, int maxResult, ServiceContext serviceContext) throws PortalException, SystemException {
        JSONArray result = JSONFactoryUtil.createJSONArray();

        List<Payment> payments = PaymentLocalServiceUtil.find(MapUtil.getLong(filter, "customerId"), MapUtil.getDate(filter, "fromDate"), MapUtil.getDate(filter, "toDate")
                , MapUtil.getLong(filter, "fromAmount"), MapUtil.getLong(filter, "toAmount"), first, maxResult, serviceContext);

        for (Payment payment : payments) {
            JSONObject paymentJson = JSONFactoryUtil.createJSONObject();
            paymentJson.put("id", payment.getId());
            paymentJson.put("customerId", payment.getCustomerId());
            paymentJson.put("paymentDate", payment.getPaymentDate());
            paymentJson.put("amount", payment.getAmount());
            paymentJson.put("createDate", payment.getCreateDate());
            paymentJson.put("description", payment.getDescription());
            paymentJson.put("factorId", payment.getFactorId());
            paymentJson.put("status", payment.getStatus());
            paymentJson.put("isActive", payment.getStatus() == WorkflowConstants.STATUS_APPROVED ? true : false);
            paymentJson.put("card", payment.getCard());

            //prepare customer data
            Customer customer = CustomerLocalServiceUtil.fetchCustomer(payment.getCustomerId());
            JSONObject customerJson = JSONFactoryUtil.createJSONObject();
            customerJson.put("firstName", customer.getFirstName());
            customerJson.put("lastName", customer.getLastName());
            customerJson.put("name", customer.getFirstName() + " " + customer.getLastName());
            paymentJson.put("customer", customerJson);

            result.put(paymentJson);
        }
        return result;
    }

    public JSONObject getTotalStats(ServiceContext serviceContext) throws PortalException, SystemException {
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
}
