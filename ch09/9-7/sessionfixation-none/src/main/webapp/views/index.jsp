<html>
<body>
<h2>Welcome to invalid-session project</h2>
<h3>ようこそ、<sec:authentication property="principal.username"/> さん。</h3>
<ul>
	<sec:authorize url="/admin">
		<li><a href="<c:url value='/admin/menu' />" >Admin Menuへ</a></li>
	</sec:authorize>
	<sec:authorize url="/admin/accounts">
		<li><a href="<c:url value='/admin/accounts/menu' />" >Accounts Menuへ</a></li>
	</sec:authorize>
</ul>
<form action="<c:url value='/logout'/>" method="post">
	<sec:csrfInput />
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
