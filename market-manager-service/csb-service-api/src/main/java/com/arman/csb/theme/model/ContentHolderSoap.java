package com.arman.csb.theme.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.arman.csb.theme.service.http.ContentHolderServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.theme.service.http.ContentHolderServiceSoap
 * @generated
 */
public class ContentHolderSoap implements Serializable {
    private String _uuid;
    private long _id;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _head;
    private String _bottom;
    private String _htmlContent;

    public ContentHolderSoap() {
    }

    public static ContentHolderSoap toSoapModel(ContentHolder model) {
        ContentHolderSoap soapModel = new ContentHolderSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setId(model.getId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setHead(model.getHead());
        soapModel.setBottom(model.getBottom());
        soapModel.setHtmlContent(model.getHtmlContent());

        return soapModel;
    }

    public static ContentHolderSoap[] toSoapModels(ContentHolder[] models) {
        ContentHolderSoap[] soapModels = new ContentHolderSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ContentHolderSoap[][] toSoapModels(ContentHolder[][] models) {
        ContentHolderSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ContentHolderSoap[models.length][models[0].length];
        } else {
            soapModels = new ContentHolderSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ContentHolderSoap[] toSoapModels(List<ContentHolder> models) {
        List<ContentHolderSoap> soapModels = new ArrayList<ContentHolderSoap>(models.size());

        for (ContentHolder model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ContentHolderSoap[soapModels.size()]);
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

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getHead() {
        return _head;
    }

    public void setHead(String head) {
        _head = head;
    }

    public String getBottom() {
        return _bottom;
    }

    public void setBottom(String bottom) {
        _bottom = bottom;
    }

    public String getHtmlContent() {
        return _htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        _htmlContent = htmlContent;
    }
}
