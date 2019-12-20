<%--
  Created by IntelliJ IDEA.
  User: 40431
  Date: 2019-12-17
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>spittle1</title>
</head>
<body>
    <h1>spittle1</h1>
    <c:out value="${spittleList}"/>
    <c:forEach items="${spittleList}" var="spittle">
        <li id="spittle_<c:out value="${spittle.id}"/>">
            <div class="spittleMessage">
                <c:out value="${spittle.message}"/>
            </div>
            <div>
                <span class="spittleTime"><c:out value="${spittle.time}"/></span>
                <span class="spittleLocation">
                    (<c:out value="${spittle.latitude}"/>,
                    <c:out value="${spittle.longitude}"/>)
                </span>
            </div>
        </li>
    </c:forEach>
</body>
</html>
