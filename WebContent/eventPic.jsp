<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Celebration Pictures</title>
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
			<img src="images/banner.JPG" width="1024" height="310px"
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
					<h3>Add Event Pictures</h3><hr/>
  	<form action="addImage" method="post" enctype="multipart/form-data">
  	<table style="margin-left: 20px; font-face: bold; font-family: arial" cellpadding="5">
  	 <tr>
  	   	 <td>Event Title : </td><td><input type="text" name="epictitle" class="tb10"/></td>
  	 </tr>
  	 <tr>
  	   	 <td>Event Description : </td><td><input type="text" name="epicdescription" class="tb10"/></td>
  	 </tr>
  	 <tr>
  	 	<td>Upload Image :</td><td><input type="file" name="epicimage" class="tb10"/></td>
  	 </tr>
  	 <tr>
  	 	<td><input type="submit" name="btnAddEventPic" value="Upload" class="testbutton"></td>
  	 	<td><input class="testbutton" type="reset" name="resetEventPic"></td>
  	 </tr>  	
  	</table>
	${requestScope["msg"]}
  </form>	
	</div>
		<div class="button">
  			<ul>
   				 <li><a href="login.jsp">Logout</a></li>
   				 <li><a href="signUp.jsp">Sign Up</a></li>
    				<li><a href="employee.jsp">Career</a></li>
    				<li><a href="upcomingEventDisplay.jsp">Event Update</a></li>
  			</ul>
		</div>
		<div class="footer">
			<p>All Right Reserved � 2015 ~ Celebration Hut</p>
		</div>
	</div>
	</div>
</body>
</html>