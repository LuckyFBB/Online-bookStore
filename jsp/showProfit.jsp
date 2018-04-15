<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/main.css" rel="stylesheet"/>
<link rel="shortcut icon" type="image/x-icon" href="images/FBB1.jpg" />
<title>网上书店</title>
<style type="text/css">      
	body
	{      
		background-image: url(images/bcg-image.jpg);
    	background-size: cover;
    	background-repeat: no-repeat;
    	background-attachment: fixed;
	}
 </style>
</head>
<body>
	<div class="profitarea">
		<div class="profit">
			<div class="title">网上书店--盈利展示</div>
			<div class="every">卖出书籍：${totalAmount }本</div>
			<div class="every">总共收入：${totalPrice }元</div>
			<input type="button" value="返回" onclick="window.history.back(-1)">
		</div>
	</div>
</body>
</html>