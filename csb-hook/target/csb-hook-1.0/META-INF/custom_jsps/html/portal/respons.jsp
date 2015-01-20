
<%
	String funknum=(String)request.getAttribute("funknum");
	String url=(String)request.getAttribute("getattachment_url");
	String error=(String)request.getAttribute("getattachment_error");

%>
<%
if (error==null){
%>
	<script type='text/javascript'>
	   window.parent.CKEDITOR.tools.callFunction(<%=funknum%>, '<%=url%>','' );
	</script>
<%
}else{
%>
	<script type='text/javascript'>
	   window.parent.CKEDITOR.tools.callFunction(<%=funknum%>, '<%=url%>', '<%=error%>');
	</script>
<%
}
%>
Done!