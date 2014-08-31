<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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


<%@page import="com.liferay.portal.util.PortalUtil" %>
<%@ include file="/html/taglib/init.jsp" %>

<%
    String portletId = portletDisplay.getRootPortletId();

    String mainPath = themeDisplay.getPathMain();

    String doAsUserId = themeDisplay.getDoAsUserId();

    if (Validator.isNull(doAsUserId)) {
        doAsUserId = Encryptor.encrypt(company.getKeyObj(), String.valueOf(themeDisplay.getUserId()));
    }

    long doAsGroupId = themeDisplay.getDoAsGroupId();

    String ckEditorConfigFileName = ParamUtil.getString(request, "ckEditorConfigFileName", "ckconfig.jsp");

    boolean useCustomDataProcessor = false;

    if (!ckEditorConfigFileName.equals("ckconfig.jsp")) {
        useCustomDataProcessor = true;
    }

    Map<String, String> configParamsMap = (Map<String, String>) request.getAttribute("liferay-ui:input-editor:configParams");
    Map<String, String> fileBrowserParamsMap = (Map<String, String>) request.getAttribute("liferay-ui:input-editor:fileBrowserParams");

    String configParams = marshallParams(configParamsMap);
    String fileBrowserParams = marshallParams(fileBrowserParamsMap);

    String cssClass = GetterUtil.getString((String) request.getAttribute("liferay-ui:input-editor:cssClass"));
    String cssClasses = GetterUtil.getString((String) request.getAttribute("liferay-ui:input-editor:cssClasses"));
    String editorImpl = (String) request.getAttribute("liferay-ui:input-editor:editorImpl");
    String name = namespace + GetterUtil.getString((String) request.getAttribute("liferay-ui:input-editor:name"));
    String initMethod = (String) request.getAttribute("liferay-ui:input-editor:initMethod");

    String onChangeMethod = (String) request.getAttribute("liferay-ui:input-editor:onChangeMethod");

    if (Validator.isNotNull(onChangeMethod)) {
        onChangeMethod = namespace + onChangeMethod;
    }

    boolean skipEditorLoading = GetterUtil.getBoolean((String) request.getAttribute("liferay-ui:input-editor:skipEditorLoading"));
    String toolbarSet = (String) request.getAttribute("liferay-ui:input-editor:toolbarSet");
    long javaScriptLastModified = ServletContextUtil.getLastModified(application, "/html/js/", true);

%>

<link href="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() + "/editor/froala/css/font-awesome.min.css", javaScriptLastModified)) %>"
      type="text/css" rel="stylesheet"/>
<link href="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() + "/editor/froala/css/froala_editor.min.css", javaScriptLastModified)) %>"
      type="text/css" rel="stylesheet"/>


<div id='edit' style="margin-top: 30px;">
</div>


<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() + "/editor/froala/js/libs/jquery-1.10.2.min.js", javaScriptLastModified)) %>"
        type="text/javascript"></script>

<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() + "/editor/froala/js/froala_editor.min.js", javaScriptLastModified)) %>"
        type="text/javascript"></script>


<%--
<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() + "/editor/froala/js/froala_editor_ie8.min.js", javaScriptLastModified)) %>" type="text/javascript"></script>
--%>
<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() + "/editor/froala/js/plugins/tables.min.js", javaScriptLastModified)) %>"
        type="text/javascript"></script>
<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() + "/editor/froala/js/plugins/colors.min.js", javaScriptLastModified)) %>"
        type="text/javascript"></script>
<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() + "/editor/froala/js/plugins/media_manager.min.js", javaScriptLastModified)) %>"
        type="text/javascript"></script>
<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() + "/editor/froala/js/plugins/font_family.min.js", javaScriptLastModified)) %>"
        type="text/javascript"></script>
<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() + "/editor/froala/js/plugins/font_size.min.js", javaScriptLastModified)) %>"
        type="text/javascript"></script>
<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() + "/editor/froala/js/plugins/block_styles.min.js", javaScriptLastModified)) %>"
        type="text/javascript"></script>
<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() + "/editor/froala/js/plugins/video.min.js", javaScriptLastModified)) %>"
        type="text/javascript"></script>


<%--
<script type="text/javascript" src="../js/froala_editor.min.js"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="../js/froala_editor_ie8.min.js"></script>
<![endif]-->
<script type="text/javascript" src="../js/plugins/tables.min.js"></script>
<script type="text/javascript" src="../js/plugins/colors.min.js"></script>
<script type="text/javascript" src="../js/plugins/media_manager.min.js"></script>
<script type="text/javascript" src="../js/plugins/font_family.min.js"></script>
<script type="text/javascript" src="../js/plugins/font_size.min.js"></script>
<script type="text/javascript" src="../js/plugins/block_styles.min.js"></script>
<script type="text/javascript" src="../js/plugins/video.min.js"></script>
--%>


<script>
    $(function () {
        $('#edit').editable({inlineMode:false,
            imageUploadURL:'http://localhost:8080/delegate/resource/images',
            imageUploadParams:{id:"my_editor"},
            imageErrorCallback:function (errors) {
                alert(errors.code);
                alert("salam");
            }
        });

        $("#edit").on('editable.contentChanged', function (editor) {
            alert(editor.editable("getHTML"));
            $("textarea[name='<portlet:namespace />content']").html(editable("getHTML"));
        });

    });

</script>


<aui:script>
    (function() {
    window['<%= name %>'] = {
    		destroy: function() {
    			CKEDITOR.instances['<%= name %>'].destroy();

    			delete window['<%= name %>'];
    		},

    		focus: function() {
    			CKEDITOR.instances['<%= name %>'].focus();
    		},

    		getCkData: function() {
    			var data = CKEDITOR.instances['<%= name %>'].getData();

    			if (CKEDITOR.env.gecko && (CKEDITOR.tools.trim(data) == '<br />')) {
    				data = '';
    			}

    			return data;
    		},

    		getHTML: function() {
                alert($("#edit").editable("getHTML"));
    			return $("#edit").editable("getHTML");
    		},

    		getText: function() {
    			return window['<%= name %>'].getCkData();
    		},

    		<%
    		if (Validator.isNotNull(onChangeMethod)) {
    		%>

    			onChangeCallback: function () {
    				var ckEditor = CKEDITOR.instances['<%= name %>'];
    				var dirty = ckEditor.checkDirty();

    				if (dirty) {
    					<%= HtmlUtil.escape(onChangeMethod) %>(window['<%= name %>'].getText());

    					ckEditor.resetDirty();
    				}
    			},

    		<%
    		}
    		%>

    		setHTML: function(value) {
    			CKEDITOR.instances['<%= name %>'].setData(value);
    		}
    	};

    })();

</aui:script>

<%!
    public String marshallParams(Map<String, String> params) {
        StringBundler sb = new StringBundler();

        if (params != null) {
            for (Map.Entry<String, String> configParam : params.entrySet()) {
                sb.append(StringPool.AMPERSAND);
                sb.append(configParam.getKey());
                sb.append(StringPool.EQUAL);
                sb.append(HttpUtil.encodeURL(configParam.getValue()));
            }
        }

        return sb.toString();
    }
%>