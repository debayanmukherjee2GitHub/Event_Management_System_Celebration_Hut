<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
<style type="text/css">
<%@include file="css/style1.css"%>
<%@include file="css/navigationBar.css"%>
<%@include file="css/rightColumn.css"%>
<%@include file="css/buttons.css"%>
</style>
<script type="text/javascript">
function gotoAdmin() {
    var w = window.open("adminLogin.jsp");
}
function gotoEmployee() {
    var w = window.open("empLogin.jsp");
}
function gotoMember() {
    var w = window.open("customerLogin.jsp");

}
</script>
</head>
<body background="images/BackgroundImage1.jpg">
	<div class="wrapper">
		<div>
			<img src="images/loginBanner.jpg" width="1026px" height="340px"
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
					<h2>Log In ...</h2><hr/>
  	<form action="" method="post">
  	<table style="margin-left: 20px; font-face: bold; font-family: arial" cellpadding="5">
  	 <tr>
  	 	<td style="color: #2175bc; font-size: 18px;"><b>Log In as ,</b> </td>
  	 	</tr>
  	 	<tr>
  	 		<td><input type="submit" name="btnGotologin1" value="Admin" class="testbutton1" 
  	 				onClick="gotoAdmin()" id="GotoLogin1"></td>
  	 		<td><input type="submit" name="btnGotologin2" value="Employee" class="testbutton1" 
  	 				onClick="gotoEmployee()" id="GotoLogin2"></td>
  	 		<td><input type="submit" name="btnGotologin3" value="Customer" class="testbutton1" 
  	 				onClick="gotoMember()" id="GotoLogin3"></td>
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