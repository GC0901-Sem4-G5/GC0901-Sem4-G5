<%-- 
    Document   : index
    Created on : May 16, 2015, 4:42:50 PM
    Author     : Hoang Ha Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EasyTickets G5</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="javascript/image_slide.js" type="text/javascript"></script>
        <script src="javascript/jquery.js" type="text/javascript"></script>
        <script src="javascript/modernizr-1.5.min.js" type="text/javascript"></script>
    </head>
    <body>
        <header>
            <div id="strapline">
                <div id="welcome_slogan">
                    <h3>Welcome To Easy Tickets <span>G5</span></h3>
                </div>
            </div>	  
            <nav>
                <div id="menubar">
                    <ul id="nav">
                        <li class="current"><a href="index.html">Home</a></li>
                        <li><a href="events.jsp">Events</a></li>
                        <li><a href="contact.jsp">Contact Us</a></li>
                        <li><a href="aboutus.jsp">About Us</a></li>
                    </ul>
                </div>	
            </nav>
        </header>
        <div id="slideshow_container">  
            <div class="slideshow">
                <ul class="slideshow">
                    <li class="show"><img width="940" height="250" src="images/home_1.jpg" alt="&quot;Enter your caption here&quot;" /></li>
                    <li><img width="940" height="250" src="images/home_2.jpg" alt="&quot;Enter your caption here&quot;" /></li>
                </ul> 
            </div> 	
        </div>  
        <div id="site_content">		
            <div class="sidebar_container">       
                <div class="sidebar">
                    <div class="sidebar_item">
                        <h2>ESCAPE RAIN FOREST</h2>
                        <p>Mùa hè chưa bao giờ hết nhiệt!! Hãy chuẩn bị tinh thần cho những cuộc vui không có điểm dừng cùng các Raver tại Escape Rain Forest 2015 ngày 16/5/2015.</p>
                    </div>
                </div>  		
                <div class="sidebar">
                    <div class="sidebar_item">
                        <h2>Latest Update</h2>
                        <h3>May 29th 2015</h3>
                        <p>VIBRATION EVENTS FEATURING ALY & FILA IN HANOI</p>         
                    </div>
                </div>
                <div class="sidebar">
                    <div class="sidebar_item">
                        <h3>Today - May 16th 2015</h3>
                        <p>CA TRÙ THĂNG LONG.</p>         
                    </div>
                </div>		
                <div class="sidebar">
                    <div class="sidebar_item">
                        <h2>Contact</h2>
                        <p>Phone: +84 (0)1234 567891</p>
                        <p>Email: <a href="mailto:info@showbiz.com">info@showbiz.com</a></p>
                    </div> 
                </div>
            </div>	

            <div id="content">
                <div class="content_item">
                    <h1>Welcome To G5's EasyTickets Website</h1> 
                    <p>ĐÂY LÀ ĐOẠN TEXT GIỚI THIỆU BLAAAAAAAAAAAAAAAAAAAA</p>   		
                    <p>DƯỚI NÀY CŨNG LÀ ĐOẠN TEXT GIỚI THIỆU. BLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA</p>

                    <div class="content_container">
                        <p>Ở ĐÂY CŨNG VẬY NỐT</p>
                        <div class="button_small">
                            <a href="#">Read more</a>
                        </div>
                    </div>
                    <div class="content_container">
                        <p>CŨNG THẾ LUÔN</p>          
                        <div class="button_small">
                            <a href="#">Read more</a>
                        </div>		  
                    </div>	

                </div>
            </div>   
        </div>  	

        <footer>
            <a href="index.jsp">Home</a> | <a href="events.jsp">Events</a> | <a href="contact.jsp">Contact Us</a> | <a href="about.jsp">About Us</a>
        </footer>

    </body>
</html>
