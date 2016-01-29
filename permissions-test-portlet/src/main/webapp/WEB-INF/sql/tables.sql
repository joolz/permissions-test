create table fubar_Foo (
	uuid_ VARCHAR(75) null,
	fooId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	stringField VARCHAR(75) null,
	booleanField BOOLEAN,
	intField INTEGER,
	dateField DATE null
);