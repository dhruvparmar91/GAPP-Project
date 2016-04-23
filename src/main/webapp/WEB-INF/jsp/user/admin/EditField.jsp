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
		<h2>Edit Field</h2>
		<form:form modelAttribute="addField">
Field name: <form:input path="name" />
			<br />
Field type: <form:select path="type">
				<form:option value="number">Number</form:option>
				<form:option value="text">Text</form:option>
				<form:option value="file">File</form:option>
			</form:select>
			<br />
Required:&nbsp;<form:checkbox path="required" value="Required" />
			<br />

			<input class="btn btn-primary" type="submit" name="submit"
				value="Save">
		</form:form>
	</div>
</body>
</html>