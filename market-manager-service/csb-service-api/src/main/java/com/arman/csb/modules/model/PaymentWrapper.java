package com.arman.csb.modules.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Payment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Payment
 * @generated
 */
public class PaymentWrapper implements Payment, ModelWrapper<Payment> {
    private Payment _payment;

    public PaymentWrapper(Payment payment) {
        _payment = payment;
    }

    @Override
    public Class<?> getModelClass() {
        return Payment.class;
    }

    @Override
    public String getModelClassName() {
        return Payment.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("id", getId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("description", getDescription());
        attributes.put("card", getCard());
        attributes.put("amount", getAmount());
        attributes.put("status", getStatus());
        attributes.put("paymentDate", getPaymentDate());
        attributes.put("customerId", getCustomerId());
        attributes.put("factorId", getFactorId());

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

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String card = (String) attributes.get("card");

        if (card != null) {
            setCard(card);
        }

        Long amount = (Long) attributes.get("amount");

        if (amount != null) {
            setAmount(amount);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Date paymentDate = (Date) attributes.get("paymentDate");

        if (paymentDate != null) {
            setPaymentDate(paymentDate);
        }

        Long customerId = (Long) attributes.get("customerId");

        if (customerId != null) {
            setCustomerId(customerId);
        }

        Long factorId = (Long) attributes.get("factorId");

        if (factorId != null) {
            setFactorId(factorId);
        }
    }

    /**
    * Returns the primary key of this payment.
    *
    * @return the primary key of this payment
    */
    @Override
    public long getPrimaryKey() {
        return _payment.getPrimaryKey();
    }

    /**
    * Sets the primary key of this payment.
    *
    * @param primaryKey the primary key of this payment
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _payment.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this payment.
    *
    * @return the uuid of this payment
    */
    @Override
    public java.lang.String getUuid() {
        return _payment.getUuid();
    }

    /**
    * Sets the uuid of this payment.
    *
    * @param uuid the uuid of this payment
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _payment.setUuid(uuid);
    }

    /**
    * Returns the ID of this payment.
    *
    * @return the ID of this payment
    */
    @Override
    public long getId() {
        return _payment.getId();
    }

    /**
    * Sets the ID of this payment.
    *
    * @param id the ID of this payment
    */
    @Override
    public void setId(long id) {
        _payment.setId(id);
    }

    /**
    * Returns the group ID of this payment.
    *
    * @return the group ID of this payment
    */
    @Override
    public long getGroupId() {
        return _payment.getGroupId();
    }

    /**
    * Sets the group ID of this payment.
    *
    * @param groupId the group ID of this payment
    */
    @Override
    public void setGroupId(long groupId) {
        _payment.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this payment.
    *
    * @return the company ID of this payment
    */
    @Override
    public long getCompanyId() {
        return _payment.getCompanyId();
    }

    /**
    * Sets the company ID of this payment.
    *
    * @param companyId the company ID of this payment
    */
    @Override
    public void setCompanyId(long companyId) {
        _payment.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this payment.
    *
    * @return the user ID of this payment
    */
    @Override
    public long getUserId() {
        return _payment.getUserId();
    }

    /**
    * Sets the user ID of this payment.
    *
    * @param userId the user ID of this payment
    */
    @Override
    public void setUserId(long userId) {
        _payment.setUserId(userId);
    }

    /**
    * Returns the user uuid of this payment.
    *
    * @return the user uuid of this payment
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _payment.getUserUuid();
    }

    /**
    * Sets the user uuid of this payment.
    *
    * @param userUuid the user uuid of this payment
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _payment.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this payment.
    *
    * @return the create date of this payment
    */
    @Override
    public java.util.Date getCreateDate() {
        return _payment.getCreateDate();
    }

    /**
    * Sets the create date of this payment.
    *
    * @param createDate the create date of this payment
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _payment.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this payment.
    *
    * @return the modified date of this payment
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _payment.getModifiedDate();
    }

    /**
    * Sets the modified date of this payment.
    *
    * @param modifiedDate the modified date of this payment
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _payment.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the description of this payment.
    *
    * @return the description of this payment
    */
    @Override
    public java.lang.String getDescription() {
        return _payment.getDescription();
    }

    /**
    * Sets the description of this payment.
    *
    * @param description the description of this payment
    */
    @Override
    public void setDescription(java.lang.String description) {
        _payment.setDescription(description);
    }

    /**
    * Returns the card of this payment.
    *
    * @return the card of this payment
    */
    @Override
    public java.lang.String getCard() {
        return _payment.getCard();
    }

    /**
    * Sets the card of this payment.
    *
    * @param card the card of this payment
    */
    @Override
    public void setCard(java.lang.String card) {
        _payment.setCard(card);
    }

    /**
    * Returns the amount of this payment.
    *
    * @return the amount of this payment
    */
    @Override
    public long getAmount() {
        return _payment.getAmount();
    }

    /**
    * Sets the amount of this payment.
    *
    * @param amount the amount of this payment
    */
    @Override
    public void setAmount(long amount) {
        _payment.setAmount(amount);
    }

    /**
    * Returns the status of this payment.
    *
    * @return the status of this payment
    */
    @Override
    public int getStatus() {
        return _payment.getStatus();
    }

    /**
    * Sets the status of this payment.
    *
    * @param status the status of this payment
    */
    @Override
    public void setStatus(int status) {
        _payment.setStatus(status);
    }

    /**
    * Returns the payment date of this payment.
    *
    * @return the payment date of this payment
    */
    @Override
    public java.util.Date getPaymentDate() {
        return _payment.getPaymentDate();
    }

    /**
    * Sets the payment date of this payment.
    *
    * @param paymentDate the payment date of this payment
    */
    @Override
    public void setPaymentDate(java.util.Date paymentDate) {
        _payment.setPaymentDate(paymentDate);
    }

    /**
    * Returns the customer ID of this payment.
    *
    * @return the customer ID of this payment
    */
    @Override
    public long getCustomerId() {
        return _payment.getCustomerId();
    }

    /**
    * Sets the customer ID of this payment.
    *
    * @param customerId the customer ID of this payment
    */
    @Override
    public void setCustomerId(long customerId) {
        _payment.setCustomerId(customerId);
    }

    /**
    * Returns the factor ID of this payment.
    *
    * @return the factor ID of this payment
    */
    @Override
    public long getFactorId() {
        return _payment.getFactorId();
    }

    /**
    * Sets the factor ID of this payment.
    *
    * @param factorId the factor ID of this payment
    */
    @Override
    public void setFactorId(long factorId) {
        _payment.setFactorId(factorId);
    }

    @Override
    public boolean isNew() {
        return _payment.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _payment.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _payment.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _payment.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _payment.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _payment.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _payment.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _payment.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _payment.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _payment.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _payment.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new PaymentWrapper((Payment) _payment.clone());
    }

    @Override
    public int compareTo(com.arman.csb.modules.model.Payment payment) {
        return _payment.compareTo(payment);
    }

    @Override
    public int hashCode() {
        return _payment.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.arman.csb.modules.model.Payment> toCacheModel() {
        return _payment.toCacheModel();
    }

    @Override
    public com.arman.csb.modules.model.Payment toEscapedModel() {
        return new PaymentWrapper(_payment.toEscapedModel());
    }

    @Override
    public com.arman.csb.modules.model.Payment toUnescapedModel() {
        return new PaymentWrapper(_payment.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _payment.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _payment.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _payment.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PaymentWrapper)) {
            return false;
        }

        PaymentWrapper paymentWrapper = (PaymentWrapper) obj;

        if (Validator.equals(_payment, paymentWrapper._payment)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _payment.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Payment getWrappedPayment() {
        return _payment;
    }

    @Override
    public Payment getWrappedModel() {
        return _payment;
    }

    @Override
    public void resetOriginalValues() {
        _payment.resetOriginalValues();
    }
}
