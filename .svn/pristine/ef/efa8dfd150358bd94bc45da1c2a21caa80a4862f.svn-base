<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<h1></h1>
	<div class="container">
		<form:form method="POST" action="addField.html"
			modelAttribute="addField" class="form-horizontal" role="form">
			<div id="legend">
				<legend>Add an Additional Field Here</legend>
			</div>
			<div class="form-group">
				<label for="fieldname" class="col-md-2 control-label">Field
					Name:</label>
				<div class="col-md-3">
					<form:input path="name" />
				</div>
			</div>
			<div class="form-group">
				<label for="fieldname" class="col-md-2 control-label">Field
					type: </label>
				<div class="col-md-3">
					<form:select path="type">
						<form:option value="number" selected="selected">Number</form:option>
						<form:option value="text">Text</form:option>
						<form:option value="file">File</form:option>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label for="fieldname" class="col-md-2 control-label">Required
					Field: </label>
				<div class="col-md-3">
					<form:checkbox path="required" value="Required" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-3">
					<input class="btn btn-primary" type="submit" name="submit"
						value="Add Requirement">
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>