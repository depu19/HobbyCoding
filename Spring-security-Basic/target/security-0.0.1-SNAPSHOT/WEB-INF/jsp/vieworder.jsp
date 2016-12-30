<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>View Placed Order</title>
</head>
<body>
	
	<table>
	    <tr>
	        <td>Customer Name </td>
	        <td>Email Id</td>  
	        <td>Item</td>
	    </tr>
    <c:forEach items="${orderList}" var="order">
    		<tr><td><c:out value="${order.customerName}"/></td><td><c:out value="${order.emailId}"/></td><td><c:out value="${order.item}"/></td></tr>
	</c:forEach>
	
	<tr><td><form action="/security/order/index">
    <input type="submit" value="Ok" />
			</form></td></tr>
	
	</table>
	
				
</body>
</html>