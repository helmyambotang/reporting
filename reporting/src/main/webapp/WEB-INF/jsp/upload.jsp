<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Nexus File Parser</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/min.js"></script>
<link type="text/css" media="screen" rel="stylesheet" href="${pageContext.request.contextPath}/res/css/file-upload.css">
<style type="text/css">
/****************** Start page styles ********************************************/
body {
	background: #DFA01B;
	font-family: arial, sans-serif;
	font-size: 11px;
}

#wrap {
	max-width: 900px;
	margin: 30px auto;
	background: #fff;
	border: 4px solid #FFD16F;
	-moz-border-radius: 15px;
	-webkit-border-radius: 15px;
	border-radius: 15px;
	padding: 20px;
}

.field {
	padding: 0 0 1em;
}
/****************** End page styles ********************************************/
</style>
</head>
<body>
	<div id="wrap">
		<form:form name="uploadFileForm"  method="post" action="upload"
			enctype="multipart/form-data">
			<div class="field">
				<label class="file-upload"> <span><strong>Upload Nessus file:</strong></span> <input type="file" name="uploadedFile">
				</label>
			</div>
<!-- 			<div class="field"> -->
<!-- 				<label class="file-upload"> <span><strong>Upload file II</strong></span> <input type="file" name="uploadFile[1]"> -->
<!-- 				</label> -->
<!-- 			</div> -->
			<input type="submit">
		</form:form>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/js/file-upload.js"></script>
</body>
</html>