<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/home-form/"/>">home</a>
<ul>
    <c:forEach items="${orders}" var="order">
        <li>
            <p>${order.key.getFirstName()} ${order.key.getLastName()}</p>
            <table>
                <tr>
                    <th>id</th>
                    <th>state</th>
                    <th>change state</th>
                </tr>
                <c:forEach items="${order.value}" var="o">
                <tr>
                   <td>${o.getId()}</td>
                    <td>${o.orderState}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/order-form/change_order_status">
                            <input type="hidden" name="id" value="${o.getId()}">
                            <select name="state">
                                <option value="WAITING_FOR_PAYMENT">WAITING_FOR_PAYMENT</option>
                                <option value="PAYED">PAYED</option>
                                <option value="DELIVERED">DELIVERED</option>
                                <option value="CANCELED">CANCELED</option>
                            </select>
                            <button type="submit">submit</button>
                        </form>
                    </td>
                </tr>
                </c:forEach>

            </table>
        </li>

    </c:forEach>
</ul>

</body>
</html>
<%--
<td>${o.orderState}</td>--%>

