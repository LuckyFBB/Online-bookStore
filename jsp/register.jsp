<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/main.css" rel="stylesheet"/>
<link rel="shortcut icon" type="image/x-icon" href="images/FBB1.jpg" />
<title>网上书店注册</title>
<style type="text/css">      
	body
	{      
		background-image: url(images/bcg-image.jpg);        
        background-size:cover;    
	}
 </style>
</head>
<body>
<div class="registerarea">
	<div class="register">
		<form action="register.do" method="post">
		<div class="title">网上书店--注册</div>
		<div class="input">
			<div class="every"><input type="text" placeholder="请输入用户名,至少4位" name="name"></div>
			<div class="every"><input type="password" placeholder="请输入密码" name="password"></div>
			<div class="every"><input type="password" placeholder="请确定密码" name="password1"></div>
			<div class="every"><input type="text" placeholder="请输入电话，11位" name="phone"></div>
			<div class="every"><input type="text" placeholder="请输入地址" name="address"></div>
			<div class="every"><input type="submit" value="注册" style="background-color: #6e8597;color: white"></div>
			<div class="every"><input type="reset" value="重置" style="background-color: #b9bcbe;color: white"></div>
		</div>
	</form>
	</div>
</div>
</body>
</html>