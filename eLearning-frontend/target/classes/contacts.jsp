<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center">Contacts</h1>
	<hr>
	<div class="d-flex justify-content-center">
		<a href="<c:url value='/' />" class="btn btn-primary mr-1 mb-1">Home</a>
		<a href="<c:url value='/add-contact' />" class="btn btn-primary mr-1 mb-1">New Contact</a>
	</div>
	<table class="table">
		<tr>
			<th>Contact ID</th>
			<th>User ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Message</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="contact" items="${ contacts }">
			<tr>
				<td>${ contact.contactId }</td>
				<td>${ contact.userId }</td>
				<td>${ contact.name }</td>
				<td>${ contact.email }</td>
				<td>${ contact.phoneNo }</td>
				<td>${ contact.message }</td>
				<td><a class="btn btn-secondary mr-1"
					href="<c:url value='/delete-contact/${ contact.contactId }' />">Delete</a>
					<a class="btn btn-secondary"
					href="<c:url value='/update-contact/${ contact.contactId }' />">Update</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>