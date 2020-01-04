<%@page import="com.mbs.dao.impl.CartDaoImpl"%>
<%@page import="com.mbs.dao.CartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CartDao cd = new CartDaoImpl();
	cd.addCartItem("1", 1);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
111
</body>
</html>