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

insert into [Type] values ('Movie')
insert into [Type] values ('Music')
insert into [Type] values ('Drama')
insert into [Type] values ('Sports')


insert into [Event] values('1','2015-06-20 07:00:00','Good kill','Tom Egan một phi công lái máy bay chiến đấu tự động cho quân đội Mỹ có thành tích trong việc tiêu diệt những mục tiêu khó của Taliban. Tuy nhiên bỗng một ngày anh nhận được một đề nghị yêu cầu nghỉ nửa buổi trong ngày','1.jpg','1','2015-06-04 07:00:00')
insert into [Event] values('1','2015-06-30 07:00:00','Spy','Susan Cooper-Nữ nhân viên phân tích của CIA không đẹp, không giỏi tiếp xúc với đàn ông và suốt ngày gắn bó với ...công việc bàn giấy nhưng lại là một người hùng thầm lặng đằng sau những chiến dịch nguy hiểm.','2.jpg','3','2015-06-04 07:00:00')
insert into [Event] values('1','2015-06-21 07:00:00','Mad Max: fury road','Ngày tận thế ở vùng đất xa xôi của Trái Đất trong khung cảnh sa mạc khắc nghiệt, Thế giới chỉ còn lại hai người có khả năng khôi phục lại trật tự thế giới. Max- một người đàn ông kiệm lời, thích hành động và luôn bị ám ảnh bởi quá khứ bi thảm liên quan đến cái cái chết của những người thân và Furiosa- người phụ nữ của hành động với niềm tin rằng sẽ sống sót nếu vượt qua được sa mạc','3.jpg','4','2015-06-04 07:00:00')

insert into [Price] values(100,2,1,15)
insert into [Price] values(100,2,2,10)
insert into [Price] values(50,4,1,35)
insert into [Price] values(50,4,2,15)
insert into [Price] values(30,5,1,15)
insert into [Price] values(30,5,2,5)


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