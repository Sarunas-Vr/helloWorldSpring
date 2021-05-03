<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <spring:url value="/css/main.css" var="springCss" />
    <link href="${springCss}" rel="stylesheet" />
    <c:url value="/css/main.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />

    <title>Skaičiuoti</title>
    <jsp:include page="header.jsp" />
    <jsp:include page="menu.jsp"/>
</head>
<body class="container">
 <h4>${sk1} ${zenklas} ${sk2} = ${rezultatas}</h4>
</body>
<jsp:include page="footer.jsp"/>
</html>
