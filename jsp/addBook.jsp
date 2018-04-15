<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/main.css" rel="stylesheet"/>
<jsp:useBean id="searchBook" class="com.Beans.Book" scope="session">
<jsp:setProperty name="searchBook" property="*"></jsp:setProperty>
</jsp:useBean>
<link rel="shortcut icon" type="image/x-icon" href="images/FBB1.jpg" />
<title>添加书籍</title>
<style type="text/css">      
	body
	{      
		background-image: url(images/bcg-image.jpg);        
        background-size:cover;    
	}
 </style>
</head>
<body>
	<div class="addarea">
		<div class="head">网上书店--添加书籍</div>
		<div class="input">
		<form action="addBook.do">
			<div class="left">
				书&nbsp;名：<input type="text" name="bookName">
				类&nbsp;型：<input type="text" name="bookType">
				原&nbsp;价：<input type="text" name="bookPrice">
				优惠价：<input type="text" name="bookLowPrice">
			</div>
			<div class="left">
				作&nbsp;者：<input type="text" name="bookWriter">
				照&nbsp;片：<input type="text" name="bookPhoto">
				时&nbsp;间：<input type="text" name="bookDate">
				出版社：<input type="text" name="bookpublisher">
			</div>
			<div class="font">简&nbsp;介：</div>
			<textarea rows="5%" cols="65%" name="bookContent" style="font-size: 18px;color: #696969;"></textarea>
			<div class="below"><input type="submit" value="添加"></div>
			<div class="below"><input type="button" value="返回" onclick="window.history.back(-1)"></div>
		</form>
		</div>
	</div>
</body>
</html>