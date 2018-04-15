<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="user" class="com.Beans.User" scope="session">
<jsp:setProperty name="user" property="*"></jsp:setProperty>
</jsp:useBean>
<link href="css/main.css" rel="stylesheet"/>
<link rel="shortcut icon" type="image/x-icon" href="images/FBB1.jpg" />
<title><jsp:getProperty property="userName" name="user"/>信息展示</title>
<style type="text/css">      
	body
	{      
		background-image: url(images/bcg-image.jpg);        
        background-size:cover;    
	}
 </style>
</head>
<body>
<div class="showuserarea">
	<div class="alter">
		<form action="alterUser.do" method="post">
			<div class="title">网上书店--我的信息</div>
			<div class="input">
				<div class="every"><input type="text" value=<jsp:getProperty property="userName" name="user"/> readonly></div>
				<div class="every"><input type="text" name="newPassword" value=<jsp:getProperty property="userPassword" name="user"/>></div>
				<div class="every"><input type="text" name="newPhone" value=<jsp:getProperty property="userPhone" name="user"/>></div>
				<div class="every"><input type="text" name="newAddress" value=<jsp:getProperty property="userAddress" name="user"/>></div>
				<div class="every"><input type="submit" value="修改信息" style="background-color: #6e8597;color:white;"></div>
				<div class="every"><input type="button" value="返回" onclick="window.history.back(-1)"style="background-color: #899496;color:white;"></div>
			</div>
		</form>
	</div>
</div>
</body>
</html>