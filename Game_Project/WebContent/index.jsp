<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f4f4f4;
        }

        form {
            margin-bottom: 20px;
            background-color: #fff;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        hr {
            border: 1px solid #ddd;
        }

        h2 {
            color: #333;
        }
    </style>
</head>
<body>
	Hi <c:out value="${sessionScope.userInfo.name}"/><br>
	Address: <c:out value="${sessionScope.userInfo.address}"/><br>
	<hr>
	<form action="UpdateUserServlet" method="post">
		<input type="hidden" name="current_name" value="${sessionScope.userInfo.name}">
		Enter New Name: <input type="text" name="name">
		Enter New Email: <input type="text" name="email">
		Enter New Password: <input type="text" name="password">	
		Enter New Address: <input type="text" name="address">
		<input type="submit" value="Update User">
	</form>
	<form action="DeleteUserServlet" method="post">
		<input type="hidden" name="deleteUserName" value="${sessionScope.userInfo.name}">
		<input type="submit" value="Delete User">
	</form>
	<form action="AddGameServlet" method="post">
		<input type="hidden" name="userName" value="${sessionScope.userInfo.name}">
    	Enter Game Title: <input type="text" name="title" required>
    	Enter Game Genre: <input type="text" name="genre" required>
    	<input type="submit" value="Add Game">
	</form>
	<form action="DisplayAllGameServlet" method="post">
		<input type="submit" value="Show All Games">
	</form>	
	<form action="DisplayMyGameServlet" method="post">
		<input type="submit" value="Show My Games">
	</form>
</body>
</html>