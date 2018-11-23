<html>
<body>
<h2>Welcome to csrf-input project</h2>
<h3>ようこそ、<sec:authentication property="principal.username"/> さん。</h3>
<ul>
	<li><a href="<c:url value='/admin/menu' />" >Admin Menuへ</a></li>
	<li><a href="<c:url value='/admin/accounts/menu' />" >Accounts Menuへ</a></li>
</ul>
<form action="<c:url value='/logout'/>" method="post">
	<sec:csrfInput />
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
