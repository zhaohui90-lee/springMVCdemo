<%--
  Created by IntelliJ IDEA.
  User: 40431
  Date: 2019-12-19
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>registerForm</title>
</head>
<style>
    div.errors{
        background-color: #ffcccc;
        border: 2px solid red;
    }
    label.error{
        color: red;
    }
</style>
<body>
    <h1>Register</h1>
    <%--<form method="post">--%>
        <%--First Name:<input type="text" name="firstName"/><br/>--%>
        <%--Last Name:<input type="text" name="lastName"/><br/>--%>
        <%--UserName:<input type="text" name="userName"/><br/>--%>
        <%--Password:<input type="password" name="password"/><br/>--%>
        <%--<input type="submit" value="Register"/>--%>
    <%--</form>--%>

    <sf:form method="post" commandName="user">
        <sf:label path="firstName" cssErrorClass="error">First Name</sf:label><sf:input path="firstName"/><sf:errors path="firstName" element="div" cssClass="errors"/><br/>
    <sf:label path="lastName" cssErrorClass="error">Last Name</sf:label><sf:input path="lastName"/><sf:errors path="lastName" element="div" cssClass="errors"/><br/>
    <sf:label path="email" cssErrorClass="error">Email</sf:label><sf:input path="email" type="email"/><sf:errors path="email" element="div" cssClass="errors"/> <br/>
    <sf:label path="userName" cssErrorClass="error">Username</sf:label><sf:input path="userName"/><sf:errors path="userName" element="div" cssClass="errors"/> <br/>
    <sf:label path="password" cssErrorClass="error">password</sf:label><sf:password path="password"/><sf:errors path="password" element="div" cssClass="errors"/> <br/>
    <input type="submit" value="Register"/>
    </sf:form>
</body>
</html>
