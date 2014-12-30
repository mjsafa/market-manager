package com.arman.csb.theme.service.impl;

import com.arman.csb.theme.model.Template;
import com.arman.csb.theme.service.base.TemplateLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;

import java.util.List;

/**
 * The implementation of the template local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.theme.service.TemplateLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.theme.service.base.TemplateLocalServiceBaseImpl
 * @see com.arman.csb.theme.service.TemplateLocalServiceUtil
 */
public class TemplateLocalServiceImpl extends TemplateLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.theme.service.TemplateLocalServiceUtil} to access the template local service.
     */

    public Template createNewTemplate() throws SystemException, PortalException {
        return createTemplate(counterLocalService.increment(Template.class.getName()));
    }

    @Override
    public Template addTemplate(Template template) throws SystemException {

/*
        try {
            resourceLocalService.addResources(
                    template.getCompanyId(),
                    template.getGroupId(), template.getUserId(),
                    Template.class.getName(),
                    template.getPrimaryKey(), false,
                    true, true);

        } catch (PortalException e) {
            throw new SystemException(e);
        }
*/

        return super.addTemplate(template);
    }

    public List<Template> getTemplatesByCompany(long companyId) throws SystemException{
        return templatePersistence.findByCompanyId(companyId);
    }

}
