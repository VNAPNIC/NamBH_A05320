use master
go
create database WPSJAsm
go
use WPSJAsm
go
create table [Login]
(
	[user] varchar(50) primary key not null,
	pass varchar(50) not null
)
create table libary
(
	code int primary key identity not null,
	name varchar(50) not null,
	author varchar(50) not null,
	bon bit not null
)

create table detail
(
	id int primary key identity not null,
	[date] varchar(50),
	[user] varchar(50),
	code int,
	constraint FK_user foreign key ([user]) references [Login]([user]),
	constraint FK_code foreign key (code) references libary(code)
)

select * from [Login] 