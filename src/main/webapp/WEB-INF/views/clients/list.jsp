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
        <th>firstName</th>
        <th>lastName</th>
        <th>city</th>
        <th>street</th>
        <th>number</th>
        <th>postcode</th>
        <th>deliveryAddress</th>

    </tr>
    <c:forEach items="${clients}" var="client">
        <tr>
            <td>${client.firstName}</td>
            <td>${client.lastName}</td>
            <td>${client.city}</td>
            <td>${client.street}</td>
            <td>${client.number}</td>
            <td>${client.postcode}</td>
            <td>${client.deliveryAddress}</td>
            <td>
                <a href="<c:url value="/client-form/delete/${client.id}"/>">delete</a></br>
                <a href="<c:url value="/client-form/edit/${client.id}"/>">update</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>