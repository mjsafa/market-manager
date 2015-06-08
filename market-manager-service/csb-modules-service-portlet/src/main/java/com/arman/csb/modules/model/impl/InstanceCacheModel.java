package com.arman.csb.modules.model.impl;

import com.arman.csb.modules.model.Instance;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Instance in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Instance
 * @generated
 */
public class InstanceCacheModel implements CacheModel<Instance>, Externalizable {
    public String uuid;
    public long id;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String url;
    public long superAdminId;
    public String logo;
    public int status;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

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
        sb.append(", url=");
        sb.append(url);
        sb.append(", superAdminId=");
        sb.append(superAdminId);
        sb.append(", logo=");
        sb.append(logo);
        sb.append(", status=");
        sb.append(status);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Instance toEntityModel() {
        InstanceImpl instanceImpl = new InstanceImpl();

        if (uuid == null) {
            instanceImpl.setUuid(StringPool.BLANK);
        } else {
            instanceImpl.setUuid(uuid);
        }

        instanceImpl.setId(id);
        instanceImpl.setGroupId(groupId);
        instanceImpl.setCompanyId(companyId);
        instanceImpl.setUserId(userId);

        if (userName == null) {
            instanceImpl.setUserName(StringPool.BLANK);
        } else {
            instanceImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            instanceImpl.setCreateDate(null);
        } else {
            instanceImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            instanceImpl.setModifiedDate(null);
        } else {
            instanceImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            instanceImpl.setName(StringPool.BLANK);
        } else {
            instanceImpl.setName(name);
        }

        if (url == null) {
            instanceImpl.setUrl(StringPool.BLANK);
        } else {
            instanceImpl.setUrl(url);
        }

        instanceImpl.setSuperAdminId(superAdminId);

        if (logo == null) {
            instanceImpl.setLogo(StringPool.BLANK);
        } else {
            instanceImpl.setLogo(logo);
        }

        instanceImpl.setStatus(status);

        instanceImpl.resetOriginalValues();

        return instanceImpl;
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
        url = objectInput.readUTF();
        superAdminId = objectInput.readLong();
        logo = objectInput.readUTF();
        status = objectInput.readInt();
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

        if (url == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(url);
        }

        objectOutput.writeLong(superAdminId);

        if (logo == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(logo);
        }

        objectOutput.writeInt(status);
    }
}
