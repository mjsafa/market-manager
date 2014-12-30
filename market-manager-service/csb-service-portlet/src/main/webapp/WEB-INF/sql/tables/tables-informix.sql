create table CSB_ContentHolder (
	uuid_ varchar(75),
	id_ int8 not null primary key,
	groupId int8,
	companyId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	name varchar(75),
	head varchar(75),
	bottom varchar(75),
	htmlContent varchar(75)
)
extent size 16 next size 16
lock mode row;

create table CSB_Template (
	uuid_ varchar(75),
	id_ int8 not null primary key,
	groupId int8,
	companyId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	name varchar(75),
	head varchar(75),
	bottom varchar(75),
	htmlContent varchar(75)
)
extent size 16 next size 16
lock mode row;
