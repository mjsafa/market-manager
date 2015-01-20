<%@ page import="com.arman.csb.util.JsoupUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.json.JSONException" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="javax.swing.*" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
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

<%@ include file="/html/portlet/blogs/init.jsp" %>



<%
    String themeName = themeDisplay.getLayout().getTheme().getName();
    if(null != themeName && (!themeName.equals("csb-admin-theme")) ){

        %>
<liferay-util:buffer var="html">
    <liferay-util:include
        page="/html/portlet/blogs/view_entry_content.portal.jsp"
        useCustomPage="<%= false %>"
    />
</liferay-util:buffer>

<%
        out.print(html);
    } else {
%>







<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("view_entry_content.jsp-searchContainer");

BlogsEntry entry = (BlogsEntry)request.getAttribute("view_entry_content.jsp-entry");

AssetEntry assetEntry = (AssetEntry)request.getAttribute("view_entry_content.jsp-assetEntry");
    JSONObject contentJsonObject = JSONFactoryUtil.getJSONFactory().createJSONObject(entry.getContent());
    String postContent = contentJsonObject.getString("content");

    JSONArray imagesArray = null;
    try{
        imagesArray = contentJsonObject.getJSONArray("images");
    }catch (Exception e){
        imagesArray = JSONFactoryUtil.createJSONArray();
    }

%>

<portlet:renderURL var="viewEntryURL">
	<portlet:param name="struts_action" value="/blogs/view_entry" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="urlTitle" value="<%= entry.getUrlTitle() %>" />
</portlet:renderURL>

<portlet:renderURL var="editEntryURL">
    <portlet:param name="struts_action" value="/blogs/edit_entry" />
    <portlet:param name="redirect" value="<%= currentURL %>" />
    <portlet:param name="backURL" value="<%= currentURL %>" />
    <portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
</portlet:renderURL>


<c:choose>
	<c:when test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.VIEW) && (entry.isVisible() || (entry.getUserId() == user.getUserId()) || BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE)) %>">

                    <div class="col-md-6">
                        <div class="portlet box grey">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-pencil-square"></i>
                                    <a href="<%= viewEntryURL %>" >
									    <%= StringUtil.shorten(HtmlUtil.escape(entry.getTitle()), 75, " ...")  %>
									</a>
								</div>
                                <div class="actions">
                                    <a href="<%=editEntryURL%>" class="btn bg-yellow-crusta btn-sm">
                                       <i class="fa fa-pencil"></i>&nbsp;<liferay-ui:message key='edit'/>&nbsp;
                                    </a>



                                    <c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.DELETE) %>">
                                        <portlet:renderURL var="viewURL">
                                            <portlet:param name="struts_action" value="/blogs/view" />
                                        </portlet:renderURL>

                                        <portlet:actionURL var="deleteEntryURL">
                                            <portlet:param name="struts_action" value="/blogs/edit_entry" />
                                            <portlet:param name="<%= Constants.CMD %>" value="<%= TrashUtil.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE %>" />
                                            <portlet:param name="redirect" value="<%= viewURL %>" />
                                            <portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
                                        </portlet:actionURL>

                                        <%--<liferay-ui:icon-delete
                                            label="<%= true %>"
                                            trash="<%= TrashUtil.isTrashEnabled(scopeGroupId) %>"
                                            url="<%= deleteEntryURL %>"
                                        />--%>
                                        <a onclick="submitForm(document.hrefFm, '<%= deleteEntryURL.toString() %>');" class="btn bg-yellow-crusta btn-sm">
                                           <i class="fa fa-trash-o"></i>&nbsp;<liferay-ui:message key='delete'/>&nbsp;
                                        </a>
                                    </c:if>

                                </div>
							</div>
							<div class="portlet-body">

                                <%
                                    String workflowStatus = WorkflowConstants.getStatusLabel(entry.getStatus());
                                    String statusColor = "green";
                                    if(workflowStatus == WorkflowConstants.LABEL_DRAFT){
                                        statusColor = "blue";
                                    } else if(workflowStatus == WorkflowConstants.LABEL_DENIED){
                                        statusColor = "red";
                                    }if(workflowStatus == WorkflowConstants.LABEL_SCHEDULED){

                                        statusColor = "yellow";
                                    }

                                %>
                                <div class="workflow-label bg-<%=statusColor%>"><liferay-ui:message key="<%=WorkflowConstants.getStatusLabel(entry.getStatus())%>"/></div>

								<div class="portlet-tabs tabbable-line">
									<ul class="nav nav-tabs">
										<li class="active">
											<a href="#post<%=entry.getEntryId()%>_1" data-toggle="tab">
                                                <liferay-ui:message key='summary'/>
                                            </a>
										</li>
										<li >
											<a href="#post<%=entry.getEntryId()%>_2" data-toggle="tab">
                                                <liferay-ui:message key='images'/>
                                            </a>
										</li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane active" id="post<%=entry.getEntryId()%>_1">
                                            <div class="scroller" style="height:130px" data-rail-visible="1" data-rail-color="white" data-handle-color="grey">

                                                <p>
                                                     <%=HtmlUtil.escape(entry.getDescription())%>
                                                 </p>
                                             </div>
										</div>
										<div class="tab-pane" id="post<%=entry.getEntryId()%>_2">
                                            <div class="scroller" style="height:130px" data-rail-visible="1" data-rail-color="white" data-handle-color="grey">
                                                <%
                                                    for(int i = 0; i < imagesArray.length() ; i++){
                                                    String imageUrl = imagesArray.getJSONObject(i).getString("serverUrl");
                                                %>


                                                            <img src="<%=imageUrl%>" class="img-responsive post-image-thumbnail" alt="">
                                                <%}%>
                                                </div>
                                        </div>
										<div class="tab-pane" id="post<%=entry.getEntryId()%>_3">
											<p>
												 Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.
											</p>
											<p>
												<a class="btn purple" href="ui_tabs_accordions_navs.html#portlet_tab2_3" target="_blank">
												Activate this tab via URL </a>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
                    </div>


    </c:when>
   	<c:otherwise>

   		<%
   		if (searchContainer != null) {
   			searchContainer.setTotal(searchContainer.getTotal() - 1);
   		}
   		%>

   	</c:otherwise>
   </c:choose>































