<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="upload" enctype="multipart/form-data">
		<fieldset>
			<legend>Upload xml file</legend>
			<p>
				<label for="fileName">File Name:</label>
				<input name="fileName" id="fileName"/>
			</p>
			<p>
				<label for="fileData">File</label>
				<input name="fileData" type="file"/>
			</p>
			<p>
				<input type="submit">
			</p>
		</fieldset>
	</form>
</body>
</html>