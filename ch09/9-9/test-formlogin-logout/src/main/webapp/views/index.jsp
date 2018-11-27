<html>
<body>
<h2>Welcome to test-formlogin-logout project</h2>
<form action="<c:url value='/logout'/>" method="post">
	<sec:csrfInput />
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
