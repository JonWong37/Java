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
<h1><a href="/ninja/new">Create NINJA</a></h1>
<div class="container-fluid">
    <table class="table table-hover table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var = "dojo" items="${dojos}">
            <tr>
                <th scope="row"><a href="/dojos/${dojo.id}">${dojo.name}</a></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <form:form action="/dojo/new" method="post" modelAttribute="dojo">
            <p>
                <form:label path="name">Dojo</form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </p>
            <input type="submit" value="Create"/>
        </form:form>
    </div>
</div>
</body>
<style>
    h1,h2{
        text-align: center;
    }

</style>
</html>

