use EasyTicket

insert into [user] values('caocuquoccuong','Cao Cu Quoc','Cuong','customer','01234444666','quoccuong@fpt.edu.vn','Nghe An','1496631908749','22:30:00','1994-01-15 00:00:00','123456789')
insert into [user] values('duyanhle','Le Duy','Anh','customer','09123456789','duyanhle@fpt.edu.vn','Ha Noi','318918492189','22:00:00','1995-03-29 00:00:00','123456789')

insert into Adminmaster values('hungvm','vumanhhung','Vu Manh Hung','hungvmgc00672@fpt.edu.vn','AD01')
insert into Adminmaster values('hanh','nguyenhoangha','Nguyen Hoang Ha','hanh@fpt.edu.vn','AM122')
insert into Adminmaster values('dattv','tranvandat','Tran Van Dat','dattv@fpt.edu.vn','MIN11')

insert into [ContactUs] values('caocuquoccuong','quoccuong@fpt.edu.vn','','khong dat duoc ve online','')
insert into [ContactUs] values('duyanhle','duyanhle@fpt.edu.vn','','khong xem duoc thong tin tai khoan','')
insert into [ContactUs] values('datbt','datbt@fpt.edu.vn','','khong dang ki duoc tai khoan','')

insert into location values('Ha Noi','so 1 duong Lac Long Quan')
insert into location values('Ha Noi','so 148 duong Giang Vo')
insert into location values('Da Nang','so 102 Le Loi')
insert into location values('TP Ho Chi Minh','so 97 Nguyen Thi Minh Khai')
insert into location values('TP Ho Chi Minh','so 77-89 phuong Ben Thanh - quan 1')

insert into [Type] values ('Movie')
insert into [Type] values ('Music')
insert into [Type] values ('Drama')
insert into [Type] values ('Sports')

insert into Arena values ('VIP')
insert into Arena values ('normal')

