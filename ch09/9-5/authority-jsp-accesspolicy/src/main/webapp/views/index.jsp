<html>
<body>
<h2>Welcome to authority-jsp-accesspolicy project</h2>
<h3>ようこそ、<sec:authentication property="principal.username"/> さん。</h3>
<ul>
	<sec:authorize access="hasRole('ADMIN')">
		<li><a href="<c:url value='/admin/menu' />" >Admin Menuへ</a></li>
	</sec:authorize>
	<sec:authorize access="hasRole('ACCOUNT_MANAGER')">
		<li><a href="<c:url value='/admin/accounts/menu' />" >Accounts Menuへ</a></li>
	</sec:authorize>
</ul>
<form action="<c:url value='/logout'/>" method="post">
	<sec:csrfInput />
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
