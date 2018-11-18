<html>
<body>
<h2>Welcome to preauthorize project</h2>
<h3>ようこそ、<sec:authentication property="principal.account.lastName"/> さん。</h3>
<a href="<c:url value='/profile'/>">ユーザ一覧</a>
<form action="<c:url value='/logout'/>" method="post">
	<sec:csrfInput />
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
