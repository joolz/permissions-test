package nl.ou.test.beans;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import nl.ou.test.model.Foo;
import nl.ou.test.service.FooLocalServiceUtil;

@ManagedBean
@ViewScoped
public class FubarBean {
	private static final Log LOG = LogFactoryUtil.getLog(FubarBean.class);

	@PostConstruct
	private void init() {
		LOG.debug("PostConstruct");
	}

	public int getSomeValue() {
		LOG.debug("getTotal");
		try {
			createDefaultFoo();
			return FooLocalServiceUtil.getFoosCount();
		} catch (final SystemException e) {
			LOG.error(e);
		}
		return GetterUtil.DEFAULT_INTEGER;
	}

	private void createDefaultFoo() {
		LOG.debug("createDefaultFoo");
		final LiferayFacesContext lfc = LiferayFacesContext.getInstance();
		try {
			final int foosCount = FooLocalServiceUtil.getFoosCount();

			if (foosCount == 0) {
				LOG.debug("No foos found, create one");
				final Foo foo = FooLocalServiceUtil.createFoo(lfc.getCompanyId(), lfc.getScopeGroupId(),
						lfc.getUserId());
				foo.setBooleanField(true);
				foo.setIntField(42);
				foo.setStringField("The answer");
				FooLocalServiceUtil.addFoo(foo);
			}
		} catch (final SystemException e) {
			LOG.error(e);
		}
	}
}
