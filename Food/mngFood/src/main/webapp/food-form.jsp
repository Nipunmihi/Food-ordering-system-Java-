<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Food Management Application</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<style>
    body {
        background-image: url('https://img.freepik.com/premium-photo/homemade-pancakes-with-fresh-berries-strawberries-blueberries-maple-syrup-wooden-background_134731-2197.jpg?w=740'); /* Updated path */
        background-size: cover;
        background-blur: 5px; /* Add a slight blur to the background */
    }

    .card {
        margin: 0 auto; /* Center the card */
        max-width: 500px; /* Adjust max-width as needed */
    }

    .add-new-food {
        color: #28a745; /* Green color */
        text-align: center;
        font-size: 24px; /* Adjust font size as needed */
    }
</style>

</head>
<body>

    <header>
        <nav class="navbar navbar-expand-md navbar-dark"
            style="background-color: tomato">
            <div>
                <a href="food-form.jsp"  class="navbar-brand"> Food Management App </a>
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/list"
                    class="nav-link">Foods</a></li>
            </ul>
        </nav>
    </header>
    <br>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${food != null}">
                    <form action="update" method="post">
                </c:if>
                <c:if test="${food == null}">
                    <form action="insert" method="post">
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${food != null}">
                        Edit Food
                    </c:if>
                        <c:if test="${food == null}">
                        <div class="add-new-food">Add New Food</div>
                    </c:if>
                    </h2>
                </caption>

                <c:if test="${food != null}">
                    <input type="hidden" name="id" value="<c:out value='${food.id}' />" />
                </c:if>

                <fieldset class="form-group">
                    <label>Food Name</label> <input type="text"
                        value="<c:out value='${food.name}' />" class="form-control"
                        name="name" required="required" pattern="[A-Za-z\s]+" title="Only alphabetical characters are allowed">
                </fieldset>

                <fieldset class="form-group">
                    <label>Food Price</label> <input type="text"
                        value="<c:out value='${food.price}' />" class="form-control"
                        name="price" required="required" pattern="\d+(\.\d{2})?" title="Price should be a number">
                </fieldset>

                <fieldset class="form-group">
                    <label>Food Favour</label> <input type="text"
                        value="<c:out value='${food.favour}' />" class="form-control"
                        name="favour" required="required">
                </fieldset>

              <button type="submit" class="btn btn-success"><i class="material-icons">save</i> Save</button>

                </form>
                
                <a class="back-link" href="http://localhost:8090/mngFood/">Back to List</a> 
                
                <a class="back-link" href="http://localhost:8090/mngFood/view">CustomerView</a> 
                
            </div>
        </div>
    </div>
</body>
</html>