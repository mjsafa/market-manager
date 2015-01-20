<%@ page import="com.liferay.portlet.blogs.model.BlogsEntry" %>
<%@ page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil" %>
<%@ page import="com.liferay.portal.service.RoleServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.util.ResourcePermissionUtil" %>
<%@ page import="com.liferay.portal.service.ResourceLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.*" %>
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

<link href="/html/css/persianDatepicker-default.css" media="all" rel="stylesheet" type="text/css"/>

<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet"
      type="text/css"/>
<link href="/html/metronic/assets/rtl/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet"
      type="text/css"/>
<link href="/html/metronic/assets/rtl/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet"
      type="text/css"/>

<link href="/html/metronic/assets/rtl/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="/html/metronic/assets/rtl/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="/html/metronic/assets/rtl/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet"
      type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link href="/html/metronic/assets/rtl/global/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
<link href="/html/metronic/assets/rtl/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet"
      type="text/css"/>
<link href="/html/metronic/assets/rtl/global/plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet"
      type="text/css"/>
<link href="/html/metronic/assets/rtl/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN PAGE STYLES -->
<link href="/html/metronic/assets/rtl/admin/pages/css/tasks.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="/html/metronic/assets/rtl/global/css/components.css" rel="stylesheet" type="text/css"/>
<link href="/html/metronic/assets/rtl/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<%--<link href="/html/metronic/assets/rtl/admin/layout2/css/layout.css" rel="stylesheet" type="text/css"/>--%>
<link href="/html/metronic/assets/rtl/admin/layout2/css/themes/default.css" rel="stylesheet" type="text/css"
      id="style_color"/>
<link href="/html/metronic/assets/rtl/admin/layout2/css/custom.css" rel="stylesheet" type="text/css"/>


<%
    String redirect = ParamUtil.getString(request, "redirect");
    String backURL = ParamUtil.getString(request, "backURL");

    String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");

    BlogsEntry entry = (BlogsEntry) request.getAttribute(WebKeys.BLOGS_ENTRY);

    long entryId = BeanParamUtil.getLong(entry, request, "entryId");

    String content = BeanParamUtil.getString(entry, request, "content");
    boolean allowPingbacks = PropsValues.BLOGS_PINGBACK_ENABLED && BeanParamUtil.getBoolean(entry, request, "allowPingbacks", true);
    boolean allowTrackbacks = PropsValues.BLOGS_TRACKBACK_ENABLED && BeanParamUtil.getBoolean(entry, request, "allowTrackbacks", true);
    boolean smallImage = BeanParamUtil.getBoolean(entry, request, "smallImage");

    boolean preview = ParamUtil.getBoolean(request, "preview");
    boolean showHeader = ParamUtil.getBoolean(request, "showHeader", true);
%>
<%
    boolean showSubtitle = PrefsPropsUtil.getPreferences(themeDisplay.getCompanyId()).getValue(BlogsEntry.class.getName() + "#" + "show_subtitle", "TRUE").equals("FALSE");

    boolean guestPermittedView = false;
    boolean guestPermittedComment = false;

    if(null != entry &&  entry.getEntryId() > 0L){
        Role guestRole = RoleServiceUtil.getRole(themeDisplay.getCompanyId(), RoleConstants.GUEST);

            List<String> actions = new ArrayList<String>();
            actions.add(ActionKeys.VIEW);
            actions.add(ActionKeys.ADD_DISCUSSION);

            List<String> currentIndividualActions = new ArrayList<String>();
            List<String> currentGroupActions = new ArrayList<String>();
            List<String> currentGroupTemplateActions = new ArrayList<String>();
            List<String> currentCompanyActions = new ArrayList<String>();

            Resource resource =  ResourceLocalServiceUtil.getResource(themeDisplay.getCompanyId(), BlogsEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(entry.getEntryId()));

            if(null != resource){
                long groupId = themeDisplay.getScopeGroupId();
                ResourcePermissionUtil.populateResourcePermissionActionIds(groupId, guestRole, resource, actions, currentIndividualActions, currentGroupActions, currentGroupTemplateActions, currentCompanyActions);

                if(currentCompanyActions.contains("VIEW") || currentIndividualActions.contains("VIEW") || currentGroupActions.contains("VIEW") || currentGroupTemplateActions.contains("VIEW")){
                    guestPermittedView = true;
                }

                if(currentCompanyActions.contains(ActionKeys.ADD_DISCUSSION) || currentIndividualActions.contains(ActionKeys.ADD_DISCUSSION) || currentGroupActions.contains(ActionKeys.ADD_DISCUSSION) || currentGroupTemplateActions.contains(ActionKeys.ADD_DISCUSSION)){
                    guestPermittedComment = true;
                }
            }

    }



