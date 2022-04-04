<%@ page language="java"
         pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>


    <link href="css/main.css" rel="stylesheet"></link>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.2/js/bootstrap-select.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.2/css/bootstrap-select.min.css" rel="stylesheet" />

</head>
<body>
<center>


    <br/><br/>

    <fmt:message key="thetemp.greeting" />
    <br/><br/><br/><br/>




    <fmt:message key="thetemp.lang.change" /><br/>
    <li><a href="<c:url value="/?lang=en"/>" >  <fmt:message key="thetemp.lang.en" /></a></li>
    <li><a href="<c:url value="/?lang=tr"/>" > <fmt:message key="thetemp.lang.tr" /></a></li>


    <form action="login" method="post">

        <fmt:message key="thetemp.user" />:<input type="text" name="usermail" id="usermail" required /> <br/><br/>
        <fmt:message key="thetemp.password" />:<input type="password" name="password" id="password"  required /> <br/><br/>

        <input type="submit" value="login"/>

        <br/><br/>


        .....
        ${msg}
        ...
        <br/><br/>
        <a href="showRegistration">  <fmt:message key="thetemp.register" /></a>

</center>
<script>






</script>

</body>