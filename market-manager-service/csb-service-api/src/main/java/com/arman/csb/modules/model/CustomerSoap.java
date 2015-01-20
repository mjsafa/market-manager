package com.arman.csb.modules.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.arman.csb.modules.service.http.CustomerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.http.CustomerServiceSoap
 * @generated
 */
public class CustomerSoap implements Serializable {
    private String _uuid;
    private long _id;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _firstName;
    private String _lastName;
    private String _mobile;
    private String _nationalCode;
    private String _email;
    private String _card;
    private long _score;
    private int _status;
    private long _customerUserId;
    private long _mentorCustomerId;

    public CustomerSoap() {
    }

    public static CustomerSoap toSoapModel(Customer model) {
        CustomerSoap soapModel = new CustomerSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setId(model.getId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setFirstName(model.getFirstName());
        soapModel.setLastName(model.getLastName());
        soapModel.setMobile(model.getMobile());
        soapModel.setNationalCode(model.getNationalCode());
        soapModel.setEmail(model.getEmail());
        soapModel.setCard(model.getCard());
        soapModel.setScore(model.getScore());
        soapModel.setStatus(model.getStatus());
        soapModel.setCustomerUserId(model.getCustomerUserId());
        soapModel.setMentorCustomerId(model.getMentorCustomerId());

        return soapModel;
    }

    public static CustomerSoap[] toSoapModels(Customer[] models) {
        CustomerSoap[] soapModels = new CustomerSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CustomerSoap[][] toSoapModels(Customer[][] models) {
        CustomerSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CustomerSoap[models.length][models[0].length];
        } else {
            soapModels = new CustomerSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CustomerSoap[] toSoapModels(List<Customer> models) {
        List<CustomerSoap> soapModels = new ArrayList<CustomerSoap>(models.size());

        for (Customer model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CustomerSoap[soapModels.size()]);
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

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public String getMobile() {
        return _mobile;
    }

    public void setMobile(String mobile) {
        _mobile = mobile;
    }

    public String getNationalCode() {
        return _nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        _nationalCode = nationalCode;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getCard() {
        return _card;
    }

    public void setCard(String card) {
        _card = card;
    }

    public long getScore() {
        return _score;
    }

    public void setScore(long score) {
        _score = score;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public long getCustomerUserId() {
        return _customerUserId;
    }

    public void setCustomerUserId(long customerUserId) {
        _customerUserId = customerUserId;
    }

    public long getMentorCustomerId() {
        return _mentorCustomerId;
    }

    public void setMentorCustomerId(long mentorCustomerId) {
        _mentorCustomerId = mentorCustomerId;
    }
}
