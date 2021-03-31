<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Saras
  Date: 30/03/2021
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <spring:url value="/css/main.css" var="springCss" />
    <link href="${springCss}" rel="stylesheet" />
    <c:url value="/css/main.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />
    <title>Skaiciuotuvas</title>
    <style>
        .error{color:red}
    </style>
</head>
<body>
 <h2>Internetinis skaiciuotuvas. Galimos operacijos: sudeti, atimti, dauginti, dalinti</h2>
 <h3>Skaiciuotuvas jautrus negiamiems skaiciams ;)</h3>
 <form:form method="post" action="skaiciuoti" modelAttribute="number">
    Pirmas skaicius: <form:input type="number" name="sk1" path="sk1"/>
                     <form:errors path="sk1" cssClass="error"/><br><br>
    Antras skaicius: <form:input type="number" name="sk2" path="sk2"/>
                     <form:errors path="sk2" cssClass="error"/><br><br>
    Operacijos zenklas:
    <select name="zenklas">
        <option selected="selected" value="+">Sudetis</option>
        <option value="-">Atimtis</option>
        <option value="*">Daugyba</option>
        <option value="/">Dalyba</option>
    </select><p>
    <input type="submit" value="skaiciuoti">
</form:form>
</body>
</html>
