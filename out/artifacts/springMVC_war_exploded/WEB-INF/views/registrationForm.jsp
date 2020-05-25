<%--
  Created by IntelliJ IDEA.
  User: 40431
  Date: 2019-12-26
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>registrationForm</title>
</head>
<body>
    <h2>Customer Registration</h2>
    <form:form modelAttribute="customer">
        <input type="hidden" name="_flowExecutorKey" value="${flowExecutionKey}">
        <b>Phone Number:</b><form:input path="phoneNumber"/><form:errors path="phoneNumber" element="div" cssClass="error"/><br/>
        <b>Name:</b><form:input path="name"/><form:errors path="name" element="div" cssClass="error"/><br/>
        <b>Address:</b><form:input path="address"/><form:errors path="address" element="div" cssClass="error"/><br/>
        <b>City:</b><form:input path="city"/><form:errors path="city" element="div" cssClass="error"/><br/>
        <b>State:</b><form:input path="state"/><form:errors path="state" element="div" cssClass="error"/><br/>
        <b>Zip Code:</b><form:input path="zipCode"/><form:errors path="zipCode" element="div" cssClass="error"/><br/>
        <input type="submit" name="_eventId_submit" value="Submit"/>
        <input type="submit" name="_eventId_cancel" value="Cancel"/>
    </form:form>
</body>
</html>
