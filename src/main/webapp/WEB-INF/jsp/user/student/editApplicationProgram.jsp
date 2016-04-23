<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>New Application</title>
</head>
<body>
	<div class="container">
		<form:form method="POST" action="editApplicationProgram.html" modelAttribute="application"
			class="form-horizontal" role="form">
			<div id="legend">
				<legend>Program To Apply</legend>
			</div>
			<div class="form-group">
				<label for="department" class="col-md-2 control-label">
					Select Department: </label>
				<div class="col-md-3">
					<strong><input type="text" size="35"
						value="${application.department.name}" disabled /> </strong>
					<%-- <form:select class="form-control" path="department" id="dept_id"
						name="dept">
							<form:option value="${department.id}">${department.name}</form:option>
					</form:select> --%>
				</div>
			</div>
			<div class="form-group">
				<label for="program" class="col-md-2 control-label"> Select
					Program:</label>
				<div class="col-md-3">
					<form:select class="form-control" path="program.id" id="list_id"
						name="prog">
						<c:forEach items="${programs}" var="program">
							<c:choose>
								<c:when test="${application.program == program}">
									<option value="${program.id}" selected="selected">${program.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${program.id}">${program.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select>
					<strong>(required field)</strong>
				</div>
			</div>
			<div class="form-group">
				<label for="term" class="col-md-2 control-label"> Select
					Term to Apply: </label>
				<div class="col-md-3">
					<form:select path="term" class="form-control">
						<form:option value="Fall 2016">Fall 2016</form:option>
						<form:option value="Winter 2017">Winter 2017</form:option>
						<form:option value="Spring 2017">Spring 2017</form:option>
						<form:option value="Fall 2017">Fall 2017</form:option>
						<form:option value="Spring 2018">Spring 2018</form:option>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input class="btn btn-primary" type="submit" name="save"
						value="Save" />
					<!-- <input class="btn btn-primary" type="submit" name="continue"
				value="Continue" /> -->
				</div>
			</div>

		</form:form>
	</div>
	<div id="temp"></div>
</body>
</html>