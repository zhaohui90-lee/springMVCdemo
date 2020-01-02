<%--
  Created by IntelliJ IDEA.
  User: 40431
  Date: 2020-01-02
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:form="http://www.springframework.org/tags/form">
<head>
    <title>Create Pizza</title>
</head>
<body>
    <form:form commandName="pizza">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
    </form:form>
</body>
</html>
