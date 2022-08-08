<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Update book</h3>
<%--@elvariable id="products" type="andrzej.cieslik.ac.end_project.model.Product"--%>
<form:form modelAttribute="products" cssClass="some-class" action="/product-form/update">
    <form:hidden path="id"/>
    <form:input path="name"/>
    <form:input path="description"/>
    <form:input path="smallFotoLink"/>
    <form:input path="fotosLink"/>
    <form:input path="deliveryPeriod"/>
    <form:input path="price"/>
    <form:input path="quantity"/>
    <form:input path="active"/>
    <input type="submit"/>
</form:form>

</body>
</html>
