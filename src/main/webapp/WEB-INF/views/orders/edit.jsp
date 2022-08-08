<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Update book</h3>
<%--@elvariable id="orders" type="andrzej.cieslik.ac.end_project.model.Order"--%>
<form:form modelAttribute="orders" cssClass="some-class" action="/author-form/update">
    <form:input path="client"/>
    <form:input path="orderState"/>
    <input type="submit"/>
</form:form>

</body>
</html>
