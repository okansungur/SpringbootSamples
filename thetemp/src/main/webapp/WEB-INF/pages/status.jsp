<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>


<%@page isELIgnored="false" %>

<html>
<head>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <title><fmt:message key="thetemp.status.title" /> </title>
</head>
<body>
<div class="container">
    <a href="<c:url value='/main' />" class="btn btn-info" role="button"><fmt:message key="thetemp.status.homepage" /></a>
    <a href="<c:url value="/logout" />" class="link-info" role="button"><fmt:message key="thetemp.status.logout" /></a>


    <h2><fmt:message key="thetemp.status.tablecaption" /> :</h2>
    <table class="table">
        <tr>

            <th><fmt:message key="thetemp.status.userid" /> </th>
            <th><fmt:message key="thetemp.status.filename" /></th>
            <th><fmt:message key="thetemp.status.processed" /></th>
            <th><fmt:message key="thetemp.status.mailsend" /></th>
            <th><fmt:message key="thetemp.status.satname" /></th>
            <th><fmt:message key="thetemp.status.azconfig" /></th>
            <th><fmt:message key="thetemp.status.processdate" /></th>
            <th><fmt:message key="thetemp.status.updatedate" /></th>
            <!-- <th>azdescription</th>-->
            <th>Select</th>
        </tr>

        <c:forEach items="${statuslist}" var="status">
            <tr>

                <td>${status.userid}</td>
                <td>${status.filename}</td>

                <td> <input class="form-check-input" type="checkbox" name="uenabled" disabled
                            <c:if test="${status.processed == 'true'}">checked="checked"</c:if> /></td>

                <td> <input class="form-check-input" type="checkbox" name="uenabled" disabled
                            <c:if test="${status.mailsend == 'true'}">checked="checked"</c:if> /></td>
                <td>${status.satname}</td>
                <td>${status.azconfig}</td>

                <td>${status.processdate}</td>
                <td>${status.updatedate}</td>
                <!--     <td>${status.azdescription}</td>-->
                <td><a href="<c:url value="/status/${status.statusid}" />"><fmt:message key="thetemp.status.select" /></a></td>


            </tr>

        </c:forEach>
    </table>




</div>


</body>

</html>