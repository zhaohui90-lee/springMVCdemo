<%--
  Created by IntelliJ IDEA.
  User: 40431
  Date: 2020-01-03
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>checkDeliveryArea</title>
</head>
<body>
    <h1>Your delivery area does not in the service area!</h1>
    <form:form>
        <input type="submit" name="_eventId_accept" value="accept">
        <input type="submit" name="_eventId_cancel" value="cancel">
    </form:form>
</body>
</html>
