<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.04.2019
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<head>
    <title>admin</title>
</head>
<body>
<a href="addAirport">Airports</a>
<a href="addCity">Cities</a>
<a href="addCountry">Countries</a>
<a href="addHotel">Hotels</a>
<a href="addTrip">Trips</a>

<table>
    <tr>
        <c:forEach items="${requestScope.trips}" var="trip">
            <td>
                <c:out value="${trip.getAirportFrom()}"/><br>
                <c:out value="${trip.getAirportTo()}"/>
            </td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
