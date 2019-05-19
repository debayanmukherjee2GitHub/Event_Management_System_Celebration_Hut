<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details</title>
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
					<c:if test="${empty sessionScope['emplog']}">
						<c:redirect url="empLogin.jsp"/>
					</c:if>
					<jsp:useBean id="ebean" class="bean.Employee"></jsp:useBean>
					<c:set var="emp" value="${ebean.getEmployeeById(sessionScope['emplog'])}"/>	
								
					<h2   style="font-family: arial; color: #2175bc;">Welcome 
							${emp.empfname} , ID: ${emp.empid}</h2><hr/> 
					
					
							
				<div style="background-color: rgba(50, 150, 50, 0.1); width:80%;
								color: rgba(50, 150, 50, 1); border-radius:10px;">
								
					<jsp:useBean id="cust" class="bean.Customer"></jsp:useBean>
						<table style="margin-left: 20px; font-face: bold; font-family: arial" 
								cellpadding="2">
							<c:forEach items="${cust.allCustomer}" var="cust">
								<tr>
									<td>Customer ID :</td>
									<td>${cust.uid}</td>
								</tr>
								<tr>
									<td>Name : </td>	
									<td>${cust.ufname} ${cust.ulname}</td>
								</tr>
								<tr>
									<td>Gender : </td>	
									<td>${cust.ugender}</td>
								</tr>
								<tr>
									<td>D.O.B : </td>	
									<td>${cust.udob}</td>
								</tr>
								<tr>
									<td>Email : </td>	
									<td>${cust.umail}</td>
								</tr>
								<tr>
									<td>Contact No. : </td>	
									<td>${cust.ucontact}</td>
								</tr>
								<tr>
									<td>Location : </td>	
									<td>${cust.ulocation}</td>
								</tr>
								<tr>
									<td>
										__________________________
										</td>
										<td>
										______________________________
									</td>
								</tr>
								
							</c:forEach>
								
						</table>
						
					</div>
					<div>&nbsp;</div>
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
			<p>All Right Reserved © 2015 ~ Celebration Hut</p>
		</div>
	</div>
	</div>
</body>
</html>