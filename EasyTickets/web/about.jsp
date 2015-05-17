<%-- 
    Document   : about
    Created on : May 17, 2015, 11:41:15 PM
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
        <title>About Us</title>
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
                        <li><a href="index.html">Home</a></li>
                        <li><a href="events.jsp">Events</a></li>
                        <li><a href="contact.jsp">Contact Us</a></li>
                        <li class="current"><a href="about.jsp">About Us</a></li>
                    </ul>
                </div>	
            </nav>
        </header>
        <div id="slideshow_container">  
            <div class="slideshow">
                <ul class="slideshow">
                    <li class="show"><img width="940" height="250" src="images/aboutus.jpg" alt="&quot;Enter your caption here&quot;" /></li>
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
                    <div class="form_settings">
                        <h2>About Us</h2>
                        <p style="padding-bottom: 15px;">‘Showbiz‘is the company is principally into ticket sales, marketing and distribution of event tickets. The services include providing information on multiple event categories, providing ticketing facilities for several leading multiplexes, arenas and stadiums. They are thinking of the concept of developing a web portal, where a customer can book movie tickets in theatres that are made available in the site. They wish to launch the website by the name ‘www.easytickets.com’ where they can provide convenient, secure, and fair access to the best possible tickets offered by the clients. Showbiz aims at making events happening across the city more accessible-just a click away. Booking tickets can now an effortless, fun and exciting experience for every showbiz customer.</p>             
                    </div><!--close form_settings-->
                </div><!--close content_item-->
            </div><!--close content-->   
        </div><!--close site_content-->  

        <footer>
            <a href="index.jsp">Home</a> | <a href="events.jsp">Events</a> | <a href="contact.jsp">Contact Us</a> | <a href="about.jsp">About Us</a>
        </footer>
    </body>
</html>
