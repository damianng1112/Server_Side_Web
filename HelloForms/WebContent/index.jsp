<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forms</title>
</head>
<body>
	<h2>Welcome</h2>
	<form action="HelloFormsServlet" method="post">
		Enter name: <input type="text" name= "name"><br>
		Enter address: <input type="text" name= "address">
		<input type="submit" value="Say Hello">
	</form>
</body>
</html>