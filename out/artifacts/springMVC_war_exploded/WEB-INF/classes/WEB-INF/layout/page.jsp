<%--
  Created by IntelliJ IDEA.
  User: 忘却的旋律
  Date: 2019-12-20
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" %>
<html>
<head>
    <title>page</title>
</head>
<body>
    <div id="header">
        <t:insertAttribute name="header"/>
    </div>

    <div id="content">
        <t:insertAttribute name="body"/>
    </div>

    <div id="footer">
        <t:insertAttribute name="footer"/>
    </div>
</body>
</html>
