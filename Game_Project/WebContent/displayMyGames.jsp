<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Display All Games</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f4f4f4;
        }

        h2 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #4caf50;
            color: white;
        }

        form {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        input[type="text"] {
            width: 40%;
            padding: 8px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #2196F3;
            color: white;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0b7dda;
        }

        input[type="submit"]:last-child {
            background-color: #ff3333;
        }

        input[type="submit"]:last-child:hover {
            background-color: #ff0000;
        }
    </style>
</head>
<body>
    <h2>Games List</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>User Name</th>
                <th>Title</th>
                <th>Genre</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="game" items="${userGames}">
                <tr>
                    <td><c:out value="${game.game_id}" /></td>
                    <td><c:out value="${game.user_name}" /></td>
                    <td><c:out value="${game.title}" /></td>
                    <td><c:out value="${game.genre}" /></td>
                    <td>
                        <form action="UpdateGameServlet" method="post">
    						<input type="hidden" name="game_id" value="${game.game_id}" />
    						<input type="text" name="title" placeholder="New Title" value="${not empty game.title ? game.title : ''}">
    						<input type="text" name="genre" placeholder="New Genre" value="${not empty game.genre ? game.genre : ''}">
    						<input type="submit" value="Update">
						</form>
                    </td>
                    <td>
                        <form action="DeleteGameServlet" method="post">
                            <input type="hidden" name="game_id" value="${game.game_id}" />
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
