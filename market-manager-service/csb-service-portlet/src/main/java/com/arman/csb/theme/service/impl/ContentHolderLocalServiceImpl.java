package com.arman.csb.theme.service.impl;

import com.arman.csb.theme.model.ContentHolder;
import com.arman.csb.theme.service.base.ContentHolderLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the content holder local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.theme.service.ContentHolderLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.theme.service.base.ContentHolderLocalServiceBaseImpl
 * @see com.arman.csb.theme.service.ContentHolderLocalServiceUtil
 */
public class ContentHolderLocalServiceImpl
        extends ContentHolderLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.theme.service.ContentHolderLocalServiceUtil} to access the content holder local service.
     */

    public List<ContentHolder> findByNameAndCompany(String name, long companyId) throws SystemException {
        return contentHolderPersistence.findByCompanyIdAndName(companyId, name);
    }

}
