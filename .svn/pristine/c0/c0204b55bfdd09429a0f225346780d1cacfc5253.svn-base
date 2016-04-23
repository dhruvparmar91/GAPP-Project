<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Continue Application</title>
</head>
<body>
	<div class="container">

		<form:form modelAttribute="application" method="POST"
			 class="form-horizontal" role="form">
			<div id="legend">
				<legend>Applicant Information</legend>
			</div>
			<div class="form-group">
				<label for="lastName" class="col-md-2 control-label"> Last
					Name:</label>
				<div class="col-md-3">
					<form:input type="text" path="lastName" />
				</div>
			</div>
			<div class="form-group">
				<label for="firstName" class="col-md-2 control-label"> First
					Name:</label>
				<div class="col-md-3">
					<form:input type="text" path="firstName" />
				</div>
			</div>
			<div class="form-group">
				<label for="cin" class="col-md-2 control-label"> CIN:</label>
				<div class="col-md-3">
					<form:input type="number" path="cin" />
				</div>
			</div>
			<div class="form-group">
				<label for="phone" class="col-md-2 control-label"> Phone: </label>
				<div class="col-md-3">
					<form:input type="number" path="phone" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-md-2 control-label"> Email: </label>
				<div class="col-md-3">
					<form:input type="text" path="email" />
				</div>
			</div>
			<div class="form-group">
				<label for="gender" class="col-md-2 control-label"> Gender:
				</label>
				<div class="col-md-3">
					<form:radiobutton path="gender" value="male" />
					&nbsp;Male&nbsp;
					<form:radiobutton path="gender" value="female" />
					&nbsp;Female
				</div>
			</div>
			<div class="form-group">
				<label for="dob" class="col-md-2 control-label"> Date of
					Birth (MM/DD/YYYY): </label>
				<div class="col-md-3">
					<form:input type="text" path="dateOfBirth" />
				</div>
			</div>
			<div class="form-group">
				<label for="citizenship" class="col-md-2 control-label">
					Citizenship: </label>
				<div class="col-md-3">
					<form:input type="text" path="citizenship" />
				</div>
			</div>
			<div id="legend">
				<legend class="">Academic Records</legend>
			</div>
			<div class="form-group">
				<label for="toefl" class="col-md-2 control-label"> TOEFL
					Score (for international students): </label>
				<div class="col-md-3">
					<form:input type="number" path="toeflScore" />
				</div>
			</div>
			<div class="form-group">
				<label for="gre" class="col-md-2 control-label"> GRE Score
					(if required by department): </label>
				<div class="col-md-3">
					<form:input type="number" path="greScore" />
				</div>
			</div>
			<div class="form-group">
				<label for="gpa" class="col-md-2 control-label"> GPA: </label>
				<div class="col-md-3">
					<form:input type="text" path="gpa" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input class="btn btn-primary" type="submit" name="save"
						value="Save & Continue" />
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>