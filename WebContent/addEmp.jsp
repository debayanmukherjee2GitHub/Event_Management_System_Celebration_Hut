<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Verification Panel</title>
<style type="text/css">
<%@include file="css/style1.css"%>
<%@include file="css/navigationBar.css"%>
<%@include file="css/rightColumn.css"%>
<%@include file="css/buttons.css"%>
<%@include file="css/fontCss.css"%>
</style>
</head>
<body  background="images/BackgroundImage1.jpg">
	<div class="wrapper">
		<div>
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
			
					<c:if test="${empty sessionScope['adminlog']}">
						<c:redirect url="adminLogin.jsp"/>
					</c:if>
					<jsp:useBean id="abean" class="bean.Admin"></jsp:useBean>
					<c:set var="admin" value="${abean.getAdminById(sessionScope['adminlog'])}"/>				
					<h2   style="font-family: arial; color: #2175bc;">Welcome 
							${admin.adminname} , ID: ${admin.adminid}</h2><hr/>
							
				<div style="background-color: rgba(50, 150, 50, 0.1); width:87%;
								color: rgba(50, 150, 50, 1); border-radius:10px;">
								
					<jsp:useBean id="emp" class="bean.Employee"></jsp:useBean>
					
						<table style="margin-left: 10px; font-face: bold; font-family: arial" 
								cellpadding="10">
	
							<c:forEach items="${emp.allEmployee}" var="emp">
								<tr>
									<td>Employee ID :</td>
									<td style="color:#424242;">${emp.empid}</td>
									<td>Photo:</td>	
									<td style="color:#424242; width: 150px; height: 150px;">
										<img src="data:image/jpeg;base64,${emp.getImageAsString()}" 
													width="100"/>
									</td>
								</tr>
								<tr>
									<td>Name : </td>	
									<td style="color:#424242;">${emp.empfname} ${emp.emplname}</td>
									<td>CV:</td>
									<td style="color:#424242;"><a href="downloadCV?empid=${emp.empid}">Download CV</a></td>
								</tr>
								<tr>
									<td>DOB : </td>	
									<td style="color:#424242;">${emp.empdob}</td>
								</tr>
								<tr>
									<td>Gender : </td>	
									<td style="color:#424242;">${emp.empgender}</td>
								</tr>
								<tr>
									<td>Email : </td>	
									<td style="color:#424242;">${emp.empmail}</td>
								</tr>
								<tr>
									<td>Contact No. : </td>	
									<td style="color:#424242;">${emp.empcontact}</td>
								</tr>
								<tr>
									<td>Highest Qualification : </td>	
									<td style="color:#424242;">${emp.emphq}</td>
								</tr>
								<tr><td></td></tr>
								
							</c:forEach>
								
						</table>
						<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
					</div>
					<div>&nbsp;</div>
				</div>
		<div class="button">
  			<ul>
   				 <li><a href="adminlogout">Logout</a></li>
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