<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Index page</title>
</head>
<body>
	<%-- <c:url var="addOrder" value="/security/order/create" ></c:url> --%>
	
	<table>
	    <tr>
	        <td>Place order here </td><td><form action="/security/order/create"><input type="submit" value="Click here" /></form></td></tr>
	       <tr> <td>View order here</td><td><form action="/security/order/view"><input type="submit" value="Click here" /></form> <td></td>
	    </tr>
   
	
	</table>
	
				
</body>
</html>