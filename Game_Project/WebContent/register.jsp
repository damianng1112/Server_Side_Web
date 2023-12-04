<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #2196F3;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #0b7dda;
        }
    </style>
</head>
<body>
    <form action="RegisterServlet" method="post">
        <h2>Register</h2>
        <label for="name">Enter Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="email">Enter Email:</label>
        <input type="text" id="email" name="email" required>

        <label for="password">Enter Password:</label>
        <input type="password" id="password" name="password" required>

        <label for="address">Enter Address:</label>
        <input type="text" id="address" name="address" required>

        <input type="submit" value="Register">
    </form>
</body>
</html>
