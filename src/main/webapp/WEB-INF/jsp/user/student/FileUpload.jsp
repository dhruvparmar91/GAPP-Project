<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form method="post"
			enctype="multipart/form-data" class="form-horizontal" role="form">
			<div id="legend">
				<legend>Upload Your Transcript</legend>
			</div>
			<div class="form-group">
				<label for="transcript" class="col-md-2 control-label">
					Transcript:</label>
				<div class="col-md-3">
					<input type="file" name="transcript" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input class="btn btn-primary" type="submit" name="submit"
						value="Upload" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>