<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="user" class="com.Beans.User" scope="session">
<jsp:setProperty name="user" property="*"></jsp:setProperty>
</jsp:useBean>
<link href="css/main.css" rel="stylesheet"/>
<link rel="shortcut icon" type="image/x-icon" href="images/FBB1.jpg" />
<title>欢迎来到网上书店</title>
<style type="text/css">      
	body
	{      
		background-image: url(images/bcg-image.jpg);        
        background-size:cover;    
	}
 </style>
</head>
<body>
	<div class="area">
		<div class="header">
			<jsp:getProperty property="userName" name="user"/>，欢迎来到网上书店
			<div class="out"><input type="button" value="退出" onclick="location='out.do'"></div>
		</div>
		<div class="logined">
			<div class="head">
				<div class="title"><a href="home.jsp">书店首页</a></div>
				<div class="title"><a href="query.do?choose=全部">进入书库</a></div>
				<div class="title"><a href="showUser.jsp">我的信息</a></div>
				<div class="title"><a href="showUserShopCart.do">我的购物车</a></div>
			</div>
			<div class="search">
				<div class="left"><a href="query.do?choose=全部">全部</a>&nbsp;|&nbsp;<a href="query.do?choose=小说">小说</a>&nbsp;|&nbsp;<a href="query.do?choose=文学">文学</a>&nbsp;|&nbsp;<a href="query.do?choose=教材">教材</a>&nbsp;|&nbsp;<a href="query.do?choose=社科">社科</a></div>
				<div class="right">
					<form action="search.do" method="post">
						<input type="text" name="searchName">
						<input type="submit" value="搜索图书" style="width:30%">
					</form>
				</div>
			</div>
			<div class="recommend">
				<div class="font">今日推荐</div>
			</div>
			<div class="books">
				<c:forEach var="book" items="${bookList}" varStatus="status" begin="1" end="4">
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
		</div>	
	</div>
</body>
</html>