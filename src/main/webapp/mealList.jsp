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
    <style>
        .normal {
            color: green;
        }

        .exceeded {
            color: red;
        }
    </style>
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>
    <h3>Meal List</h3>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Time</th>
            <th>Descripption</th>
            <th>Calories</th>
        </tr>
        </thead>
        <c:forEach items="${mealList}" var="meal">
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.UserMealWithExceed"/>
            <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                <td>
                        ${meal.dateTime.toLocalDate()}
                        ${meal.dateTime.toLocalTime()}
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
            </tr>
        </c:forEach>

        <%--<c:forEach items="${mealList}" var="meal">--%>
        <%--<jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.UserMealWithExceed"/>--%>
        <%--<tr class="${meal.exceed ? 'exceeded' : 'normal'}">--%>
        <%--<td>--%>
        <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
        <%--&lt;%&ndash;<%=TimeUtil.toString(meal.getDateTime())%>&ndash;%&gt;--%>
        <%--</td>--%>
        <%--<td>${meal.description}</td>--%>
        <%--<td>${meal.calories}</td>--%>
        <%--</tr>--%>
        <%--</c:forEach>--%>

    </table>
</section>
</body>
</html>
