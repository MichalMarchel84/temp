<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="clients" type="andrzej.cieslik.ac.end_project.model.Client"--%>
<form:form modelAttribute="clients" cssClass="some-class">
    <form:input path="firstName"/>
    <form:input path="lastName"/>
    <form:input path="city"/>
    <form:input path="street"/>
    <form:input path="number"/>
    <form:input path="postcode"/>
    <form:input path="deliveryAddress"/>
    <input type="submit"/>
</form:form>
</body>
</html>