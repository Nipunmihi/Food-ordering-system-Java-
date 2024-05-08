<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Customer Food List</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">

<style>

	
    
    body {
        font-family: Arial, sans-serif;
        background-image: url('https://img.freepik.com/free-photo/ingredients-near-pizza_23-2147772081.jpg?w=900&t=st=1698201665~exp=1698202265~hmac=0784b72c611715b4639986fb9bf74eb28e49d94e42db07ac20f10fb5da20e28a'); /* Replace with your image URL */
        background-size: cover;
        background-position: center;
    }

    header {
        margin-bottom: 20px;
    }

    .navbar {
        border-radius: 0;
    }

    .navbar-brand {
        font-size: 1.5em;
        font-weight: bold;
    }

    .navbar-nav li a {
        font-size: 1.2em;
    }

    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 10px;
        text-align: center;
    }

    th {
        background-color: #f2f2f2;
    }

    .back-link {
        display: block;
        margin-top: 20px;
        font-size: 1.2em;
        text-decoration: none;
    }
</style>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <div>
                <a href="#" class="navbar-brand">Customer Food List App</a>
            </div>
            <ul class="navbar-nav">
                <li><a href="#" class="nav-link">Foods</a></li>
            </ul>
        </nav>
    </header>

    <div class="row justify-content-center"> <!-- Center the form -->
        <form class="mx-auto"> <!-- Use mx-auto to center the form -->
            <div class="container">
                <h3 class="text-center">List of Foods</h3>
                <hr>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Favour</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="food" items="${foodList}">
                            <tr>
                                <td><c:out value="${food.name}" /></td>
                                <td><c:out value="${food.price}" /></td>
                                <td><c:out value="${food.favour}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a class="back-link" href="new">Back to List</a>
            </div>
        </form>
    </div>
</body>
</html>
