<html>
<body>
<h2>Access Denied Page</h2>
<a href="<c:url value='/'/>" >ルートメニューに戻る</a>
<form action="<c:url value='/logout'/>" method="post">
	<sec:csrfInput />
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
