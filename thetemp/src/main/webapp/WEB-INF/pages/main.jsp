<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <title> <fmt:message key="thetemp.main.title" /> </title>
</head>
<body>

<div id="page-content" class="page-content">

    <div class="jumbotron text-center">
        <h1><fmt:message key="thetemp.main.title" /> </h1>


        <a href="<c:url value="/logout" />" class="btn btn-outline-warning" role="button"><fmt:message key="thetemp.main.logout" /></a>
        <a href="<c:url value="/status" />" class="btn btn-outline-secondary" role="button">Status</a>
        <a href="<c:url value="/user" />" class="btn btn-outline-secondary" role="button">User</a>
        <br/>${username}
    </div>

    <div class="container">
        <div class="row">

            <div class="col-sm-6">



            </div>

            <div class="col-sm-6">
                <h5><fmt:message key="thetemp.main.fileupload" /></h5>



                <form method="POST" enctype="multipart/form-data" action="file/fileupload">
                    <label for="formFile" class="form-label"><fmt:message key="thetemp.main.fileupload.title" /></label>
                    <input class="form-control" type="file" id="formFile" name="file">


                    <label for="satname"><fmt:message key="thetemp.main.satellite" /></label>
                    <select class="form-control" id="satname" name="satname">
                        <option value="3A">Turksat 3A</option>
                        <option value="4A">Turksat 4A</option>
                        <option value="4B">Turksat 4B</option>
                        <option value="5A">Turksat 5A</option>

                    </select>
                    <input type="submit" value="<fmt:message key="thetemp.main.fileupload.title2" />" />

                </form>

            </div></div></div>



</div>
<center>
</br>
.....
${msg}
...
</br>

<div id="mydiv">
    hello

</div>
</center>

</div>
</div>
</div>
</body>
</html>