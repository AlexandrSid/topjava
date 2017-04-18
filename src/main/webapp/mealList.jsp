<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 2017-04-07
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Meal List</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>
    <h3>Meal List</h3>

    <form method="post" action="meals?action=filter">
        <dl>
            <dt>From Date</dt>
            <dd><input type="date" name="Start Date" value="${startDate}"></dd>
        </dl>
        <dl>
            <dt>To Date</dt>
            <dd><input type="date" name="End Date" value="${endDate}"></dd>
        </dl>
        <dl>
            <dt>From Time</dt>
            <dd><input type="time" name="Start Time" value="${startTime}"></dd>
        </dl>
        <dl>
            <dt>To Time</dt>
            <dd><input type="time" name="EndTime" value="${endTime}"></dd>
        </dl>
        <button type="submit">Filter</button>
    </form>

    <hr>
    <h4><a href="meals?action=create">Add Meal</a></h4>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Time</th>
            <th>Descripption</th>
            <th>Calories</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${mealList}" var="meal">
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.to.UserMealWithExceed"/>
            <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                <td>
                        ${meal.dateTime.toLocalDate()}
                        ${meal.dateTime.toLocalTime()}
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
                <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
            </tr>
        </c:forEach>


    </table>
</section>
</body>
</html>
