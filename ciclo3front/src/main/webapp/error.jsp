<%@ page isErrorPage="true"%>
<%@ page import='java.lang.*'%>
<%@page import="java.io.PrintWriter"%>
<%@ page isErrorPage="true" import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Error</title>
</head>
<body>
	<center>
		<h3>Sorry an exception occured!</h3>
		<% String error = new String();
		error = (String) request.getAttribute("error");
		%>
		Exception is:
		<%=error%>
		<% System.out.println(request.getAttribute("error")); %>
	</center>
</body>
</html>