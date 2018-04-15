<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="images/FBB1.jpg" />
<link href="css/main.css" rel="stylesheet"/>
<title>网上书店</title>
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
			<div class="title">管理员你好</div>
			<div class="input">
				<div class="every"><input type="button" value="查询所有用户" onclick="location='showAllUser.do?'"style="background-color: rgba(255, 245, 238,0.7);"></div>
				<div class="every"><input type="button" value="查询所有书籍" onclick="location='query.do?choose=all'" style="background-color: rgba(255, 245, 238,0.7);"></div>
				<div class="every"><input type="button" value="查询所有订单" onclick="location='showUserOrder.do'" style="background-color: rgba(255, 245, 238,0.7);"></div>
				<div class="every"><input type="button" value="查询目前盈利" onclick="location='showProfit.do'" style="background-color: rgba(255, 245, 238,0.7);"></div>
				<div class="every"><input type="button" value="退出" onclick="location='out.do'" style="background-color: rgba(255, 245, 238,0.7);"></div>
			</div>
		</form>
	</div>
</div>
</body>
</html>