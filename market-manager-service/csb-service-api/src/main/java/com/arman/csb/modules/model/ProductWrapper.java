package com.arman.csb.modules.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Product}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Product
 * @generated
 */
public class ProductWrapper implements Product, ModelWrapper<Product> {
    private Product _product;

    public ProductWrapper(Product product) {
        _product = product;
    }

    @Override
    public Class<?> getModelClass() {
        return Product.class;
    }

    @Override
    public String getModelClassName() {
        return Product.class.getName();
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
        attributes.put("name", getName());
        attributes.put("code", getCode());
        attributes.put("basePrice", getBasePrice());
        attributes.put("score", getScore());

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

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String code = (String) attributes.get("code");

        if (code != null) {
            setCode(code);
        }

        Long basePrice = (Long) attributes.get("basePrice");

        if (basePrice != null) {
            setBasePrice(basePrice);
        }

        Long score = (Long) attributes.get("score");

        if (score != null) {
            setScore(score);
        }
    }

    /**
    * Returns the primary key of this product.
    *
    * @return the primary key of this product
    */
    @Override
    public long getPrimaryKey() {
        return _product.getPrimaryKey();
    }

    /**
    * Sets the primary key of this product.
    *
    * @param primaryKey the primary key of this product
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _product.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this product.
    *
    * @return the uuid of this product
    */
    @Override
    public java.lang.String getUuid() {
        return _product.getUuid();
    }

    /**
    * Sets the uuid of this product.
    *
    * @param uuid the uuid of this product
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _product.setUuid(uuid);
    }

    /**
    * Returns the ID of this product.
    *
    * @return the ID of this product
    */
    @Override
    public long getId() {
        return _product.getId();
    }

    /**
    * Sets the ID of this product.
    *
    * @param id the ID of this product
    */
    @Override
    public void setId(long id) {
        _product.setId(id);
    }

    /**
    * Returns the group ID of this product.
    *
    * @return the group ID of this product
    */
    @Override
    public long getGroupId() {
        return _product.getGroupId();
    }

    /**
    * Sets the group ID of this product.
    *
    * @param groupId the group ID of this product
    */
    @Override
    public void setGroupId(long groupId) {
        _product.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this product.
    *
    * @return the company ID of this product
    */
    @Override
    public long getCompanyId() {
        return _product.getCompanyId();
    }

    /**
    * Sets the company ID of this product.
    *
    * @param companyId the company ID of this product
    */
    @Override
    public void setCompanyId(long companyId) {
        _product.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this product.
    *
    * @return the user ID of this product
    */
    @Override
    public long getUserId() {
        return _product.getUserId();
    }

    /**
    * Sets the user ID of this product.
    *
    * @param userId the user ID of this product
    */
    @Override
    public void setUserId(long userId) {
        _product.setUserId(userId);
    }

    /**
    * Returns the user uuid of this product.
    *
    * @return the user uuid of this product
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _product.getUserUuid();
    }

    /**
    * Sets the user uuid of this product.
    *
    * @param userUuid the user uuid of this product
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _product.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this product.
    *
    * @return the user name of this product
    */
    @Override
    public java.lang.String getUserName() {
        return _product.getUserName();
    }

    /**
    * Sets the user name of this product.
    *
    * @param userName the user name of this product
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _product.setUserName(userName);
    }

    /**
    * Returns the create date of this product.
    *
    * @return the create date of this product
    */
    @Override
    public java.util.Date getCreateDate() {
        return _product.getCreateDate();
    }

    /**
    * Sets the create date of this product.
    *
    * @param createDate the create date of this product
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _product.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this product.
    *
    * @return the modified date of this product
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _product.getModifiedDate();
    }

    /**
    * Sets the modified date of this product.
    *
    * @param modifiedDate the modified date of this product
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _product.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this product.
    *
    * @return the name of this product
    */
    @Override
    public java.lang.String getName() {
        return _product.getName();
    }

    /**
    * Sets the name of this product.
    *
    * @param name the name of this product
    */
    @Override
    public void setName(java.lang.String name) {
        _product.setName(name);
    }

    /**
    * Returns the code of this product.
    *
    * @return the code of this product
    */
    @Override
    public java.lang.String getCode() {
        return _product.getCode();
    }

    /**
    * Sets the code of this product.
    *
    * @param code the code of this product
    */
    @Override
    public void setCode(java.lang.String code) {
        _product.setCode(code);
    }

    /**
    * Returns the base price of this product.
    *
    * @return the base price of this product
    */
    @Override
    public long getBasePrice() {
        return _product.getBasePrice();
    }

    /**
    * Sets the base price of this product.
    *
    * @param basePrice the base price of this product
    */
    @Override
    public void setBasePrice(long basePrice) {
        _product.setBasePrice(basePrice);
    }

    /**
    * Returns the score of this product.
    *
    * @return the score of this product
    */
    @Override
    public long getScore() {
        return _product.getScore();
    }

    /**
    * Sets the score of this product.
    *
    * @param score the score of this product
    */
    @Override
    public void setScore(long score) {
        _product.setScore(score);
    }

    @Override
    public boolean isNew() {
        return _product.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _product.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _product.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _product.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _product.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _product.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _product.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _product.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _product.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _product.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _product.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ProductWrapper((Product) _product.clone());
    }

    @Override
    public int compareTo(Product product) {
        return _product.compareTo(product);
    }

    @Override
    public int hashCode() {
        return _product.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Product> toCacheModel() {
        return _product.toCacheModel();
    }

    @Override
    public Product toEscapedModel() {
        return new ProductWrapper(_product.toEscapedModel());
    }

    @Override
    public Product toUnescapedModel() {
        return new ProductWrapper(_product.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _product.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _product.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _product.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ProductWrapper)) {
            return false;
        }

        ProductWrapper productWrapper = (ProductWrapper) obj;

        if (Validator.equals(_product, productWrapper._product)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _product.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Product getWrappedProduct() {
        return _product;
    }

    @Override
    public Product getWrappedModel() {
        return _product;
    }

    @Override
    public void resetOriginalValues() {
        _product.resetOriginalValues();
    }
}
