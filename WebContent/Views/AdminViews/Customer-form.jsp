<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>NextGen Rides</title>
</head>
<body>
	<center>
		<h1>Customer Management</h1>
        <h2>
        	<a href="NewCustomer">Add New Customer</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="CustomerList" >List All Customers</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${customer != null}">
			<form action="CustomerUpdate" method="post">
        </c:if>
        <c:if test="${customer == null}">
			<form action="InsertCustomer" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${customer != null}">
            			Edit User
            		</c:if>
            		<c:if test="${customer == null}">
            			Add New Customer
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${user != null}">
        			<input type="hidden" name="id" value="<c:out value='${customer.id}' />" />
        		</c:if>            
            <tr>
                <th>User Name: </th>
                <td>
                	<input type="text" name="username" size="45"
                			value="<c:out value='${customer.username}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                	<input type="text" name="email" size="45"
                			value="<c:out value='${customer.email}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Country</th>
                <td>
                	<input type="text" name="country" size="15"
                			value="<c:out value='${customer.country}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                	<input type="text" name="password" size="15"
                			value="<c:out value='${customer.password}' />"
                	/>
                </td>
            </tr>
             <tr>
                <th>phone: </th>
                <td>
                	<input type="text" name="phone" size="15"
                			value="<c:out value='${customer.phone}' />"
                	/>
                </td>
            
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit"  />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
