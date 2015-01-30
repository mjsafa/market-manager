package com.arman.csb.modules.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link InvoiceItem}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceItem
 * @generated
 */
public class InvoiceItemWrapper implements InvoiceItem,
    ModelWrapper<InvoiceItem> {
    private InvoiceItem _invoiceItem;

    public InvoiceItemWrapper(InvoiceItem invoiceItem) {
        _invoiceItem = invoiceItem;
    }

    @Override
    public Class<?> getModelClass() {
        return InvoiceItem.class;
    }

    @Override
    public String getModelClassName() {
        return InvoiceItem.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("id", getId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("invoiceId", getInvoiceId());
        attributes.put("productId", getProductId());
        attributes.put("number", getNumber());

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

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Long invoiceId = (Long) attributes.get("invoiceId");

        if (invoiceId != null) {
            setInvoiceId(invoiceId);
        }

        Long productId = (Long) attributes.get("productId");

        if (productId != null) {
            setProductId(productId);
        }

        Short number = (Short) attributes.get("number");

        if (number != null) {
            setNumber(number);
        }
    }

    /**
    * Returns the primary key of this invoice item.
    *
    * @return the primary key of this invoice item
    */
    @Override
    public long getPrimaryKey() {
        return _invoiceItem.getPrimaryKey();
    }

    /**
    * Sets the primary key of this invoice item.
    *
    * @param primaryKey the primary key of this invoice item
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _invoiceItem.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this invoice item.
    *
    * @return the uuid of this invoice item
    */
    @Override
    public java.lang.String getUuid() {
        return _invoiceItem.getUuid();
    }

    /**
    * Sets the uuid of this invoice item.
    *
    * @param uuid the uuid of this invoice item
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _invoiceItem.setUuid(uuid);
    }

    /**
    * Returns the ID of this invoice item.
    *
    * @return the ID of this invoice item
    */
    @Override
    public long getId() {
        return _invoiceItem.getId();
    }

    /**
    * Sets the ID of this invoice item.
    *
    * @param id the ID of this invoice item
    */
    @Override
    public void setId(long id) {
        _invoiceItem.setId(id);
    }

    /**
    * Returns the create date of this invoice item.
    *
    * @return the create date of this invoice item
    */
    @Override
    public java.util.Date getCreateDate() {
        return _invoiceItem.getCreateDate();
    }

    /**
    * Sets the create date of this invoice item.
    *
    * @param createDate the create date of this invoice item
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _invoiceItem.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this invoice item.
    *
    * @return the modified date of this invoice item
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _invoiceItem.getModifiedDate();
    }

    /**
    * Sets the modified date of this invoice item.
    *
    * @param modifiedDate the modified date of this invoice item
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _invoiceItem.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the invoice ID of this invoice item.
    *
    * @return the invoice ID of this invoice item
    */
    @Override
    public long getInvoiceId() {
        return _invoiceItem.getInvoiceId();
    }

    /**
    * Sets the invoice ID of this invoice item.
    *
    * @param invoiceId the invoice ID of this invoice item
    */
    @Override
    public void setInvoiceId(long invoiceId) {
        _invoiceItem.setInvoiceId(invoiceId);
    }

    /**
    * Returns the product ID of this invoice item.
    *
    * @return the product ID of this invoice item
    */
    @Override
    public long getProductId() {
        return _invoiceItem.getProductId();
    }

    /**
    * Sets the product ID of this invoice item.
    *
    * @param productId the product ID of this invoice item
    */
    @Override
    public void setProductId(long productId) {
        _invoiceItem.setProductId(productId);
    }

    /**
    * Returns the number of this invoice item.
    *
    * @return the number of this invoice item
    */
    @Override
    public java.lang.Short getNumber() {
        return _invoiceItem.getNumber();
    }

    /**
    * Sets the number of this invoice item.
    *
    * @param number the number of this invoice item
    */
    @Override
    public void setNumber(java.lang.Short number) {
        _invoiceItem.setNumber(number);
    }

    @Override
    public boolean isNew() {
        return _invoiceItem.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _invoiceItem.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _invoiceItem.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _invoiceItem.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _invoiceItem.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _invoiceItem.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _invoiceItem.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _invoiceItem.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _invoiceItem.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _invoiceItem.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _invoiceItem.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new InvoiceItemWrapper((InvoiceItem) _invoiceItem.clone());
    }

    @Override
    public int compareTo(InvoiceItem invoiceItem) {
        return _invoiceItem.compareTo(invoiceItem);
    }

    @Override
    public int hashCode() {
        return _invoiceItem.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<InvoiceItem> toCacheModel() {
        return _invoiceItem.toCacheModel();
    }

    @Override
    public InvoiceItem toEscapedModel() {
        return new InvoiceItemWrapper(_invoiceItem.toEscapedModel());
    }

    @Override
    public InvoiceItem toUnescapedModel() {
        return new InvoiceItemWrapper(_invoiceItem.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _invoiceItem.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _invoiceItem.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _invoiceItem.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof InvoiceItemWrapper)) {
            return false;
        }

        InvoiceItemWrapper invoiceItemWrapper = (InvoiceItemWrapper) obj;

        if (Validator.equals(_invoiceItem, invoiceItemWrapper._invoiceItem)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public InvoiceItem getWrappedInvoiceItem() {
        return _invoiceItem;
    }

    @Override
    public InvoiceItem getWrappedModel() {
        return _invoiceItem;
    }

    @Override
    public void resetOriginalValues() {
        _invoiceItem.resetOriginalValues();
    }
}
