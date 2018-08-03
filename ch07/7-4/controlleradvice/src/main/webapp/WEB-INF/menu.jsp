<html>
<body>
	<h2>menu</h2>
	<c:url var="resources" value="/resources" />
	<c:url var="error" value="/error" />
	<ul>
		<li><a href="${resources}">リソースの獲得</a></li>
		<li><a href="${error}">疑似エラー</a></li>
	</ul>
</body>
</html>