<%--



<c:choose>
	<c:when test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.VIEW) && (entry.isVisible() || (entry.getUserId() == user.getUserId()) || BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE)) %>">
		<div class="entry <%= WorkflowConstants.getStatusLabel(entry.getStatus()) %>" id="<portlet:namespace /><%= entry.getEntryId() %>">
			<div class="entry-content">

				<%
				String strutsAction = ParamUtil.getString(request, "struts_action");
				%>

				<c:if test="<%= !entry.isApproved() %>">
					<h3>
						<liferay-ui:message key='<%= entry.isPending() ? "pending-approval" : WorkflowConstants.getStatusLabel(entry.getStatus()) %>' />
					</h3>
				</c:if>

				<portlet:renderURL var="viewEntryURL">
					<portlet:param name="struts_action" value="/blogs/view_entry" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="urlTitle" value="<%= entry.getUrlTitle() %>" />
				</portlet:renderURL>

				<c:if test='<%= !strutsAction.equals("/blogs/view_entry") %>'>
					<div class="entry-title">
						<h2><aui:a href="<%= viewEntryURL %>"><%= HtmlUtil.escape(entry.getTitle()) %></aui:a></h2>
					</div>
				</c:if>

				<div class="entry-date">
					<span class="hide-accessible"><liferay-ui:message key="published-date" /></span>

					<%= dateFormatDateTime.format(entry.getDisplayDate()) %>
				</div>
			</div>

			<portlet:renderURL var="bookmarkURL" windowState="<%= WindowState.NORMAL.toString() %>">
				<portlet:param name="struts_action" value="/blogs/view_entry" />
				<portlet:param name="urlTitle" value="<%= entry.getUrlTitle() %>" />
			</portlet:renderURL>

			<c:if test='<%= enableSocialBookmarks && socialBookmarksDisplayPosition.equals("top") %>'>
				<liferay-ui:social-bookmarks
					displayStyle="<%= socialBookmarksDisplayStyle %>"
					target="_blank"
					title="<%= entry.getTitle() %>"
					types="<%= socialBookmarksTypes %>"
					url="<%= PortalUtil.getCanonicalURL(bookmarkURL.toString(), themeDisplay, layout) %>"
				/>
			</c:if>

			<c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.DELETE) || BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.PERMISSIONS) || BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE) %>">
				<div class="lfr-meta-actions edit-actions entry">
					<table class="lfr-table">
					<tr>
						<c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE) %>">
							<td>
								<portlet:renderURL var="editEntryURL">
									<portlet:param name="struts_action" value="/blogs/edit_entry" />
									<portlet:param name="redirect" value="<%= currentURL %>" />
									<portlet:param name="backURL" value="<%= currentURL %>" />
									<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
								</portlet:renderURL>

								<liferay-ui:icon
									image="edit"
									label="<%= true %>"
									url="<%= editEntryURL %>"
								/>
							</td>
						</c:if>

						<c:if test="<%= showEditEntryPermissions && BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.PERMISSIONS) %>">
							<td>
								<liferay-security:permissionsURL
									modelResource="<%= BlogsEntry.class.getName() %>"
									modelResourceDescription="<%= entry.getTitle() %>"
									resourcePrimKey="<%= String.valueOf(entry.getEntryId()) %>"
									var="permissionsEntryURL"
									windowState="<%= LiferayWindowState.POP_UP.toString() %>"
								/>

								<liferay-ui:icon
									image="permissions"
									label="<%= true %>"
									method="get"
									url="<%= permissionsEntryURL %>"
									useDialog="<%= true %>"
								/>
							</td>
						</c:if>

						<c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.DELETE) %>">
							<td>
								<portlet:renderURL var="viewURL">
									<portlet:param name="struts_action" value="/blogs/view" />
								</portlet:renderURL>

								<portlet:actionURL var="deleteEntryURL">
									<portlet:param name="struts_action" value="/blogs/edit_entry" />
									<portlet:param name="<%= Constants.CMD %>" value="<%= TrashUtil.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE %>" />
									<portlet:param name="redirect" value="<%= viewURL %>" />
									<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
								</portlet:actionURL>

								<liferay-ui:icon-delete
									label="<%= true %>"
									trash="<%= TrashUtil.isTrashEnabled(scopeGroupId) %>"
									url="<%= deleteEntryURL %>"
								/>
							</td>
						</c:if>
					</tr>
					</table>
				</div>
			</c:if>

			<div class="entry-body">
				<c:choose>
					<c:when test='<%= displayStyle.equals(BlogsUtil.DISPLAY_STYLE_ABSTRACT) && !strutsAction.equals("/blogs/view_entry") %>'>
						<c:if test="<%= entry.isSmallImage() %>">
							<div class="asset-small-image">
								<img alt="" class="asset-small-image" src="<%= HtmlUtil.escape(entry.getEntryImageURL(themeDisplay)) %>" width="150" />
							</div>
						</c:if>

						<%
						String summary = entry.getDescription();

						if (Validator.isNull(summary)) {
							summary = entry.getDescription();
						}
						%>

						<%= StringUtil.shorten(HtmlUtil.stripHtml(summary), pageAbstractLength) %>

						<br />

						<aui:a href="<%= viewEntryURL %>"><liferay-ui:message arguments='<%= new Object[] {"hide-accessible", HtmlUtil.escape(entry.getTitle())} %>' key="read-more-x-about-x" /> &raquo;</aui:a>
					</c:when>
					<c:when test='<%= displayStyle.equals(BlogsUtil.DISPLAY_STYLE_FULL_CONTENT) || strutsAction.equals("/blogs/view_entry") %>'>

						<%
						String entryContentId = "blogs-entry-content-" + entry.getEntryId();

						boolean inlineEditEnabled = BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE) && BrowserSnifferUtil.isRtf(request) && !WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, BlogsEntry.class.getName());
						%>

						<div <%= inlineEditEnabled ? "class=\"lfr-editable\" contenteditable=\"true\" id=\"" + entryContentId + "\" spellcheck=\"false\"" : StringPool.BLANK %>>
							<%= entry.getContent() %>
						</div>

						<liferay-ui:custom-attributes-available className="<%= BlogsEntry.class.getName() %>">
							<liferay-ui:custom-attribute-list
								className="<%= BlogsEntry.class.getName() %>"
								classPK="<%= entry.getEntryId() %>"
								editable="<%= false %>"
								label="<%= true %>"
							/>
						</liferay-ui:custom-attributes-available>

						<c:if test="<%= inlineEditEnabled %>">
							<portlet:actionURL var="updateEntryContent">
								<portlet:param name="struts_action" value="/blogs/edit_entry" />
								<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UPDATE_CONTENT %>" />
								<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
							</portlet:actionURL>

							<liferay-ui:input-editor
								editorImpl="ckeditor"
								inlineEdit="<%= true %>"
								inlineEditSaveURL="<%= updateEntryContent %>"
								name="<%= entryContentId %>"
							/>
						</c:if>
					</c:when>
					<c:when test='<%= displayStyle.equals(BlogsUtil.DISPLAY_STYLE_TITLE) && !strutsAction.equals("/blogs/view_entry") %>'>
						<aui:a href="<%= viewEntryURL %>"><liferay-ui:message arguments='<%= new Object[] {"hide-accessible", HtmlUtil.escape(entry.getTitle())} %>' key="read-more-x-about-x" /> &raquo;</aui:a>
					</c:when>
				</c:choose>
			</div>

			<div class="entry-footer">
				<div class="entry-author">
					<liferay-ui:message key="written-by" /> <%= HtmlUtil.escape(PortalUtil.getUserName(entry)) %>
				</div>

				<div class="stats">
					<c:if test="<%= assetEntry != null %>">
						<span class="view-count">
							<c:choose>
								<c:when test="<%= assetEntry.getViewCount() == 1 %>">
									<%= assetEntry.getViewCount() %> <liferay-ui:message key="view" />,
								</c:when>
								<c:when test="<%= assetEntry.getViewCount() > 1 %>">
									<%= assetEntry.getViewCount() %> <liferay-ui:message key="views" />,
								</c:when>
							</c:choose>
						</span>
					</c:if>

					<c:if test="<%= enableComments %>">
						<span class="comments">

							<%
							long classNameId = PortalUtil.getClassNameId(BlogsEntry.class.getName());

							int messagesCount = MBMessageLocalServiceUtil.getDiscussionMessagesCount(classNameId, entry.getEntryId(), WorkflowConstants.STATUS_APPROVED);
							%>

							<c:choose>
								<c:when test='<%= strutsAction.equals("/blogs/view_entry") %>'>
									<%= messagesCount %> <liferay-ui:message key='<%= (messagesCount == 1) ? "comment" : "comments" %>' />
								</c:when>
								<c:otherwise>
									<aui:a href='<%= PropsValues.PORTLET_URL_ANCHOR_ENABLE ? viewEntryURL : viewEntryURL + StringPool.POUND + "blogsCommentsPanelContainer" %>'><%= messagesCount %> <liferay-ui:message key='<%= (messagesCount == 1) ? "comment" : "comments" %>' /></aui:a>
								</c:otherwise>
							</c:choose>
						</span>
					</c:if>
				</div>

				<c:if test="<%= enableFlags %>">
					<liferay-ui:flags
						className="<%= BlogsEntry.class.getName() %>"
						classPK="<%= entry.getEntryId() %>"
						contentTitle="<%= entry.getTitle() %>"
						reportedUserId="<%= entry.getUserId() %>"
					/>
				</c:if>

				<span class="entry-categories">
					<liferay-ui:asset-categories-summary
						className="<%= BlogsEntry.class.getName() %>"
						classPK="<%= entry.getEntryId() %>"
						portletURL="<%= renderResponse.createRenderURL() %>"
					/>
				</span>

				<span class="entry-tags">
					<liferay-ui:asset-tags-summary
						className="<%= BlogsEntry.class.getName() %>"
						classPK="<%= entry.getEntryId() %>"
						portletURL="<%= renderResponse.createRenderURL() %>"
					/>
				</span>

				<c:if test='<%= displayStyle.equals(BlogsUtil.DISPLAY_STYLE_FULL_CONTENT) || strutsAction.equals("/blogs/view_entry") %>'>
					<c:if test="<%= enableRelatedAssets %>">
						<div class="entry-links">
							<liferay-ui:asset-links
								assetEntryId="<%= (assetEntry != null) ? assetEntry.getEntryId() : 0 %>"
								className="<%= BlogsEntry.class.getName() %>"
								classPK="<%= entry.getEntryId() %>"
							/>
						</div>
					</c:if>

					<c:if test='<%= enableSocialBookmarks && socialBookmarksDisplayPosition.equals("bottom") %>'>
						<liferay-ui:social-bookmarks
							contentId="<%= String.valueOf(entry.getEntryId()) %>"
							displayStyle="<%= socialBookmarksDisplayStyle %>"
							target="_blank"
							title="<%= entry.getTitle() %>"
							types="<%= socialBookmarksTypes %>"
							url="<%= PortalUtil.getCanonicalURL(bookmarkURL.toString(), themeDisplay, layout) %>"
						/>
					</c:if>

					<c:if test="<%= enableRatings %>">
						<liferay-ui:ratings
							className="<%= BlogsEntry.class.getName() %>"
							classPK="<%= entry.getEntryId() %>"
						/>
					</c:if>
				</c:if>
			</div>
		</div>

		<div class="separator"><!-- --></div>
	</c:when>
	<c:otherwise>

		<%
		if (searchContainer != null) {
			searchContainer.setTotal(searchContainer.getTotal() - 1);
		}
		%>

	</c:otherwise>
</c:choose>

--%>


<%}%>