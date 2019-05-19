<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Upcoming Events</title>
<style type="text/css">
<%@include file="css/style1.css"%>
<%@include file="css/navigationBar.css"%>
<%@include file="css/rightColumn.css"%>
<%@include file="css/buttons.css"%>
<%@include file="css/textBox.css"%>
</style>
</head>
<body background="images/BackgroundImage1.jpg">
	<div class="wrapper">
		<div id="banner" class="header">
			<img src="images/upcomingEventBanner.jpg" width="1026px" height="350px"
				alt="">
		</div>
		<div class="navigation">
			<div>
				<ul class="menu-bar">
					<li><a href="mainHome.jsp">Home</a></li>
					<li><a href="galleryMain.jsp">Gallery</a></li>
					<li><a href="placeOrder.jsp">Place Order</a></li>
					<li><a href="aboutUs.jsp">About Us</a></li>
					<li><a href="help.jsp">Help</a></li>
				</ul>
			</div>
		</div>
		<div class="contentliquid">
			<div class="left">
					<h3 style="font-family: arial; color: #2175bc;">Event Updates</h3><hr/>
	<div style="background-color: rgba(50, 150, 50, 0.1); width:87%;
								color: rgba(50, 150, 50, 1); border-radius:10px;">
  	<jsp:useBean id="uevent" class="bean.UpcomingEventData"></jsp:useBean>
  	<table style="margin-left: 20px; font-face: bold; font-family: arial;
  						text-align: center;" cellpadding="10">
  	   	<tr>
  	   		<td style="color:#2175bc; font-face: bold; font-size: 18px;">New Event Name</td>
  	   		<td style="color:#2175bc; font-face: bold; font-size: 18px;">Description</td>
  	   		<td style="color:#2175bc; font-face: bold; font-size: 18px;">Starting Date</td>
  	   	</tr>
  	   	<c:forEach items="${uevent.allUpcomingEvent}" var="uevent">
  	   	<tr>
  	   		<td style="color:#424242; font-size:16px;">${uevent.ueventname}</td>
  	   		<td style="color:#424242; font-size:16px;">${uevent.uedescription}</td>
  	   		<td style="color:#424242; font-size:16px;">${uevent.ueventstartdate}</td>
  	   	</tr>
  	   	<tr><td>&nbsp;</td></tr>
  	   	</c:forEach>
  	</table>
  	</div>
  	<div>&nbsp;</div>
	</div>
		<div class="button">
  			<ul>
   				 <li><a href="login.jsp">Log In</a></li>
   				 <li><a href="signUp.jsp">Sign Up</a></li>
    			 <li><a href="employee.jsp">Career</a></li>
    			 <li><a href="upcomingEventDisplay.jsp">Event Update</a></li>
  			</ul>
		</div>
		<div class="footer">
			<p>All Right Reserved © 2015 ~ Celebration Hut</p>
		</div>
	</div>
	</div>
</body>
</html>