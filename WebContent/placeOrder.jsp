<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Place Order</title>
<style type="text/css">
<%@include file="css/style1.css"%>
<%@include file="css/navigationBar.css"%>
<%@include file="css/rightColumn.css"%>
<%@include file="css/buttons.css"%>
<%@include file="css/fontCss.css"%>
<%@include file="css/textBox.css"%>
</style>
</head>
<body background="images/BackgroundImage1.jpg">
<div class="wrapper">
		<div>
			<img src="images/placeOrderBanner.jpg" width="1026px" height="310px"
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
			<c:if test="${empty sessionScope['customerlog']}">
						<c:redirect url="customerLogin.jsp"/>
					</c:if>
					<jsp:useBean id="cbean" class="bean.Customer"></jsp:useBean>
					<c:set var="customer" value="${cbean.getCustomerById(sessionScope['customerlog'])}"/>				
					<h2   style="font-family: arial; color: #2175bc;">Welcome 
							${customer.ufname} , ID: ${customer.uid}</h2>
				<h2 style="font-family: arial; color: #2175bc;">Place your order...</h2>
				<font style="color: red;">*</font>
				<font style="font-face: bold; font-family: arial; color: #2100bc;
							font-size: 18px;">Required Fields</font><hr/>
				<h3 style="color:green">${requestScope["msg"]}</h3>
				<form action="addOrder" method="post">
					<table style="margin-left: 20px; font-face: bold; font-family: arial" cellpadding="5">
					<tr>
						<td>Customer ID :</td>
						<td><input type=text name=uid value="${customer.uid }" class="tb10"></td>
					</tr>
					<tr>
						<td class="font6">Basic Information</td>
					</tr>
					<tr><td><br></td></tr>
					<tr>
						<td><font style="color: red;">*</font>Celebration Hall Name :</td>
						<td><input type="text" name="orderhname" required class="tb10"></td>
					</tr>
					<tr>
						<td><font style="color: red;">*</font>Celebration Hall Address :</td>
						<td><textarea rows="5" cols="30" name="orderhaddress"  required class="ta10"></textarea></td>
					</tr>
					<tr>
						<td><font style="color: red;">*</font>Celebration Date :</td>
						<td><input type="date" name="orderdate"  required class="tb10"></td>
					</tr>
					<tr><td><br></td></tr>
					<tr>
						<td class="font6">Customer Needs</td>
					</tr>
					<tr><td><br></td></tr>					
					<tr>
						<td><font style="color: red;">*</font>Celebration Type :</td>
						<td>
							<select name="ordertype" required class="tb10">
								<option>----</option>
								<option>Wedding</option>
								<option>Birthday</option>
								<option>Party</option>
								<option>Get Together</option>		
							</select>
						</td>
					</tr>
					<tr>
						<td>Celebration Decoration :</td>
						<td>
							<select name="orderdecor" class="tb10">
								<option>Yes</option>
								<option>No</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Caterer :</td>
						<td>
							<select name="ordercaterer" class="tb10">
								<option>Yes</option>
								<option>No</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Menu :</td>
						<td><textarea rows="10" cols="40" name="ordermenu" class="ta10"></textarea></td>
					</tr>
					<tr>
						<td>Entrance Gate :</td>
						<td>
							<select name="ordergate" class="tb10">
								<option>----</option>
								<option>LED</option>
								<option>Balloon</option>
								<option>Flower</option>
								<option>Net</option>		
							</select>
						</td>
					</tr>
					<tr>
						<td>Car :</td>
						<td>
							<select name="ordercar" class="tb10">
								<option>----</option>
								<option>Hyundai i20</option>
								<option>Chevrolet BEAT</option>
								<option>Honda City</option>
								<option>Hyundai Verna</option>
								<option>Mahindra Scorpio M-HAWK</option>
								<option>Mahindra XUV 500</option>
								<option>BMW Sedan Class</option>
								<option>AUDI Sedan Class</option>		
							</select>
						</td>
						<td>No. of Cars : <input type="number" name="ordernocar" class="tb10"></td>
					</tr>
					<tr>
						<td>Entertainer :</td>
						<td>
							<select name="orderentertainer" class="tb10">
								<option>----</option>
								<option>Panda</option>
								<option>Micky Mouse</option>
								<option>Mini Mouse</option>
								<option>Donald Duck</option>
								<option>Buggs Bunny</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>DJ Night :</td>
						<td>
							<select name="orderdj" class="tb10">
								<option>Yes</option>
								<option>No</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Camera :</td>
						<td>
							<select name="ordercamera" class="tb10">
								<option>Yes</option>
								<option>No</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><input type="submit" name="btnOrder" class="testbutton"></td>
						<td><input class="testbutton" type="reset" name="resetOrder"></td>
					</tr>
					</table>
					
				</form>
			</div>
		
		<div class="button">
  			<ul>
   				 <li><a href="customerLogout">Log Out</a></li>
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