<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Student Page</title>
</head>
<body>
	<div class="container">
		<div align="left">
			<h3>
				<a href="studentPage.html">Student Home</a>
			</h3>
		</div>
		<div align="right">
			<a href="/gapp/user/logout.html"><button class="btn btn-success">Logout</button></a>
		</div>
		<hr />
		<h2>
			<a href="addApplication.html">Add New Application</a>
		</h2>
		<h4> To Edit the application, click on Review Application.</h4>
		<table id="myTable"
			class="table table-border table-striped table-hover " border="1"
			style="margin-top: 1cm">
			<thead class="thead-inverse" style="cursor: pointer">
				<tr>
					<th>Date Submitted</th>
					<th>Department</th>
					<th>Program</th>
					<th>Term Applied</th>
					<th>Status</th>
				<!-- 	<th></th> -->
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${user.applications}" var="application">
					<tr>
						<td><fmt:formatDate type="both"
								value="${application.appStatuses[0].date}" /></td>
						<td>${application.department.name}</td>
						<td>${application.program.name}</td>
						<td>${application.term}</td>
						<td>${application.appStatuses[0].status}</td>
						<td><a href="application/${application.id}.html">Review
								Application</a></td>
						<%-- <td><c:if
								test="${application.appStatuses[0].status == 'Not Submitted'}">
								<a href="application/${application.id}/EditApplication.html">Edit
									Application</a>
							</c:if></td> --%>
						<td><c:if
								test="${application.appStatuses[0].status == 'Not Submitted'}">
								<a href="application/${application.id}/submitApplication.html">
									<button type="button" class="btn btn-success">Submit
										Application</button>
								</a>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>