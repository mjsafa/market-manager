package com.arman.csb.modules.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for MyBlog. This utility wraps
 * {@link com.arman.csb.modules.service.impl.MyBlogServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MyBlogService
 * @see com.arman.csb.modules.service.base.MyBlogServiceBaseImpl
 * @see com.arman.csb.modules.service.impl.MyBlogServiceImpl
 * @generated
 */
public class MyBlogServiceUtil {
    private static MyBlogService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arman.csb.modules.service.impl.MyBlogServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.liferay.portal.kernel.json.JSONArray getLatestBlogEntries(
        java.lang.String blogName, int status, int start, int end,
        java.lang.String tags, java.lang.String categories)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getLatestBlogEntries(blogName, status, start, end, tags,
            categories);
    }

    public static void clearService() {
        _service = null;
    }

    public static MyBlogService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MyBlogService.class.getName());

            if (invokableService instanceof MyBlogService) {
                _service = (MyBlogService) invokableService;
            } else {
                _service = new MyBlogServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(MyBlogServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(MyBlogService service) {
    }
}
