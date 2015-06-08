package com.arman.csb.modules.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Instance}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Instance
 * @generated
 */
public class InstanceWrapper implements Instance, ModelWrapper<Instance> {
    private Instance _instance;

    public InstanceWrapper(Instance instance) {
        _instance = instance;
    }

    @Override
    public Class<?> getModelClass() {
        return Instance.class;
    }

    @Override
    public String getModelClassName() {
        return Instance.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("id", getId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("url", getUrl());
        attributes.put("superAdminId", getSuperAdminId());
        attributes.put("logo", getLogo());
        attributes.put("status", getStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        Long superAdminId = (Long) attributes.get("superAdminId");

        if (superAdminId != null) {
            setSuperAdminId(superAdminId);
        }

        String logo = (String) attributes.get("logo");

        if (logo != null) {
            setLogo(logo);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }
    }

    /**
    * Returns the primary key of this instance.
    *
    * @return the primary key of this instance
    */
    @Override
    public long getPrimaryKey() {
        return _instance.getPrimaryKey();
    }

    /**
    * Sets the primary key of this instance.
    *
    * @param primaryKey the primary key of this instance
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _instance.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this instance.
    *
    * @return the uuid of this instance
    */
    @Override
    public java.lang.String getUuid() {
        return _instance.getUuid();
    }

    /**
    * Sets the uuid of this instance.
    *
    * @param uuid the uuid of this instance
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _instance.setUuid(uuid);
    }

    /**
    * Returns the ID of this instance.
    *
    * @return the ID of this instance
    */
    @Override
    public long getId() {
        return _instance.getId();
    }

    /**
    * Sets the ID of this instance.
    *
    * @param id the ID of this instance
    */
    @Override
    public void setId(long id) {
        _instance.setId(id);
    }

    /**
    * Returns the group ID of this instance.
    *
    * @return the group ID of this instance
    */
    @Override
    public long getGroupId() {
        return _instance.getGroupId();
    }

    /**
    * Sets the group ID of this instance.
    *
    * @param groupId the group ID of this instance
    */
    @Override
    public void setGroupId(long groupId) {
        _instance.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this instance.
    *
    * @return the company ID of this instance
    */
    @Override
    public long getCompanyId() {
        return _instance.getCompanyId();
    }

    /**
    * Sets the company ID of this instance.
    *
    * @param companyId the company ID of this instance
    */
    @Override
    public void setCompanyId(long companyId) {
        _instance.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this instance.
    *
    * @return the user ID of this instance
    */
    @Override
    public long getUserId() {
        return _instance.getUserId();
    }

    /**
    * Sets the user ID of this instance.
    *
    * @param userId the user ID of this instance
    */
    @Override
    public void setUserId(long userId) {
        _instance.setUserId(userId);
    }

    /**
    * Returns the user uuid of this instance.
    *
    * @return the user uuid of this instance
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _instance.getUserUuid();
    }

    /**
    * Sets the user uuid of this instance.
    *
    * @param userUuid the user uuid of this instance
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _instance.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this instance.
    *
    * @return the user name of this instance
    */
    @Override
    public java.lang.String getUserName() {
        return _instance.getUserName();
    }

    /**
    * Sets the user name of this instance.
    *
    * @param userName the user name of this instance
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _instance.setUserName(userName);
    }

    /**
    * Returns the create date of this instance.
    *
    * @return the create date of this instance
    */
    @Override
    public java.util.Date getCreateDate() {
        return _instance.getCreateDate();
    }

    /**
    * Sets the create date of this instance.
    *
    * @param createDate the create date of this instance
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _instance.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this instance.
    *
    * @return the modified date of this instance
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _instance.getModifiedDate();
    }

    /**
    * Sets the modified date of this instance.
    *
    * @param modifiedDate the modified date of this instance
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _instance.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this instance.
    *
    * @return the name of this instance
    */
    @Override
    public java.lang.String getName() {
        return _instance.getName();
    }

    /**
    * Sets the name of this instance.
    *
    * @param name the name of this instance
    */
    @Override
    public void setName(java.lang.String name) {
        _instance.setName(name);
    }

    /**
    * Returns the url of this instance.
    *
    * @return the url of this instance
    */
    @Override
    public java.lang.String getUrl() {
        return _instance.getUrl();
    }

    /**
    * Sets the url of this instance.
    *
    * @param url the url of this instance
    */
    @Override
    public void setUrl(java.lang.String url) {
        _instance.setUrl(url);
    }

    /**
    * Returns the super admin ID of this instance.
    *
    * @return the super admin ID of this instance
    */
    @Override
    public long getSuperAdminId() {
        return _instance.getSuperAdminId();
    }

    /**
    * Sets the super admin ID of this instance.
    *
    * @param superAdminId the super admin ID of this instance
    */
    @Override
    public void setSuperAdminId(long superAdminId) {
        _instance.setSuperAdminId(superAdminId);
    }

    /**
    * Returns the logo of this instance.
    *
    * @return the logo of this instance
    */
    @Override
    public java.lang.String getLogo() {
        return _instance.getLogo();
    }

    /**
    * Sets the logo of this instance.
    *
    * @param logo the logo of this instance
    */
    @Override
    public void setLogo(java.lang.String logo) {
        _instance.setLogo(logo);
    }

    /**
    * Returns the status of this instance.
    *
    * @return the status of this instance
    */
    @Override
    public int getStatus() {
        return _instance.getStatus();
    }

    /**
    * Sets the status of this instance.
    *
    * @param status the status of this instance
    */
    @Override
    public void setStatus(int status) {
        _instance.setStatus(status);
    }

    @Override
    public boolean isNew() {
        return _instance.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _instance.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _instance.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _instance.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _instance.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _instance.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _instance.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _instance.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _instance.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _instance.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _instance.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new InstanceWrapper((Instance) _instance.clone());
    }

    @Override
    public int compareTo(Instance instance) {
        return _instance.compareTo(instance);
    }

    @Override
    public int hashCode() {
        return _instance.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Instance> toCacheModel() {
        return _instance.toCacheModel();
    }

    @Override
    public Instance toEscapedModel() {
        return new InstanceWrapper(_instance.toEscapedModel());
    }

    @Override
    public Instance toUnescapedModel() {
        return new InstanceWrapper(_instance.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _instance.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _instance.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _instance.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof InstanceWrapper)) {
            return false;
        }

        InstanceWrapper instanceWrapper = (InstanceWrapper) obj;

        if (Validator.equals(_instance, instanceWrapper._instance)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _instance.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Instance getWrappedInstance() {
        return _instance;
    }

    @Override
    public Instance getWrappedModel() {
        return _instance;
    }

    @Override
    public void resetOriginalValues() {
        _instance.resetOriginalValues();
    }
}
