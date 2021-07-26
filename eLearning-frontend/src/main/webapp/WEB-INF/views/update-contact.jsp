<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Contact</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</head>
<body>
<h1 class="text-center">Update Contact</h1>
	<hr>
	<c:url var="updateUrl" value="/update-contact" />
	<form:form action="${ updateUrl }" method="POST" modelAttribute="contact" autocomplete="off">
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">Contact Id</label>
			<div class="col-sm-3">
				<form:input path="contactId" cssClass="form-control" readonly="true"/>
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">User ID</label>
			<div class="col-sm-3">
				<form:input path="userId" cssClass="form-control"  />
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">Name</label>
			<div class="col-sm-3">
				<form:input path="name" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">Email</label>
			<div class="col-sm-3">
				<form:input path="email" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">Phone No.</label>
			<div class="col-sm-3">
				<form:input path="phoneNo" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">Message</label>
			<div class="col-sm-3">
				<form:input path="message" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<input type="submit" class="btn btn-primary mr-1" value="Update" />
			<a href="<c:url value='/contact-list' />" class="btn btn-secondary">Back</a>
		</div>
	</form:form>
</body>
</html>