%>



<script type="text/javascript">
    var serverFiles = new Array();

    function extractServerFiles(loadedContent) {
        try {
            var contentObject = JSON.parse(loadedContent);
            serverFiles = contentObject.images;
        } catch (e) {
            console.log(e);
        }

        /*
         $('<div>').append($(loadedContent)).find("script[data-main-image=true]").each(function(){
         var _name = $(this).attr('data-name');
         var _size = $(this).attr('data-size');
         var _url = $(this).attr('data-url');
         var mockFile = {
         name: _name,
         size: _size,
         type: 'image/jpeg',
         status: Dropzone.ADDED,
         url: _url,
         serverUrl: _url,
         accepted: true
         };

         serverFiles.push(mockFile);
         });
         */
    }

</script>



<c:if test="<%= showSubtitle %>">
    <h1>SALAMMMMMMMMMMM</h1>

    <h1>SALAMMMMMMMMMMM</h1>

    <h1>SALAMMMMMMMMMMM</h1>

    <h1>SALAMMMMMMMMMMM</h1>

    <h1>SALAMMMMMMMMMMM</h1>

    <h1>SALAMMMMMMMMMMM</h1>
</c:if>

<c:if test="<%= showHeader %>">
    <liferay-ui:header
            backURL="<%= backURL %>"
            localizeTitle="<%= (entry == null) %>"
            title='<%= (entry == null) ? "new-blog-entry" : entry.getTitle() %>'
            />
</c:if>

<portlet:actionURL var="editEntryURL">
    <portlet:param name="struts_action" value="/blogs/edit_entry"/>
</portlet:actionURL>

<aui:form action="<%= editEntryURL %>" enctype="multipart/form-data" method="post" name="fm" onSubmit="event.preventDefault();">
<aui:input name="<%= Constants.CMD %>" type="hidden"/>
<aui:input name="redirect" type="hidden" value="<%= redirect %>"/>
<aui:input name="backURL" type="hidden" value="<%= backURL %>"/>
<aui:input name="referringPortletResource" type="hidden" value="<%= referringPortletResource %>"/>
<aui:input name="entryId" type="hidden" value="<%= entryId %>"/>
<aui:input name="preview" type="hidden" value="<%= false %>"/>
<aui:input name="workflowAction" type="hidden" value="<%= WorkflowConstants.ACTION_PUBLISH %>"/>

<liferay-ui:error exception="<%= EntryContentException.class %>" message="please-enter-valid-content"/>
<liferay-ui:error exception="<%= EntryTitleException.class %>" message="please-enter-a-valid-title"/>

<liferay-ui:asset-categories-error/>

<liferay-ui:asset-tags-error/>

<aui:model-context bean="<%= entry %>" model="<%= BlogsEntry.class %>"/>

<c:if test="<%= (entry == null) || !entry.isApproved() %>">
    <div class="save-status" id="<portlet:namespace />saveStatus"></div>
</c:if>

<c:if test="<%= entry != null %>">
    <aui:workflow-status id="<%= String.valueOf(entry.getEntryId()) %>" status="<%= entry.getStatus() %>"/>
</c:if>


<div class="row">
    <div class="col-lg-2 col-md-3 col-sm-6 col-xs-12">
        <div class="tiles" style="margin-left: 18px;">
            <div class="tile bg-red-sunglo" id="date_tile">
                <div class="tile-body">
                    <i class="fa fa-calendar"></i>
                </div>
                <div class="tile-object">
                    <div class="title">
                        select date
                    </div>
                </div>
            </div>
            <div id="category_tile" class="tile bg-purple-studio">
                <div class="tile-body">
                    <i class="fa fa-sitemap"></i>
                </div>
                <div class="tile-object">
                    <div class="title">
                        select Category
                    </div>
                </div>
            </div>
            <div id="tags_tile" class="tile bg-blue-steel">
                <div class="tile-body">
                    <i class="fa fa-tags"></i>
                </div>
                <div class="tile-object">
                    <div class="title">
                        select Tags
                    </div>
                </div>
            </div>

            <div id="permission_tile" class="tile bg-yellow-saffron">
                <div class="tile-body">
                    <i class="fa fa-tags"></i>
                </div>
                <div class="tile-object">
                    <div class="title">
                        Post Permissions
                    </div>
                </div>
            </div>


        </div>
    </div>

    <div style="padding-left:0px;" class="col-lg-7 col-md-3 col-sm-6 col-xs-12 blog_field_container">
        <%--<input name="<portlet:namespace />title" id="<portlet:namespace />title" type="text" placeholder="title ..."  type="text" placeholder="title ..." value="<%= HtmlUtil.escapeAttribute() %>"/>--%>
            <aui:input autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" name="title" placeholder="title ..." />
            <aui:input type="textarea" label="description" name="description" placeholder="Post Descriptions ..."/>
            <%--<textarea name="<portlet:namespace />description"  id="<portlet:namespace />description"  placeholder="Post Descriptions ..."></textarea>--%>
        <div style="width:100%">
            <liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>"/>
            <aui:input name="content" type="hidden"/>
        </div>
    </div>

    <div style="padding-left:0px;" class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dzone-blog-container">

            <div class="dropzone" id="my-awesome-dropzone">

            </div>

        </div>
    </div>
