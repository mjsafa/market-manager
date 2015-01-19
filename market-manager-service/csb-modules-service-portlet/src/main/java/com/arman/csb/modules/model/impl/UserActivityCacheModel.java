package com.arman.csb.modules.model.impl;

import com.arman.csb.modules.model.UserActivity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserActivity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserActivity
 * @generated
 */
public class UserActivityCacheModel implements CacheModel<UserActivity>,
    Externalizable {
    public String uuid;
    public long id;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public String entity;
    public Short action;
    public Short importance;
    public String data;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

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
        sb.append(", entity=");
        sb.append(entity);
        sb.append(", action=");
        sb.append(action);
        sb.append(", importance=");
        sb.append(importance);
        sb.append(", data=");
        sb.append(data);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public UserActivity toEntityModel() {
        UserActivityImpl userActivityImpl = new UserActivityImpl();

        if (uuid == null) {
            userActivityImpl.setUuid(StringPool.BLANK);
        } else {
            userActivityImpl.setUuid(uuid);
        }

        userActivityImpl.setId(id);
        userActivityImpl.setGroupId(groupId);
        userActivityImpl.setCompanyId(companyId);
        userActivityImpl.setUserId(userId);

        if (userName == null) {
            userActivityImpl.setUserName(StringPool.BLANK);
        } else {
            userActivityImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            userActivityImpl.setCreateDate(null);
        } else {
            userActivityImpl.setCreateDate(new Date(createDate));
        }

        if (entity == null) {
            userActivityImpl.setEntity(StringPool.BLANK);
        } else {
            userActivityImpl.setEntity(entity);
        }

        userActivityImpl.setAction(action);
        userActivityImpl.setImportance(importance);

        if (data == null) {
            userActivityImpl.setData(StringPool.BLANK);
        } else {
            userActivityImpl.setData(data);
        }

        userActivityImpl.resetOriginalValues();

        return userActivityImpl;
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
        entity = objectInput.readUTF();
        action = objectInput.readShort();
        importance = objectInput.readShort();
        data = objectInput.readUTF();
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

        if (entity == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(entity);
        }

        objectOutput.writeShort(action);
        objectOutput.writeShort(importance);

        if (data == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(data);
        }
    }
}
