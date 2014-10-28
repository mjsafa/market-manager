package com.armansoft.csb.portlet.preferences;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 9/16/14
 * Time: 6:36 PM
 */
public class PreferencesPortlet extends MVCPortlet {

    public void updatePreferences(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {
        try {
            String name = ParamUtil.getString(actionRequest, "name");
            String value = ParamUtil.getString(actionRequest, "value");

            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(
                    WebKeys.THEME_DISPLAY);

            PortletPreferences preferences = PrefsPropsUtil.getPreferences(themeDisplay.getCompanyId());
            preferences.setValue(name, value);
            preferences.store();
        } catch (SystemException e) {
            throw new PortletException(e);
        }
    }

}
