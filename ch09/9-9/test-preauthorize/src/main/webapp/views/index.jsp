<html>
<body>
<h2>Welcome to test-preauthorize project</h2>
<h3>ようこそ、<sec:authentication property="principal.username"/> さん。</h3>
<form action="<c:url value='/logout'/>" method="post">
	<sec:csrfInput />
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
