
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>

<%--
  Created by IntelliJ IDEA.
  User: Saras
  Date: 23/03/2021
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
<%--    <!-- Access the bootstrap Css like this,--%>
<%--       Spring boot will handle the resource mapping automcatically -->--%>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.6.0/css/bootstrap.min.css" />
    <spring:url value="/css/main.css" var="springCss" />
    <link href="${springCss}" rel="stylesheet" />
    <c:url value="/css/main.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand">Spring Boot Home Page</a>
        </div>

    </div>
</nav>

<h1>Buna Buna<h1/>
<script type="text/javascript" src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>

</body>
</html>