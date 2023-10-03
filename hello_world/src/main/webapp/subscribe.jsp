<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thank you for Subscribing!</title>
</head>
<body>
	<%
	//get parameter from the request
	String firstName = request.getParameter("firstname");
	String lastName = request.getParameter("lastname");
	String emailAddress = request.getParameter("emailAddress");
	%>
	
	<table cellspacing="5" cellpadding="5" border="1">
		<tr>
			<td align="right">First name:</td>
			<td><%= firstName %></td>
		</tr>
		<tr>
			<td align="right">Last name:</td>
			<td><%= lastName %></td>
		</tr>
		<tr>
			<td align="right">Email address:</td>
			<td><%= emailAddress %></td>
		</tr>
	</table>
	
	<p>To enter another email address, click on the back <br>
	button in your browser or the Return button shown below. <br>
	</p>
	
	<form action="subscribe.html" method="post">
		<input type="submit" value="Return">
	</form>
</body>
</html>