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
	function uploadfile(event) {
		var data = new FormData();
		var file = event.currentTarget.files[0];
		var id = $(event.target).next('input').val();
		console.log(id);
		data.append('file', file);
		data.append('field', id);

		$.ajax({
			url : 'uploadAdditionalFile.html',
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
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Additional Requirements:</h1>
		<form:form method="post" 
			modelAttribute="application">
			<c:choose>
				<c:when test="${not empty application.addValues}">
					<table id="myTable"
						class="table table-border table-striped table-hover " border="1"
						style="margin-top: 1cm">
						<!-- <thead class="thead-inverse" style="cursor: pointer">
				<tr>
					<th>Date Submitted</th>
					<th>Department</th>
					<th>Program</th>
					<th>Term Applied</th>
					<th>Status</th>
					<th></th>
					<th></th>
				</tr>
			</thead> -->
						<tbody>
							<c:forEach items="${application.addValues}" var="addValue"
								varStatus="status">
								<tr>
									<td>${addValue.addField.name}:</td>
									<td><c:if test="${addValue.addField.type == 'number'}">
											<form:input type="number"
												path="addValues[${status.index}].doubleValue" />
										</c:if> <c:if test="${addValue.addField.type == 'text'}">
											<form:input type="text"
												path="addValues[${status.index}].stringValue" />
										</c:if> <c:if test="${addValue.addField.type == 'file'}">
											<form:input path="addValues[${status.index}].fileValue" type="file"
												onchange="uploadfile(event)" />
											<input type="hidden" value="${addValue.addField.id}" />
										</c:if></td>
									<td><c:choose>
											<c:when test="${addValue.addField.required == true}">
									Required
								</c:when>
											<c:otherwise>
									Optional
								</c:otherwise>
										</c:choose></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<hr />No Additional Requirements for this program<hr />
				</c:otherwise>
			</c:choose>
			<input class="btn btn-primary" type="submit" name="save"
				value="Save & Review" />
		</form:form>
	</div>
</body>
</html>