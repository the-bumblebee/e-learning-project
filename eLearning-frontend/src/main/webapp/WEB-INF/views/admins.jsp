<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admins List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center">Admins</h1>
	<hr>
	<div class="d-flex justify-content-center">
		<a href="<c:url value='/' />" class="btn btn-primary mr-1 mb-1">Home</a>
	</div>
	<table class="table">
		<tr>
			<th>Admin ID</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
		<c:forEach var="admin" items="${ admins }">
			<tr>
				<td>${ admin.adminId }</td>
				<td>${ admin.name }</td>
				<td>${ admin.email }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>