</div>

<div class="tags_popup" style="display:block;">
  <aui:input name="tags" type="assetTags"/>
</div>


<aui:fieldset>
<%--<aui:input autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" name="title"/>--%>



<c:if test="<%= preview %>">

    <%
        if (entry == null) {
            entry = new BlogsEntryImpl();
        }

        entry.setContent(content);
    %>

    <liferay-ui:message key="preview"/>:

    <div class="preview">
        <%= entry.getContent() %>
    </div>

    <br/>
</c:if>

<%--
<aui:input type="textarea" cssClass="description_input" label="description" name="description"/>
--%>




<%--<aui:field-wrapper label="content"></aui:field-wrapper>--%>
<liferay-ui:custom-attributes-available className="<%= BlogsEntry.class.getName() %>">
    <liferay-ui:custom-attribute-list
            className="<%= BlogsEntry.class.getName() %>"
            classPK="<%= entryId %>"
            editable="<%= true %>"
            label="<%= true %>"
            />
</liferay-ui:custom-attributes-available>

<c:if test="<%= PropsValues.BLOGS_PINGBACK_ENABLED && false%>">
    <aui:input helpMessage="to-allow-pingbacks,-please-also-ensure-the-entry's-guest-view-permission-is-enabled"
               name="allowPingbacks" value="<%= allowPingbacks %>"/>
</c:if>

<c:if test="<%= PropsValues.BLOGS_TRACKBACK_ENABLED && false%>">
    <aui:input helpMessage="to-allow-trackbacks,-please-also-ensure-the-entry's-guest-view-permission-is-enabled"
               name="allowTrackbacks" value="<%= allowTrackbacks %>"/>

    <aui:input label="trackbacks-to-send" name="trackbacks"/>

    <c:if test="<%= (entry != null) && Validator.isNotNull(entry.getTrackbacks()) %>">
        <aui:field-wrapper name="trackbacks-already-sent">

            <%
                for (String trackback : StringUtil.split(entry.getTrackbacks())) {
            %>

            <liferay-ui:input-resource url="<%= trackback %>"/><br/>

            <%
                }
            %>

        </aui:field-wrapper>
    </c:if>
</c:if>

<c:if test="<%= ((entry == null) || (entry.getStatus() == WorkflowConstants.STATUS_DRAFT)) && false %>">
    <aui:field-wrapper label="permissions">
        <liferay-ui:input-permissions
                modelName="<%= BlogsEntry.class.getName() %>"
                />
    </aui:field-wrapper>
</c:if>

<br/>


