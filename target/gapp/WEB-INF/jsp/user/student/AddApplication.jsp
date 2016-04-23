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
<script>
	//$(document).ready(function() {
	function ajaxProg() {
		//$('#dept_id').on('change', function() {
		var data = "id=" + $('#dept_id').val();
		$.ajax({
			type : 'GET',
			url : 'ajaxPrograms.html',
			data : data,
			success : function(response) {
				/* var data = '';
				$.each(response, function(index, element) {
					console.log(element);
					data += '<option value="' + element + '">'
					+ element + '</option>';
				}); */

				//	$('#list_id').html(data);
				$('#list_id').html(response);

			}
		});
		//});
	};
	//});
</script>
</head>
<body>
	<div class="container">
		<h4>
			<a href="studentPage.html">View Applications</a> < New GAPP
			Application
		</h4>
		<form:form method="POST" modelAttribute="application"
			class="form-horizontal" role="form">
			<div id="legend">
				<legend>Program To Apply</legend>
			</div>
			<div class="form-group">
				<label for="department" class="col-md-2 control-label">
					Select Department: </label>
				<div class="col-md-3">
					<form:select class="form-control" path="department.id" id="dept_id"
						name="dept" onchange="ajaxProg()">
						<option value="">Select department</option>
						<c:forEach items="${departments}" var="department">
							<form:option value="${department.id}">${department.name}</form:option>
						</c:forEach>
					</form:select>
					<strong>(required field)</strong>
				</div>
			</div>
			<div class="form-group">
				<label for="program" class="col-md-2 control-label"> Select
					Program:</label>
				<div class="col-md-3">
					<form:select class="form-control" path="program.id" id="list_id"
						name="prog">
						<form:option value="">Select Department first</form:option>
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
						value="Save & Continue" />
					<!-- <input class="btn btn-primary" type="submit" name="continue"
				value="Continue" /> -->
				</div>
			</div>

		</form:form>
	</div>
	<div class="col-sm-offset-2 col-sm-10"><strong>${message}</strong></div>
</body>
</html>