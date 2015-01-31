package com.arman.csb.modules.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Score}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Score
 * @generated
 */
public class ScoreWrapper implements Score, ModelWrapper<Score> {
    private Score _score;

    public ScoreWrapper(Score score) {
        _score = score;
    }

    @Override
    public Class<?> getModelClass() {
        return Score.class;
    }

    @Override
    public String getModelClassName() {
        return Score.class.getName();
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
        attributes.put("value", getValue());
        attributes.put("customerId", getCustomerId());
        attributes.put("originCustomerId", getOriginCustomerId());
        attributes.put("type", getType());

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

        Long value = (Long) attributes.get("value");

        if (value != null) {
            setValue(value);
        }

        Long customerId = (Long) attributes.get("customerId");

        if (customerId != null) {
            setCustomerId(customerId);
        }

        Long originCustomerId = (Long) attributes.get("originCustomerId");

        if (originCustomerId != null) {
            setOriginCustomerId(originCustomerId);
        }

        Integer type = (Integer) attributes.get("type");

        if (type != null) {
            setType(type);
        }
    }

    /**
    * Returns the primary key of this score.
    *
    * @return the primary key of this score
    */
    @Override
    public long getPrimaryKey() {
        return _score.getPrimaryKey();
    }

    /**
    * Sets the primary key of this score.
    *
    * @param primaryKey the primary key of this score
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _score.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this score.
    *
    * @return the uuid of this score
    */
    @Override
    public java.lang.String getUuid() {
        return _score.getUuid();
    }

    /**
    * Sets the uuid of this score.
    *
    * @param uuid the uuid of this score
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _score.setUuid(uuid);
    }

    /**
    * Returns the ID of this score.
    *
    * @return the ID of this score
    */
    @Override
    public long getId() {
        return _score.getId();
    }

    /**
    * Sets the ID of this score.
    *
    * @param id the ID of this score
    */
    @Override
    public void setId(long id) {
        _score.setId(id);
    }

    /**
    * Returns the group ID of this score.
    *
    * @return the group ID of this score
    */
    @Override
    public long getGroupId() {
        return _score.getGroupId();
    }

    /**
    * Sets the group ID of this score.
    *
    * @param groupId the group ID of this score
    */
    @Override
    public void setGroupId(long groupId) {
        _score.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this score.
    *
    * @return the company ID of this score
    */
    @Override
    public long getCompanyId() {
        return _score.getCompanyId();
    }

    /**
    * Sets the company ID of this score.
    *
    * @param companyId the company ID of this score
    */
    @Override
    public void setCompanyId(long companyId) {
        _score.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this score.
    *
    * @return the user ID of this score
    */
    @Override
    public long getUserId() {
        return _score.getUserId();
    }

    /**
    * Sets the user ID of this score.
    *
    * @param userId the user ID of this score
    */
    @Override
    public void setUserId(long userId) {
        _score.setUserId(userId);
    }

    /**
    * Returns the user uuid of this score.
    *
    * @return the user uuid of this score
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _score.getUserUuid();
    }

    /**
    * Sets the user uuid of this score.
    *
    * @param userUuid the user uuid of this score
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _score.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this score.
    *
    * @return the user name of this score
    */
    @Override
    public java.lang.String getUserName() {
        return _score.getUserName();
    }

    /**
    * Sets the user name of this score.
    *
    * @param userName the user name of this score
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _score.setUserName(userName);
    }

    /**
    * Returns the create date of this score.
    *
    * @return the create date of this score
    */
    @Override
    public java.util.Date getCreateDate() {
        return _score.getCreateDate();
    }

    /**
    * Sets the create date of this score.
    *
    * @param createDate the create date of this score
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _score.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this score.
    *
    * @return the modified date of this score
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _score.getModifiedDate();
    }

    /**
    * Sets the modified date of this score.
    *
    * @param modifiedDate the modified date of this score
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _score.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the value of this score.
    *
    * @return the value of this score
    */
    @Override
    public long getValue() {
        return _score.getValue();
    }

    /**
    * Sets the value of this score.
    *
    * @param value the value of this score
    */
    @Override
    public void setValue(long value) {
        _score.setValue(value);
    }

    /**
    * Returns the customer ID of this score.
    *
    * @return the customer ID of this score
    */
    @Override
    public long getCustomerId() {
        return _score.getCustomerId();
    }

    /**
    * Sets the customer ID of this score.
    *
    * @param customerId the customer ID of this score
    */
    @Override
    public void setCustomerId(long customerId) {
        _score.setCustomerId(customerId);
    }

    /**
    * Returns the origin customer ID of this score.
    *
    * @return the origin customer ID of this score
    */
    @Override
    public long getOriginCustomerId() {
        return _score.getOriginCustomerId();
    }

    /**
    * Sets the origin customer ID of this score.
    *
    * @param originCustomerId the origin customer ID of this score
    */
    @Override
    public void setOriginCustomerId(long originCustomerId) {
        _score.setOriginCustomerId(originCustomerId);
    }

    /**
    * Returns the type of this score.
    *
    * @return the type of this score
    */
    @Override
    public int getType() {
        return _score.getType();
    }

    /**
    * Sets the type of this score.
    *
    * @param type the type of this score
    */
    @Override
    public void setType(int type) {
        _score.setType(type);
    }

    @Override
    public boolean isNew() {
        return _score.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _score.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _score.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _score.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _score.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _score.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _score.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _score.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _score.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _score.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _score.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ScoreWrapper((Score) _score.clone());
    }

    @Override
    public int compareTo(com.arman.csb.modules.model.Score score) {
        return _score.compareTo(score);
    }

    @Override
    public int hashCode() {
        return _score.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.arman.csb.modules.model.Score> toCacheModel() {
        return _score.toCacheModel();
    }

    @Override
    public com.arman.csb.modules.model.Score toEscapedModel() {
        return new ScoreWrapper(_score.toEscapedModel());
    }

    @Override
    public com.arman.csb.modules.model.Score toUnescapedModel() {
        return new ScoreWrapper(_score.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _score.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _score.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _score.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ScoreWrapper)) {
            return false;
        }

        ScoreWrapper scoreWrapper = (ScoreWrapper) obj;

        if (Validator.equals(_score, scoreWrapper._score)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _score.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Score getWrappedScore() {
        return _score;
    }

    @Override
    public Score getWrappedModel() {
        return _score;
    }

    @Override
    public void resetOriginalValues() {
        _score.resetOriginalValues();
    }
}
