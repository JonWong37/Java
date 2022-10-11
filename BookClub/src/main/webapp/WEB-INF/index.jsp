<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Club</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <h2>Register</h2>
            <form:form action="/register" method="POST" modelAttribute="user" >
                <div class="form-group form-control">
                    <form:label path="userName">Name</form:label>
                    <form:input path="userName"/>
                    <form:errors path="userName"/>
                </div>
                <div class="form-group form-control">
                    <form:label path="email">Email</form:label>
                    <form:input path="email"/>
                    <form:errors path="email"/>
                </div>
                <div class="form-group form-control">
                    <form:label path="password">Password</form:label>
                    <form:input type="password" path="password"/>
                    <form:errors path="password"/>
                </div>
                <div class="form-group form-control">
                    <form:label path="confirm">Confirm password</form:label>
                    <form:input type ="password" path="confirm"/>
                    <form:errors path="confirm"/>
                </div>
                <input type="submit" value="Register"/>
            </form:form>
        </div>
        <div class="col">
            <h2>
                Already registered?
            </h2>
            <form:form action="/login" method="POST" modelAttribute="loginUser">
                <div class="form-group">
                    <div class="form-group form-control">
                        <form:label path="email">Email</form:label>
                        <form:input path="email"/>
                        <form:errors path="email"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-group form-control">
                        <form:label path="password">password</form:label>
                        <form:input type ="password" path="password"/>
                        <form:errors path="password"/>
                    </div>
                </div>
                <input type="submit" value="Login"/>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>

