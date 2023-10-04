<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book</title>
</head>
<body>
	Title: <c:out value="${book.title}"/><br>
	Author: <c:out value="${book.author}"/><br>
</body>
</html>