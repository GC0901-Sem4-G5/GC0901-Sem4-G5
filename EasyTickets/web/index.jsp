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
                        <li class="current"><a href="index.jsp">Home</a></li>
                        <li><a href="events.jsp">Events</a></li>
                        <li><a href="contact.jsp">Contact Us</a></li>
                        <li><a href="aboutus.jsp">About Us</a></li>
                        <li><a style="margin-left: 300px" href="signup.jsp">Sign Up</a></li>
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

        <footer>
            <a href="index.jsp">Home</a> | <a href="events.jsp">Events</a> | <a href="contact.jsp">Contact Us</a> | <a href="about.jsp">About Us</a>
        </footer>

    </body>
</html>
