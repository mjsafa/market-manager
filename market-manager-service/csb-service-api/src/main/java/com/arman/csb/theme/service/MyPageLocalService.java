package com.arman.csb.theme.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for MyPage. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MyPageLocalServiceUtil
 * @see com.arman.csb.theme.service.base.MyPageLocalServiceBaseImpl
 * @see com.arman.csb.theme.service.impl.MyPageLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MyPageLocalService extends BaseLocalService,
    InvokableLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MyPageLocalServiceUtil} to access the my page local service. Add custom service methods to {@link com.arman.csb.theme.service.impl.MyPageLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public void editPageContent(long pageId, java.lang.String itemId,
        java.lang.String newContent);

    public java.util.Map<java.lang.String, java.lang.Object> renderPageHTML(
        long pageId, com.liferay.portal.theme.ThemeDisplay themeDisplay);

    public java.util.Map<java.lang.String, java.lang.Object> renderAdminHTML(
        long pageId);
}
