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
<h1>Expense Details</h1>
<div class="container-fluid">
    <div class="card-body row">
        <h2 class="card-title">Expense Name : <c:out value="${expense.name}"></c:out></h2>
        <h4 class="card-title">Expense Vendor : <c:out value="${expense.vendor}"></c:out></h4>
        <h4 class="card-title">Amount : $<c:out value="${expense.amount}"></c:out></h4>
        <h4 class="card-title">Expense Description : <c:out value="${expense.description}"></c:out></h4>
    </div>
</div>
</body>
</html>

