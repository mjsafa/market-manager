package com.arman.csb.modules.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for MyBlog. This utility wraps
 * {@link com.arman.csb.modules.service.impl.MyBlogLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MyBlogLocalService
 * @see com.arman.csb.modules.service.base.MyBlogLocalServiceBaseImpl
 * @see com.arman.csb.modules.service.impl.MyBlogLocalServiceImpl
 * @generated
 */
public class MyBlogLocalServiceUtil {
    private static MyBlogLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arman.csb.modules.service.impl.MyBlogLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static java.util.List<com.arman.csb.modules.model.MyBlogDTO> findGroupEntries(
        long companyId, long groupId, int status, int start, int end,
        java.lang.String tags, java.lang.String categories,
        java.util.Map<java.lang.String, java.lang.Object> options) {
        return getService()
                   .findGroupEntries(companyId, groupId, status, start, end,
            tags, categories, options);
    }

    public static void clearService() {
        _service = null;
    }

    public static MyBlogLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MyBlogLocalService.class.getName());

            if (invokableLocalService instanceof MyBlogLocalService) {
                _service = (MyBlogLocalService) invokableLocalService;
            } else {
                _service = new MyBlogLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(MyBlogLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(MyBlogLocalService service) {
    }
}
