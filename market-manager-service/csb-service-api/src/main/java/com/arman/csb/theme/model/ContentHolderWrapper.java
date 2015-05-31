package com.arman.csb.theme.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ContentHolder}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContentHolder
 * @generated
 */
public class ContentHolderWrapper implements ContentHolder,
    ModelWrapper<ContentHolder> {
    private ContentHolder _contentHolder;

    public ContentHolderWrapper(ContentHolder contentHolder) {
        _contentHolder = contentHolder;
    }

    @Override
    public Class<?> getModelClass() {
        return ContentHolder.class;
    }

    @Override
    public String getModelClassName() {
        return ContentHolder.class.getName();
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
        attributes.put("head", getHead());
        attributes.put("bottom", getBottom());
        attributes.put("htmlContent", getHtmlContent());

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

        String head = (String) attributes.get("head");

        if (head != null) {
            setHead(head);
        }

        String bottom = (String) attributes.get("bottom");

        if (bottom != null) {
            setBottom(bottom);
        }

        String htmlContent = (String) attributes.get("htmlContent");

        if (htmlContent != null) {
            setHtmlContent(htmlContent);
        }
    }

    /**
    * Returns the primary key of this content holder.
    *
    * @return the primary key of this content holder
    */
    @Override
    public long getPrimaryKey() {
        return _contentHolder.getPrimaryKey();
    }

    /**
    * Sets the primary key of this content holder.
    *
    * @param primaryKey the primary key of this content holder
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _contentHolder.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this content holder.
    *
    * @return the uuid of this content holder
    */
    @Override
    public java.lang.String getUuid() {
        return _contentHolder.getUuid();
    }

    /**
    * Sets the uuid of this content holder.
    *
    * @param uuid the uuid of this content holder
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _contentHolder.setUuid(uuid);
    }

    /**
    * Returns the ID of this content holder.
    *
    * @return the ID of this content holder
    */
    @Override
    public long getId() {
        return _contentHolder.getId();
    }

    /**
    * Sets the ID of this content holder.
    *
    * @param id the ID of this content holder
    */
    @Override
    public void setId(long id) {
        _contentHolder.setId(id);
    }

    /**
    * Returns the group ID of this content holder.
    *
    * @return the group ID of this content holder
    */
    @Override
    public long getGroupId() {
        return _contentHolder.getGroupId();
    }

    /**
    * Sets the group ID of this content holder.
    *
    * @param groupId the group ID of this content holder
    */
    @Override
    public void setGroupId(long groupId) {
        _contentHolder.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this content holder.
    *
    * @return the company ID of this content holder
    */
    @Override
    public long getCompanyId() {
        return _contentHolder.getCompanyId();
    }

    /**
    * Sets the company ID of this content holder.
    *
    * @param companyId the company ID of this content holder
    */
    @Override
    public void setCompanyId(long companyId) {
        _contentHolder.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this content holder.
    *
    * @return the user ID of this content holder
    */
    @Override
    public long getUserId() {
        return _contentHolder.getUserId();
    }

    /**
    * Sets the user ID of this content holder.
    *
    * @param userId the user ID of this content holder
    */
    @Override
    public void setUserId(long userId) {
        _contentHolder.setUserId(userId);
    }

    /**
    * Returns the user uuid of this content holder.
    *
    * @return the user uuid of this content holder
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contentHolder.getUserUuid();
    }

    /**
    * Sets the user uuid of this content holder.
    *
    * @param userUuid the user uuid of this content holder
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _contentHolder.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this content holder.
    *
    * @return the user name of this content holder
    */
    @Override
    public java.lang.String getUserName() {
        return _contentHolder.getUserName();
    }

    /**
    * Sets the user name of this content holder.
    *
    * @param userName the user name of this content holder
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _contentHolder.setUserName(userName);
    }

    /**
    * Returns the create date of this content holder.
    *
    * @return the create date of this content holder
    */
    @Override
    public java.util.Date getCreateDate() {
        return _contentHolder.getCreateDate();
    }

    /**
    * Sets the create date of this content holder.
    *
    * @param createDate the create date of this content holder
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _contentHolder.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this content holder.
    *
    * @return the modified date of this content holder
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _contentHolder.getModifiedDate();
    }

    /**
    * Sets the modified date of this content holder.
    *
    * @param modifiedDate the modified date of this content holder
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _contentHolder.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this content holder.
    *
    * @return the name of this content holder
    */
    @Override
    public java.lang.String getName() {
        return _contentHolder.getName();
    }

    /**
    * Sets the name of this content holder.
    *
    * @param name the name of this content holder
    */
    @Override
    public void setName(java.lang.String name) {
        _contentHolder.setName(name);
    }

    /**
    * Returns the head of this content holder.
    *
    * @return the head of this content holder
    */
    @Override
    public java.lang.String getHead() {
        return _contentHolder.getHead();
    }

    /**
    * Sets the head of this content holder.
    *
    * @param head the head of this content holder
    */
    @Override
    public void setHead(java.lang.String head) {
        _contentHolder.setHead(head);
    }

    /**
    * Returns the bottom of this content holder.
    *
    * @return the bottom of this content holder
    */
    @Override
    public java.lang.String getBottom() {
        return _contentHolder.getBottom();
    }

    /**
    * Sets the bottom of this content holder.
    *
    * @param bottom the bottom of this content holder
    */
    @Override
    public void setBottom(java.lang.String bottom) {
        _contentHolder.setBottom(bottom);
    }

    /**
    * Returns the html content of this content holder.
    *
    * @return the html content of this content holder
    */
    @Override
    public java.lang.String getHtmlContent() {
        return _contentHolder.getHtmlContent();
    }

    /**
    * Sets the html content of this content holder.
    *
    * @param htmlContent the html content of this content holder
    */
    @Override
    public void setHtmlContent(java.lang.String htmlContent) {
        _contentHolder.setHtmlContent(htmlContent);
    }

    @Override
    public boolean isNew() {
        return _contentHolder.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _contentHolder.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _contentHolder.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _contentHolder.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _contentHolder.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _contentHolder.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _contentHolder.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _contentHolder.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _contentHolder.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _contentHolder.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _contentHolder.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ContentHolderWrapper((ContentHolder) _contentHolder.clone());
    }

    @Override
    public int compareTo(com.arman.csb.theme.model.ContentHolder contentHolder) {
        return _contentHolder.compareTo(contentHolder);
    }

    @Override
    public int hashCode() {
        return _contentHolder.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.arman.csb.theme.model.ContentHolder> toCacheModel() {
        return _contentHolder.toCacheModel();
    }

    @Override
    public com.arman.csb.theme.model.ContentHolder toEscapedModel() {
        return new ContentHolderWrapper(_contentHolder.toEscapedModel());
    }

    @Override
    public com.arman.csb.theme.model.ContentHolder toUnescapedModel() {
        return new ContentHolderWrapper(_contentHolder.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _contentHolder.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _contentHolder.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _contentHolder.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContentHolderWrapper)) {
            return false;
        }

        ContentHolderWrapper contentHolderWrapper = (ContentHolderWrapper) obj;

        if (Validator.equals(_contentHolder, contentHolderWrapper._contentHolder)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _contentHolder.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ContentHolder getWrappedContentHolder() {
        return _contentHolder;
    }

    @Override
    public ContentHolder getWrappedModel() {
        return _contentHolder;
    }

    @Override
    public void resetOriginalValues() {
        _contentHolder.resetOriginalValues();
    }
}
