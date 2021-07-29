<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedbacks List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center">Feedbacks</h1>
	<hr>
	<div class="d-flex justify-content-center">
		<a href="<c:url value='/' />" class="btn btn-primary mr-1 mb-1">Home</a>
		<c:if test="${ sessionScope.accountType == 'user' }">
			<a href="<c:url value='/add-feedback' />" class="btn btn-primary mr-1 mb-1">New Feedback</a>
		</c:if>
	</div>
	<table class="table">
		<tr>
			<th>User ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Feedback</th>
			<c:if test="${ sessionScope.accountType == 'user' }">
				<th>Actions</th>
			</c:if>
		</tr>
		<c:forEach var="feedback" items="${ feedbacks }">
			<tr>
				<td>${ feedback.userId }</td>
				<td>${ feedback.name }</td>
				<td>${ feedback.email }</td>
				<td>${ feedback.feedback }</td>
				<c:if test="${ sessionScope.accountType == 'user' }">
				<c:set value="disabled" var="disabledClass"></c:set>
				<c:if test="${ feedback.userId == sessionScope.userId }">
					<c:set value="" var="disabledClass"></c:set>
				</c:if>
				<td><a class="btn btn-secondary mr-1 ${ disabledClass }"
					href="<c:url value='/delete-feedback/${ feedback.fId }' />">Delete</a>
					<a class="btn btn-secondary ${ disabledClass }"
					href="<c:url value='/update-feedback/${ feedback.fId }' />">Update</a>
				</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>