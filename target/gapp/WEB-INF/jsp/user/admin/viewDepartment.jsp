<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Department Page</title>
</head>
<body>
	<h1></h1>
	<div class="container">
		<h4>
			<a href="../adminPage.html">View Departments</a>
		</h4>
		<%-- 	<h3><a href="${department.id}/removeDepartment.html">Remove This Department</a></h3> --%>
		<div class="row">
			<div class="col-md-6">
				<h4>Department Name:</h4>
			</div>
			<div class="col-md-12">
				${department.name} <a href="${department.id}/editName.html"><button
						class="btn btn-success">Edit</button></a>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-6">
				<h4>Programs:</h4>
			</div>
			<div class="col-md-12">
				<ul>
					<c:forEach items="${department.programs}" var="program">

						<li style="padding-top: 15px">${program.name}&nbsp;<a
							href="${department.id}/editProgram/${program.id}.html"><button
									class="btn btn-success">Edit</button></a>&nbsp; <a
							href="${department.id}/removeProgram/${program.id}.html"><button
									class="btn btn-success">Remove</button></a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<h4>Additional Requirements:</h4>
			</div>
			<div class="col-md-12">
				<ul>
					<c:forEach items="${department.addFields}" var="additional">
						<li>Field Name:&nbsp; ${additional.name}<br /> Field
							Type:&nbsp; ${additional.type}<br /> Required
							Field:&nbsp;${additional.required}&nbsp;<a
							href="${department.id}/editField/${additional.id}.html"><button
									class="btn btn-success">Edit</button></a> &nbsp;<a
							href="${department.id}/removeField/${additional.id}.html"><button
									class="btn btn-success">Remove</button></a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<br />
	</div>
</body>
</html>