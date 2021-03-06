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
<title>Application Page</title>
</head>
<body>
<body>
	<div class="container" style="margin: 10px 20px 30px 40px">
		<h4>
			<a href="../studentPage.html">View Applications</a>
		</h4>
		<hr />
		<h4>
			Program To Apply
			<c:if test="${application.appStatuses[0].status == 'Not Submitted'}"> &nbsp;
				<a href="${application.id}/editApplicationProgram.html">Edit</a>
			</c:if>
		</h4>
		<table id="programInfo"
			class="table table-border table-striped table-hover "
			style="margin-top: 1cm">
			<tbody>
				<tr>
					<td>Department:</td>
					<td>${application.department.name}</td>
				</tr>
				<tr>
					<td>Program:</td>
					<td>${application.program.name}</td>
				</tr>
				<tr>
					<td>Term:</td>
					<td>${application.term}</td>
				</tr>
				<tr>
			</tbody>
		</table>
		<h4>
			Basic Information:
			<c:if test="${application.appStatuses[0].status == 'Not Submitted'}"> &nbsp;
				<a href="${application.id}/editApplicantInfo.html">Edit</a>
			</c:if>
		</h4>
		<table id="basicInfo"
			class="table table-border table-striped table-hover "
			style="margin-top: 1cm">
			<tbody>
				<tr>
					<td>Last Name:</td>
					<td>${application.lastName}</td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td>${application.firstName}</td>
				</tr>
				<tr>
					<td>CIN:</td>
					<td>${application.cin}</td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td>${application.phone}</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td>${application.email}</td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td>${application.gender}</td>
				</tr>
				<tr>
					<td>Date of Birth (MM/DD/YYYY):</td>
					<td><fmt:formatDate value="${application.dateOfBirth}"
							var="dateValue" pattern="MM/dd/yyyy" /> ${dateValue}</td>
				</tr>
				<tr>
					<td>Citizenship:</td>
					<td>${application.citizenship}</td>
				</tr>
			</tbody>
		</table>
		<h4>
			Academic Records:
			<c:if test="${application.appStatuses[0].status == 'Not Submitted'}"> &nbsp;
				<a href="${application.id}/editAcademicInfo.html">Edit</a>
			</c:if>
		</h4>
		<table id="academicRecords"
			class="table table-border table-striped table-hover "
			style="margin-top: 1cm">
			<tbody>
				<tr>
					<td>TOEFL Score(for international students)::</td>
					<td>${application.toeflScore}</td>
				</tr>
				<tr>
					<td>GRE Score(if required by department):</td>
					<td>${application.greScore}</td>
				</tr>
				<tr>
					<td>GPA::</td>
					<td>${application.gpa}</td>
				</tr>
				<tr>
					<td>Transcript:</td>
					<td><c:if test="${not empty application.transcript}">
							<a href="${application.id}/downloadTranscript.html">Download</a>
						</c:if></td>
				</tr>
			</tbody>
		</table>
		<h4>
			Educational Background:
			<c:if test="${application.appStatuses[0].status == 'Not Submitted'}"> &nbsp;
				<a href="${application.id}/editEducationInfo.html">Edit</a>
			</c:if>
		</h4>
		<table id="educationalBackground"
			class="table table-border table-striped table-hover " border="1"
			style="margin-top: 1cm">
			<thead class="thead-inverse" style="cursor: pointer">
				<tr>
					<th>College/University Name:</th>
					<th>Degree Earned</th>
					<th>Academic Major</th>
					<th>Start Year</th>
					<th>End Year</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${application.degrees}" var="degree">
					<tr>
						<td>${degree.school}</td>
						<td>${degree.name}</td>
						<td>${degree.major}</td>
						<td>${degree.startYear}</td>
						<td>${degree.endYear}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h4>
			Additional Requirements:
			<%--  <c:if test="${application.appStatuses[0].status == 'Not Submitted'}"> &nbsp;
				<a href="${application.id}/editRequirements.html">Edit</a>
			</c:if> --%>
		</h4>
		<c:choose>
			<c:when test="${not empty application.addValues}">
				<table id="addFields"
					class="table table-border table-striped table-hover " border="1"
					style="margin-top: 1cm">
					<thead class="thead-inverse" style="cursor: pointer">
						<tr>
							<th>Requirement</th>
							<th>Score</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${application.addValues}" var="addValue">
							<tr>
								<td>${addValue.addField.name}</td>
								<td><c:if test="${addValue.addField.type == 'number'}">
									${addValue.doubleValue}
									 <c:if
											test="${application.appStatuses[0].status == 'Not Submitted'}"> &nbsp;
				<a href="${application.id}/editAdditionalInfo/${addValue.id}.html">Edit</a>
										</c:if> 
									</c:if> <c:if test="${addValue.addField.type == 'text'}">
									${addValue.stringValue}
									 <c:if
											test="${application.appStatuses[0].status == 'Not Submitted'}"> &nbsp;
				<a href="${application.id}/editAdditionalInfo/${addValue.id}.html">Edit</a>
										</c:if> 
									</c:if> <c:if test="${addValue.addField.type == 'file'}">
										<c:if test="${not empty addValue.fileValue}">
											<a
												href="${application.id}/addFileDownload/${addValue.id}.html">Download</a>
										</c:if>

										<c:if
											test="${application.appStatuses[0].status == 'Not Submitted'}">
											<a href="${application.id}/addFileUpload/${addValue.id}.html">
												<button type="button" class="btn btn-success">Edit
													Upload</button>
											</a> 
										</c:if>
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
				<hr />No Additional Requirements<hr />
			</c:otherwise>
		</c:choose>
		<c:if test="${application.appStatuses[0].status == 'Not Submitted'}">
			<a href="${application.id}/submitApplication.html"><button
					type="button" class="btn btn-success">Submit Application</button></a>
		</c:if>
	</div>
</body>

</body>
</html>