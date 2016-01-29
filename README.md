# Liferay portlet with service (data model)

To do some testing with permissions. See [this](https://dev.liferay.com/develop/tutorials/-/knowledge_base/6-1/security-and-permissions)

To give anyone in the role ROLE_X view_foo permission on the model:

- go to control panel
- click role MYROLE, Define permissions, Applications
- permissions-test
- check desired permissions and save
- place portlet (site and role must match if it is a siterole!)

Note: if MYROLE is a site-role, the portlet must be placed on the site on which a user has the ROLE_X role, otherwise the permissions won’t kick in.
