<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.04.2019
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>addCity</title>
</head>
<body>
<form:form method="POST" action="/app/saveCity">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" id ="txt" name="name" ></td>
        </tr>
        <tr>
            <td>Country</td>
            <td>
                <select name="country">
                    <c:forEach items="${requestScope.countries}" var="country">
                        <option><c:out value="${country.getName()}"/></option>
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
        <td>City</td>
    </tr>
    <c:forEach items="${requestScope.cities}" var="city">
        <tr>
            <td><c:out value="${city.getName()}"/></td>
            <td><c:out value="${city.getCountryId().getName()}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