<div style="display: none;">
    <liferay-ui:panel defaultState="closed" extended="<%= false %>" id="blogsEntryAbstractPanel"
                      persistState="<%= true %>" title="abstract">
        <liferay-ui:error exception="<%= EntrySmallImageNameException.class %>">

            <%
                String[] imageExtensions = PrefsPropsUtil.getStringArray(PropsKeys.BLOGS_IMAGE_EXTENSIONS, StringPool.COMMA);
            %>

            <liferay-ui:message
                    key="image-names-must-end-with-one-of-the-following-extensions"/> <%= StringUtil.merge(imageExtensions, ", ") %>
            .
        </liferay-ui:error>

        <liferay-ui:error exception="<%= EntrySmallImageSizeException.class %>">

            <%
                long imageMaxSize = PrefsPropsUtil.getLong(PropsKeys.BLOGS_IMAGE_SMALL_MAX_SIZE) / 1024;
            %>

            <liferay-ui:message arguments="<%= imageMaxSize %>"
                                key="please-enter-a-small-image-with-a-valid-file-size-no-larger-than-x"/>
        </liferay-ui:error>

        <aui:fieldset>
            <aui:input label="description" name="description"/>

            <div id="<portlet:namespace />smallImageContainer">
                <div class="lfr-blogs-small-image-header">
                    <aui:input label="use-small-image" name="smallImage"/>
                </div>

                <div class="lfr-blogs-small-image-content toggler-content-collapsed">
                    <aui:row>
                        <c:if test="<%= smallImage && (entry != null) %>">
                            <aui:col width="<%= 50 %>">
                                <img alt="<liferay-ui:message key=" preview" />" class="lfr-blogs-small-image-preview"
                                src="<%= Validator.isNotNull(entry.getSmallImageURL()) ? entry.getSmallImageURL() : themeDisplay.getPathImage() + "/template?img_id=" + entry.getSmallImageId() + "&t=" + WebServerServletTokenUtil.getToken(entry.getSmallImageId()) %>" />
                            </aui:col>
                        </c:if>

                        <aui:col width="<%= (smallImage && (entry != null)) ? 50 : 100 %>">
                            <aui:fieldset>
                                <aui:input cssClass="lfr-blogs-small-image-type" inlineField="<%= true %>"
                                           label="small-image-url" name="type" type="radio"/>

                                <aui:input cssClass="lfr-blogs-small-image-value" inlineField="<%= true %>" label=""
                                           name="smallImageURL"/>
                            </aui:fieldset>

                            <aui:fieldset>
                                <aui:input cssClass="lfr-blogs-small-image-type" inlineField="<%= true %>"
                                           label="small-image" name="type" type="radio"/>

                                <aui:input cssClass="lfr-blogs-small-image-value" inlineField="<%= true %>" label=""
                                           name="smallFile" type="file"/>
                            </aui:fieldset>
                        </aui:col>
                    </aui:row>
                </div>
            </div>
        </aui:fieldset>
    </liferay-ui:panel>
</div>


<div style="display: none;">
    <liferay-ui:panel defaultState="closed" extended="<%= false %>" id="blogsEntryCategorizationPanel"
                      persistState="<%= true %>" title="categorization">
        <aui:fieldset>
            <aui:input name="categories" type="assetCategories"/>
        </aui:fieldset>
    </liferay-ui:panel>


    <liferay-ui:panel defaultState="closed" extended="<%= false %>" id="blogsEntryAssetLinksPanel"
                      persistState="<%= true %>" title="related-assets">
        <aui:fieldset>
            <liferay-ui:input-asset-links
                    className="<%= BlogsEntry.class.getName() %>"
                    classPK="<%= entryId %>"
                    />
        </aui:fieldset>
    </liferay-ui:panel>


</div>

<%
    boolean pending = false;

    if (entry != null) {
        pending = entry.isPending();
    }
%>

<c:if test="<%= pending %>">
    <div class="alert alert-info">
        <liferay-ui:message key="there-is-a-publication-workflow-in-process"/>
    </div>
</c:if>

<%

   String selected = "selected";

%>

<div id="permission_popup" >
    <aui:select name="viewableBy" multiple="false">
        <aui:option selected="<%=guestPermittedView%>" value="<%=RoleConstants.GUEST%>">GUEST</aui:option>
        <aui:option selected="<%=!guestPermittedView%>" value="<%=RoleConstants.USER%>">USER</aui:option>
    </aui:select>


    <aui:select multiple="false" name="commentableBy">
        <aui:option selected="<%=guestPermittedComment %>" value="<%=RoleConstants.GUEST%>">GUEST</aui:option>
        <aui:option selected="<%=!guestPermittedComment %>" value="<%=RoleConstants.USER%>">USER</aui:option>
    </aui:select>
</div>

<aui:button-row>

    <%
        String saveButtonLabel = "save";

        if ((entry == null) || entry.isDraft() || entry.isApproved()) {
            saveButtonLabel = "save-as-draft";
        }

        String publishButtonLabel = "publish";

        if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, BlogsEntry.class.getName())) {
            publishButtonLabel = "submit-for-publication";
        }
    %>

    <c:if test="<%= (entry != null) && entry.isApproved() && WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(entry.getCompanyId(), entry.getGroupId(), BlogsEntry.class.getName()) %>">
        <div class="alert alert-info">
            <%= LanguageUtil.format(pageContext, "this-x-is-approved.-publishing-these-changes-will-cause-it-to-be-unpublished-and-go-through-the-approval-process-again", ResourceActionsUtil.getModelResource(locale, BlogsEntry.class.getName())) %>
        </div>
    </c:if>

    <aui:button name="saveButton" onClick='<%= renderResponse.getNamespace() + "saveEntry(true, false);" %>'
                primary="<%= false %>" type="submit" value="<%= saveButtonLabel %>"/>

    <c:if test="<%= (entry == null) || entry.isDraft() || preview %>">
        <aui:button name="previewButton" onClick='<%= renderResponse.getNamespace() + "previewEntry();" %>'
                    value="preview"/>
    </c:if>

    <aui:button disabled="<%= pending %>" name="publishButton"
                onClick='<%= renderResponse.getNamespace() + "saveEntry(false, false);" %>' type="submit"
                value="<%= publishButtonLabel %>"/>

    <aui:button href="<%= redirect %>" name="cancelButton" type="cancel"/>
