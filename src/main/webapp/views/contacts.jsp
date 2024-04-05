<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>
	function confirmDelete(){
		return confirm("Are you sure, you want to delete)
	}
</script>

</head>
<body>
	
	<a href="contact">+Add New Contact</a>
    <table border="1">
    	<thead>
    		<tr>
    			<td>Name</td>
    			<td>Email</td>
    			<td>Number</td>
    			<td>Action</td>
    		</tr>
    	</thead>
    	<tbody>
    	
    		<c: forEach items="${contacts}" var="contact">
    		<tr>
    			<td>${contact.contactName}</td>
    			<td>${contact.contactEmail}</td>
    			<td>${contact.contactNumber}</td>
    			<td><a href="edit?cid=${contact.contactId}">Edit</a> 
    			<a href="delete?cid=${contact.contactId}">Delete</a></td>
    		</tr>
    		</c:forEach>
    	</tbody>
    </table>

</body>
</html>
