package com.arman.csb.modules.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.arman.csb.modules.service.http.InvoiceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.http.InvoiceServiceSoap
 * @generated
 */
public class InvoiceSoap implements Serializable {
    private String _uuid;
    private long _id;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _customerId;
    private String _address;
    private String _telephone;
    private String _mobile;
    private Short _typeOfDelivery;

    public InvoiceSoap() {
    }

    public static InvoiceSoap toSoapModel(Invoice model) {
        InvoiceSoap soapModel = new InvoiceSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setId(model.getId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setCustomerId(model.getCustomerId());
        soapModel.setAddress(model.getAddress());
        soapModel.setTelephone(model.getTelephone());
        soapModel.setMobile(model.getMobile());
        soapModel.setTypeOfDelivery(model.getTypeOfDelivery());

        return soapModel;
    }

    public static InvoiceSoap[] toSoapModels(Invoice[] models) {
        InvoiceSoap[] soapModels = new InvoiceSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static InvoiceSoap[][] toSoapModels(Invoice[][] models) {
        InvoiceSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new InvoiceSoap[models.length][models[0].length];
        } else {
            soapModels = new InvoiceSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static InvoiceSoap[] toSoapModels(List<Invoice> models) {
        List<InvoiceSoap> soapModels = new ArrayList<InvoiceSoap>(models.size());

        for (Invoice model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new InvoiceSoap[soapModels.size()]);
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

    public long getCustomerId() {
        return _customerId;
    }

    public void setCustomerId(long customerId) {
        _customerId = customerId;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public String getTelephone() {
        return _telephone;
    }

    public void setTelephone(String telephone) {
        _telephone = telephone;
    }

    public String getMobile() {
        return _mobile;
    }

    public void setMobile(String mobile) {
        _mobile = mobile;
    }

    public Short getTypeOfDelivery() {
        return _typeOfDelivery;
    }

    public void setTypeOfDelivery(Short typeOfDelivery) {
        _typeOfDelivery = typeOfDelivery;
    }
}
