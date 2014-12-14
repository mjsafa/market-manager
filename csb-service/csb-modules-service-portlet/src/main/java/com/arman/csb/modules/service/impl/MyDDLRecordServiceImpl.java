package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.service.base.MyDDLRecordServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.util.OrderByComparatorFactory;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetServiceUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the my d d l record remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.MyDDLRecordService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.MyDDLRecordServiceBaseImpl
 * @see com.arman.csb.modules.service.MyDDLRecordServiceUtil
 */
public class MyDDLRecordServiceImpl extends MyDDLRecordServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.MyDDLRecordServiceUtil} to access the my d d l record remote service.
     */

    public DDLRecord addRecord(String siteName, String formName, Map<String, Serializable> fieldsMap, ServiceContext serviceContext) throws PortalException, SystemException {

        try {
            Group group = GroupLocalServiceUtil.getGroup(serviceContext.getCompanyId(), siteName);

            List<DDLRecordSet> ddlRecordSets =  (List<DDLRecordSet>)DDLRecordSetLocalServiceUtil.search(serviceContext.getCompanyId(), group.getGroupId(), formName, null, 0, true, 0, 100, null);
            if(!ddlRecordSets.isEmpty()){
                DDLRecordSet recordSet = ddlRecordSets.get(0);
                return ddlRecordLocalService.addRecord(serviceContext.getUserId(), group.getGroupId(), recordSet.getRecordSetId(), 0 , fieldsMap, serviceContext);
            }else {
                return null;
            }

        } catch (PortalException e) {
            throw e;
        } catch (SystemException e) {
            throw e;
        }
    }
}
