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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Upload Additional Requirement</h1>
		<form:form method="post" modelAttribute="addvalue"
			enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
						<td>${addvalue.addField.name}:</td>
						<td><input type="file" name="file" /></td>
					</tr>

				</tbody>
			</table>
			<input class="btn btn-primary" type="submit" name="save"
				value="Upload" />
		</form:form>
	</div>
</body>
</html>