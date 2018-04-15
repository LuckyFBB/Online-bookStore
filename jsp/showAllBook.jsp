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
<title>所有书籍展示</title>
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
		<div class="header">所有书籍展示</div>
		<div class="addbook">
			<input type="button" value="添加书籍信息" onclick="window.location.href='addBook.jsp';">
		</div>
		<c:forEach var="book" items="${bookList}" varStatus="status">
		<div class="allbook">
			<div class="left"><img src="${book.bookPhoto}"/></div>
			<div class="middle">
				<div class="name"><c:out value="${book.bookName}" /></div>
				<div class="content"><c:out value="${book.bookContent}" /></div>
			</div>
			<div class="rightleft">
				<div class="massege">作者：<c:out value="${book.bookWriter}" /></div>
				<div class="massege"><c:out value="${book.bookPublisher}" /></div>
				<div class="massege">类型：<c:out value="${book.bookType}" /></div>
			</div>
			<div class="rightright">
				<div class="massege">时间：<c:out value="${book.bookDate}" /></div>
				<div class="massege">原价：<c:out value="${book.bookPrice}" /></div>
				<div class="massege">优惠价：<c:out value="${book.bookLowPrice}" /></div></div>
			<div class="alter">
				<input type="button" value="修改" onclick="location='updateBook.do?bookName=${book.bookName}'">
				<input type="button" value="删除" onclick="location='deleteBook.do?bookName=${book.bookName}'">
			</div>
		</div>
		</c:forEach>
	</div>
</body>
</html>