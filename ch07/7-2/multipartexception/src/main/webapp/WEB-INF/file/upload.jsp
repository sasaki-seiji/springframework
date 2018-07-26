<html>
<body>
	<h2>ファイルアップロード</h2>
	<form:form modelAttribute="fileUploadForm" enctype="multipart/form-data">
		ファイル：<form:input path="file" type="file" /><br />
		<form:button>アップロード</form:button>
	</form:form>
</body>
</html>