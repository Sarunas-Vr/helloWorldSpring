<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Registracija</title>
    <jsp:include page="header.jsp" />
</head>
<body>
    <div class="container">

        <form:form method="post" modelAttribute="userForm" class="form-signin">
            <h2 class="form-signin-heading">Naujos paskyros sukūrimas</h2>
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="username" type="text" class="form-control" placeholder="Prisijungimo vardas"
                                autoFocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>


            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="password" type="password" class="form-control" placeholder="Slaptažodis"></form:input>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>


            <spring:bind path="passwordConfirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="passwordConfirm" type="password" class="form-control" placeholder="Slaptažodžio patvitrtinimas"></form:input>
                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Sukurti</button>
        </form:form>

    </div>
</body>
<jsp:include page="footer.jsp" />
</html>
