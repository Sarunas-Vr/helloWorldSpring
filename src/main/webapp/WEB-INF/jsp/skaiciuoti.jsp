<%--
  Created by IntelliJ IDEA.
  User: Saras
  Date: 30/03/2021
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <spring:url value="/css/main.css" var="springCss" />
    <link href="${springCss}" rel="stylesheet" />
    <c:url value="/css/main.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />
    <title>Skaiciuoti</title>
</head>
<body>
 <h4>${sk1} ${zenklas} ${sk2} = ${rezultatas}</h4>
</body>
</html>
