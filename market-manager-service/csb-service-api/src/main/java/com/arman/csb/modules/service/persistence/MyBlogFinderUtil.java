package com.arman.csb.modules.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class MyBlogFinderUtil {
    private static MyBlogFinder _finder;

    public static MyBlogFinder getFinder() {
        if (_finder == null) {
            _finder = (MyBlogFinder) PortletBeanLocatorUtil.locate(com.arman.csb.modules.service.ClpSerializer.getServletContextName(),
                    MyBlogFinder.class.getName());

            ReferenceRegistry.registerReference(MyBlogFinderUtil.class,
                "_finder");
        }

        return _finder;
    }

    public void setFinder(MyBlogFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(MyBlogFinderUtil.class, "_finder");
    }
}
