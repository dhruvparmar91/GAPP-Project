<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Register Page</title>
</head>
<body>

<form:form modelAttribute="user" class="form-horizontal" method='post' action='register.html'
		style="margin: 25px">
		<fieldset>
			<legend>Register</legend>
			<div class="control-group">
				<label class="control-label">Firstname</label>
				<div class="controls">
					<form:input path="firstName" class="input-xlarge" />
					<form:errors path="firstName"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">Lastname</label>
				<div class="controls">
					<form:input path="lastName" class="input-xlarge" />
					<form:errors path="lastName"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">Email</label>
				<div class="controls">
					<form:input path="email" class="input-xlarge" />
					<form:errors path="email"/>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label">Password</label>
				<div class="controls">
					<input type="password" class="input-xlarge" id="password"
						name="password">
						<form:errors path="password"/>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label"></label>
				<div class="controls">
					<button type="submit" class="btn btn-success">Register</button>
				</div>
			</div>

		</fieldset>
	</form:form>
</body>
</html>