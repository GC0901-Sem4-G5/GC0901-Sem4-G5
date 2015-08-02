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
statuspay nvarchar(20) not null
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
	userid int foreign key references [User](id),
	Priceid int foreign key references [Price](id),
	codeticket nvarchar(50) not null,
	created datetime  DEFAULT GETDATE(),
	[status] varchar(10)
)
 --- thong tin ve da ban---

 select * from [Event] where DateStart >= GETDATE()


 insert into [orderDetail](orderId,PriceId,quantity,total) values(1,1,10,500)
 select * from orderDetail where orderId =1
