package com.arman.csb.modules.model.impl;

import com.arman.csb.modules.model.Score;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Score in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Score
 * @generated
 */
public class ScoreCacheModel implements CacheModel<Score>, Externalizable {
    public String uuid;
    public long id;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public int value;
    public long customerId;
    public long originCustomerId;
    public int type;

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
        sb.append(", value=");
        sb.append(value);
        sb.append(", customerId=");
        sb.append(customerId);
        sb.append(", originCustomerId=");
        sb.append(originCustomerId);
        sb.append(", type=");
        sb.append(type);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Score toEntityModel() {
        ScoreImpl scoreImpl = new ScoreImpl();

        if (uuid == null) {
            scoreImpl.setUuid(StringPool.BLANK);
        } else {
            scoreImpl.setUuid(uuid);
        }

        scoreImpl.setId(id);
        scoreImpl.setGroupId(groupId);
        scoreImpl.setCompanyId(companyId);
        scoreImpl.setUserId(userId);

        if (userName == null) {
            scoreImpl.setUserName(StringPool.BLANK);
        } else {
            scoreImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            scoreImpl.setCreateDate(null);
        } else {
            scoreImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            scoreImpl.setModifiedDate(null);
        } else {
            scoreImpl.setModifiedDate(new Date(modifiedDate));
        }

        scoreImpl.setValue(value);
        scoreImpl.setCustomerId(customerId);
        scoreImpl.setOriginCustomerId(originCustomerId);
        scoreImpl.setType(type);

        scoreImpl.resetOriginalValues();

        return scoreImpl;
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
        value = objectInput.readInt();
        customerId = objectInput.readLong();
        originCustomerId = objectInput.readLong();
        type = objectInput.readInt();
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
        objectOutput.writeInt(value);
        objectOutput.writeLong(customerId);
        objectOutput.writeLong(originCustomerId);
        objectOutput.writeInt(type);
    }
}
