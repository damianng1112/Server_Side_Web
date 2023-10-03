<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book</title>
</head>
<body>
	<h2>Welcome</h2>
	<form action="HelloBookServlet" method="post">
		Enter title: <input type="text" name= "title"><br>
		Enter author: <input type="text" name= "author">
		<input type="submit" value="Create Book">
	</form>
</body>
</html>