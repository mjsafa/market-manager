package no.uninett.agora.ckeditor;

import java.util.Enumeration;
import java.util.List;

import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalService;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

public class ImageUploaderStrutsAction extends BaseStrutsAction {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//String filename = ParamUtil.get(request, "filename", "none");
		
		String error=null;
		FileUploadWrapper fupload=new FileUploadWrapper(request);
		Enumeration<String> parnames=fupload.getParameterNames();
		List <FileItem> files= fupload.getFileItems();
		
		//for (FileItem fileItem : files) {
			//System.out.println(fileItem.getName()+" "+fileItem.getFieldName());
		//}
		
		
		FileItem fileitem=fupload.getFileItem("upload");

		String funknum=fupload.getParameter("CKEditorFuncNum");

		funknum=request.getParameter("CKEditorFuncNum");
		request.setAttribute("funknum", funknum);
		
		String wikipageid=request.getParameter("wikipageid");
		WikiPage wpage=WikiPageLocalServiceUtil.getWikiPage(Long.parseLong(wikipageid));
				
		Long userid=PortalUtil.getUserId(request);		
		
		try{
			WikiPageLocalServiceUtil.addPageAttachment(userid, wpage.getNodeId(), wpage.getTitle(), fileitem.getName(), fileitem.getInputStream() , MimeTypesUtil.getContentType(fileitem.getName()));
		}catch (com.liferay.portlet.documentlibrary.DuplicateFileException e){
			error="Dette filnavnet finnes allerede.";
		}
		StringBundler url = new StringBundler(40);
		//url.append("http://localhost:8080");
		url.append("/c/portal/getpageattachment?wikipageId=");
		url.append(wpage.getPageId());
		url.append("&filename=");		
		url.append(fileitem.getName());

		
		request.setAttribute("getattachment_url", url.toString());
		request.setAttribute("getattachment_error", error);

		/*
		PortletURL rowURL = renderResponse.createActionURL();

		rowURL.setWindowState(LiferayWindowState.EXCLUSIVE);

		rowURL.setParameter("struts_action", "/wiki/get_page_attachment");
		rowURL.setParameter("nodeId", String.valueOf(node.getNodeId()));
		rowURL.setParameter("title", wikiPage.getTitle());
		rowURL.setParameter("fileName", shortFileName);
		
		
*/
		
		
		return "/portal/respons.jsp";
	}
	
	
}
