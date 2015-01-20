package com.arman.csb.login;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public class LoginAction extends BaseStrutsPortletAction {

    public void processAction(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {
        ThemeDisplay themeDisplay =
            (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        Long currentuser = themeDisplay.getUserId();

        if (currentuser != null) {
            System.out.println("Wrapped /login/ action2");

        }
        originalStrutsPortletAction.processAction(
            originalStrutsPortletAction, portletConfig, actionRequest,
            actionResponse);

        if(SessionErrors.contains(actionRequest, "com.liferay.portal.security.auth.AuthException") ||
                SessionErrors.contains(actionRequest, "com.liferay.portal.UserPasswordException")){
            String loginName = ParamUtil.getString(actionRequest, "login");
            User foundUser = UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(), loginName);

            if(SessionErrors.contains(actionRequest, "com.liferay.portal.security.auth.AuthException")  ||
                            SessionErrors.contains(actionRequest, "com.liferay.portal.UserPasswordException")){
                themeDisplay.getRequest().getSession().setAttribute("LoginError", "UserPassException");
            }

            if(null != foundUser && foundUser.getStatus() == WorkflowConstants.STATUS_INACTIVE){
                themeDisplay.getRequest().getSession().setAttribute("LoginError", "UserInactive");
            }
        }

    }

    public String render(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws Exception {

        System.out.println("Wrapped /login/ action");

        return originalStrutsPortletAction.render(
            null, portletConfig, renderRequest, renderResponse);

    }

    public void serveResource(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ResourceRequest resourceRequest,
            ResourceResponse resourceResponse)
        throws Exception {

        originalStrutsPortletAction.serveResource(
            originalStrutsPortletAction, portletConfig, resourceRequest,
            resourceResponse);

    }

}