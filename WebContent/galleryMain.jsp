<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gallery</title>
<style type="text/css">
<%@include file="css/style1.css"%>
<%@include file="css/navigationBar.css"%>
<%@include file="css/rightColumn.css"%>
<%@include file="css/buttons.css"%>
<%@include file="css/fontCss.css"%>
<%@include file="css/event1.css"%>
<%@include file="css/event2.css"%>
<%@include file="css/event3.css"%>
<%@include file="css/event4.css"%>
</style>
</head>
<body background="images/BackgroundImage1.jpg">
	<div class="wrapper">
		<div>
			<img src="images/bannerGallery.JPG" width="1026px" height="310px"
				alt="bannerGallery">
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
				<h2 style="color: #2175bc; font-family: arial;">Gallery ...</h2><hr>
				<div style="text-align:center;">
					<jsp:useBean id="event" class="bean.EventPic"></jsp:useBean>
					<c:forEach items="${event.allEventPic}" var="event">
						<img src="data:image/jpeg;base64,${event.getEventImageAsString()}"
								width="350px" height="250px"/>
					</c:forEach>
				</div>
				
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