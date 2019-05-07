<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.04.2019
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<html>
<head>
    <title>addTrip</title>
</head>
<body>
<form:form method="POST" action="/app/saveTrip">
    <table>

        <tr>
            <td>Airport from</td>
            <td>
                <select name="airportFrom">
                    <c:forEach items="${requestScope.airports}" var="airport">
                        <option><c:out value="${airport.getName()}"/></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Airport to</td>
            <td>
                <select name="airportTo">
                    <c:forEach items="${requestScope.airports}" var="airport">
                        <option><c:out value="${airport.getName()}"/></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Hotel</td>
            <td>
                <select name="hotelTo">
                    <c:forEach items="${requestScope.hotels}" var="hotel">
                        <option><c:out value="${hotel.getName()}"/></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>City</td>
            <td>
                <select name="cityTo">
                    <c:forEach items="${requestScope.cities}" var="city">
                        <option><c:out value="${city.getName()}"/></option>
                    </c:forEach>
                </select>
            </td>

        </tr>
        <tr>
            <td>Depature</td>
            <td>
                <input type="date" name="departureDate">

            </td>
        </tr>
        <tr>
            <td>Return</td>
            <td>
                <input type="date" name="returnDate">
            </td>
        </tr>
        <tr>
            <td>Count of days</td>
            <td>
                <input type="number" name="countOfDays">
            </td>
        </tr>
        <tr>
            <td>Type</td>
            <td>
                <select name="type">
                    <option>BB</option>
                    <option>HB</option>
                    <option>FB</option>
                    <option>AI</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Price for Adult</td>
            <td>
                <input type="number" name="priceForAdult">
            </td>
        </tr>
        <tr>
            <td>Price for Child</td>
            <td>
                <input type="number" name="priceForChild">
            </td>
        </tr>
        <tr>
            <td>Promotion</td>
            <td>
                <input type="number" name="promotion">
            </td>
        </tr>
        <tr>
            <td>Count of persons</td>
            <td>
                <input type="number" name="countOfPersons">
            </td>
        </tr>

        <tr>
            <td>Description</td>
            <td><textarea type="text" name="description" size="60" placeholder="max lenght 255"
                          maxlength="255" rows="4" cols="50"></textarea></td>
        </tr>
        </tr>
        <tr>
            <td><input type="submit" value="Zapisz"/></td>
        </tr>
    </table>
</form:form>

<table>
    <tr>
        <td>Airport from</td>
        <td>Airport to</td>
        <td>Hotel</td>
        <td>City</td>
        <td>Departure</td>
        <td>Return</td>
        <td>Count of days</td>
        <td>Type</td>
        <td>Price for adult</td>
        <td>Price for Child</td>
        <td>Promotion</td>
        <td>Count of persons</td>
        <td>Description</td>
    </tr>
    <c:forEach items="${requestScope.trips}" var="trip">
        <tr>
            <td><c:out value="${trip.getAirportFrom().getName()}"/></td>
            <td><c:out value="${trip.getAirportTo().getName()}"/></td>
            <td><c:out value="${trip.getHotelTo().getName()}"/></td>
            <td><c:out value="${trip.getCityTo().getName()}"/></td>
            <td><c:out value="${trip.getDepartureDate()}"/></td>
            <td><c:out value="${trip.getReturnDate()}"/></td>
            <td><c:out value="${trip.getCountOfDays()}"/></td>
            <td><c:out value="${trip.getType()}"/></td>
            <td><c:out value="${trip.getPriceForAdult()}"/></td>
            <td><c:out value="${trip.getPriceForChild()}"/></td>
            <td><c:out value="${trip.getPromotion()}"/></td>
            <td><c:out value="${trip.getCountOfPersons()}"/></td>
            <td><c:out value="${trip.getDescription()}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
