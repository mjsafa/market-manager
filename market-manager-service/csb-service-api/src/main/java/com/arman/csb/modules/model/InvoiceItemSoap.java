package com.arman.csb.modules.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.arman.csb.modules.service.http.InvoiceItemServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.http.InvoiceItemServiceSoap
 * @generated
 */
public class InvoiceItemSoap implements Serializable {
    private String _uuid;
    private long _id;
    private Date _createDate;
    private Date _modifiedDate;
    private long _invoiceId;
    private String _productCode;
    private String _productName;
    private Short _number;
    private long _basePrice;

    public InvoiceItemSoap() {
    }

    public static InvoiceItemSoap toSoapModel(InvoiceItem model) {
        InvoiceItemSoap soapModel = new InvoiceItemSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setId(model.getId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setInvoiceId(model.getInvoiceId());
        soapModel.setProductCode(model.getProductCode());
        soapModel.setProductName(model.getProductName());
        soapModel.setNumber(model.getNumber());
        soapModel.setBasePrice(model.getBasePrice());

        return soapModel;
    }

    public static InvoiceItemSoap[] toSoapModels(InvoiceItem[] models) {
        InvoiceItemSoap[] soapModels = new InvoiceItemSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static InvoiceItemSoap[][] toSoapModels(InvoiceItem[][] models) {
        InvoiceItemSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new InvoiceItemSoap[models.length][models[0].length];
        } else {
            soapModels = new InvoiceItemSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static InvoiceItemSoap[] toSoapModels(List<InvoiceItem> models) {
        List<InvoiceItemSoap> soapModels = new ArrayList<InvoiceItemSoap>(models.size());

        for (InvoiceItem model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new InvoiceItemSoap[soapModels.size()]);
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

    public long getInvoiceId() {
        return _invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        _invoiceId = invoiceId;
    }

    public String getProductCode() {
        return _productCode;
    }

    public void setProductCode(String productCode) {
        _productCode = productCode;
    }

    public String getProductName() {
        return _productName;
    }

    public void setProductName(String productName) {
        _productName = productName;
    }

    public Short getNumber() {
        return _number;
    }

    public void setNumber(Short number) {
        _number = number;
    }

    public long getBasePrice() {
        return _basePrice;
    }

    public void setBasePrice(long basePrice) {
        _basePrice = basePrice;
    }
}
