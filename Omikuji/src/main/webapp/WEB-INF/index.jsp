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
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>Send someone an Omikuji</h3>
    <form action='/login' method='POST'>
        <div class="row mb-3">
            <label for="inputPassword3" class="col-sm-2 col-form-label">Pick a number between 5 and 25</label>
            <select class="form-select" name ="years" aria-label="Default select">
                <option selected="">Years</option>
                <c:forEach var = "i" begin = "5" end = "25">
                    <option><c:out value="${i}"></c:out></option>
                </c:forEach>
        </select>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Enter the name of a City</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name ="city">
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Enter the name of a Person</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name ="person">
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Enter your hobby</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name ="hobby">
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Enter any type of living thing</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name ="thing">
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Say something nice to someone</label>
            <div class="form-floating">
                <textarea class="form-control" placeholder="Leave a comment here" name="comment" style="height: 100px"></textarea>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Send</button>
    </form>
</div>
</body>
</html>