</aui:button-row>
</aui:fieldset>


<div class="date_form" style="display:none;">
    <aui:input name="displayDate"/>
</div>

</aui:form>

<aui:script>
    var <portlet:namespace/>saveDraftIntervalId = null;
    var <portlet:namespace/>oldTitle = null;
    var <portlet:namespace/>oldContent = null;

    function <portlet:namespace/>clearSaveDraftIntervalId() {
    if (<portlet:namespace/>saveDraftIntervalId != null) {
    clearInterval(<portlet:namespace/>saveDraftIntervalId);
    }
    }

    function <portlet:namespace/>getSuggestionsContent() {
    var content = '';

    content += document.<portlet:namespace/>fm.<portlet:namespace/>title.value + ' ';
    content += window.<portlet:namespace/>editor.getHTML();

    return content;
    }

    function <portlet:namespace/>initEditor() {
    var loadedContent = "<%= UnicodeFormatter.toString(content) %>";
    if(serverFiles && serverFiles.length < 1){
    extractServerFiles(loadedContent);
    }

    try{
    return JSON.parse(loadedContent).content;
    }catch(e){
    return loadedContent;
    }
    }


    function <portlet:namespace/>previewEntry() {
    document.<portlet:namespace/>fm.<portlet:namespace/><%= Constants.CMD %>.value = "<%= (entry == null) ? Constants.ADD : Constants.UPDATE %>";
    document.<portlet:namespace/>fm.<portlet:namespace/>preview.value = "true";
    document.<portlet:namespace/>fm.<portlet:namespace/>workflowAction.value = "<%= WorkflowConstants.ACTION_SAVE_DRAFT %>";

    if (window.<portlet:namespace/>editor) {
    document.<portlet:namespace/>fm.<portlet:namespace/>content.value = window.<portlet:namespace/>editor.getHTML();
    }

    submitForm(document.<portlet:namespace/>fm);
    }

    Liferay.provide(
    window,
    '<portlet:namespace/>saveEntry',
    function(draft, ajax) {
    var A = AUI();

    var title = document.<portlet:namespace/>fm.<portlet:namespace/>title.value;
    var content = window.<portlet:namespace/>editor.getHTML();

    var publishButton = A.one('#<portlet:namespace/>publishButton');
    var cancelButton = A.one('#<portlet:namespace/>cancelButton');

    var saveStatus = A.one('#<portlet:namespace/>saveStatus');
    var saveText ='<%= UnicodeLanguageUtil.format(pageContext, ((entry != null) && entry.isPending()) ? "entry-saved-at-x" : "draft-saved-at-x", "[TIME]", false) %>';

    if (draft && ajax) {
    if ((title == '') || (content == '')) {
    return;
    }

    if ((<portlet:namespace/>oldTitle == title) && (<portlet:namespace/>oldContent == content)) {

    return;
    }

    <portlet:namespace/>oldTitle = title;
    <portlet:namespace/>oldContent = content;

    var url = '<portlet:actionURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>"><portlet:param name="struts_action" value="/blogs/edit_entry"/><portlet:param name="ajax" value="true"/><portlet:param name="preview" value="false"/></portlet:actionURL>';

    var data = {
    <portlet:namespace/>assetTagNames: document.<portlet:namespace/>fm.<portlet:namespace/>assetTagNames.value,
    <portlet:namespace/><%= Constants.CMD %>: '<%= Constants.ADD %>',
    <portlet:namespace/>content: content,
    <portlet:namespace/>displayDateAmPm: document.<portlet:namespace/>fm.<portlet:namespace/>displayDateAmPm.value,
    <portlet:namespace/>displayDateDay: document.<portlet:namespace/>fm.<portlet:namespace/>displayDateDay.value,
    <portlet:namespace/>displayDateHour: document.<portlet:namespace/>fm.<portlet:namespace/>displayDateHour.value,
    <portlet:namespace/>displayDateMinute: document.<portlet:namespace/>fm.<portlet:namespace/>displayDateMinute.value,
    <portlet:namespace/>displayDateMonth: document.<portlet:namespace/>fm.<portlet:namespace/>displayDateMonth.value,
    <portlet:namespace/>displayDateYear: document.<portlet:namespace/>fm.<portlet:namespace/>displayDateYear.value,
    <portlet:namespace/>entryId: document.<portlet:namespace/>fm.<portlet:namespace/>entryId.value,
    <portlet:namespace/>redirect: document.<portlet:namespace/>fm.<portlet:namespace/>redirect.value,
    <portlet:namespace/>referringPortletResource: document.<portlet:namespace/>fm.<portlet:namespace/>referringPortletResource.value,
    <portlet:namespace/>title: title,
    <portlet:namespace/>workflowAction: <%= WorkflowConstants.ACTION_SAVE_DRAFT %>
    };

    var customAttributes = A.one(document.<portlet:namespace/>fm).all('[name^=<portlet:namespace/>ExpandoAttribute]');

    customAttributes.each(
    function(item, index, collection) {
    data[item.attr('name')] = item.val();
    }
    );

    A.io.request(
    url,
    {
    data: data,
    dataType: 'json',
    on: {
    failure: function() {
    if (saveStatus) {
    saveStatus.set('className', 'alert alert-error save-status');
    saveStatus.html('<%= UnicodeLanguageUtil.get(pageContext, "could-not-save-draft-to-the-server") %>');
    }
    },
    start: function() {
    Liferay.Util.toggleDisabled(publishButton, true);

    if (saveStatus) {
    saveStatus.set('className', 'alert alert-info save-status pending');
    saveStatus.html('<%= UnicodeLanguageUtil.get(pageContext, "saving-draft") %>');
    }
    },
    success: function(event, id, obj) {
    var instance = this;

    var message = instance.get('responseData');

    if (message) {
    document.<portlet:namespace/>fm.<portlet:namespace/>entryId.value = message.entryId;
    document.<portlet:namespace/>fm.<portlet:namespace/>redirect.value = message.redirect;

    var tabs1BackButton = A.one('#<portlet:namespace/>tabs1TabsBack');

    if (tabs1BackButton) {
    tabs1BackButton.attr('href', message.redirect);
    }

    if (cancelButton) {
    cancelButton.detach('click');

    cancelButton.on(
    'click',
    function() {
    location.href = message.redirect;
    }
    );
    }

    var now = saveText.replace(/\[TIME\]/gim, (new Date()).toString());

    if (saveStatus) {
    saveStatus.set('className', 'alert alert-success save-status');
    saveStatus.html(now);
    }
    }
    else {
    saveStatus.hide();
    }

    Liferay.Util.toggleDisabled(publishButton, false);
    }
    }
    }
    );
    }
    else {
    <portlet:namespace/>clearSaveDraftIntervalId();

    document.<portlet:namespace/>fm.<portlet:namespace/><%= Constants.CMD %>.value = "<%= (entry == null) ? Constants.ADD : Constants.UPDATE %>";
    document.<portlet:namespace/>fm.<portlet:namespace/>content.value = content;

    if (draft) {
    document.<portlet:namespace/>fm.<portlet:namespace/>workflowAction.value= <%= WorkflowConstants.ACTION_SAVE_DRAFT %>;
    }
    else {
    document.<portlet:namespace/>fm.<portlet:namespace/>workflowAction.value = <%= WorkflowConstants.ACTION_PUBLISH %>;
    }

    submitForm(document.<portlet:namespace/>fm);
    }
    },
    ['aui-io']
    );
