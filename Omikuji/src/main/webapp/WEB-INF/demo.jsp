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
    <title>Omikuji</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container row">
    <div class="col-4"></div>
    <div class="col-6">
        <h3>Here's your Omikuji</h3>
        <p>
            In <c:out value="${years}"></c:out> years, you will live in <c:out value="${city}"></c:out> with <c:out value="${person}"></c:out> as your roommate, <c:out value="${hobby}"></c:out> for a living. The next time you see a <c:out value="${thing}"></c:out>, you will have good luck. Also, <c:out value="${comment}"></c:out>.
        </p>
    </div>
    <div class="col-3"></div>
</div>
</body>
</html>