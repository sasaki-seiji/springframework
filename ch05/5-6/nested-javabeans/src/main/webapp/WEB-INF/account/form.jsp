<html>
<body>
	<h2>登録画面</h2>
	<form:form modelAttribute="accountCreateForm" action="create">
		<h3>アカウント情報</h3>
		<table>
		<tr>
			<td>名前</td>
			<td><form:input path="account.name" /></td>
			<td><form:errors path="account.name" /></td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td><form:input path="account.email" /></td>
			<td><form:errors path="account.email" /></td>
		</tr>
		</table>
		<h3>カード情報</h3>
		<table>
		<tr>
			<td>番号</td>
			<td><form:input path="card.no" type="password"/></td>
			<td><form:errors path="card.no" /></td>
		</tr>
		<tr>
			<td>期限</td>
			<td><form:input path="card.validMonth" type="date"/></td>
			<td><form:errors path="card.validMonth" /></td>
		</tr>
		</table>
		<br />
		<div>
			<form:button name="cancel">中止</form:button>
			<form:button name="create">登録</form:button>
		</div>
	</form:form>
</body>
</html>