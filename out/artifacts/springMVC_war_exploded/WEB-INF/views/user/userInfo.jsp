<%--
  Created by IntelliJ IDEA.
  User: 40431
  Date: 2019-12-19
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>userInfo</title>
</head>
<body>
    <h1>userInfo</h1>
    <c:out value="${userInfo.userName}"/><br/>
    <c:out value="${userInfo.firstName}"/><br/>
    <c:out value="${userInfo.lastName}"/><br/>
    <c:out value="${userInfo.password}"/><br/>
    <c:out value="${userInfo.email}"/><br/>
    <c:out value="${userInfo.profileImage}"/>
</body>
</html>
