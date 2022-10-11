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
    <title>Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<h1>Add a new book to the shelf</h1>
<div class="container-fluid">
    <div>
        <form:form action="/addbook" method="POST" modelAttribute="book" >
            <input type="hidden" name="user" value="${user.id}">
            <div class="form-group form-control">
                <form:label path="title">Title</form:label>
                <form:input path="title"/>
                <form:errors path="title"/>
            </div>
            <div class="form-group form-control">
                <form:label path="author">Author</form:label>
                <form:input path="author"/>
                <form:errors path="author"/>
            </div>
            <div class="form-group form-control">
                <form:label path="thoughts">Thoughts</form:label>
                <form:textarea rows = "5" cols = "30" path="thoughts"/>
                <form:errors path="thoughts"/>
            </div>
            <input type="submit" value="Add book to shelf"/>
        </form:form>
    </div>
</div>
</body>
<style>

</style>
</html>