</aui:script>

<aui:script use="aui-base">
    var cancelButton = A.one('#<portlet:namespace/>cancelButton');

    if (cancelButton) {
    cancelButton.on(
    'click',
    function() {
    <portlet:namespace/>clearSaveDraftIntervalId();

    location.href = '<%= HtmlUtil.escapeJS(PortalUtil.escapeRedirect(redirect)) %>';
    }
    );
    }

    <c:if test="<%= (entry == null) || ((entry.getUserId() == user.getUserId()) && (entry.getStatus() == WorkflowConstants.STATUS_DRAFT)) %>">
        <portlet:namespace/>saveDraftIntervalId = setInterval('<portlet:namespace/>saveEntry(true, true)', 30000000);
        <portlet:namespace/>oldTitle = document.<portlet:namespace/>fm.<portlet:namespace/>title.value;
        <portlet:namespace/>oldContent = <portlet:namespace/>initEditor();
    </c:if>
</aui:script>

<aui:script use="aui-toggler">
    var container = A.one('#<portlet:namespace/>smallImageContainer');

    var types = container.all('.lfr-blogs-small-image-type');
    var values = container.all('.lfr-blogs-small-image-value');

    var selectSmallImageType = function(index) {
    types.set('checked', false);

    types.item(index).set('checked', true);

    values.set('disabled', true);

    values.item(index).set('disabled', false);
    };

    container.delegate(
    'change',
    function(event) {
    var index = types.indexOf(event.currentTarget);

    selectSmallImageType(index);
    },
    '.lfr-blogs-small-image-type'
    );

    new A.Toggler(
    {
    animated: true,
    content: '#<portlet:namespace/>smallImageContainer .lfr-blogs-small-image-content',
    expanded: <%= smallImage %>,
    header: '#<portlet:namespace/>smallImageContainer .lfr-blogs-small-image-header',
    on: {
    animatingChange: function(event) {
    var instance = this;

    var expanded = !instance.get('expanded');

    A.one('#<portlet:namespace/>smallImage').set('value', expanded);
    A.one('#<portlet:namespace/>smallImageCheckbox').set('checked', expanded);

    if (expanded) {
    types.each(
    function(item, index, collection) {
    if (item.get('checked')) {
    values.item(index).set('disabled', false);
    }
    }
    );
    }
    else {
    values.set('disabled', true);
    }
    }
    }
    }
    );

    selectSmallImageType('<%= (entry != null) && Validator.isNotNull(entry.getSmallImageURL()) ? 0 : 1 %>');
