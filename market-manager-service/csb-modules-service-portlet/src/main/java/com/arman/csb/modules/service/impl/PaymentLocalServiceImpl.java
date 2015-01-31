package com.arman.csb.modules.service.impl;

import com.arman.csb.constants.ScoreConstants;
import com.arman.csb.constants.WorkflowConstants;
import com.arman.csb.modules.model.Customer;
import com.arman.csb.modules.model.Payment;
import com.arman.csb.modules.model.PaymentModel;
import com.arman.csb.modules.model.impl.PaymentImpl;
import com.arman.csb.modules.service.ClpSerializer;
import com.arman.csb.modules.service.CustomerLocalServiceUtil;
import com.arman.csb.modules.service.PaymentLocalServiceUtil;
import com.arman.csb.modules.service.ScoreLocalServiceUtil;
import com.arman.csb.modules.service.base.PaymentLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparatorFactory;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.util.portlet.PortletProps;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the payment local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.PaymentLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.PaymentLocalServiceBaseImpl
 * @see com.arman.csb.modules.service.PaymentLocalServiceUtil
 */
public class PaymentLocalServiceImpl extends PaymentLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.PaymentLocalServiceUtil} to access the payment local service.
     */

    public Payment addPayment(long amount, Long customerId, Date paymentDate, int status, Long factorId, String description,
                              ServiceContext serviceContext)
            throws PortalException, SystemException {

        long totalPayedOrPending = sumPayedOrPending(customerId);
        long totalScore = ScoreLocalServiceUtil.sumByCustomerAndType(customerId, ScoreConstants.TYPE_DIRECT, null, null) + ScoreLocalServiceUtil.sumByCustomerAndType(customerId, ScoreConstants.TYPE_DIRECT, null, null);
        if (totalScore - totalPayedOrPending < amount) {
            throw new PortalException("payment-exceed-score");
        }


        Customer referencedCustomer = CustomerLocalServiceUtil.fetchCustomer(customerId);
        if(referencedCustomer.getStatus() != WorkflowConstants.STATUS_APPROVED){
            throw new PortalException("customer-not-active");
        }

        Payment newPayment = PaymentLocalServiceUtil.createPayment(counterLocalService.increment(Payment.class.getName()));
        newPayment.setAmount(amount);
        newPayment.setCustomerId(customerId);
        newPayment.setPaymentDate(null);
        newPayment.setCreateDate(new Date());
        newPayment.setStatus(status);
        newPayment.setFactorId(factorId);
        newPayment.setDescription(description);
        newPayment.setCard(referencedCustomer.getCard());
        newPayment.setUserId(serviceContext.getUserId());
        newPayment.setCompanyId(serviceContext.getCompanyId());
        newPayment.setGroupId(serviceContext.getScopeGroupId());
        newPayment.setModifiedDate(new Date());

        addPayment(newPayment);
        return newPayment;
    }

    public long totalPayedAmount(Long customerId) throws PortalException, SystemException {
        ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Payment.class, classLoader);
        query.add(PropertyFactoryUtil.forName("customerId").eq(customerId));
        query.add(PropertyFactoryUtil.forName("status").eq(WorkflowConstants.STATUS_APPROVED));
        query.setProjection(ProjectionFactoryUtil.sum("amount"));

        List<Object[]> results = dynamicQuery(query);
        for (Object[] result : results) {
            return (Long) result[0];
        }
        return 0;
    }


    public List<Payment> find(Long customerId, Date fromDate, Date toDate, long amountFrom, long amountTo, int status, int first, int maxResult, ServiceContext serviceContext) throws PortalException, SystemException {
        ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Payment.class, classLoader);
        if (null != customerId && customerId > 0) {
            query.add(PropertyFactoryUtil.forName("customerId").eq(customerId));
        }
        if (null != fromDate) {
            query.add(PropertyFactoryUtil.forName("createDate").ge(fromDate));
        }
        if (null != toDate) {
            query.add(PropertyFactoryUtil.forName("createDate").le(toDate));
        }

        if (amountFrom > 0) {
            query.add(PropertyFactoryUtil.forName("amount").ge(amountFrom));
        }
        if (amountTo > 0) {
            query.add(PropertyFactoryUtil.forName("amount").le(amountTo));
        }

        if (status != WorkflowConstants.STATUS_ANY) {
            query.add(PropertyFactoryUtil.forName("status").eq(status));
        }

        query.addOrder(OrderFactoryUtil.desc("createDate"));

        return dynamicQuery(query);
    }

    public long totalPaymentAmount(Long customerId, Date fromDate, Date toDate) throws PortalException, SystemException {
        ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Payment.class, classLoader);
        if (null != customerId && customerId > 0) {
            query.add(PropertyFactoryUtil.forName("customerId").eq(customerId));
        }
        if (null != fromDate) {
            query.add(PropertyFactoryUtil.forName("createDate").ge(fromDate));
        }
        if (null != toDate) {
            query.add(PropertyFactoryUtil.forName("createDate").le(toDate));
        }

        query.add(PropertyFactoryUtil.forName("status").eq(WorkflowConstants.STATUS_APPROVED));

        query.setProjection(ProjectionFactoryUtil.sum("amount"));
        long amount = 0;
        List<Long> result = dynamicQuery(query);
        if (!result.isEmpty() && null != result.get(0)) {
            return result.get(0);
        }
        return amount;
    }


    public List<Payment> findByStatus(int status) throws PortalException, SystemException {
        return paymentPersistence.findByStatus(status);
    }

    public Payment updateStatus(Payment payment, int status) throws PortalException, SystemException {
        payment.setStatus(status);
        if (status == WorkflowConstants.STATUS_APPROVED) {
            payment.setPaymentDate(new Date());
        }
        return paymentPersistence.update(payment);
    }

    public Payment deletePayment(long paymentId) throws PortalException, SystemException {
        Payment payment = fetchPayment(paymentId);
        if (payment.getStatus() != WorkflowConstants.STATUS_PENDING) {
            throw new PortalException("payment-not-pending");
        }
        return paymentPersistence.remove(payment.getId());
    }

    public long sumPayedOrPending(Long customerId) throws PortalException, SystemException {
        ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Payment.class, classLoader);

        Criterion criterion = RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED);
        criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_DOWNLOADED));
        criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_PENDING));
        query.add(criterion);
        query.setProjection(ProjectionFactoryUtil.sum("amount"));
        long amount = 0;
        List<Long> result = dynamicQuery(query);
        if (!result.isEmpty() && null != result.get(0)) {
            return result.get(0);
        }
        return amount;
    }

    public XSSFWorkbook getExcelDocument(List<Payment> payments) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("اطلاعات پرداخت ها");

        XSSFRow header = sheet.createRow(0);

        Cell idHeader = header.createCell(0);
        idHeader.setCellValue("شناسه درخواست");

        Cell amountHeader = header.createCell(1);
        amountHeader.setCellValue("مبلغ پرداختی (ریال)");

        Cell cardNumberHeader = header.createCell(2);
        cardNumberHeader.setCellValue("شماره کارت");


        int rowNum = 1;
        for (Payment payment : payments) {
            XSSFRow row = sheet.createRow(rowNum);

            Cell id = row.createCell(0);
            id.setCellValue(payment.getId());

            long totalAmount = calculateMoneyInRials(payment);
            Cell amount = row.createCell(1);
            amount.setCellValue(totalAmount);

            Cell cardNumber = row.createCell(2);
            cardNumber.setCellValue(payment.getCard());

            rowNum++;
        }

        sheet.setColumnWidth(0, 7500);
        sheet.setColumnWidth(1, 7500);
        sheet.setColumnWidth(2, 7500);


        return workbook;
    }


    public long calculateMoneyInRials(Payment payment) {
        long scoreToRials = Long.valueOf(PortletProps.get("market-manager.config.score-to-rials"));
        return payment.getAmount() * scoreToRials;
    }

    public long calculateMoneyInRials(List<Payment> payments) {
        long totalMoney = 0L;
        for (Payment payment : payments) {
            totalMoney += calculateMoneyInRials(payment);
        }
        return totalMoney;
    }

    public void subtractCommissionScore(Payment payment) {
        payment.setAmount(payment.getAmount() - (Long.valueOf(PortletProps.get("market-manager.config.payment-commission-score")) * 1000));
    }

    public void subtractCommissionScore(List<Payment> payments) {
        for (Payment payment : payments) {
            subtractCommissionScore(payment);
        }
    }

}
