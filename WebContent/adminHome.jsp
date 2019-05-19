<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
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
			<img src="images/adminHomeBanner2.jpg" width="1026px" height="340px"
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
					<form action="" method="post">
						<table>
							<tr>
								<td style="font-size:18px; font-face:normal; font-family:arial;
		 		text-align: center; background-color: rgba(50, 150, 50, 0.3); padding:10px; color:#424242;
		 		color: rgba(50, 150, 50, 1); border-radius:5px; width:150px; height:150px;">
		 								<a href="adminInsert.jsp" 
		 									style="color:#424242; text-decoration: none !important;">
		 											Add New Admin
		 								</a>
		 						</td>
		 						<td style="width:5px; height:150px;"></td>
								<td style="font-size:18px; font-face:normal; font-family:arial;
		 		text-align: center; background-color: rgba(50, 150, 50, 0.3); padding:10px; color:#424242;
		 		color: rgba(50, 150, 50, 1); border-radius:5px; width:150px; height:150px;">
		 								<a href="eventPic.jsp"
		 									style="color:#424242; text-decoration: none !important;">
		 											Add Events
		 								</a>
		 						</td>
		 						<td style="width:5px; height:150px;"></td>
								<td style="font-size:18px; font-face:normal; font-family:arial;
		 		text-align: center; background-color: rgba(50, 150, 50, 0.3); padding:10px; color:#424242;
		 		color: rgba(50, 150, 50, 1); border-radius:5px; width:150px; height:150px;">
										<a href="upcomingEvent.jsp" style="color:#424242; 
															text-decoration: none !important;">
													Add Upcoming Events
												</a>
								</td>
								<td style="width:5px; height:150px;"></td>
								<td style="font-size:18px; font-face:normal; font-family:arial;
		 		text-align: center; background-color: rgba(50, 150, 50, 0.3); padding:10px; color:#424242;
		 		color: rgba(50, 150, 50, 1); border-radius:5px; width:150px; height:150px;">
										<a href="addEmp.jsp" style="color:#424242; 
															text-decoration: none !important;">
													View Employee Details
										</a>
								</td>
							</tr>
						</table>
					</form>
					<br>
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