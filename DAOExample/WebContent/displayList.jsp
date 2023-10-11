<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display List</title>
</head>
<body>
	<c:forEach items="${listOfUsers}" var="user">
		<c:out value="${user.name}"/>
		<c:out value="${user.address}"/>
		<br>
	</c:forEach>
</body>
</html>