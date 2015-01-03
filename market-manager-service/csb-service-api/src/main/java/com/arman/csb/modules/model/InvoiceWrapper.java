package com.arman.csb.modules.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Invoice}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Invoice
 * @generated
 */
public class InvoiceWrapper implements Invoice, ModelWrapper<Invoice> {
    private Invoice _invoice;

    public InvoiceWrapper(Invoice invoice) {
        _invoice = invoice;
    }

    @Override
    public Class<?> getModelClass() {
        return Invoice.class;
    }

    @Override
    public String getModelClassName() {
        return Invoice.class.getName();
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
        attributes.put("customerId", getCustomerId());
        attributes.put("address", getAddress());
        attributes.put("telephone", getTelephone());
        attributes.put("mobile", getMobile());
        attributes.put("typeOfDelivery", getTypeOfDelivery());

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

        Long customerId = (Long) attributes.get("customerId");

        if (customerId != null) {
            setCustomerId(customerId);
        }

        String address = (String) attributes.get("address");

        if (address != null) {
            setAddress(address);
        }

        String telephone = (String) attributes.get("telephone");

        if (telephone != null) {
            setTelephone(telephone);
        }

        String mobile = (String) attributes.get("mobile");

        if (mobile != null) {
            setMobile(mobile);
        }

        Short typeOfDelivery = (Short) attributes.get("typeOfDelivery");

        if (typeOfDelivery != null) {
            setTypeOfDelivery(typeOfDelivery);
        }
    }

    /**
    * Returns the primary key of this invoice.
    *
    * @return the primary key of this invoice
    */
    @Override
    public long getPrimaryKey() {
        return _invoice.getPrimaryKey();
    }

    /**
    * Sets the primary key of this invoice.
    *
    * @param primaryKey the primary key of this invoice
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _invoice.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this invoice.
    *
    * @return the uuid of this invoice
    */
    @Override
    public java.lang.String getUuid() {
        return _invoice.getUuid();
    }

    /**
    * Sets the uuid of this invoice.
    *
    * @param uuid the uuid of this invoice
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _invoice.setUuid(uuid);
    }

    /**
    * Returns the ID of this invoice.
    *
    * @return the ID of this invoice
    */
    @Override
    public long getId() {
        return _invoice.getId();
    }

    /**
    * Sets the ID of this invoice.
    *
    * @param id the ID of this invoice
    */
    @Override
    public void setId(long id) {
        _invoice.setId(id);
    }

    /**
    * Returns the group ID of this invoice.
    *
    * @return the group ID of this invoice
    */
    @Override
    public long getGroupId() {
        return _invoice.getGroupId();
    }

