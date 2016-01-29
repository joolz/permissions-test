package nl.ou.test.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import nl.ou.test.model.Foo;
import nl.ou.test.service.FooLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class FooActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public FooActionableDynamicQuery() throws SystemException {
        setBaseLocalService(FooLocalServiceUtil.getService());
        setClass(Foo.class);

        setClassLoader(nl.ou.test.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("fooId");
    }
}
