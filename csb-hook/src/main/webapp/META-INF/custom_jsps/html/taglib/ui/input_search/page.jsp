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

<%@ include file="/html/taglib/init.jsp" %>


<%
    String themeName = themeDisplay.getLayout().getTheme().getName();
    if(null != themeName && (!themeName.equals("csb-admin-theme")) ){

        %>
<liferay-util:buffer var="html">
    <liferay-util:include

        page="/html/taglib/ui/input_search/page.portal.jsp"
        useCustomPage="<%= false %>"
    />
</liferay-util:buffer>

<%
        out.print(html);
    } else {
%>




<%
    boolean autoFocus = GetterUtil.getBoolean(request.getAttribute("liferay-ui:input-search:autoFocus"));
    String buttonLabel = GetterUtil.getString((String) request.getAttribute("liferay-ui:input-search:buttonLabel"));
    String cssClass = GetterUtil.getString((String) request.getAttribute("liferay-ui:input-search:cssClass"));
    String id = GetterUtil.getString((String) request.getAttribute("liferay-ui:input-search:id"));
    String name = GetterUtil.getString((String) request.getAttribute("liferay-ui:input-search:name"));
    String placeholder = GetterUtil.getString((String) request.getAttribute("liferay-ui:input-search:placeholder"));
    boolean showButton = GetterUtil.getBoolean(request.getAttribute("liferay-ui:input-search:showButton"));
    String title = GetterUtil.getString((String) request.getAttribute("liferay-ui:input-search:title"));

    String value = ParamUtil.getString(request, name);
%>

<%--<div class="<%= cssClass %>">
    <input class="search-query span9" id="<portlet:namespace /><%= id %>" name="<portlet:namespace /><%= name %>"
           placeholder="<%= placeholder %>" title="<%= title %>" type="text"
           value="<%= HtmlUtil.escapeAttribute(value) %>"/>

    <c:if test="<%= showButton %>">
        <button class="btn" type="submit">

        </button>
    </c:if>
</div>--%>



<div class="tile double bg-yellow-casablanca">

    <form class="search-form search-form-expanded" action="extra_search.html" method="GET">

            <input type="text" class="search-tile-input" placeholder="Search..."  id="<portlet:namespace /><%= id %>" name="<portlet:namespace /><%= name %>" value="<%= HtmlUtil.escapeAttribute(value) %>">
                    <%--<a href="javascript:;" class="btn submit"></a>--%>
                    <button type="submit" class="search-tile-button">
                        <i class="fa fa-search"></i>
                        <%--<%= buttonLabel %>--%>
                    </button>

    </form>
    <%--<div class="tile-body"><i class="fa fa- fa-pencil-square-o"></i></div>
    <div class="tile-object">
        <div class="title"> Add Blog Entry</div>
        <div class="number"></div>
    </div>--%>
</div>


<c:if test="<%= autoFocus %>">
    <aui:script>
        Liferay.Util.focusFormField('#<%= namespace %><%= id %>');
    </aui:script>
</c:if>

<%}%>