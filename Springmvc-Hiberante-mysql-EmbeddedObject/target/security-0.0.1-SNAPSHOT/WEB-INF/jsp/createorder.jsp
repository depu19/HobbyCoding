<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Place Order</title>
</head>
<body>
	<%-- <c:url var="addOrder" value="/security/order/create" ></c:url> --%>
	<form name="order" method="post" action="/security/order/create">
		<table>
			<tr>
				<td><form:label path="order.customerName">
						<spring:message text="Customer Name" />
					</form:label></td>

				<td><form:input type="text" path="order.customerName" /></td>
			</tr>
			<tr>
				<td><form:label path="order.emailId">
						<spring:message text="Email Id" />
					</form:label></td>

				<td><form:input type="text" path="order.emailId" /></td>
			</tr>
			<tr>
				<td><form:label path="order.item">
						<spring:message text="Item" />
					</form:label></td>

				<td><form:input type="text" path="order.item" /></td>
			</tr>
			<tr>
				<td><input type="submit"/></td>
				<td></td>
			</tr>
			</table>
</form>
<c:out value="Order Placed successfully"></c:out>
</body>
</html>