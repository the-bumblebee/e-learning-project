<%@ page isELIgnored="false"%>
<!-- To enable expression -->

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
	<h2 class="text-center">${ message }</h2>
	<hr>
	<div class="text-center">
		<a href="user-list" class="btn btn-outline-primary mr-1">Users</a>
		<a href="add-user" class="btn btn-outline-primary mr-1">Register</a>
		<a href="course-list" class="btn btn-outline-primary">Courses</a>
		<a href="feedback-list" class="btn btn-outline-primary">Feedbacks</a>
	</div>
</body>
</html>
