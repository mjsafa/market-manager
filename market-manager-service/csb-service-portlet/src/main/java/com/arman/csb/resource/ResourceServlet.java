package com.arman.csb.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 8/28/14
 * Time: 10:25 AM
 */
public class ResourceServlet extends HttpServlet {

    private static final String _fileSeparator = System.getProperty("file.separator");

    private int FILEBUFFERSIZE = 1024;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String SITE_ABSOLUTE_PAT = PortletProps.get("site.files.absolutePath");
        InputStream in = null;
        ServletOutputStream out = response.getOutputStream();

        try {
            String virtualHostName = PortalUtil.getCompany(request).getVirtualHostname();

            //get the path to resource
            String filePath = getFilePath(request, virtualHostName);

            //get MimeType for the resource
            String mimeType = MimeTypesUtil.getContentType(request.getPathInfo().split("/")[request.getPathInfo().split("/").length - 1]);
            response.setContentType(mimeType);

            //write the file to servlet output stream
            in = new FileInputStream(filePath);
            byte[] bytes = new byte[FILEBUFFERSIZE];
            int bytesRead;
            while ((bytesRead = in.read(bytes)) != -1) {
                out.write(bytes, 0, bytesRead);
            }

        } catch (FileNotFoundException fileException) {//if resource not found, send 404 error to client
            PortalUtil.sendError(HttpServletResponse.SC_NOT_FOUND, new FileNotFoundException(), request, response);
        } catch (Exception e) {
            //e.printStackTrace();
            log(e.getMessage(), e);
        } finally {
            if (null != in) {
                in.close();
                out.close();
            }
        }
    }

    private String getFilePath(HttpServletRequest request, String virtualHost) {
        String SITE_ABSOLUTE_PAT = PortletProps.get("site.files.absolutePath");

        try {
            SITE_ABSOLUTE_PAT = PrefsPropsUtil.getString("site.files.absolutePath");
        } catch (SystemException e) {}

        String[] paths = request.getPathInfo().split("/");
        String filePath = "";
        for (int i = 2; i < paths.length; i++) {
            filePath += "/" + paths[i];
        }
        filePath = virtualHost + filePath;

        String basePath = SITE_ABSOLUTE_PAT + _fileSeparator + PortletProps.get("site.files.path");

        filePath = basePath + _fileSeparator + filePath;

        return filePath;
    }


    /**
     * Generates the url for upload based on the relative path of request
     *
     * @param request
     * @param virtualHost
     * @param fileName
     * @return
     */
    private String getUploadPath(HttpServletRequest request, String virtualHost, String fileName) {
        String SITE_ABSOLUTE_PAT = PortletProps.get("site.files.absolutePath");
        try {
            SITE_ABSOLUTE_PAT = PrefsPropsUtil.getString("site.files.absolutePath");
        } catch (SystemException e) {}


        //extracts relative path to the file
        String[] paths = request.getPathInfo().split("/");
        String filePath = "";
        for (int i = 2; i < paths.length; i++) {
            filePath += "/" + paths[i];
        }

        //creates absolute path
        filePath = virtualHost + _fileSeparator + PortletProps.get("site.upload.path") + filePath + _fileSeparator + fileName;
        String basePath = SITE_ABSOLUTE_PAT + _fileSeparator + PortletProps.get("site.files.path");
        filePath = basePath + _fileSeparator + filePath;

        return filePath;
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String virtualHostName = PortalUtil.getCompany(request).getVirtualHostname();

            if (request.getContentType().startsWith(ContentTypes.MULTIPART_FORM_DATA) || request.getContentType().startsWith(ContentTypes.MULTIPART_MIXED)) {

                List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                        String fieldname = item.getFieldName();
                        String fieldvalue = item.getString();
                        // ... (do your job here)
                    } else {
                        // Process form file field (input type="file").
                        String fieldname = item.getFieldName();
                        String filename = FilenameUtils.getName(item.getName());
                        filename = System.currentTimeMillis() + "_" + filename;
                        InputStream filecontent = item.getInputStream();
                        // ... (do your job here)
                        IOUtils.copy(filecontent, new FileOutputStream(getUploadPath(request, virtualHostName, filename)));
                        response.getWriter().write("{ \"link\": \"" + getFileUrl(request, true) + "/" + filename + "\" }");
                        response.setContentType("text/html");
                    }
                }
            } else if (request.getParameter("imageData") != null || true) {
                byte[] bytes = Base64.decode(IOUtils.toString(request.getInputStream()));

                String fileName = "cropped" + "_" + System.currentTimeMillis() + ".jpg";
                IOUtils.copy(new ByteArrayInputStream(bytes), new FileOutputStream(getUploadPath(request, virtualHostName, fileName)));

                response.getWriter().write("{ \"link\": \"" + getFileUrl(request, true) + "/" + fileName + "\" }");
                response.setContentType("text/html");
            }
        } catch (FileUploadException e) {
            throw new ServletException("Cannot parse multipart request.", e);
        } catch (SystemException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (PortalException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    private String getFileUrl(HttpServletRequest request, boolean isUploaded) {
        if (isUploaded) {
            String path = request.getRequestURI();
            String[] pathSlashes = path.split("/");
            String finalPath = "/" + pathSlashes[1] + "/" + pathSlashes[2] + "/" + PortletProps.get("site.upload.path");
            for (int i = 3; i < pathSlashes.length; i++) {
                finalPath += "/" + pathSlashes[i];
            }

            return finalPath;
        }

        return "";
    }
}
