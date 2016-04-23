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
<script>
	function uploadFunction(event) {
		var data = new FormData();
		var file = event.currentTarget.files[0];
		var id = $(event.target).next('input').val();
		data.append('file', file);

		$.ajax({
			url : 'editTranscriptUpload.html',
			data : data,
			processData : false,
			contentType : false,
			type : 'POST',
			DataType : 'multipart/form-data',
			success : function(data) {
				alert(data);
			},
			error : function(err) {
				alert(err);
			}
		});
		//});
	};
</script>
</head>
<body>
	<div class="container">

		<form:form modelAttribute="application" method="POST"
			class="form-horizontal" role="form">

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
				<label for="transcript" class="col-md-2 control-label"> Transcript: </label>
				<div class="col-md-3">
					<input type="file" onchange="uploadFunction(event)" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input class="btn btn-primary" type="submit" name="save"
						value="Save" />
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>