    /**
    * Sets the group ID of this invoice.
    *
    * @param groupId the group ID of this invoice
    */
    @Override
    public void setGroupId(long groupId) {
        _invoice.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this invoice.
    *
    * @return the company ID of this invoice
    */
    @Override
    public long getCompanyId() {
        return _invoice.getCompanyId();
    }

    /**
    * Sets the company ID of this invoice.
    *
    * @param companyId the company ID of this invoice
    */
    @Override
    public void setCompanyId(long companyId) {
        _invoice.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this invoice.
    *
    * @return the user ID of this invoice
    */
    @Override
    public long getUserId() {
        return _invoice.getUserId();
    }

    /**
    * Sets the user ID of this invoice.
    *
    * @param userId the user ID of this invoice
    */
    @Override
    public void setUserId(long userId) {
        _invoice.setUserId(userId);
    }

    /**
    * Returns the user uuid of this invoice.
    *
    * @return the user uuid of this invoice
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _invoice.getUserUuid();
    }

    /**
    * Sets the user uuid of this invoice.
    *
    * @param userUuid the user uuid of this invoice
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _invoice.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this invoice.
    *
    * @return the user name of this invoice
    */
    @Override
    public java.lang.String getUserName() {
        return _invoice.getUserName();
    }

    /**
    * Sets the user name of this invoice.
    *
    * @param userName the user name of this invoice
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _invoice.setUserName(userName);
    }

    /**
    * Returns the create date of this invoice.
    *
    * @return the create date of this invoice
    */
    @Override
    public java.util.Date getCreateDate() {
        return _invoice.getCreateDate();
    }

    /**
    * Sets the create date of this invoice.
    *
    * @param createDate the create date of this invoice
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _invoice.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this invoice.
    *
    * @return the modified date of this invoice
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _invoice.getModifiedDate();
    }

    /**
    * Sets the modified date of this invoice.
    *
    * @param modifiedDate the modified date of this invoice
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _invoice.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the customer ID of this invoice.
    *
    * @return the customer ID of this invoice
    */
    @Override
    public long getCustomerId() {
        return _invoice.getCustomerId();
    }

    /**
    * Sets the customer ID of this invoice.
    *
    * @param customerId the customer ID of this invoice
    */
    @Override
    public void setCustomerId(long customerId) {
        _invoice.setCustomerId(customerId);
    }

    /**
    * Returns the address of this invoice.
    *
    * @return the address of this invoice
    */
    @Override
    public java.lang.String getAddress() {
        return _invoice.getAddress();
    }

    /**
    * Sets the address of this invoice.
    *
    * @param address the address of this invoice
    */
    @Override
    public void setAddress(java.lang.String address) {
        _invoice.setAddress(address);
    }

    /**
    * Returns the telephone of this invoice.
    *
    * @return the telephone of this invoice
    */
    @Override
    public java.lang.String getTelephone() {
        return _invoice.getTelephone();
    }

    /**
    * Sets the telephone of this invoice.
    *
    * @param telephone the telephone of this invoice
    */
    @Override
    public void setTelephone(java.lang.String telephone) {
        _invoice.setTelephone(telephone);
    }

    /**
    * Returns the mobile of this invoice.
    *
    * @return the mobile of this invoice
    */
    @Override
    public java.lang.String getMobile() {
        return _invoice.getMobile();
    }

    /**
    * Sets the mobile of this invoice.
    *
    * @param mobile the mobile of this invoice
    */
    @Override
    public void setMobile(java.lang.String mobile) {
        _invoice.setMobile(mobile);
    }

    /**
    * Returns the type of delivery of this invoice.
    *
    * @return the type of delivery of this invoice
    */
    @Override
    public java.lang.Short getTypeOfDelivery() {
        return _invoice.getTypeOfDelivery();
    }

    /**
    * Sets the type of delivery of this invoice.
    *
    * @param typeOfDelivery the type of delivery of this invoice
    */
    @Override
    public void setTypeOfDelivery(java.lang.Short typeOfDelivery) {
        _invoice.setTypeOfDelivery(typeOfDelivery);
    }

    @Override
    public boolean isNew() {
        return _invoice.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _invoice.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _invoice.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _invoice.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _invoice.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _invoice.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _invoice.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _invoice.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _invoice.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _invoice.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _invoice.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new InvoiceWrapper((Invoice) _invoice.clone());
    }

    @Override
    public int compareTo(Invoice invoice) {
        return _invoice.compareTo(invoice);
    }

    @Override
    public int hashCode() {
        return _invoice.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Invoice> toCacheModel() {
        return _invoice.toCacheModel();
    }

    @Override
    public Invoice toEscapedModel() {
        return new InvoiceWrapper(_invoice.toEscapedModel());
    }

    @Override
    public Invoice toUnescapedModel() {
        return new InvoiceWrapper(_invoice.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _invoice.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _invoice.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _invoice.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof InvoiceWrapper)) {
            return false;
        }

        InvoiceWrapper invoiceWrapper = (InvoiceWrapper) obj;

        if (Validator.equals(_invoice, invoiceWrapper._invoice)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _invoice.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Invoice getWrappedInvoice() {
        return _invoice;
    }

    @Override
    public Invoice getWrappedModel() {
        return _invoice;
    }

    @Override
    public void resetOriginalValues() {
        _invoice.resetOriginalValues();
    }
}
