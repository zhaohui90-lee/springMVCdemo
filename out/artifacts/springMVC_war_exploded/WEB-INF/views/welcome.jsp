<%--
  Created by IntelliJ IDEA.
  User: 40431
  Date: 2019-12-26
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Welcome to pizza!</title>
</head>
<body>
    <h2>Welcome to pizza!</h2>
    <form:form>
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
        <input type="text" name="phoneNumber"/><br/>
        <input type="submit" name="_eventId_phoneEntered" value="Lookup Customer"/>
    </form:form>
</body>
</html>
