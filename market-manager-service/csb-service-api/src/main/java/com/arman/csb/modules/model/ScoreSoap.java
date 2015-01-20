package com.arman.csb.modules.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.arman.csb.modules.service.http.ScoreServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.http.ScoreServiceSoap
 * @generated
 */
public class ScoreSoap implements Serializable {
    private String _uuid;
    private long _id;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _value;
    private long _customerId;
    private long _originCustomerId;
    private int _type;

    public ScoreSoap() {
    }

    public static ScoreSoap toSoapModel(Score model) {
        ScoreSoap soapModel = new ScoreSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setId(model.getId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setValue(model.getValue());
        soapModel.setCustomerId(model.getCustomerId());
        soapModel.setOriginCustomerId(model.getOriginCustomerId());
        soapModel.setType(model.getType());

        return soapModel;
    }

    public static ScoreSoap[] toSoapModels(Score[] models) {
        ScoreSoap[] soapModels = new ScoreSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ScoreSoap[][] toSoapModels(Score[][] models) {
        ScoreSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ScoreSoap[models.length][models[0].length];
        } else {
            soapModels = new ScoreSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ScoreSoap[] toSoapModels(List<Score> models) {
        List<ScoreSoap> soapModels = new ArrayList<ScoreSoap>(models.size());

        for (Score model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ScoreSoap[soapModels.size()]);
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

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public long getValue() {
        return _value;
    }

    public void setValue(long value) {
        _value = value;
    }

    public long getCustomerId() {
        return _customerId;
    }

    public void setCustomerId(long customerId) {
        _customerId = customerId;
    }

    public long getOriginCustomerId() {
        return _originCustomerId;
    }

    public void setOriginCustomerId(long originCustomerId) {
        _originCustomerId = originCustomerId;
    }

    public int getType() {
        return _type;
    }

    public void setType(int type) {
        _type = type;
    }
}
