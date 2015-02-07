package com.armansoft.csb.portlet.login;

import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.ContentUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 2/6/15
 * Time: 12:07 AM
 */
public class ForgotPasswordPortlet extends MVCPortlet {
    
    public void sendPassword(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(
                    WebKeys.THEME_DISPLAY);

            ServiceContext serviceContext = ServiceContextFactory.getInstance(
                                User.class.getName(), actionRequest);

            String body = ContentUtil.get(PropsUtil.get(PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_BODY));

            UserLocalServiceUtil.sendPassword(
                    themeDisplay.getCompanyId(), "mjsafa@gmail.com", "mojtaba.safaeian.com", "admin@faraitmall.ir", "salam",
                    body, serviceContext);
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
