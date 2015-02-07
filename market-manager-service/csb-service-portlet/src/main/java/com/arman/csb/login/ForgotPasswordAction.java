package com.arman.csb.login;

import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 2/5/15
 * Time: 1:02 PM
 */
public class ForgotPasswordAction extends BaseStrutsAction {
    public String execute(
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        String name = ParamUtil.get(request, "name", "World");

        request.setAttribute("name", name);

        return "/login";
    }

}
