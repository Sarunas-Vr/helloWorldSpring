<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Skaiciai</title>
    <jsp:include page="header.jsp" />
</head>
<body>
    <div>
        <table>
            <tr>
                <th>Pirmas skaicius</th>
                <th>Zenklas</th>
                <th>Antras skaicius</th>
                <th>Rezultatas</th>
                <th>Veiksmas</th>
            </tr>

        <%-- Iteruoja per visa skaiciu sarasa --%>
            <c:forEach var="skaicius" items="${skaiciai}">

                <tr>
                    <td>${skaicius.sk1}</td>
                    <td>${skaicius.zenklas}</td>
                    <td>${skaicius.sk2}</td>
                    <td>${skaicius.result}</td>
                    <td>
                    <%--   atvaizduoti atnaujinimo adresa --%>
                        <a>Keisti</a>
                        <a>Trinti</a>
                        <a>Rodyti</a>
                    </td>

                </tr>


            </c:forEach>
        </table>
    </div>
</body>
</html>
