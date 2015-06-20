package com.arman.csb.modules.service.impl;

import com.arman.csb.constant.UserActivityConstant;
import com.arman.csb.constants.WorkflowConstants;
import com.arman.csb.modules.model.Instance;
import com.arman.csb.modules.model.impl.InstanceImpl;
import com.arman.csb.modules.service.InstanceLocalServiceUtil;
import com.arman.csb.modules.service.MyUserServiceUtil;
import com.arman.csb.modules.service.UserActivityLocalServiceUtil;
import com.arman.csb.modules.service.base.InstanceServiceBaseImpl;
import com.arman.csb.modules.util.RoleUtil;
import com.arman.csb.theme.model.Template;
import com.arman.csb.theme.service.TemplateLocalServiceUtil;
import com.arman.csb.util.MapUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.*;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.model.VirtualHost;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.*;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the instance remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.InstanceService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.InstanceServiceBaseImpl
 * @see com.arman.csb.modules.service.InstanceServiceUtil
 */
public class InstanceServiceImpl extends InstanceServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.InstanceServiceUtil} to access the instance remote service.
     */


    public JSONObject addInstance(Map<String, Object> instance, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId());

        User onlineUser = UserLocalServiceUtil.getUser(serviceContext.getUserId());

        Instance newInstance = InstanceLocalServiceUtil.createInstance(counterLocalService.increment(Instance.class.getName()));

        newInstance.setUserName(onlineUser.getFullName());
        newInstance.setUserId(onlineUser.getUserId());
        newInstance.setCompanyId(serviceContext.getCompanyId());
        newInstance.setGroupId(serviceContext.getScopeGroupId());
        newInstance.setStatus(WorkflowConstants.STATUS_ACTIVE);
        newInstance.setCreateDate(new Date());
        newInstance.setModifiedDate(new Date());

        newInstance = getInstanceData(newInstance, instance);

        Group group = GroupLocalServiceUtil.addGroup(onlineUser.getUserId(), 0, Group.class.getName(), 0, 0,
                newInstance.getName(), "", 1, true, 0, "/"+newInstance.getUrl(), true, true, serviceContext);
        group.setClassPK(group.getGroupId());
        GroupLocalServiceUtil.updateGroup(group);

        newInstance.setGroupId(group.getGroupId());

        GroupLocalServiceUtil.addUserGroup(newInstance.getSuperAdminId(), group.getGroupId());

        VirtualHost virtualHost = VirtualHostLocalServiceUtil.createVirtualHost(counterLocalService.increment(VirtualHost.class.getName()));
        virtualHost.setCompanyId(serviceContext.getCompanyId());
        virtualHost.setLayoutSetId(group.getPublicLayoutSet().getLayoutSetId());
        virtualHost.setHostname(newInstance.getUrl());
        VirtualHostLocalServiceUtil.addVirtualHost(virtualHost);

        ///// Adding Admin Layout /////
        Layout adminLayout = LayoutLocalServiceUtil.addLayout(onlineUser.getUserId(), group.getGroupId(), false, 0,
                "admin", "", "", "portlet", false, "/admin", serviceContext);
        adminLayout.setThemeId("csbfront_WAR_csbfronttheme");
        LayoutLocalServiceUtil.updateLayout(adminLayout);
        LayoutLocalServiceUtil.updateLookAndFeel(group.getGroupId(), false, adminLayout.getLayoutId(),
                "csbfront_WAR_csbfronttheme", "01", "", false);

        Template template = TemplateLocalServiceUtil.getTemplateByName("admin");
        ExpandoValueLocalServiceUtil.addValue(serviceContext.getCompanyId(), Layout.class.getName(),
                ExpandoTableConstants.DEFAULT_TABLE_NAME, "templateId",
                adminLayout.getPlid(), template.getId());


        ///// Adding Login Layout /////
        Layout loginLayout = LayoutLocalServiceUtil.addLayout(onlineUser.getUserId(), group.getGroupId(), false, 0,
                "login", "", "", "portlet", false, "/login", serviceContext);
        loginLayout.setThemeId("csbfront_WAR_csbfronttheme");
        LayoutLocalServiceUtil.updateLayout(loginLayout);
        LayoutLocalServiceUtil.updateLookAndFeel(group.getGroupId(), false, loginLayout.getLayoutId(),
                "csbfront_WAR_csbfronttheme", "01", "", false);

        template = TemplateLocalServiceUtil.getTemplateByName("login");
        ExpandoValueLocalServiceUtil.addValue(serviceContext.getCompanyId(), Layout.class.getName(),
                ExpandoTableConstants.DEFAULT_TABLE_NAME, "templateId",
                loginLayout.getPlid(), template.getId());


        InstanceLocalServiceUtil.addInstance(newInstance);

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_INSTANCE,
                UserActivityConstant.ACTION_ADD, UserActivityConstant.IMPORTANCE_HIGH,
                getUserActivityJSONObject(newInstance, serviceContext).toString(), serviceContext);

        return getJSONObject(newInstance,  serviceContext);
    }

    public JSONObject updateInstance(Map<String, Object> instance, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId());

        long instanceId = MapUtil.getLong(instance, "id");
        Instance updateInstance = InstanceLocalServiceUtil.getInstance(instanceId);

        long oldSuperAdminId = updateInstance.getSuperAdminId();

        updateInstance.setModifiedDate(new Date());
        updateInstance = getInstanceData(updateInstance, instance);

        Group group = GroupLocalServiceUtil.getGroup(updateInstance.getGroupId());
        group.setName(updateInstance.getName());

        GroupLocalServiceUtil.updateGroup(group);

        GroupLocalServiceUtil.deleteUserGroup(oldSuperAdminId, group.getGroupId());
        GroupLocalServiceUtil.addUserGroup(updateInstance.getSuperAdminId(), group.getGroupId());

        VirtualHost virtualHost = VirtualHostLocalServiceUtil.getVirtualHost(serviceContext.getCompanyId(),
                group.getPublicLayoutSet().getLayoutSetId());
        virtualHost.setHostname(updateInstance.getUrl());

        VirtualHostLocalServiceUtil.updateVirtualHost(virtualHost);

        InstanceLocalServiceUtil.updateInstance(updateInstance);

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_INSTANCE,
                UserActivityConstant.ACTION_EDIT, UserActivityConstant.IMPORTANCE_HIGH,
                getUserActivityJSONObject(updateInstance, serviceContext).toString(), serviceContext);

        return getJSONObject(updateInstance, serviceContext);
    }

    public JSONObject updateInstanceStatus(long instanceId, int status, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId());

        Instance instance = InstanceLocalServiceUtil.getInstance(instanceId);
        int oldStatus = instance.getStatus();

        instance.setStatus(status);
        InstanceLocalServiceUtil.updateInstance(instance);

        JSONObject result = getJSONObject(instance, serviceContext);
        result.put("oldStatus", oldStatus);

        Group group = GroupLocalServiceUtil.getGroup(instance.getGroupId());
        group.setActive(!group.getActive());
        GroupLocalServiceUtil.updateGroup(group);

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_INSTANCE,
                UserActivityConstant.ACTION_CHANGE_STATUS, UserActivityConstant.IMPORTANCE_HIGH,
                result.toString(), serviceContext);

        return result;
    }

    public JSONObject getInstanceById(long instanceId, ServiceContext serviceContext) throws SystemException, PortalException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId());

        Instance instance = InstanceLocalServiceUtil.getInstance(instanceId);

        return getJSONObject(instance, serviceContext);
    }

    public JSONObject getInstanceByGroupId(long groupId, ServiceContext serviceContext) throws PortalException, SystemException {
        RoleUtil.checkAnyRoles(serviceContext.getUserId());

        Instance instance = instancePersistence.findByGroupId(groupId);

        return getJSONObject(instance, serviceContext);
    }

    public JSONArray search(String filter, int status, int start, int maxResult, ServiceContext serviceContext)
            throws PortalException, SystemException {
        JSONArray result = JSONFactoryUtil.createJSONArray();

        Session session = productPersistence.openSession();

        String sql = CustomSQLUtil.get("com.arman.csb.modules.service.Instance.search");
        sql = sql.replaceAll("##KEYWORD##", "%" + filter + "%");

        SQLQuery queryObject = session.createSQLQuery(sql);

        queryObject.addEntity(InstanceImpl.TABLE_NAME, InstanceImpl.class);
        queryObject.setFirstResult(start);
        queryObject.setMaxResults(maxResult);

        QueryPos qPos = QueryPos.getInstance(queryObject);
        if(-1 == status) {
            qPos.add(true);
        } else {
            qPos.add(false);
        }

        qPos.add(status);

        List<Instance> instances = queryObject.list();

        for (Instance instance : instances) {
            result.put(getJSONObject(instance, serviceContext));
        }

        return result;
    }

    private Instance getInstanceData(Instance instanceObject, Map<String, Object> instance) {
        instanceObject.setSuperAdminId(MapUtil.getLong(instance, "superAdminId"));
        instanceObject.setName(MapUtil.getString(instance, "name"));
        instanceObject.setUrl(MapUtil.getString(instance, "url"));
        instanceObject.setLogo(MapUtil.getString(instance, "logo"));

        return instanceObject;
    }

    private JSONObject getJSONObject(Instance instance, ServiceContext serviceContext) throws PortalException, SystemException {
        JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
        JSONObject result = JSONFactoryUtil.createJSONObject(jsonSerializer.serialize(instance));

        result.put("superAdmin", MyUserServiceUtil.getById(instance.getSuperAdminId(), serviceContext));

        return result;
    }

    private JSONObject getUserActivityJSONObject(Instance instance, ServiceContext serviceContext) throws PortalException, SystemException {
        JSONObject result = getJSONObject(instance, serviceContext);

        User superAdmin = UserLocalServiceUtil.getUser(instance.getSuperAdminId());

        result.put("superAdminName", superAdmin.getFullName());

        return result;
    }

}
