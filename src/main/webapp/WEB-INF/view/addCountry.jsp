<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.04.2019
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>addCountry</title>
</head>
<body>
<form:form method="POST" action="/app/saveCountry">
    <table>
        <tr>
            <td>Country</td>
            <td><input type="text" id ="txt" name="name" ></td>
        </tr>
        <tr>
            <td>Continent</td>
            <td>
                <select name="continent">
                    <c:forEach items="${requestScope.continents}" var="continent">
                        <option><c:out value="${continent.getContinentName()}"/></option>
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
        <td>Country</td>
        <td>Continent</td>
    </tr>
    <c:forEach items="${requestScope.countries}" var="country">
        <tr>
            <td><c:out value="${country.getName()}"/></td>
            <td><c:out value="${country.getContinentId().getContinentName()}"/></td>


            <form:form method="POST" action="/app/modifyCountry">
                <input type="hidden" value="${country.getId()}" name="id">
                <td><input type="text" name="name"></td>
                <td>
                    <select name="continent">
                        <c:forEach items="${requestScope.continents}" var="continent">
                            <option><c:out value="${continent.getContinentName()}"/></option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="submit" onclick="return confirm('Do you really want to modify this element?');" value="Modify" name="modify"></td>
            </form:form>
            <form:form method="POST" action="/app/deleteCountry">
                <input type="hidden" value="${country.getId()}" name="id">
                <td><input type="submit" onclick="return confirm('Do you really want to delete this element?');" value="Delete" name="delete"></td>
            </form:form>
        </tr>
    </c:forEach>
</table>
</body>
</html>
