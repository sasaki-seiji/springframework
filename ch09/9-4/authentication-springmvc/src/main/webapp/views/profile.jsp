<html>
<body>
<h2>ユーザ情報</h2>
<table>
	<tr>
		<td>username:</td>
		<td>${account.username}</td>
	</tr>
	<tr>
		<td>admin:</td>
		<td>${account.admin}</td>
	</tr>
	<tr>
		<td>userUuid:</td>
		<td>${account.userUuid}</td>
	</tr>
	<tr>
		<td>lastName:</td>
		<td>${account.lastName}</td>
	</tr>
</table>
<form action="<c:url value='/logout'/>" method="post">
	<sec:csrfInput />
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
