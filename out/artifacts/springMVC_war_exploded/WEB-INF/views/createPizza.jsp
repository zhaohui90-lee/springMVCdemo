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
    <div align="center">
        <h2>Create Pizza</h2>
        <form:form modelAttribute="pizza">
            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

            <b>Size:</b>
            <br/>
            <table >
                <tr>
                    <td><form:radiobutton path="size" label="Small(12-inch)---$6.99" value="SMALL"/></td>
                    <td><form:radiobutton path="size" label="Medium(14-inch)---$7.99" value="MEDIUM"/></td>
                    <td><form:radiobutton path="size" label="Large(16-inch)---$8.99" value="LARGE"/></td>
                    <td><form:radiobutton path="size" label="Ginormous(20-inch)---$9.99" value="GINORMOUS"/></td>
                </tr>
            </table>
            <br/>
            <br/>
            <b>Toppings: PRICE_PER_TOPPING 0.20$</b>
            <br/>
            <table>
                <tr>
                    <td><form:checkboxes path="toppings" name="topping" items="${toppingsList}" delimiter="<br/>"/></td>
                </tr>
            </table>
            <br/>
            <br/>
            <b>Hyperchannel</b>
            <table>
                <tr>
                    <td><form:checkbox path="specialPizza" label="MEAT" value="MEAT"/></td>
                </tr>
                <tr>
                    <td><form:checkbox path="specialPizza" label="VEGGIE" value="VEGGIE"/></td>
                </tr>
                <tr>
                    <td><form:checkbox path="specialPizza" label="THEWORKS" value="THEWORKS"/></td>
                </tr>
            </table>
            <input type="submit" name="_eventId_addPizza" class="button" value="Continue"/>
            <input type="submit" name="_eventId_cancel" class="button" value="Cancel">
        </form:form>
    </div>
</body>
</html>
