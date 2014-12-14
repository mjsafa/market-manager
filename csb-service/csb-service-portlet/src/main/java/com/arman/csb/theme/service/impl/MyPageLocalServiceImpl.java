package com.arman.csb.theme.service.impl;

import com.arman.csb.theme.model.ContentHolder;
import com.arman.csb.theme.model.Template;
import com.arman.csb.theme.service.ContentHolderLocalServiceUtil;
import com.arman.csb.theme.service.TemplateLocalServiceUtil;
import com.arman.csb.theme.service.base.MyPageLocalServiceBaseImpl;
import com.arman.csb.util.JsoupUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Layout;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.CompanyServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * The implementation of the my page local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.theme.service.MyPageLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.theme.service.base.MyPageLocalServiceBaseImpl
 * @see com.arman.csb.theme.service.MyPageLocalServiceUtil
 */
public class MyPageLocalServiceImpl extends MyPageLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.theme.service.MyPageLocalServiceUtil} to access the my page local service.
     */

    public Log _logger = LogFactoryUtil.getLog(MyPageLocalServiceImpl.class.getName());


    private static final String TEMPLATE_DIRECTORY = "templates";
    private static final String PAGE_DIRECTORY = "pages";
    private static final String CONTENT_TAG_NAME = "content";
    private static final String FILE_SYSTEM_RELATIVE_PATH = PortletProps.get("site.files.path");
    private static final String MODULE_NAMESPACE = "module";
    private static final Map<String, Object> fileLocks = new HashMap<String, Object>();

    String resourcesBaseUrl = "/delegate/resource/";

    private static final Long REPOSITORY_ID = 23L;


    public void editPageContent(long pageId, String itemId, String newContent) {
        try {
            Layout layout = LayoutLocalServiceUtil.getLayout(pageId);
            Long templateId = (Long) layout.getExpandoBridge().getAttribute("templateId");
            Template template = TemplateLocalServiceUtil.getTemplate(templateId);

            //retrieve JSOUP Document for template and page content
            Object templateLock = lock(layout.getCompanyId(), REPOSITORY_ID, TEMPLATE_DIRECTORY, template.getName() + ".html");
            synchronized (templateLock) {
                String templateContent = getContent(layout.getCompanyId(), REPOSITORY_ID, TEMPLATE_DIRECTORY, template.getName() + ".html");
                Document templateDoc = Jsoup.parse(templateContent);

                String pageName = SAXReaderUtil.read(new StringReader(layout.getName())).selectSingleNode("//Name").getText();
                Object pageLock = lock(layout.getCompanyId(), REPOSITORY_ID, PAGE_DIRECTORY, pageName + ".html");
                synchronized (pageLock) {
                    String pageContent = getContent(layout.getCompanyId(), REPOSITORY_ID, PAGE_DIRECTORY, pageName + ".html");
                    Document pageDoc = Jsoup.parse(pageContent);

                    Elements foundElements = templateDoc.select("*[data-editable=" + itemId + "]");
                    boolean foundInTemplate = true;
                    if (foundElements.isEmpty()) {
                        foundInTemplate = false;
                        foundElements = pageDoc.select("*[data-editable]");
                    }

                    if (foundElements.isEmpty()) {
                        throw new PortalException("element_not_found");
                    }

                    Element element = foundElements.get(0);
                    //newContent = newContent.replaceAll(resourcesBaseUrl, "");

                    if (element.tagName().equals("img")) {
                        Document newElement = Jsoup.parse(newContent);
                        element.attr("src", newElement.select("img").attr("src"));
                    } else if (element.tagName().equals("a")) {
                        Document newElement = Jsoup.parse(newContent);
                        element.attr("href", newElement.select("a").attr("href"));
                        if (!org.jsoup.helper.StringUtil.isBlank(newElement.select("a").html())) {
                            element.html(newElement.select("a").html());
                        }

                        if (!newElement.select("a").select("i").isEmpty()) {
                            element.select("i").attr("class", newElement.select("a").select("i").attr("class"));
                        }
                    } else if (element.tagName().equals("i")) {
                        Document newElement = Jsoup.parse(newContent);
                        element.attr("class", newElement.select("i").attr("class"));
                    } else {
                        element.html(newContent);
                    }


                    if (foundInTemplate) {
                        setContent(layout.getCompanyId(), REPOSITORY_ID, TEMPLATE_DIRECTORY, template.getName() + ".html", templateDoc.outerHtml());
                    } else {
                        setContent(layout.getCompanyId(), REPOSITORY_ID, PAGE_DIRECTORY, pageName + ".html", pageDoc.outerHtml());
                    }
                }
            }
        } catch (PortalException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SystemException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (DocumentException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    public Map<String, Object> renderPageHTML(long pageId) {
        try {
            Layout layout = LayoutLocalServiceUtil.getLayout(pageId);
            Long templateId = (Long) layout.getExpandoBridge().getAttribute("templateId");
            Template template = TemplateLocalServiceUtil.getTemplate(templateId);


            //retrieve JSOUP Document for template and page content
            String templateContent = getContent(layout.getCompanyId(), REPOSITORY_ID, TEMPLATE_DIRECTORY, template.getName() + ".html");
            Document templateDoc = Jsoup.parse(templateContent);

            String pageName = SAXReaderUtil.read(new StringReader(layout.getName())).selectSingleNode("//Name").getText();
            String pageContent = getContent(layout.getCompanyId(), REPOSITORY_ID, PAGE_DIRECTORY, pageName + ".html");
            Document pageDoc = Jsoup.parse(pageContent);

            //merge head of page and template into template <head> TAG
            JsoupUtil.mergeHeads(templateDoc.head(), pageDoc.head());

            String pageHtml = "";
            Element pageBody = pageDoc.body();
            if (null != pageBody) {
                pageHtml = pageBody.html();
            } else {
                pageHtml = pageContent;
            }

            JsoupUtil.replaceTag(templateDoc.select("site|pageContent").first(), "div", pageHtml);
            replaceContentHolders(templateDoc, layout.getCompanyId());


            JsoupUtil.prependValueToProperty(templateDoc.select("*"), "img", "src", resourcesBaseUrl, true);
            JsoupUtil.prependValueToProperty(templateDoc.select("*"), "link", "href", resourcesBaseUrl, true);
            JsoupUtil.prependValueToProperty(templateDoc.select("*"), "script[src]", "src", resourcesBaseUrl, true);
            JsoupUtil.prependValueToProperty(templateDoc.select("*"), "video[poster]", "poster", resourcesBaseUrl, true);
            JsoupUtil.prependValueToProperty(templateDoc.select("*"), "source", "src", resourcesBaseUrl, true);
            JsoupUtil.prependValueToProperty(templateDoc.select("*"), "a[data-type=prettyPhoto[gallery]", "href", resourcesBaseUrl, true);
            JsoupUtil.prependValueToProperty(templateDoc.select("a:not([href^=#])"), "a:not([href^=http])", "href", resourcesBaseUrl, true);

            replaceModuleTags(templateDoc);

            Elements footerScriptElement = templateDoc.select("site|footerScripts");
            String footerScripts = footerScriptElement.html();
            templateDoc.select("site|footerScripts").remove();

            String bodyAttributes = "";

            bodyAttributes = templateDoc.body().attributes().html();

            Map<String, Object> result = new HashMap<String, Object>();
            result.put("head", templateDoc.head().html());
            result.put("body", templateDoc.body().html());
            result.put("bodyClassName", templateDoc.body().className());
            result.put("footerScripts", footerScripts);
            result.put("bodyAttributes", bodyAttributes);

            result.put("authToken", AuthTokenUtil.getAuthToken());

            return result;

        } catch (PortalException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SystemException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (DocumentException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        //return html page for error
        return new HashMap<String, Object>();
    }


    public Map<String, Object> renderAdminHTML(long pageId) {
        try {
            String cdnUrl = "http://" + PortletProps.get("csb.cdn") + resourcesBaseUrl;
            Layout layout = LayoutLocalServiceUtil.getLayout(pageId);
            Long templateId = (Long) layout.getExpandoBridge().getAttribute("templateId");
            Template template = TemplateLocalServiceUtil.getTemplate(templateId);


            //retrieve JSOUP Document for template and page content
            String templateContent = getContent(REPOSITORY_ID, TEMPLATE_DIRECTORY, template.getName() + ".html", PortletProps.get("csb.admin.folder"));
            Document templateDoc = Jsoup.parse(templateContent);

            String pageName = SAXReaderUtil.read(new StringReader(layout.getName())).selectSingleNode("//Name").getText();
            String pageContent = getContent(REPOSITORY_ID, PAGE_DIRECTORY, pageName + ".html", PortletProps.get("csb.admin.folder"));
            Document pageDoc = Jsoup.parse(pageContent);

            //merge head of page and template into template <head> TAG
            JsoupUtil.mergeHeads(templateDoc.head(), pageDoc.head());

            String pageHtml = "";
            Element pageBody = pageDoc.body();
            if (null != pageBody) {
                pageHtml = pageBody.html();
            } else {
                pageHtml = pageContent;
            }

            JsoupUtil.replaceTag(templateDoc.select("site|pageContent").first(), "div", pageHtml);
            replaceContentHolders(templateDoc, layout.getCompanyId());


            JsoupUtil.prependValueToProperty(templateDoc.select("*"), "img", "src", cdnUrl, true);
            JsoupUtil.prependValueToProperty(templateDoc.select("*"), "link", "href", cdnUrl, true);
            JsoupUtil.prependValueToProperty(templateDoc.select("*"), "script[src]", "src", cdnUrl, true);
            JsoupUtil.prependValueToProperty(templateDoc.select("*"), "video[poster]", "poster", cdnUrl, true);
            JsoupUtil.prependValueToProperty(templateDoc.select("*"), "source", "src", cdnUrl, true);
            JsoupUtil.prependValueToProperty(templateDoc.select("*"), "a[data-type=prettyPhoto[gallery]", "href", cdnUrl, true);
            JsoupUtil.prependValueToProperty(templateDoc.select("a:not([href^=#])").select("a:not([href^=/page])"), "a:not([href^=http])", "href", cdnUrl, true);

            replaceModuleTags(templateDoc);

            Elements footerScriptElement = templateDoc.select("site|footerScripts");
            String footerScripts = footerScriptElement.html();
            templateDoc.select("site|footerScripts").remove();

            String bodyAttributes = "";

            bodyAttributes = templateDoc.body().attributes().html();

            Map<String, Object> result = new HashMap<String, Object>();
            result.put("head", templateDoc.head().html());
            result.put("body", templateDoc.body().html());
            result.put("bodyClassName", templateDoc.body().className());
            result.put("footerScripts", footerScripts);
            result.put("bodyAttributes", bodyAttributes);
            result.put("htmlAttributes", templateDoc.getElementsByTag("html").get(0).attributes());

            result.put("authToken", AuthTokenUtil.getAuthToken());

            return result;

        } catch (PortalException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SystemException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (DocumentException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        //return html page for error
        return new HashMap<String, Object>();
    }


    private String getContent(long companyId, long repositoryId, String directory, String fileName) {
        return getContent(companyId, repositoryId, directory, fileName, null);
    }

    private String getContent( long repositoryId, String directory, String fileName, String staticHost) {
            return getContent(0L, repositoryId, directory, fileName, staticHost);
    }


    private String getContent(long companyId, long repositoryId, String directory, String fileName, String virtualHost) {
        try {

            Company company = null;

            String companyDomain = virtualHost;
            if(null == companyDomain){
                company = CompanyLocalServiceUtil.getCompany(companyId);
                companyDomain = company.getVirtualHostname();
            }

            String _fileSeparator = System.getProperty("file.separator");
            String liferayHome = PropsUtil.get("liferay.home");

            String fileDirectory = liferayHome + _fileSeparator + FILE_SYSTEM_RELATIVE_PATH + _fileSeparator + companyDomain + _fileSeparator + directory + _fileSeparator + fileName;

            FileInputStream stream = new FileInputStream(fileDirectory);

            StringBuffer fileContent = new StringBuffer();
            List<String> lines = IOUtils.readLines(stream, Charsets.UTF_8);
            for (String line : lines) {
                fileContent.append(line + System.getProperty("line.separator"));
            }
            return fileContent.toString();

        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (IOException e) {
            _logger.error("io_error");
        }

        return "";
    }

    private void setContent(long companyId, long repositoryId, String directory, String fileName, String content) {
        try {

            Company company = CompanyLocalServiceUtil.getCompany(companyId);
            String companyDomain = company.getVirtualHostname();

            String _fileSeparator = System.getProperty("file.separator");
            String liferayHome = PropsUtil.get("liferay.home");

            String fileDirectory = liferayHome + _fileSeparator + FILE_SYSTEM_RELATIVE_PATH + _fileSeparator + companyDomain + _fileSeparator + directory + _fileSeparator + fileName;

            FileOutputStream stream = new FileOutputStream(fileDirectory);
            IOUtils.write(content, stream, Charsets.UTF_8);
            stream.flush();
            stream.close();

        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (IOException e) {
            _logger.error("io_error");
        }

    }

    private Object lock(long companyId, long repositoryId, String directory, String fileName) {
        try {

            Company company = CompanyLocalServiceUtil.getCompany(companyId);
            String companyDomain = company.getVirtualHostname();

            String _fileSeparator = System.getProperty("file.separator");
            String liferayHome = PropsUtil.get("liferay.home");

            String fileDirectory = liferayHome + _fileSeparator + FILE_SYSTEM_RELATIVE_PATH + _fileSeparator + companyDomain + _fileSeparator + directory + _fileSeparator + fileName;

            Object lock = fileLocks.get(fileDirectory);
            if (null == lock) {
                lock = new Object();
                fileLocks.put(fileDirectory, lock);
            }

            return lock;

        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return null;
    }


    private void replaceContentHolders(Document document, Long companyId) throws SystemException {
        //find all content holder tags
        Elements contentHolders = document.select("site|content");
        for (Element contentHolder : contentHolders) {
            String name = contentHolder.attr("name");
            List<ContentHolder> foundHolders = ContentHolderLocalServiceUtil.findByNameAndCompany(name, companyId);
            if (!foundHolders.isEmpty()) {
                ContentHolder contentHolderModel = foundHolders.get(0);

                Document contentHolderDoc = Jsoup.parse(contentHolderModel.getHtmlContent());
                Element head = contentHolderDoc.head();
                if (null != head) {
                    JsoupUtil.mergeHeads(document.head(), head);
                }

                Element body = contentHolderDoc.body();
                String contentHolderHTML = "";
                if (null != body) {
                    contentHolderHTML = body.html();
                } else {
                    contentHolderHTML = contentHolderModel.getHtmlContent();
                }

                JsoupUtil.replaceTag(contentHolder, "DIV", contentHolderHTML);
            }
        }
    }


    private void replaceModuleTags(Document document) {
        String[] moduleNames = {"blogPosts", "blogPost"};


        for (String moduleName : moduleNames) {
            Elements moduleElements = document.select(MODULE_NAMESPACE + "|" + moduleName);
            for (Element moduleElement : moduleElements) {
                moduleElement.tagName("script");
                moduleElement.attr("data-moduleName", moduleName);
                moduleElement.attr("type", "text/template");
            }

        }
    }

}
