<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Admin Page</title>
</head>
<body>
	<div class="container">
		<h1>Admin Page</h1>
		<hr />
		<div align="right">
			<a href="../logout.html"><button class="btn btn-success">Logout</button></a>
		</div>
		<h2>
			<a href="addDepartment.html">Add New Department</a>
		</h2>
		<table id="myTable"
			class="table table-border table-striped table-hover " border="1"
			style="margin-top: 1cm">
			<thead class="thead-inverse" style="cursor: pointer">
				<tr>
					<th>Department Name</th>
					<th>Programs</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${departments}" var="department">
					<tr>
						<td>${department.name}</td>
						<td>${department.programs.size()}</td>
						<td><a href="department/${department.id}.html">View
								Department</a></td>
						<td><a href="department/${department.id}/addProgram.html">Add
								Program</a></td>
						<td><a href="department/${department.id}/addField.html">Add
								Additional Field</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<p>To Edit/Remove the department, programs and additional fields,
				click on View Department.
		</div>
	</div>

</body>
</html>