</aui:script>

<%
    if (entry != null) {
        PortletURL portletURL = renderResponse.createRenderURL();

        portletURL.setParameter("struts_action", "/blogs/view_entry");
        portletURL.setParameter("entryId", String.valueOf(entry.getEntryId()));

        PortalUtil.addPortletBreadcrumbEntry(request, entry.getTitle(), portletURL.toString());
        PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "edit"), currentURL);
    } else {
        PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "add-entry"), currentURL);
    }
%>

<%!
    public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.blogs.edit_entry.jsp";
%>


<script type="text/javascript" src="/html/js/persianDatepicker.js"></script>
<script type="text/javascript" src="/html/js/dropzone.js"></script>
<script type="text/javascript">
    var fileUrls;
    var files;

    Dropzone.autoDiscover = false;

    var main_image_dropzone = $("div#my-awesome-dropzone").dropzone({
        url:"/delegate/resource/blogs",
        addRemoveLinks:true,
        maxFiles:10,
        thumbnailWidth:210,
        thumbnailHeight:210,
        init:function () {
            var that = this;
            this.on("success", function (file, res) {
                try {
                    var url = JSON.parse(res).link;
                    file.serverUrl = url;
                } catch (e) {
                    file.serverUrl = url;
                }

                /*fileUrls[file.name] = url
                 mainFileUrl = url;
                 mainFile = file;*/
            });


            this.on("drop", function (file) {
                /*  if(mainFile){
                 //that.removeFile(mainFile);
                 }*/
            });


            this.on("removedfile", function (file) {
                /*if(mainFile){
                 //mainFile = undefined;
                 //mainFileUrl = undefined;
                 }*/
            });

            var loadedContent = "<%= UnicodeFormatter.toString(content) %>";
            if (serverFiles && serverFiles.length < 1) {
                extractServerFiles(loadedContent);
            }


            var that = this;
            //add currently available files to uploader(EDIT MODE)
            for (var i = 0; i < serverFiles.length; i++) {
                // Call the default addedfile event handler
                that.options.addedfile.call(that, serverFiles[i]);

                // And optionally show the thumbnail of the file:
                that.options.thumbnail.call(that, serverFiles[i], serverFiles[i].url);
                that.files.push(serverFiles[i]);
            }

        }

    });


    /*function appendImages(htmlContent){

     var files =  Dropzone.forElement("div#my-awesome-dropzone").getAcceptedFiles();


     var content = $($.parseHTML(htmlContent));
     content.find("script[data-main-image=true]").remove();

     files.forEach(function(file, index){
     if(file.serverUrl){
     var mainImageContainer = $("<script data-main-image='true' type='text/template' data-url='" + file.serverUrl + "'>" + "<" + "/script>");
     mainImageContainer.attr("data-size", file.size);
     mainImageContainer.attr("data-name", file.name);
     htmlContent =  $('<div>').append($(htmlContent).clone()).html() + $('<div>').append(mainImageContainer.clone()).html();
     }else{
     htmlContent =  $('<div>').append($(htmlContent)).html() ;
     }
     });

     return htmlContent;
     }
     */


    function appendImages(htmlContent) {
        var files = Dropzone.forElement("div#my-awesome-dropzone").getAcceptedFiles();

        var images = [];
        files.forEach(function (file, index) {
            if (file.serverUrl) {
                var image = {
                    accepted:file.accepted,
                    height:file.height,
                    name:file.name,
                    serverUrl:file.serverUrl,
                    size:file.size,
                    status:file.status,
                    type:file.type,
                    width:file.width,
                    url:file.serverUrl
                };

                images.push(image);
            }
        });

        var result = {content:htmlContent, images:images};
        return JSON.stringify(result);
    }


