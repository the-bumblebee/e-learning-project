<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center">Courses</h1>
	<hr>
	<div class="d-flex justify-content-center">
		<a href="<c:url value='/' />" class="btn btn-primary mr-1 mb-1">Home</a>
		<a href="<c:url value='/add-course' />" class="btn btn-primary mr-1 mb-1">New Course</a>
	</div>
	<table class="table">
		<tr>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Description</th>
			<th>Fees</th>
			<th>Resource</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="course" items="${ courses }">
			<tr>
				<td>${ course.courseId }</td>
				<td>${ course.cName }</td>
				<td>${ course.cDesp }</td>
				<td>${ course.cFees }</td>
				<td>${ course.cResource }</td>
				<td><a class="btn btn-secondary mr-1"
					href="<c:url value='/delete-course/${ course.courseId }' />">Delete</a>
					<a class="btn btn-secondary"
					href="<c:url value='/update-course/${ course.courseId }' />">Update</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>