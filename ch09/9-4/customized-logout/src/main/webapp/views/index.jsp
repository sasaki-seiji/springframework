<html>
<body>
<h2>Welcome to customized-logout project</h2>
<form action="<c:url value='/auth/logout'/>" method="post">
	<sec:csrfInput />
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
