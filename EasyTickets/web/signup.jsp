<%-- 
    Document   : signup
    Created on : May 18, 2015, 1:45:16 PM
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
        <title>JSP Page</title>
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
            <form action="index.html" method="post">

                <h1>Sign Up</h1>

                <fieldset>
                    <legend><span class="number">1</span>Your basic info</legend>
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="user_name">

                    <label for="mail">Email:</label>
                    <input type="email" id="mail" name="user_email">

                    <label for="password">Password:</label>
                    <input type="password" id="password" name="user_password">

                    <label>Age:</label>
                    <input type="radio" id="under_13" value="under_13" name="user_age"><label for="under_13" class="light">Under 13</label><br>
                    <input type="radio" id="over_13" value="over_13" name="user_age"><label for="over_13" class="light">13 or older</label>
                </fieldset>

                <fieldset>
                    <legend><span class="number">2</span>Your profile</legend>
                    <label for="bio">Biography:</label>
                    <textarea id="bio" name="user_bio"></textarea>
                </fieldset>
                <fieldset>
                    <label for="job">Job Role:</label>
                    <select id="job" name="user_job">
                        <optgroup label="Web">
                            <option value="frontend_developer">Front-End Developer</option>
                            <option value="php_developor">PHP Developer</option>
                            <option value="python_developer">Python Developer</option>
                            <option value="rails_developer"> Rails Developer</option>
                            <option value="web_designer">Web Designer</option>
                            <option value="WordPress_developer">WordPress Developer</option>
                        </optgroup>
                        <optgroup label="Mobile">
                            <option value="Android_developer">Androild Developer</option>
                            <option value="iOS_developer">iOS Developer</option>
                            <option value="mobile_designer">Mobile Designer</option>
                        </optgroup>
                        <optgroup label="Business">
                            <option value="business_owner">Business Owner</option>
                            <option value="freelancer">Freelancer</option>
                        </optgroup>
                        <optgroup label="Other">
                            <option value="secretary">Secretary</option>
                            <option value="maintenance">Maintenance</option>
                        </optgroup>
                    </select>

                    <label>Interests:</label>
                    <input type="checkbox" id="development" value="interest_development" name="user_interest"><label class="light" for="development">Development</label><br>
                    <input type="checkbox" id="design" value="interest_design" name="user_interest"><label class="light" for="design">Design</label><br>
                    <input type="checkbox" id="business" value="interest_business" name="user_interest"><label class="light" for="business">Business</label>

                </fieldset>
                <button type="sub<h1>Sign Up</h1>

                        <fieldset>
                        <legend><span class="number">1</span>Your basic info</legend>
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="user_name">

                    <label for="mail">Email:</label>
                    <input type="email" id="mail" name="user_email">

                    <label for="password">Password:</label>
                    <input type="password" id="password" name="user_password">

                    <label>Age:</label>
                    <input type="radio" id="under_13" value="under_13" name="user_age"><label for="under_13" class="light">Under 13</label><br>
                    <input type="radio" id="over_13" value="over_13" name="user_age"><label for="over_13" class="light">13 or older</label>
                    </fieldset>

                    <fieldset>
                        <legend><span class="number">2</span>Your profile</legend>
                        <label for="bio">Biography:</label>
                        <textarea id="bio" name="user_bio"></textarea>
                    </fieldset>
                    <fieldset>
                        <label for="job">Job Role:</label>
                        <select id="job" name="user_job">
                            <optgroup label="Web">
                                <option value="frontend_developer">Front-End Developer</option>
                                <option value="php_developor">PHP Developer</option>
                                <option value="python_developer">Python Developer</option>
                                <option value="rails_developer"> Rails Developer</option>
                                <option value="web_designer">Web Designer</option>
                                <option value="WordPress_developer">WordPress Developer</option>
                            </optgroup>
                            <optgroup label="Mobile">
                                <option value="Android_developer">Androild Developer</option>
                                <option value="iOS_developer">iOS Developer</option>
                                <option value="mobile_designer">Mobile Designer</option>
                            </optgroup>
                            <optgroup label="Business">
                                <option value="business_owner">Business Owner</option>
                                <option value="freelancer">Freelancer</option>
                            </optgroup>
                            <optgroup label="Other">
                                <option value="secretary">Secretary</option>
                                <option value="maintenance">Maintenance</option>
                            </optgroup>
                        </select>

                        <label>Interests:</label>
                        <input type="checkbox" id="development" value="interest_development" name="user_interest"><label class="light" for="development">Development</label><br>
                        <input type="checkbox" id="design" value="interest_design" name="user_interest"><label class="light" for="design">Design</label><br>
                        <input type="checkbox" id="business" value="interest_business" name="user_interest"><label class="light" for="business">Business</label>

                    </fieldset>mit">Sign Up</button>
            </form>
            <nav>
                <div id="menubar">
                    <ul id="nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="events.jsp">Events</a></li>
                        <li><a href="contact.jsp">Contact Us</a></li>
                        <li><a href="aboutus.jsp">About Us</a></li>
                        <li class="current"><a style="margin-left: 300px" href="signup.jsp">Sign Up</a></li>
                    </ul>
                </div>	
            </nav>
        </header>
    </body>
</html>
