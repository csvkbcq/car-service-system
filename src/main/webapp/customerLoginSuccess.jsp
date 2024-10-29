<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Success</title>
    <style>
        body {
            background-color: #f0f8ff; /* Light blue background */
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .container p {
            font-size: 18px;
            color: #333;
        }
        a {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            text-decoration: none;
            color: white;
            background-color: #4CAF50; /* Green button style */
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Login Success</h2>
        <br>
        <%
        out.println("Dear " + session.getAttribute("sname") + ", you have successfully logged in");
        %><br>
        <a href="carDetails.html">Enter your car details</a><br>
        <a href="carDetails.html">Edit car details</a><br>
        <a href="serviceRequest.html">Request for car service</a><br>
        <a href="serviceStatus.html">Check service status</a><br>
    </div>
</body>
</html>