insert into [Event] values('1','2015-06-20 07:00:00','Good kill','Tom Egan một phi công lái máy bay chiến đấu tự động cho quân đội Mỹ có thành tích trong việc tiêu diệt những mục tiêu khó của Taliban. Tuy nhiên bỗng một ngày anh nhận được một đề nghị yêu cầu nghỉ nửa buổi trong ngày','1.jpg','1','2015-06-04 07:00:00')
insert into [Event] values('1','2015-06-30 07:00:00','Spy','Susan Cooper-Nữ nhân viên phân tích của CIA không đẹp, không giỏi tiếp xúc với đàn ông và suốt ngày gắn bó với ...công việc bàn giấy nhưng lại là một người hùng thầm lặng đằng sau những chiến dịch nguy hiểm.','2.jpg','3','2015-06-04 07:00:00')
insert into [Event] values('1','2015-06-21 07:00:00','Mad Max: fury road','Ngày tận thế ở vùng đất xa xôi của Trái Đất trong khung cảnh sa mạc khắc nghiệt, Thế giới chỉ còn lại hai người có khả năng khôi phục lại trật tự thế giới. Max- một người đàn ông kiệm lời, thích hành động và luôn bị ám ảnh bởi quá khứ bi thảm liên quan đến cái cái chết của những người thân và Furiosa- người phụ nữ của hành động với niềm tin rằng sẽ sống sót nếu vượt qua được sa mạc','3.jpg','4','2015-06-04 07:00:00')
insert into [Event] values('2','2015-06-20 07:00:00','Mr.Dam Live Show','7 năm sau liveshow Thương hoài ngàn năm gây ra tiếng vang lớn cũng như là một trong những cột mốc quan trọng trong sự nghiệp của Đàm Vĩnh Hưng, sáng 17/11, nam ca sĩ và ê-kíp đã công bố dự án liveshow Thương hoài ngàn năm 2.','4.jpg','1','2015-06-04 07:00:00')
insert into [Event] values('2','2015-06-30 07:00:00','My Tam liveshow "Heartbeat"','Sau thành công của live concert Heartbeat vào năm ngoái, Mỹ Tâm quyết định tái hiện không khí của chương trình bằng hai đêm diễn dự kiến diễn ra vào 22/4 ','5.jpg','3','2015-06-04 07:00:00')
insert into [Event] values('2','2015-06-21 07:00:00','Quang Le - Hát trên quê hương 4','Liveshow Quang Lê – Hát trên quê hương lần 4 với chủ đề Tình yêu & Nỗi nhớ diễn ra vào ngày 25-4-2015, tại Sân khấu ca nhạc Lan Anh, TP.HCM.','6.jpg','4','2015-06-04 07:00:00')
insert into [Event] values('3','2015-06-20 07:00:00','CẦN CÓ AI ĐÓ ĐỂ YÊU THƯƠNG',' Những đóng góp ý kiến về việc bán vé xin gọi 08.38404027 hoặc nhắn tin 0903927170 (GD Huỳnh Anh Tuấn) hoặc a Thảo….!Xin Cám Ơn sự quan tâm của quý khách.!!','7.jpg','1','2015-06-04 07:00:00')
insert into [Event] values('3','2015-06-30 07:00:00','Nàng Công Chúa Đi Lạc',' Những đóng góp ý kiến về việc bán vé xin gọi 08.38404027 hoặc nhắn tin 0903927170 (GD Huỳnh Anh Tuấn) hoặc a Thảo….!Xin Cám Ơn sự quan tâm của quý khách.!!','8.jpg','3','2015-06-04 07:00:00')
insert into [Event] values('3','2015-06-21 07:00:00','NGŨ QUÝ KỲ PHÙNG',' Những đóng góp ý kiến về việc bán vé xin gọi 08.38404027 hoặc nhắn tin 0903927170 (GD Huỳnh Anh Tuấn) hoặc a Thảo….!Xin Cám Ơn sự quan tâm của quý khách.!!.','9.jpg','4','2015-06-04 07:00:00')
insert into [Event] values('4','2015-06-20 07:00:00','DTQG VIỆT NAM - MU',' Những đóng góp ý kiến về việc bán vé xin gọi 08.38404027 hoặc nhắn tin 0903927170 (GD Huỳnh Anh Tuấn) hoặc a Thảo….!Xin Cám Ơn sự quan tâm của quý khách.!!','10.jpg','1','2015-06-04 07:00:00')
insert into [Event] values('4','2015-06-30 07:00:00','DTQG VIỆT NAM - Chealsea',' Những đóng góp ý kiến về việc bán vé xin gọi 08.38404027 hoặc nhắn tin 0903927170 (GD Huỳnh Anh Tuấn) hoặc a Thảo….!Xin Cám Ơn sự quan tâm của quý khách.!!','11.jpg','3','2015-06-04 07:00:00')
insert into [Event] values('4','2015-06-21 07:00:00','DTQG VIỆT NAM - DTQG TRUNG QUỐC',' Những đóng góp ý kiến về việc bán vé xin gọi 08.38404027 hoặc nhắn tin 0903927170 (GD Huỳnh Anh Tuấn) hoặc a Thảo….!Xin Cám Ơn sự quan tâm của quý khách.!!.','12.jpg','4','2015-06-04 07:00:00')

insert into [Price] values(50,1,1,80)
insert into [Price] values(50,1,2,50)
insert into [Price] values(100,2,1,15)
insert into [Price] values(100,2,2,10)
insert into [Price] values(50,3,1,180)
insert into [Price] values(50,3,2,80)
insert into [Price] values(50,4,1,35)
insert into [Price] values(50,4,2,15)
insert into [Price] values(30,5,1,15)
insert into [Price] values(30,5,2,5)
insert into [Price] values(200,6,1,50)
insert into [Price] values(200,6,2,10)
insert into [Price] values(50,7,1,180)
insert into [Price] values(50,7,2,80)
insert into [Price] values(50,8,1,35)
insert into [Price] values(50,8,2,15)
insert into [Price] values(30,9,1,15)
insert into [Price] values(30,9,2,5)
insert into [Price] values(200,10,1,50)
insert into [Price] values(200,10,2,10)

insert into [Ticket] values ('1','2','1','da thanh toan','')
insert into [Ticket] values ('2','2','2','da thanh toan','')
insert into [Ticket] values ('2','5','1','oder','')
insert into [Ticket] values ('1','5','2','da thanh toan','')
insert into [Ticket] values ('1','3','1','order','')
insert into [Ticket] values ('2','3','2','order','')

insert into [order] values('07:00:00','1','2')
insert into [order] values('07:30:00','2','1')
insert into [order] values('08:00:00','1','3')
insert into [order] values('08:30:00','2','4')
insert into [order] values('09:00:00','1','1')

insert into [orderDetail] values('1','1','1','30')
insert into [orderDetail] values('2','1','2','20')
insert into [orderDetail] values('1','5','1','45')
insert into [orderDetail] values('2','5','2','20')


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

select * from [user] where username='abc' and [password] = '123456789'
