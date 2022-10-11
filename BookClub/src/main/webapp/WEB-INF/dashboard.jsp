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
<div class="container-fluid">
<h1>Welcome, <c:out value="${user.userName}"></c:out></h1>
    <h1><a href="/newbook">Add a new book</a></h1>
    <table class="table table-hover table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Title</th>
            <th scope="col">Author Name</th>
            <th scope="col">Posted by</th>
        </tr>
        </thead>
        <c:forEach var = "book" items="${books}">
        <tbody>
            <td>${book.id}</td>
            <td><a href="/book/${book.id}">${book.title}</a></td>
            <td>${book.author}</td>
            <td>${book.user.userName}</td>
            <td><a href="/book/${book.id}">Delete</a></td>
        </tbody>
        </c:forEach>
    </table>

</div>
</body>
<style>
    h1,h2{
        text-align: center;
    }

</style>
</html>

