<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Edit Program Page</title>
</head>
<body>
<h1></h1>
	<div class="container">
		<form:form modelAttribute="program">
Program Name: <form:input path="name" />
			<input type="submit" class="btn btn-primary" name="submit"
				value="Save" />
		</form:form>
	</div>
</body>
</html>