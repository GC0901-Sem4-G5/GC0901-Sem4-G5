use EasyTicket

insert into [user] values('vumanhhung','Vu Manh','Hung','admin','01663254964','hungvmgc00672@fpt.edu.vn','Ha Noi','0123456789','22:09:00','1995-10-30 00:00:00','123456789')
insert into [user] values('tranvandat','Tran Van','Dat','admin','01325496475','tranvandat@fpt.edu.vn','Ha Noi','0123789456','22:21:00','1994-12-12 00:00:00','123456789')
insert into [user] values('nguyenhoangha','Nguyen Hoang','Ha','admin','0978123456','hoanghanguyen@fpt.edu.vn','Ha Noi','034361694987','22:22:00','1995-09-15 00:00:00','123456789')
insert into [user] values('caocuquoccuong','Cao Cu Quoc','Cuong','customer','01234444666','quoccuong@fpt.edu.vn','Nghe An','1496631908749','22:30:00','1994-01-15 00:00:00','123456789')
insert into [user] values('duyanhle','Le Duy','Anh','customer','09123456789','duyanhle@fpt.edu.vn','Ha Noi','318918492189','22:00:00','1995-03-29 00:00:00','123456789')

insert into Adminmaster values('hungvm','vumanhhung','Vu Manh Hung','hungvmgc00672@fpt.edu.vn','AD01')
insert into Adminmaster values('hanh','nguyenhoangha','Nguyen Hoang Ha','hanh@fpt.edu.vn','AM122')
insert into Adminmaster values('dattv','tranvandat','Tran Van Dat','dattv@fpt.edu.vn','MIN11')

insert into [ContactUs] values('4','Gap loi khi dat ve','giai thich tai sao k dat dc ve','18:00:00')
insert into [ContactUs] values('5','Gap loi ve tai khoan','tai sao toi khong the chinh sua thong tin ca nhan','07:00:00')
insert into [ContactUs] values('4','Gap loi xem show dien','toi khong the xem duoc show dien','12:30:00')

insert into location values('Ha Noi','so 1 duong Lac Long Quan')
insert into location values('Ha Noi','so 148 duong Giang Vo')
insert into location values('Da Nang','so 102 Le Loi')
insert into location values('TP Ho Chi Minh','so 97 Nguyen Thi Minh Khai')
insert into location values('TP Ho Chi Minh','so 77-89 phuong Ben Thanh - quan 1')

insert into [Type] values ('music')
insert into [Type] values ('movie')
insert into [Type] values ('sport')
insert into [Type] values ('meeting')
insert into [Type] values ('sale off')

insert into [Event] values('3','2015-05-31 07:00:00','2015-07-13 09:00:00','Aptech Cup','giai bong da Approtrain Aptech','1','23:09:00')
insert into [Event] values('2','2015-06-12 07:00:00','2015-06-30 09:00:00','Phim moi','Fast and Furious 7','3','23:28:00')
insert into [Event] values('4','2015-02-11 07:00:00','2015-02-11 18:00:00','Fifa online 3','Giao luu cac CLB toan Viet Nam','2','23:45:00')
insert into [Event] values('5','2015-05-31 07:00:00','2015-06-03 00:00:00','Big Sale Off','giam gia nhan dip 1-6','5','23:05:00')
insert into [Event] values('3','2015-06-07 01:45:00','2015-06-07 03:45:00','Chung ket C1 2015','Juvetus - Barcelona','4','23:10:00')

insert into Arena values('2','VIP','10')
insert into Arena values('2','thuong','20')
insert into Arena values('1','VIP','4')
insert into Arena values('1','thuong','100')
insert into Arena values('4','VIP','100')
insert into Arena values('4','thuong','2000')
insert into Arena values('5','VIP','50')
insert into Arena values('5','thuong','3950')
select * from Arena
insert into [Price] values('1','200.000')
insert into [Price] values('2','80.000')
insert into [Price] values('3','50.000')
insert into [Price] values('4','25.000')
insert into [Price] values('5','0.000')
insert into [Price] values('6','30.000')
insert into [Price] values('7','1000.000')
insert into [Price] values('8','300.000')

insert into [Ticket] values('4','1','4','07:00:00','da thanh toan')
insert into [Ticket] values('4','4','5','08:30:00','khach moi')
insert into [Ticket] values('5','2','2','15:00:00','chua thanh toan')
insert into [Ticket] values('5','1','4','18:00:00','da thanh toan')
insert into [Ticket] values('4','5','7','21:00:00','chua thanh toan')

insert into [order] values('07:00:00','4','2')
insert into [order] values('07:30:00','4','1')
insert into [order] values('08:00:00','5','3')
insert into [order] values('08:30:00','5','4')
insert into [order] values('09:00:00','4','1')

insert into [orderDetail] values('1','1','4','50.000')
insert into [orderDetail] values('2','2','1','200.000')
insert into [orderDetail] values('3','2','2','160.000')
insert into [orderDetail] values('4','4','6','120.000')
insert into [orderDetail] values('5','5','7','1000.000')

select * from [user]
select * from Adminmaster
select * from Arena
select * from [ContactUs]
select * from [Event]
select * from [order]
select * from [orderDetail]
select * from [Price]
select * from [Ticket]
select * from [Type]