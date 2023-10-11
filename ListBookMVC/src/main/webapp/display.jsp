<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display List</title>
</head>
<body>
	<c:forEach items="${listOfBooks}" var="book">
		<c:out value="${book.title}"/>
		<c:out value="${book.author}"/>
		<br>
	</c:forEach>
</body>
</html>