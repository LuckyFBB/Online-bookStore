<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="updateBook" class="com.Beans.Book" scope="session">
<jsp:setProperty name="updateBook" property="*"></jsp:setProperty>
</jsp:useBean>
<link href="css/main.css" rel="stylesheet"/>
<link rel="shortcut icon" type="image/x-icon" href="images/FBB1.jpg" />
<title>修改书籍信息</title>
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
		<div class="head">网上书店--修改书籍</div>
		<div class="input">
		<form action="updateBook.do" method="post">
			<div class="left">
				书&nbsp;名：<input type="text" name="bookName" value=<jsp:getProperty property="bookName" name="updateBook"/>>
				类&nbsp;型：<input type="text" name="bookType" value=<jsp:getProperty property="bookType" name="updateBook"/>>
				原&nbsp;价：<input type="text" name="bookPrice" value=<jsp:getProperty property="bookPrice" name="updateBook"/>>
				优惠价：<input type="text" name="bookLowPrice" value=<jsp:getProperty property="bookLowPrice" name="updateBook"/>>
			</div>
			<div class="left">
				作&nbsp;者：<input type="text" name="bookWriter" value=<jsp:getProperty property="bookWriter" name="updateBook"/>>
				照&nbsp;片：<input type="text" name="bookPhoto" value=<jsp:getProperty property="bookPhoto" name="updateBook"/>>
				时&nbsp;间：<input type="text" name="bookDate" value=<jsp:getProperty property="bookDate" name="updateBook"/>>
				出版社：<input type="text" name="bookPublisher" value=<jsp:getProperty property="bookPublisher" name="updateBook"/>>
			</div>
			<div class="font">简&nbsp;介：</div>
			<textarea rows="5%" cols="65%" name="bookContent" style="font-size: 18px;color: #696969;"><jsp:getProperty property="bookContent" name="updateBook"/></textarea>
			<div class="below" style="margin-top:5%"><input type="submit" value="修改"></div>
			<div class="below" style="margin-top:5%"><input type="button" value="返回" onclick="window.history.back(-1)"></div>
		</form>
		</div>
	</div>
</body>
</html>