<%--
  Created by IntelliJ IDEA.
  User: 40431
  Date: 2019-12-26
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:form="http://www.springframework.org/tags/form">
<jsp:output omit-xml-declaration="yes"/>
<jsp:directive.page contentType="text/html; utf-8"/>
<head>
    <title>Welcome to pizza!</title>
</head>
<body>
    <h2>Welcome to pizza!</h2>
    <form:form>
        <input type="hidden" name="_flowExecutorKey" value="${flowExecutionKey}">
        <input type="text" name="phoneNumber"><br/>
        <input type="submit" name="_eventId_phoneEntered" value="Lookup Customer">
    </form:form>
</body>
</html>
