<html>
<body>
<h2>Welcome to csrf-springmvc project</h2>
<h3>ようこそ、<sec:authentication property="principal.username"/> さん。</h3>
<ul>
	<sec:authorize url="/admin">
		<li><a href="<c:url value='/admin/menu' />" >Admin Menuへ</a></li>
	</sec:authorize>
	<sec:authorize url="/admin/accounts">
		<li><a href="<c:url value='/admin/accounts/menu' />" >Accounts Menuへ</a></li>
	</sec:authorize>
</ul>
<c:url var="logoutUrl" value="/logout"/>
<form:form action="${logoutUrl}">
	<input type="submit" value="ログアウト(form:form)" />
</form:form>
</body>
</html>