</script>



<script src="/html/metronic/assets/rtl/global/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="/html/metronic/assets/rtl/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js"
        type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
        type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
        type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"
        type="text/javascript"></script>

<script src="/html/metronic/assets/rtl/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/jquery.pulsate.min.js" type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/bootstrap-daterangepicker/moment.min.js"
        type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/bootstrap-daterangepicker/daterangepicker.js"
        type="text/javascript"></script>

<script src="/html/metronic/assets/rtl/global/plugins/fullcalendar/fullcalendar/fullcalendar.min.js"
        type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js"
        type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/global/plugins/gritter/js/jquery.gritter.js" type="text/javascript"></script>


<script src="/html/metronic/assets/rtl/global/scripts/metronic.js" type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/admin/layout2/scripts/layout.js" type="text/javascript"></script>

<script src="/html/metronic/assets/rtl/admin/layout2/scripts/demo.js" type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/admin/pages/scripts/index.js" type="text/javascript"></script>
<script src="/html/metronic/assets/rtl/admin/pages/scripts/tasks.js" type="text/javascript"></script>


<script src="/html/metronic/assets/rtl/admin/layout2/scripts/balloon.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>

    var toggleBalloon = function(element){
        $(".tile.active").hideBalloon();
        if(element.hasClass("active")){
            element.hideBalloon();
            $(".tile.active").removeClass("active");
        }else{
            $(".tile.active").removeClass("active");
            element.addClass("active");
            element.showBalloon();
        }
    }

    jQuery(document).ready(function () {


        Metronic.init(); // init metronic core componets
        Layout.init(); // init layout
        Demo.init(); // init demo features
        Index.init();
        Index.initDashboardDaterange();
       // Index.initJQVMAP(); // init index page's custom scripts
        Index.initCalendar(); // init index page's custom scripts
        Index.initCharts(); // init index page's custom scripts
        Index.initChat();
        Index.initMiniCharts();
        Index.initIntro();
        Tasks.initDashboardWidget();


        $.balloon.defaults.classname = "my-balloon";
    	$.balloon.defaults.showDuration = "50";
    	$.balloon.defaults.hideDuration = "30";
        $.balloon.defaults.showAnimation= function (d) { this.fadeIn(d); }



    	$.balloon.defaults.css = {
    		opacity:"1",
    		padding: "20px 40px 10px 40px",
    		border: "4px solid #21C3E2"
    	};
    	$.balloon.defaults.tipSize = "20";

        var dateInitialized = false;
        $('#date_tile').showBalloon({ contents:$(".date_form").show() , position:"right" }).click(
            function(){
                if(!dateInitialized){
                    window.initiateDatePicker();
                    dateInitialized = true;
                };
                toggleBalloon($(this));
            }

        ).hideBalloon();


        var categoryClicked = false;
        $('#category_tile').click(function(){
            $(".tile").hideBalloon();
            $(".tile").removeClass("active");
            if(!categoryClicked){
                $(".categoriesselector").find("button").click();
                categoryClicked = true;
            }
            $(".categoriesselector").find("button").click();
        }) ;


        $('#tags_tile').showBalloon({ contents:$(".tags_popup").show() , position:"right", classname:"my-balloon tags" }).click(
            function(){
                toggleBalloon($(this));
            }
        ).hideBalloon();


        $('#permission_tile').showBalloon({ contents:$("#permission_popup").show() , position:"right", classname:"my-balloon tags" }).click(
            function(){
                toggleBalloon($(this));
            }
        ).hideBalloon();


        //hide all balloons when another area is clicked
        $(".blog_field_container").click(function(){
            $(".tile").hideBalloon();
            $(".tile").removeClass("active");
        })
    });


</script>


