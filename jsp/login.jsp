<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="images/FBB1.jpg" />
<link href="css/main.css" rel="stylesheet"/>
<title>网上书店登录</title>
<style type="text/css">      
	body
	{      
		background-image: url(images/bcg-image.jpg);      
        background-size:cover;    
	}
 </style>
</head>
<body>
<div class="loginarea">
	<div class="login">
		<form action="login.do" method="post">
			<div class="title">网上书店--登录</div>
			<div class="input">
				<div class="every"><input type="text" placeholder="请输入用户名" name="name"></div>
				<div class="every"><input type="password" placeholder="请输入密码" name="password"></div>
				<div class="radio">
					<div class="each"><input type="radio" name="login" checked="checked" value="user">普通用户</div>
					<div class="each"><input type="radio" name="login" value="manager">管理员</div>
				</div>
				<div class="every"><input type="submit" value="登录" style="background-color: #6e8597;color: white"></div>
				<div class="every"><input type="button" value="直接访问" onclick="location='query.do?choose=notLogin'"style="background-color: #899496;color: white"></div>
				<div class="every"><input type="reset" value="重置" style="background-color: #b9bcbe;color: white"></div>
			</div>
		</form>
	</div>
</div>
</body>
</html>