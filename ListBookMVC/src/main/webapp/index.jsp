<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book</title>
</head>
<body>
	<form action="ListBookServlet" method="post">
		Enter title: <input type="text" name="title">
		Enter author: <input type="text" name="author">
		<input type="submit" value="click me">
	</form>
</body>
</html>