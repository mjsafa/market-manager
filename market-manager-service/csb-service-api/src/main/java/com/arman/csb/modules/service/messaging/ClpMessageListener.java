package com.arman.csb.modules.service.messaging;

import com.arman.csb.modules.service.ClpSerializer;
import com.arman.csb.modules.service.CustomerLocalServiceUtil;
import com.arman.csb.modules.service.CustomerServiceUtil;
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
import com.arman.csb.modules.service.ScoreLocalServiceUtil;
import com.arman.csb.modules.service.ScoreServiceUtil;

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
            ScoreLocalServiceUtil.clearService();

            ScoreServiceUtil.clearService();
        }
    }
}
