<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Users</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>firstname</th>
			<th>lastname</th>
			<th>email</th>
			<th>password</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.password}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>