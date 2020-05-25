<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title> Rides NextGen</title>
</head>
<body>
	<center>
		<h1>Booking Management</h1>
        <h2>
        	<a href="BookingNew">Add New booking</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="BookingList">List All bookings</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of bookings</h2></caption>
            <tr>
                <th>ID</th>
                <th>UserName</th>
                <th>Rent_date</th>
                <th>destination_start</th>
                <th>destination_end</th>
                <th>payment</th>
                <th>bike</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.rent_date}" /></td>
                    <td><c:out value="${user.destination_start}" /></td>
                    <td><c:out value="${user.destination_end}" /></td>
                    <td><c:out value="${user.payment}" /></td>
                    <td><c:out value="${user.bike}" /></td>
                    <td>
                    	<a href="BookingEdit?id=<c:out value='${user.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="BookingDelete?id=<c:out value='${user.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
    
</body>
</html>
