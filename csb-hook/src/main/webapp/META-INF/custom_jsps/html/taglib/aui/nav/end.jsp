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

<%
    String themeName = themeDisplay.getLayout().getTheme().getName()+ "_";
    if(null != themeName && (!themeName.equals("csb-admin-theme")) ){

        %>
<liferay-util:buffer var="html">
    <liferay-util:include

        page="/html/taglib/aui/nav/end.portal.jsp"
        useCustomPage="<%= false %>"
    />
</liferay-util:buffer>

<%
        out.print(html);
    } else {
%>

<%--

</ul>

<c:if test="<%= collapsible %>">
	</div>
</c:if >--%>
    </ul>
  </div>
</div>

<%}%>