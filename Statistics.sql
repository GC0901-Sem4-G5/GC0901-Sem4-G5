select * from OrderDetail
Select MONTH([order].created) as 'THANG', Sum(orderDetail.total) as 'Doanh thu'
From orderdetail
INNER JOIN [order]
ON [order].id = orderDetail.orderId
Group by MONTH([order].created)

Select DAY([order].created) as 'NGAY', Sum(orderDetail.total) as 'Doanh thu'
From orderdetail
INNER JOIN [order]
ON [order].id = orderDetail.orderId
Group by DAY([order].created)

Select YEAR([order].created) as 'NGAY', Sum(orderDetail.total) as 'Doanh thu'
From orderdetail
INNER JOIN [order]
ON [order].id = orderDetail.orderId
Group by YEAR([order].created)