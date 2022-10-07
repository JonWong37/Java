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
<h1>Create a Ninja</h1>
<div class="container-fluid">
    <div>
        <form:form action="/ninja/new" method="post" modelAttribute="ninja">
            <p>
                <form:label path="firstName">Ninja</form:label>
                <form:errors path="firstName"/>
                <form:input path="firstName"/>
            </p>
            <p>
                <form:label path="lastName">Last Name</form:label>
                <form:errors path="lastName"/>
                <form:input path="lastName"/>
            </p>
            <p>
                <form:label path="age">Age</form:label>
                <form:errors path="age"/>
                <form:input path="age"/>
            </p>
                <form:select class="form-select" path="dojo">
                    <option selected>Pick your dojo</option>
                        <c:forEach var="dojo" items="${dojos}">
                            <option value="${dojo.id}">${dojo.name}</option>
                        </c:forEach>
                </form:select>
            <input type="submit" value="Create"/>
        </form:form>
    </div>
</div>
</body>
<style>

</style>
</html>