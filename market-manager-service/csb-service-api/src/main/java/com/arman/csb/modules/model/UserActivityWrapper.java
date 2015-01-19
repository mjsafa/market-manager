package com.arman.csb.modules.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserActivity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserActivity
 * @generated
 */
public class UserActivityWrapper implements UserActivity,
    ModelWrapper<UserActivity> {
    private UserActivity _userActivity;

    public UserActivityWrapper(UserActivity userActivity) {
        _userActivity = userActivity;
    }

    @Override
    public Class<?> getModelClass() {
        return UserActivity.class;
    }

    @Override
    public String getModelClassName() {
        return UserActivity.class.getName();
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
        attributes.put("entity", getEntity());
        attributes.put("action", getAction());
        attributes.put("importance", getImportance());
        attributes.put("data", getData());

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

        String entity = (String) attributes.get("entity");

        if (entity != null) {
            setEntity(entity);
        }

        Short action = (Short) attributes.get("action");

        if (action != null) {
            setAction(action);
        }

        Short importance = (Short) attributes.get("importance");

        if (importance != null) {
            setImportance(importance);
        }

        String data = (String) attributes.get("data");

        if (data != null) {
            setData(data);
        }
    }

    /**
    * Returns the primary key of this user activity.
    *
    * @return the primary key of this user activity
    */
    @Override
    public long getPrimaryKey() {
        return _userActivity.getPrimaryKey();
    }

    /**
    * Sets the primary key of this user activity.
    *
    * @param primaryKey the primary key of this user activity
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _userActivity.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this user activity.
    *
    * @return the uuid of this user activity
    */
    @Override
    public java.lang.String getUuid() {
        return _userActivity.getUuid();
    }

    /**
    * Sets the uuid of this user activity.
    *
    * @param uuid the uuid of this user activity
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _userActivity.setUuid(uuid);
    }

    /**
    * Returns the ID of this user activity.
    *
    * @return the ID of this user activity
    */
    @Override
    public long getId() {
        return _userActivity.getId();
    }

    /**
    * Sets the ID of this user activity.
    *
    * @param id the ID of this user activity
    */
    @Override
    public void setId(long id) {
        _userActivity.setId(id);
    }

    /**
    * Returns the group ID of this user activity.
    *
    * @return the group ID of this user activity
    */
    @Override
    public long getGroupId() {
        return _userActivity.getGroupId();
    }

    /**
    * Sets the group ID of this user activity.
    *
    * @param groupId the group ID of this user activity
    */
    @Override
    public void setGroupId(long groupId) {
        _userActivity.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this user activity.
    *
    * @return the company ID of this user activity
    */
    @Override
    public long getCompanyId() {
        return _userActivity.getCompanyId();
    }

    /**
    * Sets the company ID of this user activity.
    *
    * @param companyId the company ID of this user activity
    */
    @Override
    public void setCompanyId(long companyId) {
        _userActivity.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this user activity.
    *
    * @return the user ID of this user activity
    */
    @Override
    public long getUserId() {
        return _userActivity.getUserId();
    }

    /**
    * Sets the user ID of this user activity.
    *
    * @param userId the user ID of this user activity
    */
    @Override
    public void setUserId(long userId) {
        _userActivity.setUserId(userId);
    }

    /**
    * Returns the user uuid of this user activity.
    *
    * @return the user uuid of this user activity
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _userActivity.getUserUuid();
    }

    /**
    * Sets the user uuid of this user activity.
    *
    * @param userUuid the user uuid of this user activity
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _userActivity.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this user activity.
    *
    * @return the user name of this user activity
    */
    @Override
    public java.lang.String getUserName() {
        return _userActivity.getUserName();
    }

    /**
    * Sets the user name of this user activity.
    *
    * @param userName the user name of this user activity
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _userActivity.setUserName(userName);
    }

    /**
    * Returns the create date of this user activity.
    *
    * @return the create date of this user activity
    */
    @Override
    public java.util.Date getCreateDate() {
        return _userActivity.getCreateDate();
    }

    /**
    * Sets the create date of this user activity.
    *
    * @param createDate the create date of this user activity
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _userActivity.setCreateDate(createDate);
    }

    /**
    * Returns the entity of this user activity.
    *
    * @return the entity of this user activity
    */
    @Override
    public java.lang.String getEntity() {
        return _userActivity.getEntity();
    }

    /**
    * Sets the entity of this user activity.
    *
    * @param entity the entity of this user activity
    */
    @Override
    public void setEntity(java.lang.String entity) {
        _userActivity.setEntity(entity);
    }

    /**
    * Returns the action of this user activity.
    *
    * @return the action of this user activity
    */
    @Override
    public java.lang.Short getAction() {
        return _userActivity.getAction();
    }

    /**
    * Sets the action of this user activity.
    *
    * @param action the action of this user activity
    */
    @Override
    public void setAction(java.lang.Short action) {
        _userActivity.setAction(action);
    }

    /**
    * Returns the importance of this user activity.
    *
    * @return the importance of this user activity
    */
    @Override
    public java.lang.Short getImportance() {
        return _userActivity.getImportance();
    }

    /**
    * Sets the importance of this user activity.
    *
    * @param importance the importance of this user activity
    */
    @Override
    public void setImportance(java.lang.Short importance) {
        _userActivity.setImportance(importance);
    }

    /**
    * Returns the data of this user activity.
    *
    * @return the data of this user activity
    */
    @Override
    public java.lang.String getData() {
        return _userActivity.getData();
    }

    /**
    * Sets the data of this user activity.
    *
    * @param data the data of this user activity
    */
    @Override
    public void setData(java.lang.String data) {
        _userActivity.setData(data);
    }

    @Override
    public boolean isNew() {
        return _userActivity.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _userActivity.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _userActivity.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _userActivity.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _userActivity.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _userActivity.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _userActivity.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _userActivity.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _userActivity.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _userActivity.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _userActivity.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new UserActivityWrapper((UserActivity) _userActivity.clone());
    }

    @Override
    public int compareTo(UserActivity userActivity) {
        return _userActivity.compareTo(userActivity);
    }

    @Override
    public int hashCode() {
        return _userActivity.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<UserActivity> toCacheModel() {
        return _userActivity.toCacheModel();
    }

    @Override
    public UserActivity toEscapedModel() {
        return new UserActivityWrapper(_userActivity.toEscapedModel());
    }

    @Override
    public UserActivity toUnescapedModel() {
        return new UserActivityWrapper(_userActivity.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _userActivity.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _userActivity.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _userActivity.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof UserActivityWrapper)) {
            return false;
        }

        UserActivityWrapper userActivityWrapper = (UserActivityWrapper) obj;

        if (Validator.equals(_userActivity, userActivityWrapper._userActivity)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public UserActivity getWrappedUserActivity() {
        return _userActivity;
    }

    @Override
    public UserActivity getWrappedModel() {
        return _userActivity;
    }

    @Override
    public void resetOriginalValues() {
        _userActivity.resetOriginalValues();
    }
}
