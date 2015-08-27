USE [EasyTicket]
GO
/****** Object:  Table [dbo].[Adminmaster]    Script Date: 8/27/2015 9:17:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Adminmaster](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[fullname] [nvarchar](100) NULL,
	[email] [nvarchar](100) NULL,
	[staffid] [nvarchar](20) NOT NULL,
	[role] [varchar](4000) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Arena]    Script Date: 8/27/2015 9:17:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Arena](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[area] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ContactUs]    Script Date: 8/27/2015 9:17:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContactUs](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
	[email] [nvarchar](100) NULL,
	[phone] [nvarchar](100) NULL,
	[content] [nvarchar](1000) NOT NULL,
	[created] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Event]    Script Date: 8/27/2015 9:17:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Event](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[typeid] [int] NULL,
	[DateStart] [datetime] NOT NULL,
	[eventname] [varchar](100) NOT NULL,
	[content] [varchar](1000) NOT NULL,
	[enventImg] [varchar](500) NULL,
	[location] [int] NULL,
	[created] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FAQ]    Script Date: 8/27/2015 9:17:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FAQ](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[question] [nvarchar](500) NULL,
	[answer] [nvarchar](500) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[location]    Script Date: 8/27/2015 9:17:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[location](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[city] [nvarchar](30) NOT NULL,
	[address] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[order]    Script Date: 8/27/2015 9:17:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[created] [datetime] NULL,
	[userOrder] [int] NULL,
	[statuspay] [nvarchar](20) NOT NULL,
	[payid] [nvarchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[orderDetail]    Script Date: 8/27/2015 9:17:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orderDetail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[orderId] [int] NULL,
	[PriceId] [int] NULL,
	[quantity] [int] NULL,
	[total] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Price]    Script Date: 8/27/2015 9:17:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Price](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[quantity] [int] NOT NULL,
	[eventid] [int] NULL,
	[arenaId] [int] NULL,
	[price] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Ticket]    Script Date: 8/27/2015 9:17:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Ticket](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[priceid] [int] NULL,
	[orderDetailid] [int] NULL,
	[codeticket] [nvarchar](50) NOT NULL,
	[created] [datetime] NULL,
	[status] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Type]    Script Date: 8/27/2015 9:17:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Type](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[typeName] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[user]    Script Date: 8/27/2015 9:17:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](30) NOT NULL,
	[firstname] [varchar](30) NOT NULL,
	[lastname] [varchar](30) NOT NULL,
	[type] [varchar](30) NOT NULL,
	[telephone] [varchar](15) NULL,
	[email] [varchar](50) NOT NULL,
	[address] [varchar](100) NULL,
	[bankAccount] [varchar](200) NULL,
	[created] [varchar](30) NOT NULL,
	[birthdate] [datetime] NULL,
	[password] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Adminmaster] ON 

INSERT [dbo].[Adminmaster] ([id], [username], [password], [fullname], [email], [staffid], [role]) VALUES (1, N'admin', N'admin', N'Vu Manh Hung', N'hungvmgc00672@fpt.edu.vn', N'AD01', N'admin')
INSERT [dbo].[Adminmaster] ([id], [username], [password], [fullname], [email], [staffid], [role]) VALUES (2, N'hanh', N'nguyenhoangha', N'Nguyen Hoang Ha', N'hanh@fpt.edu.vn', N'AM122', NULL)
INSERT [dbo].[Adminmaster] ([id], [username], [password], [fullname], [email], [staffid], [role]) VALUES (3, N'dattv', N'tranvandat', N'Tran Van Dat', N'dattv@fpt.edu.vn', N'MIN11', NULL)
SET IDENTITY_INSERT [dbo].[Adminmaster] OFF
SET IDENTITY_INSERT [dbo].[Arena] ON 

INSERT [dbo].[Arena] ([id], [area]) VALUES (1, N'VIP')
INSERT [dbo].[Arena] ([id], [area]) VALUES (2, N'normal')
SET IDENTITY_INSERT [dbo].[Arena] OFF
SET IDENTITY_INSERT [dbo].[ContactUs] ON 

INSERT [dbo].[ContactUs] ([id], [name], [email], [phone], [content], [created]) VALUES (1, N'caocuquoccuong', N'quoccuong@fpt.edu.vn', N'', N'khong dat duoc ve online', CAST(0x0000000000000000 AS DateTime))
INSERT [dbo].[ContactUs] ([id], [name], [email], [phone], [content], [created]) VALUES (2, N'duyanhle', N'duyanhle@fpt.edu.vn', N'', N'khong xem duoc thong tin tai khoan', CAST(0x0000000000000000 AS DateTime))
INSERT [dbo].[ContactUs] ([id], [name], [email], [phone], [content], [created]) VALUES (3, N'datbt', N'datbt@fpt.edu.vn', N'', N'khong dang ki duoc tai khoan', CAST(0x0000000000000000 AS DateTime))
SET IDENTITY_INSERT [dbo].[ContactUs] OFF
SET IDENTITY_INSERT [dbo].[Event] ON 

INSERT [dbo].[Event] ([id], [typeid], [DateStart], [eventname], [content], [enventImg], [location], [created]) VALUES (1, 1, CAST(0x0000A4BD00735B40 AS DateTime), N'Good kill', N'Tom Egan m?t phi công lái máy bay chi?n d?u t? d?ng cho quân d?i M? có thành tích trong vi?c tiêu di?t nh?ng m?c tiêu khó c?a Taliban. Tuy nhiên b?ng m?t ngày anh nh?n du?c m?t d? ngh? yêu c?u ngh? n?a bu?i trong ngày', N'1.jpg', 1, CAST(0x0000A4AD00735B40 AS DateTime))
INSERT [dbo].[Event] ([id], [typeid], [DateStart], [eventname], [content], [enventImg], [location], [created]) VALUES (2, 1, CAST(0x0000A4C700735B40 AS DateTime), N'Spy', N'Susan Cooper-N? nhân viên phân tích c?a CIA không d?p, không gi?i ti?p xúc v?i dàn ông và su?t ngày g?n bó v?i ...công vi?c bàn gi?y nhung l?i là m?t ngu?i hùng th?m l?ng d?ng sau nh?ng chi?n d?ch nguy hi?m.', N'2.jpg', 3, CAST(0x0000A4AD00735B40 AS DateTime))
INSERT [dbo].[Event] ([id], [typeid], [DateStart], [eventname], [content], [enventImg], [location], [created]) VALUES (3, 1, CAST(0x0000A4BE00735B40 AS DateTime), N'Mad Max: fury road', N'Ngày t?n th? ? vùng d?t xa xôi c?a Trái Ð?t trong khung c?nh sa m?c kh?c nghi?t, Th? gi?i ch? còn l?i hai ngu?i có kh? nang khôi ph?c l?i tr?t t? th? gi?i. Max- m?t ngu?i dàn ông ki?m l?i, thích hành d?ng và luôn b? ám ?nh b?i quá kh? bi th?m liên quan d?n cái cái ch?t c?a nh?ng ngu?i thân và Furiosa- ngu?i ph? n? c?a hành d?ng v?i ni?m tin r?ng s? s?ng sót n?u vu?t qua du?c sa m?c', N'3.jpg', 4, CAST(0x0000A4AD00735B40 AS DateTime))
INSERT [dbo].[Event] ([id], [typeid], [DateStart], [eventname], [content], [enventImg], [location], [created]) VALUES (4, 2, CAST(0x0000A4BD00735B40 AS DateTime), N'Mr.Dam Live Show', N'7 nam sau liveshow Thuong hoa`i nga`n nam gây ra tiê´ng vang lo´n cu~ng nhu la` mô?t trong nhu~ng cô?t mô´c quan tro?ng trong su? nghiê?p cu?a Ða`m Vi~nh Hung, sa´ng 17/11, nam ca si~ va` ê-ki´p da~ công bô´ du? a´n liveshow Thuong hoài ngàn nam 2.', N'4.jpg', 1, CAST(0x0000A4AD00735B40 AS DateTime))
INSERT [dbo].[Event] ([id], [typeid], [DateStart], [eventname], [content], [enventImg], [location], [created]) VALUES (5, 2, CAST(0x0000A4C700735B40 AS DateTime), N'My Tam liveshow "Heartbeat"', N'Sau thành công c?a live concert Heartbeat vào nam ngoái, M? Tâm quy?t d?nh tái hi?n không khí c?a chuong trình b?ng hai dêm di?n d? ki?n di?n ra vào 22/4 ', N'5.jpg', 3, CAST(0x0000A4AD00735B40 AS DateTime))
INSERT [dbo].[Event] ([id], [typeid], [DateStart], [eventname], [content], [enventImg], [location], [created]) VALUES (6, 2, CAST(0x0000A4BE00735B40 AS DateTime), N'Quang Le - Hát trên quê huong 4', N'Liveshow Quang Lê – Ha´t trên quê huong l?n 4 v?i chu? dê` Ti`nh yêu & Nô~i nho´ diê~n ra va`o nga`y 25-4-2015, ta?i Sân khâ´u ca nha?c Lan Anh, TP.HCM.', N'6.jpg', 4, CAST(0x0000A4AD00735B40 AS DateTime))
INSERT [dbo].[Event] ([id], [typeid], [DateStart], [eventname], [content], [enventImg], [location], [created]) VALUES (7, 3, CAST(0x0000A4BD00735B40 AS DateTime), N'C?N CÓ AI ÐÓ Ð? YÊU THUONG', N' Nh?ng dóng góp ý ki?n v? vi?c bán vé xin g?i 08.38404027 ho?c nh?n tin 0903927170 (GD Hu?nh Anh Tu?n) ho?c a Th?o….!Xin Cám On s? quan tâm c?a quý khách.!!', N'7.jpg', 1, CAST(0x0000A4AD00735B40 AS DateTime))
INSERT [dbo].[Event] ([id], [typeid], [DateStart], [eventname], [content], [enventImg], [location], [created]) VALUES (8, 3, CAST(0x0000A4C700735B40 AS DateTime), N'Nàng Công Chúa Ði L?c', N' Nh?ng dóng góp ý ki?n v? vi?c bán vé xin g?i 08.38404027 ho?c nh?n tin 0903927170 (GD Hu?nh Anh Tu?n) ho?c a Th?o….!Xin Cám On s? quan tâm c?a quý khách.!!', N'8.jpg', 3, CAST(0x0000A4AD00735B40 AS DateTime))
INSERT [dbo].[Event] ([id], [typeid], [DateStart], [eventname], [content], [enventImg], [location], [created]) VALUES (9, 3, CAST(0x0000A4BE00735B40 AS DateTime), N'NGU QUÝ K? PHÙNG', N' Nh?ng dóng góp ý ki?n v? vi?c bán vé xin g?i 08.38404027 ho?c nh?n tin 0903927170 (GD Hu?nh Anh Tu?n) ho?c a Th?o….!Xin Cám On s? quan tâm c?a quý khách.!!.', N'9.jpg', 4, CAST(0x0000A4AD00735B40 AS DateTime))
INSERT [dbo].[Event] ([id], [typeid], [DateStart], [eventname], [content], [enventImg], [location], [created]) VALUES (10, 4, CAST(0x0000A4BD00735B40 AS DateTime), N'DTQG VI?T NAM - MU', N' Nh?ng dóng góp ý ki?n v? vi?c bán vé xin g?i 08.38404027 ho?c nh?n tin 0903927170 (GD Hu?nh Anh Tu?n) ho?c a Th?o….!Xin Cám On s? quan tâm c?a quý khách.!!', N'10.jpg', 1, CAST(0x0000A4AD00735B40 AS DateTime))
INSERT [dbo].[Event] ([id], [typeid], [DateStart], [eventname], [content], [enventImg], [location], [created]) VALUES (11, 4, CAST(0x0000A4C700735B40 AS DateTime), N'DTQG VI?T NAM - Chealsea', N' Nh?ng dóng góp ý ki?n v? vi?c bán vé xin g?i 08.38404027 ho?c nh?n tin 0903927170 (GD Hu?nh Anh Tu?n) ho?c a Th?o….!Xin Cám On s? quan tâm c?a quý khách.!!', N'11.jpg', 3, CAST(0x0000A4AD00735B40 AS DateTime))
INSERT [dbo].[Event] ([id], [typeid], [DateStart], [eventname], [content], [enventImg], [location], [created]) VALUES (12, 4, CAST(0x0000A4BE00735B40 AS DateTime), N'DTQG VI?T NAM - DTQG TRUNG QU?C', N' Nh?ng dóng góp ý ki?n v? vi?c bán vé xin g?i 08.38404027 ho?c nh?n tin 0903927170 (GD Hu?nh Anh Tu?n) ho?c a Th?o….!Xin Cám On s? quan tâm c?a quý khách.!!.', N'12.jpg', 4, CAST(0x0000A4AD00735B40 AS DateTime))
SET IDENTITY_INSERT [dbo].[Event] OFF
SET IDENTITY_INSERT [dbo].[FAQ] ON 

INSERT [dbo].[FAQ] ([id], [question], [answer]) VALUES (2, N'sdfas', N'sdfasdfag76574567537')
INSERT [dbo].[FAQ] ([id], [question], [answer]) VALUES (3, N'asdf', N'asdf')
INSERT [dbo].[FAQ] ([id], [question], [answer]) VALUES (5, N'adssdfdfsdsfdfdsf', N'asfaf')
INSERT [dbo].[FAQ] ([id], [question], [answer]) VALUES (6, N'fjhgfhhgynjvjhjj', N'ddasdadasddfdff')
SET IDENTITY_INSERT [dbo].[FAQ] OFF
SET IDENTITY_INSERT [dbo].[location] ON 

INSERT [dbo].[location] ([id], [city], [address]) VALUES (1, N'Ha Noi', N'so 1 duong Lac Long Quan')
INSERT [dbo].[location] ([id], [city], [address]) VALUES (2, N'Ha Noi', N'so 148 duong Giang Vo')
INSERT [dbo].[location] ([id], [city], [address]) VALUES (3, N'Da Nang', N'so 102 Le Loi')
INSERT [dbo].[location] ([id], [city], [address]) VALUES (4, N'TP Ho Chi Minh', N'so 97 Nguyen Thi Minh Khai')
INSERT [dbo].[location] ([id], [city], [address]) VALUES (5, N'TP Ho Chi Minh', N'so 77-89 phuong Ben Thanh - quan 1')
SET IDENTITY_INSERT [dbo].[location] OFF
SET IDENTITY_INSERT [dbo].[Price] ON 

INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (1, 50, 1, 1, 80)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (2, 50, 1, 2, 50)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (3, 100, 2, 1, 15)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (4, 100, 2, 2, 10)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (5, 50, 3, 1, 180)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (6, 50, 3, 2, 80)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (7, 50, 4, 1, 35)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (8, 50, 4, 2, 15)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (9, 30, 5, 1, 15)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (10, 30, 5, 2, 5)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (11, 200, 6, 1, 50)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (12, 200, 6, 2, 10)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (13, 50, 7, 1, 180)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (14, 50, 7, 2, 80)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (15, 50, 8, 1, 35)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (16, 50, 8, 2, 15)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (17, 30, 9, 1, 15)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (18, 30, 9, 2, 5)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (19, 200, 10, 1, 50)
INSERT [dbo].[Price] ([id], [quantity], [eventid], [arenaId], [price]) VALUES (20, 200, 10, 2, 10)
SET IDENTITY_INSERT [dbo].[Price] OFF
SET IDENTITY_INSERT [dbo].[Type] ON 

INSERT [dbo].[Type] ([id], [typeName]) VALUES (1, N'Movie')
INSERT [dbo].[Type] ([id], [typeName]) VALUES (2, N'Music')
INSERT [dbo].[Type] ([id], [typeName]) VALUES (3, N'Drama')
INSERT [dbo].[Type] ([id], [typeName]) VALUES (4, N'Sports')
SET IDENTITY_INSERT [dbo].[Type] OFF
SET IDENTITY_INSERT [dbo].[user] ON 

INSERT [dbo].[user] ([id], [username], [firstname], [lastname], [type], [telephone], [email], [address], [bankAccount], [created], [birthdate], [password]) VALUES (1, N'caocuquoccuong', N'Cao Cu Quoc', N'Cuong', N'customer', N'01234444666', N'quoccuong@fpt.edu.vn', N'Nghe An', N'1496631908749', N'22:30:00', CAST(0x0000862B00000000 AS DateTime), N'123456789')
INSERT [dbo].[user] ([id], [username], [firstname], [lastname], [type], [telephone], [email], [address], [bankAccount], [created], [birthdate], [password]) VALUES (2, N'duyanhle', N'Le Duy', N'Anh', N'customer', N'09123456789', N'duyanhle@fpt.edu.vn', N'Ha Noi', N'318918492189', N'22:00:00', CAST(0x000087E100000000 AS DateTime), N'123456789')
SET IDENTITY_INSERT [dbo].[user] OFF
ALTER TABLE [dbo].[ContactUs] ADD  DEFAULT (getdate()) FOR [created]
GO
ALTER TABLE [dbo].[Event] ADD  DEFAULT (getdate()) FOR [created]
GO
ALTER TABLE [dbo].[order] ADD  DEFAULT (getdate()) FOR [created]
GO
ALTER TABLE [dbo].[Ticket] ADD  DEFAULT (getdate()) FOR [created]
GO
ALTER TABLE [dbo].[Event]  WITH CHECK ADD FOREIGN KEY([location])
REFERENCES [dbo].[location] ([id])
GO
ALTER TABLE [dbo].[Event]  WITH CHECK ADD FOREIGN KEY([typeid])
REFERENCES [dbo].[Type] ([id])
GO
ALTER TABLE [dbo].[order]  WITH CHECK ADD FOREIGN KEY([userOrder])
REFERENCES [dbo].[user] ([id])
GO
ALTER TABLE [dbo].[orderDetail]  WITH CHECK ADD FOREIGN KEY([orderId])
REFERENCES [dbo].[order] ([id])
GO
ALTER TABLE [dbo].[orderDetail]  WITH CHECK ADD FOREIGN KEY([PriceId])
REFERENCES [dbo].[Price] ([id])
GO
ALTER TABLE [dbo].[Price]  WITH CHECK ADD FOREIGN KEY([arenaId])
REFERENCES [dbo].[Arena] ([id])
GO
ALTER TABLE [dbo].[Price]  WITH CHECK ADD FOREIGN KEY([eventid])
REFERENCES [dbo].[Event] ([id])
GO
ALTER TABLE [dbo].[Ticket]  WITH CHECK ADD FOREIGN KEY([orderDetailid])
REFERENCES [dbo].[orderDetail] ([id])
GO
ALTER TABLE [dbo].[Ticket]  WITH CHECK ADD FOREIGN KEY([priceid])
REFERENCES [dbo].[Price] ([id])
GO
