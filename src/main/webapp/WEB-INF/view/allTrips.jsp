<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.04.2019
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>trips</title>
</head>
<body>
<table>
    <col width="30%">
    <col width="30%">
    <col width="30%">
    <tr>
        <c:forEach items="${requestScope.trips}" var="trip">
            <td>
                <c:out value="From: ${trip.getAirportFrom().getName()}"/><br>
                <c:out value="to: ${trip.getAirportTo().getName()}"/><br>
                <c:out value="Hotel: ${trip.getHotelTo().getName()}"/><br>
                <c:out value="City: ${trip.getCityTo().getName()}"/><br>
                <c:out value="Depature date: ${trip.getDepatureDate()}"/><br>
                <c:out value="Return date: ${trip.getReturnDate()}"/><br>
                <c:out value="Count of days: ${trip.getCountOfDays()}"/><br>
                <c:out value="Type: ${trip.getType()}"/><br>
                <c:out value="Price for adult: ${trip.getPriceForAdult()}"/><br>
                <c:out value="Price for child: ${trip.getPriceForChild()}"/><br>
                <c:out value="Count of persons: ${trip.getCountOfPersons()}"/><br>
                <c:out value="Description: ${trip.getDescription()}"/><br>
            </td>
        </c:forEach>
    </tr>
</table>



<table>
    <col width="30%">
    <col width="30%">
    <col width="30%">
    <tr>
        <c:forEach items="${requestScope.nearestTrips}" var="trip">
            <td>
                <c:out value="From: ${trip.getAirportFrom().getName()}"/><br>
                <c:out value="to: ${trip.getAirportTo().getName()}"/><br>
                <c:out value="Hotel: ${trip.getHotelTo().getName()}"/><br>
                <c:out value="City: ${trip.getCityTo().getName()}"/><br>
                <c:out value="Depature date: ${trip.getDepatureDate()}"/><br>
                <c:out value="Return date: ${trip.getReturnDate()}"/><br>
                <c:out value="Count of days: ${trip.getCountOfDays()}"/><br>
                <c:out value="Type: ${trip.getType()}"/><br>
                <c:out value="Price for adult: ${trip.getPriceForAdult()}"/><br>
                <c:out value="Price for child: ${trip.getPriceForChild()}"/><br>
                <c:out value="Count of persons: ${trip.getCountOfPersons()}"/><br>
                <c:out value="Description: ${trip.getDescription()}"/><br>
            </td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
