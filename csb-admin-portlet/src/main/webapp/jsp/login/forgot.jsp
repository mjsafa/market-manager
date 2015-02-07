<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%@ page import="com.arman.csb.theme.model.Template" %>
<%@ page import="com.arman.csb.theme.service.TemplateLocalServiceUtil" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<portlet:defineObjects/>


<%

    ThemeDisplay themeDisplay =
            (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

    long groupId = themeDisplay.getLayout().getGroupId();


    String redirect = ParamUtil.getString(request, "redirect");
%>

<portlet:renderURL var="viewLocationURL"/>
<portlet:actionURL name='sendPassword' var="editTemplateURL"
                   windowState="normal"/>

<liferay-ui:header
        backURL="<%= viewLocationURL %>"
        title='type'
        />

<portlet:actionURL var="loginURL">
			<portlet:param name="struts_action" value="/login/login" />
		</portlet:actionURL>

<button><%= loginURL%></button>

<aui:form action="<%= editTemplateURL%>" method="POST" name="fm">
    <aui:fieldset>
        <aui:input name="redirect" type="hidden" value="<%= redirect %>"/>


        <aui:input name="name" type="text"/>

        <aui:input name="head" type="textArea"/>

        <aui:input name="htmlContent" type="textArea"/>

        <aui:input name="footer" type="textArea"/>


        <aui:input name="groupId" value="<%=groupId%>" type="hidden"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>

        <aui:button onClick="<%= viewLocationURL %>" type="cancel"/>
    </aui:button-row>
</aui:form>