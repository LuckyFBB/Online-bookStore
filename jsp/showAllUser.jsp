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
<title>所有用户展示</title>
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
	<div class="userarea">
		<div class="input">
			<input type="button" value="返回" onclick="window.location.href='manager.jsp';">
		</div>
		<div class="header">所有用户展示</div>
		<div class="print">
			<div class="everyone">用户名</div>
			<div class="everytwo">用户密码</div>
			<div class="everytwo">用户电话</div>
			<div class="everythree">用户地址</div>
		</div>
		<c:forEach var="user" items="${allUserList}" varStatus="status">
			<div class="print">
			<div class="everyone"><c:out value="${user.userName }" /></div>
			<div class="everytwo"><c:out value="${user.userPassword }" /></div>
			<div class="everytwo"><c:out value="${user.userPhone }" /></div>
			<div class="everythree"><c:out value="${user.userAddress }" /></div>
		</div>
		</c:forEach>
	</div>
</body>
</html>