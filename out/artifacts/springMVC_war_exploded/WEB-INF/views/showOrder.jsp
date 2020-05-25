<%--
  Created by IntelliJ IDEA.
  User: 40431
  Date: 2020-01-06
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>showOrder</title>
</head>
<body>
    <div align="center">
        <h2>Your Order</h2>

        <h3>Deliver to:</h3>
        <table>
            <tr>
                <td>name</td>
                <td>${order.customer.name}</td>
            </tr>
            <tr>
                <td>address</td>
                <td>${order.customer.address}</td>
            </tr>
            <tr>
                <td>city</td>
                <td>${order.customer.city}</td>
            </tr>
            <tr>
                <td>state</td>
                <td>${order.customer.state}</td>
            </tr>
            <tr>
                <td>zipCode</td>
                <td>${order.customer.zipCode}</td>
            </tr>
            <tr>
                <td>phoneNumber</td>
                <td>${order.customer.phoneNumber}</td>
            </tr>
        </table>
        <hr/>
        <h3>
            Order total:
            <fmt:formatNumber type="currency" value="${order.total}"/>
        </h3>
        <hr/>
        <h3>Pizzas:</h3>

        <c:if test="${fn:length(order.pizzas) eq 0}">
            <b>No pizzas in this order.</b>
        </c:if>

        <br/>
        <table border="1">
            <tr>
                <th>Size</th>
                <th>Toppings</th>
                <th>IsCombo</th>
                <th>Price</th>
            </tr>
            <c:forEach items="${order.pizzas}" var="pizza">
                <tr>
                    <td align="center">${pizza.size}</td>
                    <td align="center">
                        <c:forEach items="${pizza.toppings}" var="topping">
                            <c:out value="${topping}"/>
                        </c:forEach>
                    </td>
                    <td>${pizza.price}</td>
                </tr>
            </c:forEach>
        </table>
        <form:form>
            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">
            <input type="submit" name="_eventId_createPizza" value="createPizza"/>
            <input type="submit" name="_eventId_checkout" value="checkout"/>
            <input type="submit" name="_event_cancel" value="cancel"/>
        </form:form>
    </div>
</body>
</html>
