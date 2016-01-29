create index IX_E0919937 on fubar_Foo (booleanField);
create index IX_A74E42D3 on fubar_Foo (companyId, groupId);
create index IX_D812F7F9 on fubar_Foo (groupId);
create index IX_14834C3 on fubar_Foo (uuid_);
create index IX_B11A4785 on fubar_Foo (uuid_, companyId);
create unique index IX_9128EB47 on fubar_Foo (uuid_, groupId);