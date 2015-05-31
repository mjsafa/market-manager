package com.arman.csb.theme.model.impl;

import com.arman.csb.theme.model.ContentHolder;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ContentHolder in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ContentHolder
 * @generated
 */
public class ContentHolderCacheModel implements CacheModel<ContentHolder>,
    Externalizable {
    public String uuid;
    public long id;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String head;
    public String bottom;
    public String htmlContent;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", id=");
        sb.append(id);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", name=");
        sb.append(name);
        sb.append(", head=");
        sb.append(head);
        sb.append(", bottom=");
        sb.append(bottom);
        sb.append(", htmlContent=");
        sb.append(htmlContent);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ContentHolder toEntityModel() {
        ContentHolderImpl contentHolderImpl = new ContentHolderImpl();

        if (uuid == null) {
            contentHolderImpl.setUuid(StringPool.BLANK);
        } else {
            contentHolderImpl.setUuid(uuid);
        }

        contentHolderImpl.setId(id);
        contentHolderImpl.setGroupId(groupId);
        contentHolderImpl.setCompanyId(companyId);
        contentHolderImpl.setUserId(userId);

        if (userName == null) {
            contentHolderImpl.setUserName(StringPool.BLANK);
        } else {
            contentHolderImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            contentHolderImpl.setCreateDate(null);
        } else {
            contentHolderImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            contentHolderImpl.setModifiedDate(null);
        } else {
            contentHolderImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            contentHolderImpl.setName(StringPool.BLANK);
        } else {
            contentHolderImpl.setName(name);
        }

        if (head == null) {
            contentHolderImpl.setHead(StringPool.BLANK);
        } else {
            contentHolderImpl.setHead(head);
        }

        if (bottom == null) {
            contentHolderImpl.setBottom(StringPool.BLANK);
        } else {
            contentHolderImpl.setBottom(bottom);
        }

        if (htmlContent == null) {
            contentHolderImpl.setHtmlContent(StringPool.BLANK);
        } else {
            contentHolderImpl.setHtmlContent(htmlContent);
        }

        contentHolderImpl.resetOriginalValues();

        return contentHolderImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        id = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        head = objectInput.readUTF();
        bottom = objectInput.readUTF();
        htmlContent = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(id);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (head == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(head);
        }

        if (bottom == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(bottom);
        }

        if (htmlContent == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(htmlContent);
        }
    }
}
