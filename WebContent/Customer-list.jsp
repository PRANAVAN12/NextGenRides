<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title> Rides NextGen</title>
</head>
<body>
	<center>
		<h1>Customer Management</h1>
        <h2>
        	<a href="<%=request.getContextPath()%>/NewCustomer">Add New Customer</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="<%=request.getContextPath()%>/CustomerList">List All Customer</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Customers</h2></caption>
            <tr>
                <th>ID</th>
                <th>UserName</th>
                <th>Email</th>
                <th>Country</th>
                <th>password</th>
                <th>phone</th>
                
                <th>Actions</th>
            </tr>
            <c:forEach var="customer" items="${Customerlis}">
                <tr>
                    <td><c:out value="${customer.id}" /></td>
                    <td><c:out value="${customer.username}" /></td>
                    <td><c:out value="${customer.email}" /></td>
                    <td><c:out value="${customer.country}" /></td>
                    <td><c:out value="${customer.password}" /></td>
                    <td><c:out value="${customer.phone}" /></td>
                   
                    <td>
                    	<a href="<%=request.getContextPath()%>/CustomerEdit?id=<c:out value='${customer.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="<%=request.getContextPath()%>/CustomerDelete?id=<c:out value='${customer.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
    
</body>
</html>
