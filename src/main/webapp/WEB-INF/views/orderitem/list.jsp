<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/home-form/"/>">home</a>
<table>
    <tr>
        <th>product_name</th>
        <th>price</th>
        <th>quantity</th>
        <th>order_status</th>
    </tr>
    <c:forEach items="${orderItems}" var="orderitem"><%--@elvariable id="product" type="javax.xml.stream.util.StreamReaderDelegate"--%>
    <%--@elvariable id="order" type="javax.sql.rowset.spi.SyncResolver"--%>
        <tr>
            <td>${product.name}</td>
            <td>${orderitem.price}</td>
            <td>${orderitem.quantity}</td>
            <td>${order.status}</td>


            <td>
                <a href="<c:url value="/orderitem-form/update/${address.id}"/>">buy</a></br>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>