create database EasyTicket
use EasyTicket
go
-- Start Data Not Change -- 
create table [user](
	id int not null identity primary key,
	username varchar(30) not null,
	firstname varchar(30) not null,
	lastname varchar(30) not null,
	[type] varchar(30) not null,
	telephone varchar(15),
	email varchar(50) not null,
	[address] varchar(100),
	bankAccount varchar(200),
	created varchar(30) not null,
	birthdate datetime,
	[password] varchar(30) not null

)

create table Adminmaster(
id int identity primary key,
username nvarchar(50) not null,
[password] nvarchar(50) not null,
fullname nvarchar(100),
email nvarchar(100),
staffid nvarchar(20) not null
)

create table [ContactUs](
	id int not null identity primary key,
	name nvarchar(100),
	email nvarchar(100),
	phone nvarchar(100),
	content nvarchar(1000) not null,
	created datetime  DEFAULT GETDATE()
)


create table FAQ(
id int identity primary key,
question nvarchar(500),
answer nvarchar(500)
)

-- end ---


-- main data --

create table location(
id int identity primary key,
city nvarchar(30) not null,
[address] nvarchar(100)
)  -- dia diem dien ra ---

create table [Type](
id int identity primary key,
typeName nvarchar(50) not null
) -- the loai event : music, movie, sport... ---

create table [Event](
	id int not null identity primary key,
	typeid int foreign key references [Type](id),
	DateStart datetime not null,
	eventname varchar(100) not null,
	content varchar(1000) not null,
	enventImg varchar(500),
	location int foreign key references location(id),
	created datetime  DEFAULT GETDATE()
) --- thong tin chi tiet su kien --- 

create table Arena(
	id int not null identity primary key,
	area varchar(50) not null, -- vip hay thuong ---
) -- khu vuc cho moi event --


create table [Price](
	id int not null identity primary key,
	quantity int not null,
	eventid int foreign key references [Event](id),
	arenaId int foreign key references Arena(id),
	[price] float
)-- gia ve cho moi id khu vuc --


create table [order](
id int identity primary key,
created datetime  DEFAULT GETDATE(),
userOrder int foreign key references [user](id),
statuspay nvarchar(20) not null,
payid nvarchar(40)
)
 --- hoa don ---

create table orderDetail(
id int identity primary key,
orderId int foreign key references [order](id), -- ma order 
PriceId int foreign key references [Price](id),
quantity int, -- ma khu vuc
total float not null -- so tien
) --

create table [Ticket](
	id int not null identity primary key,
	priceid int foreign key references Price(id),
	orderDetailid int foreign key references orderDetail(id),
	codeticket nvarchar(50) not null,
	created datetime  DEFAULT GETDATE(),
	[status] varchar(10)
)

 --- thong tin ve da ban---

 select Ticket.id,Ticket.codeticket,Arena.area,[Event].DateStart,[Event].eventname,location.[address],location.city  from Ticket inner join Price on Price.id = Ticket.priceid inner join Arena on Price.arenaId = Arena.id inner join [Event] on [Event].id = Price.eventid inner join location on [Event].location = location.id inner join orderDetail on orderDetail.id = Ticket.orderDetailid inner join [order] on [order].id = orderDetail.orderId where [order].id = 12 order by codeticket