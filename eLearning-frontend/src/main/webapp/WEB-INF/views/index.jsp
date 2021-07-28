<%@ page isELIgnored="false"%>
<!-- To enable expression -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>eLearning Portal</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<body>
	<h1 class="text-center">${ message }</h1>
	<hr>
	<div class="text-center">
		<a href="user-list" class="btn btn-outline-primary mr-1">Users</a> <a
			href="course-list" class="btn btn-outline-primary">Courses</a> <a
			href="feedback-list" class="btn btn-outline-primary">Feedbacks</a> <a
			href="contact-list" class="btn btn-outline-primary">Contacts</a> <a
			href="admin-list" class="btn btn-outline-primary">Admins</a>
	</div>
	<div
		class="bg-light rounded border border-secondary col-md-3 mx-auto mt-5 py-3">
		<h3 class="text-center">Login</h3>
		<c:if test="${ sessionScope.error != null }">
			<p class="text-danger">${ sessionScope.error }</p>
		</c:if>
		<form:form action="login" method="POST" modelAttribute="command"
			autocomplete="off">
			<div class="form-group">
				<label>Email</label>
				<form:input path="email" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label>Password</label>
				<form:password path="password" cssClass="form-control" />
			</div>
			<div class="form-group">
				<div class="form-check">
					<form:radiobutton path="accountType" cssClass="form-check-input"
						value="admin" />
					<label class="form-check-label" for="admin">Admin</label>
				</div>
				<div class="form-check">
					<form:radiobutton path="accountType" cssClass="form-check-input"
						value="user" checked="checked" />
					<label class="form-check-label" for="user">User</label>
				</div>
			</div>
			<div class="form-group row justify-content-md-center">
				<input type="submit" class="btn btn-primary col-md-6" value="Login" />
			</div>
		</form:form>
	</div>
</body>
</html>
