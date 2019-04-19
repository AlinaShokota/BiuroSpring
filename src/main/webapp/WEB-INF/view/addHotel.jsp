<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.04.2019
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<head>
    <title>addHotel</title>
</head>
<body>
<form:form method="POST" action="/app/saveHotel">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" id ="txt" name="name" ></td>
        </tr>
        <tr>
        <tr>
            <td>Standart</td>
            <td>
                <select name="standart">
                    <option>One star</option>
                    <option>Two stars</option>
                    <option>Three stars</option>
                    <option>Four stars</option>
                    <option>Five stars</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Description</td>
            <td><textarea type="text" name="description" size="60" placeholder="max lenght 255"
                          maxlength="255" rows="4" cols="50"></textarea></td>
        </tr>
            <td>City</td>
            <td>
                <select name="city">
                    <c:forEach items="${requestScope.cities}" var="city">
                        <option><c:out value="${city.getName()}"/></option>
                    </c:forEach>
                </select>
            </td>

        </tr>
        <tr>
            <td><input type="submit" value="Zapisz"/></td>
        </tr>
    </table>
</form:form>

<table>
    <tr>
        <td>Name</td>
        <td>Standard</td>
        <td>Description</td>
        <td>City</td>
    </tr>
    <c:forEach items="${requestScope.hotels}" var="hotel">
        <tr>
            <td><c:out value="${hotel.getName()}"/></td>
            <td><c:out value="${hotel.getStandard()}"/></td>
            <td><c:out value="${hotel.getDescription()}"/></td>
            <td><c:out value="${hotel.getCityId().getName()}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
