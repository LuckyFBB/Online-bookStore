<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/main.css" rel="stylesheet"/>
<link rel="shortcut icon" type="image/x-icon" href="images/FBB1.jpg" />
<title>${choose}图书展示</title>
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
			<input type="button" value="返回" onclick="window.history.go(-1);">
		</div>
		<div class="header">${choose}图书展示</div>
		<c:forEach var="book" items="${bookList}" varStatus="status">
			<div class="book">		
				<div class="left"><img src="${book.bookPhoto}"></div>
				<div class="right">
					<div class="name"><c:out value="${book.bookName}" /></div>
					<div class="massege">作者：<c:out value="${book.bookWriter}" /></div>
					<div class="massege">类别：<c:out value="${book.bookType}" /></div>
					<div class="more"><a href="search.do?searchName=${book.bookName}">[查看更多详情]</a></div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>