create database EasyTicket
use EasyTicket
go

create table [user](
	id int not null identity primary key,
	username varchar(30) not null,
	firstname varchar(30) not null,
	lastname varchar(30) not null,
	[type] varchar(30) not null,
	telephone varchar(15),
	email varchar(50) not null,
	[address] varchar(100),
	backAccount varchar(200),
	created timestamp not null,
	birthdate datetime,
	[password] varchar(30) not null
)

create table [Event](
	id int not null identity primary key,
	[type] varchar(10),
	startdate datetime not null,
	enddate datetime not null,
	city varchar(100),
	[address] varchar(100),
	caption varchar(100) not null,
	content text not null,
	userid int foreign key references [User](id),
	created timestamp not null
)

create table [Ticket](
	id int not null identity primary key,
	useid int foreign key references [User](id),
	eventid int foreign key references [Event](id),
	line varchar(50),
	created timestamp not null,
	status varchar(10)
)

create table [StaticInfo](
	id int not null identity primary key,
	[type] varchar(50),
	caption varchar(200) not null,
	content text not null,
	userid int foreign key references [User](id),
	created timestamp not null
)

create table [Seat](
	id int not null identity primary key,
	eventid int foreign key references [Event](id),
	area varchar(50),
	line int,
	[rank] int
)

create table [Price](
	id int not null identity primary key,
	eventid int foreign key references [Event](id),
	seatid int foreign key references [Seat](id),
	lineNumbet int,
	[price] float
)

create table [ContactUs](
	id int not null identity primary key,
	customerid int foreign key references [User](id),
	caption varchar(200) not null,
	content text not null,
	created timestamp not null
)

select * from [user]
select * from [Event]
select * from [Ticket]
select * from [ContactUs]
select * from [Price]
select * from [Seat]
select * from [StaticInfo]

drop table [user]
drop table [Event]
drop table [ContactUs]
drop table [Price]
drop table [Seat]
drop table [StaticInfo]
drop table [Ticket]