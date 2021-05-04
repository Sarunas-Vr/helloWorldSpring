<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- puslapio turinio keliui nustatyti --%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="UTF-8">
    <title>Prisijungimas</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
    <h1 class="text-center">Internetinis skaičiuotuvas</h1>
    <div class="container">
        <form method="POST" action="${contextPath}/prisijungti" class="form-signin">
            <h3 class="form-header">Prisijungimas</h3>
            <div class="form-group ${error != null ? 'has-error' : ''}">
                <span>${message}</span>
                <input name="username" type="text" class="form-control" placeholder="Prisijungimo vardas"
                autofocus="true"/>
                <input name="password" type="password" class="form-control" placeholder="Slaptažodis" />
                <span>${error}</span>
                <%--
                    Web aplikacijai naudotojui turetu isduoti papildoma parametra, kuris nebutu nuspejamas piktavaliui.
                    Paprastai naudotojui yra isduodamas unikalus CSRF zetonas (token),
                    kuris turi buti validuojamas back-end'e su kiekviena duomenis keiciancia uzklausa
                 --%>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Prisijungti</button>
                <h4 class="text-center"><a href="${contextPath}/registruoti">Sukurti naują paskyrą</a></h4>
            </div>
        </form>
    </div>
<jsp:include page="footer.jsp"/>
</body>
</html>
