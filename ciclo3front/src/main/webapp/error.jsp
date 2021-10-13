<%@ page isErrorPage="true"%>
<%@ page import='java.lang.*'%>
<%@page import="java.io.PrintWriter"%>
<%@ page isErrorPage="true" import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.css">
</link>
<link rel="stylesheet" href="Styles/styles.css">
<meta charset="utf-8">
<title>Tienda Generica</title>
</head>
<body>
	<center>
		<h1>Sorry an exception occured!</h1>
		<%
		String error = new String();
		error = (String) request.getAttribute("error");
		%>
		Exception is:
		<h2><%=error%></h2>
		<div>
			<img alt="Imagen"
				src="<%=request.getContextPath()%>/images/image1.jpg’/">
		</div>
	</center>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
</body>
</html>