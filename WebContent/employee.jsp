<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Career</title>
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
			<img src="images/careerBanner1.jpg" width="1026px" height="350px"
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
				<h3   style="font-family: arial; 
							color: #2175bc;">Apply for a job at Celebration Hut</h3><hr/>
				
				<form action="addEmployee" method="post" enctype="multipart/form-data">
					<table style="margin-left: 20px; font-face: bold; font-family: arial" cellpadding="5">
					<tr>
						<td>First Name:</td><td><input type="text" name="empfname" class="tb10">
					</tr>
					<tr>
						<td>Last Name:</td><td><input type="text" name="emplname" class="tb10"></td>
					</tr>
					<tr>
						<td>Address:</td><td><textarea rows="5" cols="30" name="empaddress" class="ta10"></textarea></td>
					</tr>
					<tr>
						<td>D.O.B:</td><td><input type="date" name="empdob" class="tb10"></td>
						<td>Gender:</td>
							<td>
								<select name="empgender" class="tb10">
									<option>Male</option>
									<option>Female</option>							
								</select>
							</td>
					</tr>
					<tr>
						<td>Email:</td><td><input type="text" name="empmail" class="tb10"></td>
					</tr>
					<tr>
						<td>Contact No.:</td><td><input type="number" name="empcontact" class="tb10"></td>
					</tr>
					<tr>
						<td>Highest Qualification:</td>
						<td>
							<select name="emphq" class="tb10">
								<option>-Select-</option>
								<option>Post Graduation</option>
								<option>Graduation</option>
								<option>10+2 / Higher Secondary</option>
								<option>10th</option>							
							</select>
						</td>
					</tr>
					<tr>
						<td>Upload Photo:</td>
						<td><input type="file" name="empphoto" class="tb10"></td>
					</tr>
					<tr>
						<td>Upload CV/Resume:</td>
						<td><input type="file" name="empcv" class="tb10"></td>
					</tr>
					<tr>
						<td>Password:</td><td><input type="password" name="emppassword" class="tb10"></td>
					</tr>
					<tr>
						<td>Confirm Password:</td><td><input type="password" name="empconfirmpassword"
						 									class="tb10"></td>
					</tr>
					<tr>
						<td><input type="submit" name="btnAddemp" class="testbutton" 
												value="Submit"></td>
						<td><input class="testbutton" type="reset" name="resetEmp"></td>
					</tr>
					<tr>
						
						<td>${requestScope["msg"]}</td>
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