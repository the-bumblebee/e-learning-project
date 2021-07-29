<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center">Admin Dashboard</h1>
	<hr>
	<div class="text-center">
		<a href="<c:url value='/user-list' />" class="btn btn-outline-primary mr-1">Users</a> <a
			href="<c:url value='/course-list' />" class="btn btn-outline-primary">Courses</a> <a
			href="<c:url value='/feedback-list' />" class="btn btn-outline-primary">Feedbacks</a> <a
			href="<c:url value='/contact-list' />" class="btn btn-outline-primary">Contacts</a> <a
			href="<c:url value='/admin-list' />" class="btn btn-outline-primary">Admins</a> <a
			href="<c:url value='/logout' />" class="btn btn-outline-primary">Logout</a>
	</div>
	${ command.email } <br />
	${ command.password } <br />
	${ command.accountType } <br />
</body>
</html>