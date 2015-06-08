package com.arman.csb.modules.service.messaging;

import com.arman.csb.modules.service.ClpSerializer;
import com.arman.csb.modules.service.CustomerLocalServiceUtil;
import com.arman.csb.modules.service.CustomerServiceUtil;
import com.arman.csb.modules.service.InstanceLocalServiceUtil;
import com.arman.csb.modules.service.InstanceServiceUtil;
import com.arman.csb.modules.service.InvoiceItemLocalServiceUtil;
import com.arman.csb.modules.service.InvoiceItemServiceUtil;
import com.arman.csb.modules.service.InvoiceLocalServiceUtil;
import com.arman.csb.modules.service.InvoiceServiceUtil;
import com.arman.csb.modules.service.MyBlogLocalServiceUtil;
import com.arman.csb.modules.service.MyBlogServiceUtil;
import com.arman.csb.modules.service.MyDDLRecordLocalServiceUtil;
import com.arman.csb.modules.service.MyDDLRecordServiceUtil;
import com.arman.csb.modules.service.MyUserLocalServiceUtil;
import com.arman.csb.modules.service.MyUserServiceUtil;
import com.arman.csb.modules.service.PaymentLocalServiceUtil;
import com.arman.csb.modules.service.PaymentServiceUtil;
import com.arman.csb.modules.service.ProductLocalServiceUtil;
import com.arman.csb.modules.service.ProductServiceUtil;
import com.arman.csb.modules.service.ScoreLocalServiceUtil;
import com.arman.csb.modules.service.ScoreServiceUtil;
import com.arman.csb.modules.service.UserActivityLocalServiceUtil;
import com.arman.csb.modules.service.UserActivityServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            CustomerLocalServiceUtil.clearService();

            CustomerServiceUtil.clearService();
            InstanceLocalServiceUtil.clearService();

            InstanceServiceUtil.clearService();
            InvoiceLocalServiceUtil.clearService();

            InvoiceServiceUtil.clearService();
            InvoiceItemLocalServiceUtil.clearService();

            InvoiceItemServiceUtil.clearService();
            MyBlogLocalServiceUtil.clearService();

            MyBlogServiceUtil.clearService();
            MyDDLRecordLocalServiceUtil.clearService();

            MyDDLRecordServiceUtil.clearService();
            MyUserLocalServiceUtil.clearService();

            MyUserServiceUtil.clearService();
            PaymentLocalServiceUtil.clearService();

            PaymentServiceUtil.clearService();
            ProductLocalServiceUtil.clearService();

            ProductServiceUtil.clearService();
            ScoreLocalServiceUtil.clearService();

            ScoreServiceUtil.clearService();
            UserActivityLocalServiceUtil.clearService();

            UserActivityServiceUtil.clearService();
        }
    }
}
