<%--
  Created by IntelliJ IDEA.
  User: Saras
  Date: 29/04/2021
  Time: 05:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <caption>Skaiciaus informacija</caption>
        <table>
            <tr>
                <td><b>Id:</b></td>
                <td><b>${skaicius.id}</b></td>
            </tr>
            <tr>
                <td><b>Pirmas skaicius:</b></td>
                <td>${skaicius.sk1}</td>
            </tr>
            <tr>
                <td><b>Zenklas:</b></td>
                <td>${skaicius.zenklas}</td>
            </tr>
            <tr>
                <td><b>Antras skaicius:</b></td>
                <td>${skaicius.sk2}</td>
            </tr>
            <tr><b>Rezultatas:</b></tr>
            <td>${skaicius.rezult}</td>
        </table>
    </div>
    <br>
    <a type="button" href="/skaiciai" class="button">Atgal</a>
</body>
</html>
