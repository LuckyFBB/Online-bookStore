<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="images/FBB1.jpg" />
<link href="css/main.css" rel="stylesheet"/>
<title>网上书店首页</title>
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
		<form method="get">
			<div class="title">网上书店--首页</div>
			<div class="text"><br>网上书店欢迎你<br>我们立志提供最好的服务<br>满足你对书籍的所有需求<br><br>思想旅行从这里出发</div>
			<div class="input">
				<div class="every"><input type="button" value="登录" onclick="location='query.do?choose=login'" style="background-color: #6e8597;color: white"></div>
				<div class="every"><input type="button" value="直接访问" onclick="location='query.do?choose=notLogin'"style="background-color: #899496;color: white"></div>
				<div class="every"><input type="button" value="注册" onclick="location='query.do?choose=register'" style="background-color: #b9bcbe;color: white"></div>
			</div>
		</form>
	</div>
</div>
</body>
</html>