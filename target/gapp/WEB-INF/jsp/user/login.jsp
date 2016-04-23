<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Login Page</title>
</head>
<body>
	<form:form modelAttribute="user" class="form-horizontal"
		method='post' action='login.html' style="margin: 25px">
		<fieldset>
			<legend>Login</legend>
			<div class="control-group">
				<label class="control-label">Email</label>
				<div class="controls">
					<form:input path="email" class="input-xlarge" />
					<form:errors path="email" />
				</div>
			</div>


			<div class="control-group">
				<label class="control-label">Password</label>
				<div class="controls">
					<form:input type="password" path="password" class="input-xlarge"
						name="password" />
					<form:errors path="password" />
				</div>
			</div>

			<div class="control-group">
				<label class="control-label"></label>
				<div class="controls">
					<button type="submit" class="btn btn-success">Login</button>
				</div>
			</div>
		</fieldset>
	</form:form>

</body>
</html>