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
        <th>name</th>
        <th>description</th>
        <th>smallFotoLink</th>
        <th>fotosLink</th>
        <th>deliveryPeriod</th>
        <th>price</th>
        <th>quantity</th>
        <th>active</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td hidden>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.smallFotoLink}</td>
            <td>${product.fotosLink}</td>
            <td>${product.deliveryPeriod}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.active}</td>
            <td>
                <a href="<c:url value="/product-form/delete/${product.id}"/>">delete</a></br>
                <a href="<c:url value="/product-form/edit/${product.id}"/>">update</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>