<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display House List</title>
</head>
<body>
	<c:forEach items="${listOfHouses}" var="house">
		Owner: <c:out value="${house.owner}"/><br>
		Address: <c:out value="${house.address}"/><br>
		Number of Bedrooms: <c:out value="${house.numOfBedrooms}"/><br>
		<hr>
	</c:forEach>
</body>
</html>