<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/taglib/aui/nav/init.jsp" %>
<%--

<c:if test="<%= collapsible %>">
    <div class="collapse nav-collapse" id="<%= id %>NavbarCollapse">
</c:if>

<ul aria-label="<%= Validator.isNull(ariaLabel) ? portletDisplay.getTitle() : ariaLabel %>" class="nav <%= cssClass %>"
    id="<%= id %>"
    role="<%= Validator.isNull(ariaRole) ? "menubar" : ariaRole %>" <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>>

--%>

<%
    String themeName = themeDisplay.getLayout().getTheme().getName() + "_";
    if(null != themeName && (!themeName.equals("csb-admin-theme")) ){

        %>
<liferay-util:buffer var="html">
    <liferay-util:include

        page="/html/taglib/aui/nav/start.portal.jsp"
        useCustomPage="<%= false %>"
    />
</liferay-util:buffer>

<%
        out.print(html);
    } else {
%>


<div  id="<%= id %>NavbarCollapse" class="page-actions">
    <div class="btn-group">
        <button type="button" class="btn btn-circle green-haze dropdown-toggle" data-toggle="dropdown">
            <i class="fa fa-plus"></i>&nbsp;<span class="hidden-sm hidden-xs">Options&nbsp;</span>&nbsp;<i class="fa fa-angle-down"></i>
        </button>

        <ul role="<%= Validator.isNull(ariaRole) ? "menubar" : ariaRole %>"  id="<%= id %>" class="dropdown-menu"
            <%--role="menu"--%> <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>>



<%}%>