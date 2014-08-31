package com.arman.csb.theme.service.messaging;

import com.arman.csb.theme.service.ClpSerializer;
import com.arman.csb.theme.service.ContentHolderLocalServiceUtil;
import com.arman.csb.theme.service.ContentHolderServiceUtil;
import com.arman.csb.theme.service.MyPageLocalServiceUtil;
import com.arman.csb.theme.service.MyPageServiceUtil;
import com.arman.csb.theme.service.TemplateLocalServiceUtil;
import com.arman.csb.theme.service.TemplateServiceUtil;

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
            ContentHolderLocalServiceUtil.clearService();

            ContentHolderServiceUtil.clearService();
            MyPageLocalServiceUtil.clearService();

            MyPageServiceUtil.clearService();
            TemplateLocalServiceUtil.clearService();

            TemplateServiceUtil.clearService();
        }
    }
}
