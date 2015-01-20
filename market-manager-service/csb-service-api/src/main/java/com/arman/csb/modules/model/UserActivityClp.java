package com.arman.csb.modules.model;

import com.arman.csb.modules.service.ClpSerializer;
import com.arman.csb.modules.service.UserActivityLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class UserActivityClp extends BaseModelImpl<UserActivity>
    implements UserActivity {
    private String _uuid;
    private long _id;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private String _entity;
    private Short _action;
    private Short _importance;
    private String _data;
    private BaseModel<?> _userActivityRemoteModel;

    public UserActivityClp() {
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
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_userActivityRemoteModel != null) {
            try {
                Class<?> clazz = _userActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_userActivityRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_userActivityRemoteModel != null) {
            try {
                Class<?> clazz = _userActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_userActivityRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_userActivityRemoteModel != null) {
            try {
                Class<?> clazz = _userActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_userActivityRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_userActivityRemoteModel != null) {
            try {
                Class<?> clazz = _userActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_userActivityRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_userActivityRemoteModel != null) {
            try {
                Class<?> clazz = _userActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_userActivityRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_userActivityRemoteModel != null) {
            try {
                Class<?> clazz = _userActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_userActivityRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_userActivityRemoteModel != null) {
            try {
                Class<?> clazz = _userActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_userActivityRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEntity() {
        return _entity;
    }

    @Override
    public void setEntity(String entity) {
        _entity = entity;

        if (_userActivityRemoteModel != null) {
            try {
                Class<?> clazz = _userActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setEntity", String.class);

                method.invoke(_userActivityRemoteModel, entity);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Short getAction() {
        return _action;
    }

    @Override
    public void setAction(Short action) {
        _action = action;

        if (_userActivityRemoteModel != null) {
            try {
                Class<?> clazz = _userActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setAction", Short.class);

                method.invoke(_userActivityRemoteModel, action);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Short getImportance() {
        return _importance;
    }

    @Override
    public void setImportance(Short importance) {
        _importance = importance;

        if (_userActivityRemoteModel != null) {
            try {
                Class<?> clazz = _userActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setImportance", Short.class);

                method.invoke(_userActivityRemoteModel, importance);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getData() {
        return _data;
    }

    @Override
    public void setData(String data) {
        _data = data;

        if (_userActivityRemoteModel != null) {
            try {
                Class<?> clazz = _userActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setData", String.class);

                method.invoke(_userActivityRemoteModel, data);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getUserActivityRemoteModel() {
        return _userActivityRemoteModel;
    }

    public void setUserActivityRemoteModel(BaseModel<?> userActivityRemoteModel) {
        _userActivityRemoteModel = userActivityRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _userActivityRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_userActivityRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            UserActivityLocalServiceUtil.addUserActivity(this);
        } else {
            UserActivityLocalServiceUtil.updateUserActivity(this);
        }
    }

    @Override
    public UserActivity toEscapedModel() {
        return (UserActivity) ProxyUtil.newProxyInstance(UserActivity.class.getClassLoader(),
            new Class[] { UserActivity.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        UserActivityClp clone = new UserActivityClp();

        clone.setUuid(getUuid());
        clone.setId(getId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setEntity(getEntity());
        clone.setAction(getAction());
        clone.setImportance(getImportance());
        clone.setData(getData());

        return clone;
    }

    @Override
    public int compareTo(UserActivity userActivity) {
        long primaryKey = userActivity.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof UserActivityClp)) {
            return false;
        }

        UserActivityClp userActivity = (UserActivityClp) obj;

        long primaryKey = userActivity.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", id=");
        sb.append(getId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", entity=");
        sb.append(getEntity());
        sb.append(", action=");
        sb.append(getAction());
        sb.append(", importance=");
        sb.append(getImportance());
        sb.append(", data=");
        sb.append(getData());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(37);

        sb.append("<model><model-name>");
        sb.append("com.arman.csb.modules.model.UserActivity");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>entity</column-name><column-value><![CDATA[");
        sb.append(getEntity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>action</column-name><column-value><![CDATA[");
        sb.append(getAction());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>importance</column-name><column-value><![CDATA[");
        sb.append(getImportance());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>data</column-name><column-value><![CDATA[");
        sb.append(getData());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
