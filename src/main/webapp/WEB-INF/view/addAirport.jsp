<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.04.2019
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>addAirport</title>
</head>
<body>
<form:form method="POST" action="/app/saveAirport">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" id="txt" name="name"></td>
        </tr>
        <tr>
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
        <td>City</td>
    </tr>
    <c:forEach items="${requestScope.airports}" var="airport">
        <tr>
            <td><c:out value="${airport.getName()}"/></td>
            <td><c:out value="${airport.getCityId().getName()}"/></td>

            <form:form method="POST" action="/app/modifyAirport">
                <input type="hidden" value="${airport.getId()}" name="id">
                <td><input type="text" name="name"></td>
                <td>
                    <select name="city">
                        <c:forEach items="${requestScope.cities}" var="city">
                            <option><c:out value="${city.getName()}"/></option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="submit" onclick="return confirm('Do you really want to modify this element?');" value="Modify" name="modify"></td>
            </form:form>
            <form:form method="POST" action="/app/deleteAirport">
                <input type="hidden" value="${airport.getId()}" name="id">
                <td><input type="submit" onclick="return confirm('Do you really want to delete this element?');" value="Delete" name="delete"></td>
            </form:form>
        </tr>
    </c:forEach>
</table>
</body>

</html>
