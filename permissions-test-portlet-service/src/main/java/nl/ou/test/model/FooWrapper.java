package nl.ou.test.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Foo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Foo
 * @generated
 */
public class FooWrapper implements Foo, ModelWrapper<Foo> {
    private Foo _foo;

    public FooWrapper(Foo foo) {
        _foo = foo;
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

    /**
    * Returns the primary key of this foo.
    *
    * @return the primary key of this foo
    */
    @Override
    public long getPrimaryKey() {
        return _foo.getPrimaryKey();
    }

    /**
    * Sets the primary key of this foo.
    *
    * @param primaryKey the primary key of this foo
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _foo.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this foo.
    *
    * @return the uuid of this foo
    */
    @Override
    public java.lang.String getUuid() {
        return _foo.getUuid();
    }

    /**
    * Sets the uuid of this foo.
    *
    * @param uuid the uuid of this foo
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _foo.setUuid(uuid);
    }

    /**
    * Returns the foo ID of this foo.
    *
    * @return the foo ID of this foo
    */
    @Override
    public long getFooId() {
        return _foo.getFooId();
    }

    /**
    * Sets the foo ID of this foo.
    *
    * @param fooId the foo ID of this foo
    */
    @Override
    public void setFooId(long fooId) {
        _foo.setFooId(fooId);
    }

    /**
    * Returns the group ID of this foo.
    *
    * @return the group ID of this foo
    */
    @Override
    public long getGroupId() {
        return _foo.getGroupId();
    }

    /**
    * Sets the group ID of this foo.
    *
    * @param groupId the group ID of this foo
    */
    @Override
    public void setGroupId(long groupId) {
        _foo.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this foo.
    *
    * @return the company ID of this foo
    */
    @Override
    public long getCompanyId() {
        return _foo.getCompanyId();
    }

    /**
    * Sets the company ID of this foo.
    *
    * @param companyId the company ID of this foo
    */
    @Override
    public void setCompanyId(long companyId) {
        _foo.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this foo.
    *
    * @return the user ID of this foo
    */
    @Override
    public long getUserId() {
        return _foo.getUserId();
    }

    /**
    * Sets the user ID of this foo.
    *
    * @param userId the user ID of this foo
    */
    @Override
    public void setUserId(long userId) {
        _foo.setUserId(userId);
    }

    /**
    * Returns the user uuid of this foo.
    *
    * @return the user uuid of this foo
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _foo.getUserUuid();
    }

    /**
    * Sets the user uuid of this foo.
    *
    * @param userUuid the user uuid of this foo
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _foo.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this foo.
    *
    * @return the user name of this foo
    */
    @Override
    public java.lang.String getUserName() {
        return _foo.getUserName();
    }

    /**
    * Sets the user name of this foo.
    *
    * @param userName the user name of this foo
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _foo.setUserName(userName);
    }

    /**
    * Returns the create date of this foo.
    *
    * @return the create date of this foo
    */
    @Override
    public java.util.Date getCreateDate() {
        return _foo.getCreateDate();
    }

    /**
    * Sets the create date of this foo.
    *
    * @param createDate the create date of this foo
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _foo.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this foo.
    *
    * @return the modified date of this foo
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _foo.getModifiedDate();
    }

    /**
    * Sets the modified date of this foo.
    *
    * @param modifiedDate the modified date of this foo
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _foo.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the string field of this foo.
    *
    * @return the string field of this foo
    */
    @Override
    public java.lang.String getStringField() {
        return _foo.getStringField();
    }

    /**
    * Sets the string field of this foo.
    *
    * @param stringField the string field of this foo
    */
    @Override
    public void setStringField(java.lang.String stringField) {
        _foo.setStringField(stringField);
    }

    /**
    * Returns the boolean field of this foo.
    *
    * @return the boolean field of this foo
    */
    @Override
    public boolean getBooleanField() {
        return _foo.getBooleanField();
    }

    /**
    * Returns <code>true</code> if this foo is boolean field.
    *
    * @return <code>true</code> if this foo is boolean field; <code>false</code> otherwise
    */
    @Override
    public boolean isBooleanField() {
        return _foo.isBooleanField();
    }

    /**
    * Sets whether this foo is boolean field.
    *
    * @param booleanField the boolean field of this foo
    */
    @Override
    public void setBooleanField(boolean booleanField) {
        _foo.setBooleanField(booleanField);
    }

    /**
    * Returns the int field of this foo.
    *
    * @return the int field of this foo
    */
    @Override
    public int getIntField() {
        return _foo.getIntField();
    }

    /**
    * Sets the int field of this foo.
    *
    * @param intField the int field of this foo
    */
    @Override
    public void setIntField(int intField) {
        _foo.setIntField(intField);
    }

    /**
    * Returns the date field of this foo.
    *
    * @return the date field of this foo
    */
    @Override
    public java.util.Date getDateField() {
        return _foo.getDateField();
    }

    /**
    * Sets the date field of this foo.
    *
    * @param dateField the date field of this foo
    */
    @Override
    public void setDateField(java.util.Date dateField) {
        _foo.setDateField(dateField);
    }

    @Override
    public boolean isNew() {
        return _foo.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _foo.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _foo.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _foo.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _foo.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _foo.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _foo.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _foo.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _foo.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _foo.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _foo.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new FooWrapper((Foo) _foo.clone());
    }

    @Override
    public int compareTo(nl.ou.test.model.Foo foo) {
        return _foo.compareTo(foo);
    }

    @Override
    public int hashCode() {
        return _foo.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<nl.ou.test.model.Foo> toCacheModel() {
        return _foo.toCacheModel();
    }

    @Override
    public nl.ou.test.model.Foo toEscapedModel() {
        return new FooWrapper(_foo.toEscapedModel());
    }

    @Override
    public nl.ou.test.model.Foo toUnescapedModel() {
        return new FooWrapper(_foo.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _foo.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _foo.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _foo.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FooWrapper)) {
            return false;
        }

        FooWrapper fooWrapper = (FooWrapper) obj;

        if (Validator.equals(_foo, fooWrapper._foo)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _foo.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Foo getWrappedFoo() {
        return _foo;
    }

    @Override
    public Foo getWrappedModel() {
        return _foo;
    }

    @Override
    public void resetOriginalValues() {
        _foo.resetOriginalValues();
    }
}
