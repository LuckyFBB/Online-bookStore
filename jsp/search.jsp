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
<title><jsp:getProperty property="bookName" name="searchBook"/></title>
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
		<div class="header">欢迎来到网上书店</div>
		<div class="leftsearch">
			<div class="bookPhoto">
				<img src="<jsp:getProperty property="bookPhoto" name="searchBook"/>">
			</div>
		</div>
		<div class="rightsearch">
			<div class="bookName"><jsp:getProperty property="bookName" name="searchBook"/></div>
			<div class="bookMessage">类别：<jsp:getProperty property="bookType" name="searchBook"/></div>
			<div class="bookMessage">作者：<jsp:getProperty property="bookWriter" name="searchBook"/></div>
			<div class="bookMessage">出版社：<jsp:getProperty property="bookPublisher" name="searchBook"/></div>
			<div class="bookMessage">出版时间：<jsp:getProperty property="bookDate" name="searchBook"/></div>
			<div class="bookContent"><jsp:getProperty property="bookContent" name="searchBook"/></div>
			<div class="bookMessage">原价：<jsp:getProperty property="bookPrice" name="searchBook"/></div>
			<div class="bookMessage">优惠价：<jsp:getProperty property="bookLowPrice" name="searchBook"/></div>
			<div class="bookInput"><input type="button" value="加入购物车" onclick="location='addShopCart.do'"></div>
			<div class="bookInput"><input type="button" value="返回" onclick="window.history.go(-1);"></div>
		</div>
	</div>
</body>
</html>