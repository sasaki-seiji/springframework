<html>
<body>
<h2>Welcome to requestpostprocessor project</h2>
<h3>ようこそ、<sec:authentication property="principal.username"/> さん。</h3>
<a href="<c:url value='/message/list' />">メッセージリストへ</a>
<form action="<c:url value='/logout'/>" method="post">
	<sec:csrfInput />
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
