<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center">Users</h1>
	<hr>
	<div class="d-flex justify-content-center">
		<a href="<c:url value='/' />" class="btn btn-primary mr-1 mb-1">Home</a>
	</div>
	<table class="table">
		<tr>
			<th>User ID</th>
			<th>Avatar</th>
			<th>Name</th>
			<th>Phone Number</th>
			<th>Email</th>
			<th>Address</th>
			<th>Registration Date</th>
			<th>Actions</th>
		</tr>
		<tr>
			<td class="align-middle">${ user.userId }</td>
			<td class="align-middle">
				<img src="data:image/jpeg;base64,${ user.uploadPhoto }" width="50px" />
			</td>
			<td class="align-middle">${ user.name }</td>
			<td class="align-middle">${ user.phoneNo }</td>
			<td class="align-middle">${ user.email }</td>
			<td class="align-middle">${ user.address }</td>
			<fmt:parseDate value="${ user.regDate }" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
			<td class="align-middle"><fmt:formatDate value="${ parsedDate }" pattern="dd-MM-yyyy" /></td>
			<td class="align-middle">
				<a class="btn btn-secondary" href="<c:url value='/user/update' />">Update</a>
			</td>
		</tr>
	</table>
</body>
</html>