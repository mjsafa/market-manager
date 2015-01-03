package com.arman.csb.theme.model.impl;

import com.arman.csb.theme.model.Template;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Template in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Template
 * @generated
 */
public class TemplateCacheModel implements CacheModel<Template>, Externalizable {
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
    public Template toEntityModel() {
        TemplateImpl templateImpl = new TemplateImpl();

        if (uuid == null) {
            templateImpl.setUuid(StringPool.BLANK);
        } else {
            templateImpl.setUuid(uuid);
        }

        templateImpl.setId(id);
        templateImpl.setGroupId(groupId);
        templateImpl.setCompanyId(companyId);
        templateImpl.setUserId(userId);

        if (userName == null) {
            templateImpl.setUserName(StringPool.BLANK);
        } else {
            templateImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            templateImpl.setCreateDate(null);
        } else {
            templateImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            templateImpl.setModifiedDate(null);
        } else {
            templateImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            templateImpl.setName(StringPool.BLANK);
        } else {
            templateImpl.setName(name);
        }

        if (head == null) {
            templateImpl.setHead(StringPool.BLANK);
        } else {
            templateImpl.setHead(head);
        }

        if (bottom == null) {
            templateImpl.setBottom(StringPool.BLANK);
        } else {
            templateImpl.setBottom(bottom);
        }

        if (htmlContent == null) {
            templateImpl.setHtmlContent(StringPool.BLANK);
        } else {
            templateImpl.setHtmlContent(htmlContent);
        }

        templateImpl.resetOriginalValues();

        return templateImpl;
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
