package no.uninett.agora.ckeditor;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil;
import com.liferay.portlet.wiki.service.WikiPageServiceUtil;

public class GetPageAttachmentStrutsAction extends BaseStrutsAction {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String wikiPageId = request.getParameter("wikipageId");
		String fileName   = request.getParameter("filename");
		
		WikiPage page = WikiPageLocalServiceUtil.getWikiPage(Long.parseLong(wikiPageId));
						
		String path = page.getAttachmentsFolderId() + "/" + fileName;

		InputStream is = DLStoreUtil.getFileAsStream(
			page.getCompanyId(), CompanyConstants.SYSTEM, path);
		long contentLength = DLStoreUtil.getFileSize(
			page.getCompanyId(), CompanyConstants.SYSTEM, path);
		String contentType = MimeTypesUtil.getContentType(fileName);

		ServletResponseUtil.sendFile(
			request, response, fileName, is, contentLength, contentType);
		
		return "";
		
	}
	
	

	
	
	
}
