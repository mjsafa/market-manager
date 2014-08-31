create table CSB_ContentHolder (
	uuid_ nvarchar(75) null,
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName nvarchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	name nvarchar(75) null,
	head nvarchar(75) null,
	bottom nvarchar(75) null,
	htmlContent nvarchar(75) null
);

create table CSB_Template (
	uuid_ nvarchar(75) null,
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName nvarchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	name nvarchar(75) null,
	head nvarchar(75) null,
	bottom nvarchar(75) null,
	htmlContent nvarchar(75) null
);
