<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hi</title>
</head>
<body>
	Name: <c:out value="${user.name}"/><br>
	Address: <c:out value="${user.address}"/><br>
</body>
</html>