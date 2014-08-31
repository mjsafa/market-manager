package com.armansoft.csb.portlet.template;

import com.arman.csb.theme.model.Template;
import com.arman.csb.theme.service.TemplateLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactory;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 8/21/14
 * Time: 12:21 PM
 */
public class TemplatePortlet extends MVCPortlet {
    private static Log logger = LogFactoryUtil.getLog(TemplatePortlet.class);


    public void saveTemplate(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(
                    WebKeys.THEME_DISPLAY);
            User user = themeDisplay.getUser();

            String name = ParamUtil.getString(actionRequest, "name");
            String head = ParamUtil.getString(actionRequest, "head");
            String htmlContent = ParamUtil.getString(actionRequest, "htmlContent");
            String footer = ParamUtil.getString(actionRequest, "footer");

            Long groupId = ParamUtil.getLong(actionRequest, "groupId");

            Template template = TemplateLocalServiceUtil.createNewTemplate();
            template.setHead(head);
            template.setName(name);
            template.setHtmlContent(htmlContent);
            template.setBottom(footer);

            template.setUserId(user.getUserId());
            template.setCompanyId(themeDisplay.getCompanyId());
            template.setGroupId(groupId);
            template.setUserName(themeDisplay.getUser().getFullName());

            TemplateLocalServiceUtil.addTemplate(template);

            logger.info("Add new template completed successfully: " + template);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error( actionRequest.getParameterMap() , e);
            SessionErrors.add(actionRequest, "new_template_error");
        }
    }
}
