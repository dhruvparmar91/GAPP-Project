<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>Education Information</h2>
		<hr />
		<!-- <div align="right">
			<a href="../logout.html"><button class="btn btn-success">Logout</button></a>
		</div> -->

		<a href="addEducation.html"><button type="button"
				class="btn btn-success">Add Education</button> </a>

		<form method="POST" class="form-horizontal" role="form">
			<c:choose>
				<c:when test="${not empty degrees}">
					<table id="myTable"
						class="table table-border table-striped table-hover " border="1"
						style="margin-top: 1cm">
						<thead class="thead-inverse" style="cursor: pointer">
							<tr>
								<th>Education</th>
								<th>Major</th>
								<th>School/University</th>
								<th>Start Year</th>
								<th>End Year</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${degrees}" var="degree">
								<tr>
									<td>${degree.name}</td>
									<td>${degree.major}</td>
									<td>${degree.school}</td>
									<td>${degree.startYear}</td>
									<td>${degree.endYear}</td>
									<td><a href="education/${degree.id}/editEducation.html">Edit</a></td>
									<td><a href="education/${degree.id}/removeEducation.html">Remove</a>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<hr />
					<div align="center">No Education added</div>
					<hr />
				</c:otherwise>
			</c:choose>
			
			<input class="btn btn-primary" type="submit" name="save"
				value="Save & Continue " />
			<!-- <input class="btn btn-primary" type="submit" name="review"
				value="Save & Review " /> -->

		</form>
	</div>

</body>
</html>