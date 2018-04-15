<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="user" class="com.Beans.User" scope="session">
<jsp:setProperty name="user" property="*"></jsp:setProperty>
</jsp:useBean>
<link href="css/main.css" rel="stylesheet"/>
<link rel="shortcut icon" type="image/x-icon" href="images/FBB1.jpg" />
<title><jsp:getProperty property="userName" name="user"/>的购物车展示</title>
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
	<div class="showbookarea">
		<div class="input">
			<input type="button" value="返回" onclick="window.location.href='userLogined.jsp';">
		</div>
		<div class="input2">
			<input type="button" value="查看我的订单" style="float:right" onclick="location='showUserOrder.do'">
		</div>
		<div class="header">购物车展示</div>
		<c:forEach var="userShopCart" items="${userShopCartList}" varStatus="status">
			<div class="order">
				<div class="left"><img src="${userShopCart.bookPhoto}" /></div>
				<div class="middle">
					<div class="name1"><c:out value="${userShopCart.bookName}" /></div>
					<div class="massege">原价：<c:out value="${userShopCart.bookPrice}" /></div>
					<div class="massege">优惠价：<c:out value="${userShopCart.bookLowPrice}" /></div>
				</div>
				<div class="right">
					<div class="amount">
						<input type="button" value="+" style="background-color:#e6eb87;" onclick="location='addAmount.do?alter=add&bookName=${userShopCart.bookName}'">
						<input type="text" value="${userShopCart.bookAmount}" readonly>
						<input type="button" value="-" style="background-color:#e6eb87;" onclick="location='addAmount.do?alter=reduce&bookName=${userShopCart.bookName}'">
					</div>
					<div class="delete">
						<input type="button" value="购买" onclick="location='addOrder.do?bookName=${userShopCart.bookName}'">
						<input type="button" value="删除" onclick="location='deleteShopCart.do?bookName=${userShopCart.bookName}'">
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>