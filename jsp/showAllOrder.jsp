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
<title>所有订单展示</title>
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
			<input type="button" value="返回" onclick="window.location.href='manager.jsp';">
		</div>
		<div class="header">所有订单展示</div>
		<div class="state">未发货</div>
		<c:forEach var="userOrderAllWei" items="${allUserOrderWeiList}" varStatus="status">
			<div class="order">
				<div class="left"><img src="${userOrderAllWei.bookPhoto}" /></div>
				<div class="user">
					<div class="name"><c:out value="${userOrderAllWei.bookName}" /></div>
					<div class="massege">原价：<c:out value="${userOrderAllWei.bookPrice}" /></div>
					<div class="massege">优惠价：<c:out value="${userOrderAllWei.bookLowPrice}" /></div>
					<div class="massege">数量：<c:out value="${userOrderAllWei.bookAmount}" /></div>
				</div>
				<div class="orderbook">
					<div class="name"></div>
					<div class="massege">买家：<c:out value="${userOrderAllWei.userName}" /></div>
					<div class="massege">电话：<c:out value="${userOrderAllWei.userPhone}" /></div>
					<div class="massege">地址：<c:out value="${userOrderAllWei.userAddress}" /></div>
				</div>
				<div class="alter"><input type="button" value="发货" onclick="location='alterOrder.do?userName=${userOrderAllWei.userName}&bookName=${userOrderAllWei.bookName}&buyingTime=${userOrderAllWei.buyingTime}'"></div>
			</div>
		</c:forEach>
		<div class="state">已发货</div>
		<c:forEach var="userOrderAllFa" items="${allUserOrderFaList}" varStatus="status">
			<div class="order">
				<div class="left"><img src="${userOrderAllFa.bookPhoto}" /></div>
				<div class="user">
					<div class="name"><c:out value="${userOrderAllFa.bookName}" /></div>
					<div class="massege">原价：<c:out value="${userOrderAllFa.bookPrice}" /></div>
					<div class="massege">优惠价：<c:out value="${userOrderAllFa.bookLowPrice}" /></div>
					<div class="massege">数量：<c:out value="${userOrderAllFa.bookAmount}" /></div>
				</div>
				<div class="orderbook">
					<div class="name"></div>
					<div class="massege">买家：<c:out value="${userOrderAllFa.userName}" /></div>
					<div class="massege">电话：<c:out value="${userOrderAllFa.userPhone}" /></div>
					<div class="massege">地址：<c:out value="${userOrderAllFa.userAddress}" /></div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>