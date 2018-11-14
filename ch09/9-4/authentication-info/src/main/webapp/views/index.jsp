<html>
<body>
<h2>Welcome to authentication-info</h2>
<h3>ようこそ、<sec:authentication property="principal.account.lastName"/> さん。</h3>
<form action="<c:url value='/logout'/>" method="post">
	<sec:csrfInput />
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
