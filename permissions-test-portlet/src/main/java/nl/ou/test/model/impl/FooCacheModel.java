package nl.ou.test.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import nl.ou.test.model.Foo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Foo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Foo
 * @generated
 */
public class FooCacheModel implements CacheModel<Foo>, Externalizable {
    public String uuid;
    public long fooId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String stringField;
    public boolean booleanField;
    public int intField;
    public long dateField;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", fooId=");
        sb.append(fooId);
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
        sb.append(", stringField=");
        sb.append(stringField);
        sb.append(", booleanField=");
        sb.append(booleanField);
        sb.append(", intField=");
        sb.append(intField);
        sb.append(", dateField=");
        sb.append(dateField);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Foo toEntityModel() {
        FooImpl fooImpl = new FooImpl();

        if (uuid == null) {
            fooImpl.setUuid(StringPool.BLANK);
        } else {
            fooImpl.setUuid(uuid);
        }

        fooImpl.setFooId(fooId);
        fooImpl.setGroupId(groupId);
        fooImpl.setCompanyId(companyId);
        fooImpl.setUserId(userId);

        if (userName == null) {
            fooImpl.setUserName(StringPool.BLANK);
        } else {
            fooImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            fooImpl.setCreateDate(null);
        } else {
            fooImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            fooImpl.setModifiedDate(null);
        } else {
            fooImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (stringField == null) {
            fooImpl.setStringField(StringPool.BLANK);
        } else {
            fooImpl.setStringField(stringField);
        }

        fooImpl.setBooleanField(booleanField);
        fooImpl.setIntField(intField);

        if (dateField == Long.MIN_VALUE) {
            fooImpl.setDateField(null);
        } else {
            fooImpl.setDateField(new Date(dateField));
        }

        fooImpl.resetOriginalValues();

        return fooImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        fooId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        stringField = objectInput.readUTF();
        booleanField = objectInput.readBoolean();
        intField = objectInput.readInt();
        dateField = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(fooId);
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

        if (stringField == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(stringField);
        }

        objectOutput.writeBoolean(booleanField);
        objectOutput.writeInt(intField);
        objectOutput.writeLong(dateField);
    }
}
