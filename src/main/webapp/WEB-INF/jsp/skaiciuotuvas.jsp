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
</head>
<body>
 <h2>Internetinis skaiciuotuvas. Galimos operacijos: sudeti, atimti, dauginti, dalinti</h2>
<form method="post" action="skaiciuoti">
    Pirmas skaicius: <input type="number" name="sk1"><p>
    Antras skaicius: <input type="number" name="sk2"><p>
    Operacijos zenklas:
    <select name="zenklas">
        <option selected="selected" value="+">Sudetis</option>
        <option value="-">Atimtis</option>
        <option value="*">Daugyba</option>
        <option value="/">Dalyba</option>
    </select><p>
    <input type="submit" value="skaiciuoti">
</form>
</body>
</html>
