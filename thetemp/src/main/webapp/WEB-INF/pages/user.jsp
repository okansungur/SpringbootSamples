<%@ page language="java"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>


<%@page isELIgnored="false" %>

<html>
<head>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title><fmt:message key="thetemp.user.title" /></title>
</head>
<body>

<div class="container">

    <a href="<c:url value='/main' />" class="btn btn-outline-danger" role="button"><fmt:message key="thetemp.user.homepage" /></a>
    <a href="<c:url value="/logout" />" class="link-info" role="button"><fmt:message key="thetemp.main.logout" /></a>


    <h2><fmt:message key="thetemp.user.title" />:</h2>
    <table class="table">
        <tr>

            <th></th>
            <th><fmt:message key="thetemp.user.table.mail" /></th>
            <th><fmt:message key="thetemp.user.table.roles" /></th>
            <th><fmt:message key="thetemp.user.table.enabled" /></th>
            <th><fmt:message key="thetemp.user.update" /></th>
            <th><fmt:message key="thetemp.user.delete" /></th>

        </tr>

        <c:forEach items="${userlist}" var="user">
            <form action="<c:url value="/updateUser" />" method="post">
                <tr>
                    <td><input type="hidden" name="userid" id="userid" value="${user.userId}"></td>
                    <td>${user.email}</td>
                    <td><c:out value="${user.roles[0].name}"/></td>

                    <td>
                        <input class="form-check-input" type="checkbox" name="uenabled"
                               <c:if test="${user.enabled == 'true'}">checked="checked"</c:if> />


                    </td>

                    <td>
                        <button type="submit" class="btn btn-primary" value="Update"><fmt:message key="thetemp.user.update" /></button>

                    </td>
            </form>
            <form action="<c:url value="/deleteUser" />" method="post">
                <td>
                    <input type="hidden" name="id" id="id" value="${user.userId}">
                    <button type="submit" class="btn btn-primary" value="Delete"><fmt:message key="thetemp.user.delete" /></button>
                </td>
            </form>
            </tr>



        </c:forEach>
    </table>

    </br>
    .....
    ${message}
    ...
    </br>


</div>


</body>
</html>