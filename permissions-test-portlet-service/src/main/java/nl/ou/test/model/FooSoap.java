package nl.ou.test.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FooSoap implements Serializable {
    private String _uuid;
    private long _fooId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _stringField;
    private boolean _booleanField;
    private int _intField;
    private Date _dateField;

    public FooSoap() {
    }

    public static FooSoap toSoapModel(Foo model) {
        FooSoap soapModel = new FooSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setFooId(model.getFooId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setStringField(model.getStringField());
        soapModel.setBooleanField(model.getBooleanField());
        soapModel.setIntField(model.getIntField());
        soapModel.setDateField(model.getDateField());

        return soapModel;
    }

    public static FooSoap[] toSoapModels(Foo[] models) {
        FooSoap[] soapModels = new FooSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static FooSoap[][] toSoapModels(Foo[][] models) {
        FooSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new FooSoap[models.length][models[0].length];
        } else {
            soapModels = new FooSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static FooSoap[] toSoapModels(List<Foo> models) {
        List<FooSoap> soapModels = new ArrayList<FooSoap>(models.size());

        for (Foo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FooSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _fooId;
    }

    public void setPrimaryKey(long pk) {
        setFooId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getFooId() {
        return _fooId;
    }

    public void setFooId(long fooId) {
        _fooId = fooId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getStringField() {
        return _stringField;
    }

    public void setStringField(String stringField) {
        _stringField = stringField;
    }

    public boolean getBooleanField() {
        return _booleanField;
    }

    public boolean isBooleanField() {
        return _booleanField;
    }

    public void setBooleanField(boolean booleanField) {
        _booleanField = booleanField;
    }

    public int getIntField() {
        return _intField;
    }

    public void setIntField(int intField) {
        _intField = intField;
    }

    public Date getDateField() {
        return _dateField;
    }

    public void setDateField(Date dateField) {
        _dateField = dateField;
    }
}
