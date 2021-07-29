<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Feedback</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</head>
<body>
<h1 class="text-center">New Feedback</h1>
	<hr>
	<form:form action="add-feedback" method="POST" modelAttribute="feedback" autocomplete="off">
<!-- 		<div class="form-group row justify-content-md-center"> -->
<!-- 			<label class="col-sm-1">Feedback Id</label> -->
<!-- 			<div class="col-sm-3"> -->
<%-- 				<form:input path="fId" cssClass="form-control" /> --%>
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<div class="form-group row justify-content-md-center"> -->
<!-- 			<label class="col-sm-1">User ID</label> -->
<!-- 			<div class="col-sm-3"> -->
<%-- 				<form:input path="userId" cssClass="form-control"  /> --%>
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<div class="form-group row justify-content-md-center"> -->
<!-- 			<label class="col-sm-1">Name</label> -->
<!-- 			<div class="col-sm-3"> -->
<%-- 				<form:input path="name" cssClass="form-control" /> --%>
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 		<div class="form-group row justify-content-md-center"> -->
<!-- 			<label class="col-sm-1">Email</label> -->
<!-- 			<div class="col-sm-3"> -->
<%-- 				<form:input path="email" cssClass="form-control" /> --%>
<!-- 			</div> -->
<!-- 		</div> -->
		<form:hidden path="userId"/>
		<form:hidden path="name"/>
		<form:hidden path="email"/>
		<div class="form-group row justify-content-md-center">
			<label class="col-sm-1">Feedback</label>
			<div class="col-sm-3">
				<form:input path="feedback" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group row justify-content-md-center">
			<input type="submit" class="btn btn-primary mr-1" value="Add Feedback" />
			<input type="reset" class="btn btn-secondary" value="Cancel" />
		</div>
	</form:form>
</body>
</html>