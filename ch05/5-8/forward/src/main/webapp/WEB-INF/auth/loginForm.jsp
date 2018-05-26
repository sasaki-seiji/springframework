<html>
<body>
	<h2>ログイン画面</h2>
	<form:form modelAttribute="loginForm">
		<table>
		<tr>
			<td>ユーザ名</td>
			<td><form:input path="username" /></td>
			<td><form:errors path="username" /></td>
		</tr>
		<tr>
			<td>パスワード</td>
			<td><form:input path="password" type="password" /></td>
			<td><form:errors path="password" /></td>
		</tr>
		</table>
		<br />
		<div>
			<form:button>ログイン</form:button>
		</div>
	</form:form>
</body>
</html>