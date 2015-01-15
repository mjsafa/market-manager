package com.arman.csb.modules.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.arman.csb.modules.service.http.PaymentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.http.PaymentServiceSoap
 * @generated
 */
public class PaymentSoap implements Serializable {
    private String _uuid;
    private long _id;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private Date _createDate;
    private Date _modifiedDate;
    private String _description;
    private String _card;
    private long _amount;
    private int _status;
    private Date _paymentDate;
    private long _customerId;
    private long _factorId;

    public PaymentSoap() {
    }

    public static PaymentSoap toSoapModel(Payment model) {
        PaymentSoap soapModel = new PaymentSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setId(model.getId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setDescription(model.getDescription());
        soapModel.setCard(model.getCard());
        soapModel.setAmount(model.getAmount());
        soapModel.setStatus(model.getStatus());
        soapModel.setPaymentDate(model.getPaymentDate());
        soapModel.setCustomerId(model.getCustomerId());
        soapModel.setFactorId(model.getFactorId());

        return soapModel;
    }

    public static PaymentSoap[] toSoapModels(Payment[] models) {
        PaymentSoap[] soapModels = new PaymentSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PaymentSoap[][] toSoapModels(Payment[][] models) {
        PaymentSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PaymentSoap[models.length][models[0].length];
        } else {
            soapModels = new PaymentSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PaymentSoap[] toSoapModels(List<Payment> models) {
        List<PaymentSoap> soapModels = new ArrayList<PaymentSoap>(models.size());

        for (Payment model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PaymentSoap[soapModels.size()]);
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

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getCard() {
        return _card;
    }

    public void setCard(String card) {
        _card = card;
    }

    public long getAmount() {
        return _amount;
    }

    public void setAmount(long amount) {
        _amount = amount;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public Date getPaymentDate() {
        return _paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        _paymentDate = paymentDate;
    }

    public long getCustomerId() {
        return _customerId;
    }

    public void setCustomerId(long customerId) {
        _customerId = customerId;
    }

    public long getFactorId() {
        return _factorId;
    }

    public void setFactorId(long factorId) {
        _factorId = factorId;
    }
}
