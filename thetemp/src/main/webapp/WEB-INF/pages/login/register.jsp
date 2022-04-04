<%@ page language="java"
         pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register User</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>

</head>
<body>
<div class="container">
    <h2>   <fmt:message key="thetemp.page.register" /></h2>

    <form action="saveuser" method="post" class="was-validated" >
        <div class="form-group">
            <label for="firstName"><fmt:message key="thetemp.page.firstname" /></label>
            <input type="text" name="firstName" id="firstName" value='${firstname}' placeholder="<fmt:message key="thetemp.page.firstname" />"  required class="form-control"/>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="lastName"><fmt:message key="thetemp.page.lastname" /></label>
            <input type="text" name="lastName" id="lastName" value="${lastname}"  placeholder="<fmt:message key="thetemp.page.lastname" />" required class="form-control"/>
        </div>
        <div class="form-group">
            <label for="email"><fmt:message key="thetemp.page.email" /></label>
            <input type="text" name="email" id="email" value='${email}' placeholder="<fmt:message key="thetemp.page.email" />" required class="form-control"/>
        </div>
        <div class="form-group">
            <label for="password"><fmt:message key="thetemp.page.pass" /></label>
            <input type="password" name="password" id="password" required class="form-control"/>
        </div>
        <div class="form-group">
            <label for="confirmPassword"><fmt:message key="thetemp.page.repass" /></label>
            <input type="password" name="confirmPassword" id="confirmPassword" required class="form-control"/>
        </div>


        <div class="form-group">
            <div class="g-recaptcha" data-sitekey="6LfuxgcfAAAAABuz4j4N9ynEkrfVJlnJ7g0aANxl">
            </div>

        </div>
        <input type="submit"  name="submit"  id="submit" value="<fmt:message key="thetemp.page.button" />">
    </form>

    <br/>


    .....
    ${msg}
    ...
    <span id="captcha-error" style="color:red"></span>



</div>
</body>
</html>