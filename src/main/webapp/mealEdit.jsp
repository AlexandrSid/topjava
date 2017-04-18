<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 2017-04-10
  Time: 1:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Meal</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h2><a href= "index.html">Home</a></h2>
    <h3>Edit Meal</h3>
    <hr>
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.UserMeal" scope="request"/>
    <form method="post" action="meals">
        <input type="hidden" name="id" value="${meal.id}">
        <dl>
            <dt>Date Time</dt>
            <dd><input type="datetime-local" value="${meal.dateTime}" name="dateTime"></dd>
        </dl>
        <dl>
            <dt>Description</dt>
            <dd><input type="text" value="${meal.description}" size="40" name="description"></dd>
        </dl>
        <dl>
            <dt>Calories</dt>
            <dd><input type="number" value="${meal.calories}" name="calories"></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()">Cancel</button>
    </form>
</section>

</body>
</html>
