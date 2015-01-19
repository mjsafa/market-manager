package com.arman.csb.modules.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.arman.csb.modules.service.http.UserActivityServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.http.UserActivityServiceSoap
 * @generated
 */
public class UserActivitySoap implements Serializable {
    private String _uuid;
    private long _id;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private String _entity;
    private Short _action;
    private Short _importance;
    private String _data;

    public UserActivitySoap() {
    }

    public static UserActivitySoap toSoapModel(UserActivity model) {
        UserActivitySoap soapModel = new UserActivitySoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setId(model.getId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setEntity(model.getEntity());
        soapModel.setAction(model.getAction());
        soapModel.setImportance(model.getImportance());
        soapModel.setData(model.getData());

        return soapModel;
    }

    public static UserActivitySoap[] toSoapModels(UserActivity[] models) {
        UserActivitySoap[] soapModels = new UserActivitySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static UserActivitySoap[][] toSoapModels(UserActivity[][] models) {
        UserActivitySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new UserActivitySoap[models.length][models[0].length];
        } else {
            soapModels = new UserActivitySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static UserActivitySoap[] toSoapModels(List<UserActivity> models) {
        List<UserActivitySoap> soapModels = new ArrayList<UserActivitySoap>(models.size());

        for (UserActivity model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new UserActivitySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public String getEntity() {
        return _entity;
    }

    public void setEntity(String entity) {
        _entity = entity;
    }

    public Short getAction() {
        return _action;
    }

    public void setAction(Short action) {
        _action = action;
    }

    public Short getImportance() {
        return _importance;
    }

    public void setImportance(Short importance) {
        _importance = importance;
    }

    public String getData() {
        return _data;
    }

    public void setData(String data) {
        _data = data;
    }
}
