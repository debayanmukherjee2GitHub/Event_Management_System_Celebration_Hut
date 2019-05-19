<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
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
		<div class="header">
			<img src="images/signUpBanner.jpg" width="1026" height="350px"
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
				<h3  style="font-family: arial; color: #2175bc;">Sign Up ...</h3><hr/>
				<form action="addCustomer" method="post">
					<table style="margin-left: 20px; font-face: bold; font-family: arial" cellpadding="5">
					
					<tr>
						<td>First Name:</td><td><input type="text" name="ufname" class="tb10"></td>
					</tr>
					<tr>
						<td>Last Name:</td><td><input type="text" name="ulname" class="tb10"></td>
					</tr>
					<tr>
						<td>D.O.B:</td><td><input type="date" name="udob" class="tb10"></td>
					</tr>
					<tr>
						<td>Gender:</td>
						<td>
							<select name="ugender" class="tb10">
								<option>--</option>
								<option>Male</option>
								<option>Female</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Email:</td><td><input type="text" name="umail" class="tb10"></td>
					</tr>
					<tr>
						<td>Contact No.:</td><td><input type="number" name="ucontact" class="tb10"></td>
					</tr>
					<tr>
						<td>Current Location:</td>
						<td>
							<select name="ulocation" class="tb10">
								<option>--</option>
								<option>Ahmedabad</option>
								<option>Bengaluru</option>
								<option>Chennai</option>
								<option>Delhi</option>
								<option>Hyderabad</option>
								<option>Kolkata</option>
								<option>Mumbai</option>
								<option>Pune</option>							
							</select>
						</td>
					</tr>
					<tr>
						<td>Password:</td><td><input type="password" name="upassword" class="tb10"></td>
					</tr>
					<tr>
						<td>Confirm Password:</td><td><input type="password" name="uconfirmpassword" class="tb10"></td>
					</tr>
					<tr>
						<td><input type="submit" name="btnSignup" class="testbutton"></td>
						<td><input class="testbutton" type="reset" name="resetSignup"></td>
					</tr>
					
					</table>
				</form>
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