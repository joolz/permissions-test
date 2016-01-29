package nl.ou.test.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import nl.ou.test.service.ClpSerializer;
import nl.ou.test.service.FooLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class FooClp extends BaseModelImpl<Foo> implements Foo {
    private String _uuid;
    private long _fooId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _stringField;
    private boolean _booleanField;
    private int _intField;
    private Date _dateField;
    private BaseModel<?> _fooRemoteModel;
    private Class<?> _clpSerializerClass = nl.ou.test.service.ClpSerializer.class;

    public FooClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Foo.class;
    }

    @Override
    public String getModelClassName() {
        return Foo.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _fooId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setFooId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _fooId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("fooId", getFooId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("stringField", getStringField());
        attributes.put("booleanField", getBooleanField());
        attributes.put("intField", getIntField());
        attributes.put("dateField", getDateField());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long fooId = (Long) attributes.get("fooId");

        if (fooId != null) {
            setFooId(fooId);
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

        String stringField = (String) attributes.get("stringField");

        if (stringField != null) {
            setStringField(stringField);
        }

        Boolean booleanField = (Boolean) attributes.get("booleanField");

        if (booleanField != null) {
            setBooleanField(booleanField);
        }

        Integer intField = (Integer) attributes.get("intField");

        if (intField != null) {
            setIntField(intField);
        }

        Date dateField = (Date) attributes.get("dateField");

        if (dateField != null) {
            setDateField(dateField);
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_fooRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getFooId() {
        return _fooId;
    }

    @Override
    public void setFooId(long fooId) {
        _fooId = fooId;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setFooId", long.class);

                method.invoke(_fooRemoteModel, fooId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_fooRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_fooRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_fooRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_fooRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_fooRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_fooRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStringField() {
        return _stringField;
    }

    @Override
    public void setStringField(String stringField) {
        _stringField = stringField;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setStringField", String.class);

                method.invoke(_fooRemoteModel, stringField);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getBooleanField() {
        return _booleanField;
    }

    @Override
    public boolean isBooleanField() {
        return _booleanField;
    }

    @Override
    public void setBooleanField(boolean booleanField) {
        _booleanField = booleanField;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setBooleanField", boolean.class);

                method.invoke(_fooRemoteModel, booleanField);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getIntField() {
        return _intField;
    }

    @Override
    public void setIntField(int intField) {
        _intField = intField;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setIntField", int.class);

                method.invoke(_fooRemoteModel, intField);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getDateField() {
        return _dateField;
    }

    @Override
    public void setDateField(Date dateField) {
        _dateField = dateField;

        if (_fooRemoteModel != null) {
            try {
                Class<?> clazz = _fooRemoteModel.getClass();

                Method method = clazz.getMethod("setDateField", Date.class);

                method.invoke(_fooRemoteModel, dateField);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Foo.class.getName()));
    }

    public BaseModel<?> getFooRemoteModel() {
        return _fooRemoteModel;
    }

    public void setFooRemoteModel(BaseModel<?> fooRemoteModel) {
        _fooRemoteModel = fooRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _fooRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_fooRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            FooLocalServiceUtil.addFoo(this);
        } else {
            FooLocalServiceUtil.updateFoo(this);
        }
    }

    @Override
    public Foo toEscapedModel() {
        return (Foo) ProxyUtil.newProxyInstance(Foo.class.getClassLoader(),
            new Class[] { Foo.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        FooClp clone = new FooClp();

        clone.setUuid(getUuid());
        clone.setFooId(getFooId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setStringField(getStringField());
        clone.setBooleanField(getBooleanField());
        clone.setIntField(getIntField());
        clone.setDateField(getDateField());

        return clone;
    }

    @Override
    public int compareTo(Foo foo) {
        int value = 0;

        value = getStringField().compareTo(foo.getStringField());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FooClp)) {
            return false;
        }

        FooClp foo = (FooClp) obj;

        long primaryKey = foo.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", fooId=");
        sb.append(getFooId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", stringField=");
        sb.append(getStringField());
        sb.append(", booleanField=");
        sb.append(getBooleanField());
        sb.append(", intField=");
        sb.append(getIntField());
        sb.append(", dateField=");
        sb.append(getDateField());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append("nl.ou.test.model.Foo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fooId</column-name><column-value><![CDATA[");
        sb.append(getFooId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stringField</column-name><column-value><![CDATA[");
        sb.append(getStringField());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>booleanField</column-name><column-value><![CDATA[");
        sb.append(getBooleanField());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>intField</column-name><column-value><![CDATA[");
        sb.append(getIntField());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateField</column-name><column-value><![CDATA[");
        sb.append(getDateField());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
