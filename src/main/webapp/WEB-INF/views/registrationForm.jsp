<%--
  Created by IntelliJ IDEA.
  User: 40431
  Date: 2019-12-26
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:c="http://java.sun.com/jsp/jstl/core"
        xmlns:spring="http://www.springframework.org/tags"
        xmlns:form="http://www.springframework.org/tags/form">
<jsp:output omit-xml-declaration="yes"/>
<jsp:directive.page contentType="text/html; UTF-8"/>
<head>
    <title>registrationForm</title>
</head>
<body>
    <h2>Customer Registration</h2>
    <form:form commandName="customer">
        <input type="hidden" name="_flowExecutorKey" value="${flowExecutionKey}">
        <b>Phone Number:</b><form:input path="phoneNumber"/><br/>
        <b>Name:</b><form:input path="name"/><br/>
        <b>Address:</b><form:input path="address"/><br/>
        <b>City:</b><form:input path="city"/><br/>
        <b>State:</b><form:input path="state"/><br/>
        <b>Zip Code:</b><form:input path="zipCode"/><br/>
        <input type="submit" name="_eventId_submit" value="Submit"/>
        <input type="submit" name="_eventId_cancel" value="Cancel"/>
    </form:form>
</body>
</html>
