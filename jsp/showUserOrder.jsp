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
<title><jsp:getProperty property="userName" name="user"/>的订单展示</title>
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
			<input type="button" value="返回" onclick="location='showUserShopCart.do'">
		</div>
		<div class="header">订单展示</div>
		<div class="state">已发货</div>
		<c:forEach var="userOrderFa" items="${userOrderFaList}" varStatus="status">
			<div class="order1">
				<div class="left1"><img src="${userOrderFa.bookPhoto}" /></div>
				<div class="middle1">
					<div class="name1"><c:out value="${userOrderFa.bookName}" /></div>
					<div class="massege">原价：<c:out value="${userOrderFa.bookPrice}"/>|优惠价：<c:out value="${userOrderFa.bookLowPrice}" /></div>
					<div class="massege">数量：<c:out value="${userOrderFa.bookAmount}"/></div>
					<div class="massege">购买时间：<c:out value="${userOrderFa.buyingTime}" /></div>
				</div>
			</div>
		</c:forEach>
		<div class="state">未发货</div>
		<c:forEach var="userOrderWei" items="${userOrderWeiList}" varStatus="status">
			<div class="order1">
				<div class="left1"><img src="${userOrderWei.bookPhoto}" /></div>
				<div class="middle1">
					<div class="name1"><c:out value="${userOrderWei.bookName}" /></div>
					<div class="massege">原价：<c:out value="${userOrderWei.bookPrice}"/>|优惠价：<c:out value="${userOrderWei.bookLowPrice}" /></div>
					<div class="massege">数量：<c:out value="${userOrderWei.bookAmount}"/></div>
					<div class="massege">购买时间：<c:out value="${userOrderWei.buyingTime}" /></div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>