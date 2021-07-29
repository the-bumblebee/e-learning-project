<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</head>
<body>
	<h1 class="text-center">Update User</h1>
	<hr>
	<c:url var="updateUrl" value="/update-user" />
	<form:form action="${ updateUrl }" method="POST" modelAttribute="user" enctype="multipart/form-data" autocomplete="off">
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">User Id</label>
			<div class="col-sm-3">
				<form:input path="userId" cssClass="form-control" readonly="true"/>
<!-- 				<input type="hidden" name="id" value="234234" /> For validating userId -->
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">Name</label>
			<div class="col-sm-3">
				<form:input path="name" cssClass="form-control"  />
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">Phone No.</label>
			<div class="col-sm-3">
				<form:input path="phoneNo" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">Email</label>
			<div class="col-sm-3">
				<form:input path="email" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">Address</label>
			<div class="col-sm-3">
				<form:input path="address" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">Reg Date</label>
			<div class="col-sm-3">
				<input type="date" class="form-control" name="reg-date" value="${ user.regDate }" />
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">Password</label>
			<div class="col-sm-3">
				<form:password path="password" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">Upload Photo</label>
			<div class="col-sm-3 custom-file">
				<input type="file" class="custom-file-input" name="upload-photo" accept="image/*" value="${ user.uploadPhoto } "/>
				<label class="custom-file-label">Choose Photo</label>
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<input type="submit" class="btn btn-primary mr-1" value="Update" />
			<a href="<c:url value='/user-list' />" class="btn btn-secondary">Back</a>
		</div>
	</form:form>
	<script type="application/javascript">
		$('input[type="file"]').change(function(e){
			var fileName = e.target.files[0].name;
			$('.custom-file-label').text(fileName);
		});
	</script>
</body>
</html>