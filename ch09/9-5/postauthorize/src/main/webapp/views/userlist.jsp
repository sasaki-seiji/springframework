<html>
<body>
<h2>ユーザ一覧</h2>
<ul>
<c:forEach var="username" items="${usernames}" >
	<li><a href="<c:url value='/profile' />/${username}"><c:out value="${username}のユーザ情報"/></a>
</c:forEach>
</ul>
<form action="<c:url value='/logout'/>" method="post">
	<sec:csrfInput />
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
