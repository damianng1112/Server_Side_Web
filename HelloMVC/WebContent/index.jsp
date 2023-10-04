<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test MVC</title>
</head>
<body>
	<form method="post" action="HelloControllerServlet">
	Enter Name: <input type="text" name="name">
	<input type="submit" value="say hello">
	</form><br>
	<form method="post" action="CreateBookServlet">
	Enter title: <input type="text" name="title">
	Enter author: <input type="text" name="author">
	<input type="submit" value="create book">
	</form>
</body>
</html>