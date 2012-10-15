<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<form:form name="uploadFileForm" method="post" action="upload" enctype="multipart/form-data">
		<fieldset>
			<legend>Upload xml file</legend>
			<p>
				<label for="uploadedFile">File Name:</label>
				<input type="file" name="uploadedFile"/>
			</p>
			<p>
				<input type="submit">
			</p>
		</fieldset>
	</form:form>
</body>
</html>