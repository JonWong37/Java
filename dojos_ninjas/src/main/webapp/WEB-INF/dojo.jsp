<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Travels</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<h1>${dojo.name}'s Ninjas</h1>
<div class="container-fluid">
    <table class="table table-hover table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Age</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var = "ninja" items = "${dojo.ninjas}">
                <tr>
                        <td>${ninja.firstName}</td>
                        <td>${ninja.lastName}</td>
                        <td>${ninja.age}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div>
    </div>
</div>
</body>
<style>
    h1,h2{
        text-align: center;
    }

</style>
</html>

