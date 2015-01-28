package com.arman.csb.modules.servlet;

import com.arman.csb.constant.UserActivityConstant;
import com.arman.csb.constants.WorkflowConstants;
import com.arman.csb.modules.model.Payment;
import com.arman.csb.modules.service.PaymentLocalServiceUtil;
import com.arman.csb.modules.service.UserActivityLocalServiceUtil;
import com.arman.csb.modules.util.RoleEnum;
import com.arman.csb.modules.util.RoleUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 8/28/14
 * Time: 10:25 AM
 */
public class PaymentServlet extends HttpServlet {

    private static final String _fileSeparator = System.getProperty("file.separator");

    private int FILEBUFFERSIZE = 1024;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long userId = PortalUtil.getUserId(request);
        try {
            RoleUtil.checkAnyRoles(userId, RoleEnum.PAYMENT_MANAGER.toString());
        } catch (PrincipalException e) {
            PortalUtil.sendError(HttpServletResponse.SC_FORBIDDEN, new SecurityException(), request, response);
        }

        ServletOutputStream out = response.getOutputStream();
        try {
            response.setContentType("application/force-download");
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + "payments-workbook.xlsx\"");

            List<Payment> payments = PaymentLocalServiceUtil.findByStatus(WorkflowConstants.STATUS_DOWNLOADED);
            PaymentLocalServiceUtil.subtractCommissionScore(payments);

            JSONObject result = JSONFactoryUtil.createJSONObject();
            result.put("paymentCount", payments.size());
            result.put("status", com.arman.csb.constants.WorkflowConstants.STATUS_APPROVED);
            result.put("totalAmount", PaymentLocalServiceUtil.calculateMoneyInRials(payments));

            ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
            UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_PAYMENT, UserActivityConstant.ACTION_DOWNLOAD,
                    UserActivityConstant.IMPORTANCE_HIGH, result.toString(), serviceContext);


            Workbook workbook = PaymentLocalServiceUtil.getExcelDocument(payments);
            workbook.write(out);

        } catch (PortalException e) {
            e.printStackTrace();
            throw new ServletException();
        } catch (SystemException e) {
            e.printStackTrace();
            throw new ServletException();
        } finally {
            out.close();
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
