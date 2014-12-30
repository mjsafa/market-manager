create database 'lportal.gdb' page_size 8192 user 'sysdba' password 'masterkey';
connect 'lportal.gdb' user 'sysdba' password 'masterkey';
create table CSB_ContentHolder (uuid_ varchar(75),id_ int64 not null primary key,groupId int64,companyId int64,userId int64,userName varchar(75),createDate timestamp,modifiedDate timestamp,name varchar(75),head varchar(75),bottom varchar(75),htmlContent varchar(75));
create table CSB_Template (uuid_ varchar(75),id_ int64 not null primary key,groupId int64,companyId int64,userId int64,userName varchar(75),createDate timestamp,modifiedDate timestamp,name varchar(75),head varchar(75),bottom varchar(75),htmlContent varchar(75));
