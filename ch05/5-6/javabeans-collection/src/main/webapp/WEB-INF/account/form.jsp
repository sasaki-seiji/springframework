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
		<h3>カード情報１</h3>
		<table>
		<tr>
			<td>番号</td>
			<td><form:input path="cards[0].no" type="password"/></td>
			<td><form:errors path="cards[0].no" /></td>
		</tr>
		<tr>
			<td>期限</td>
			<td><form:input path="cards[0].validMonth" type="date"/></td>
			<td><form:errors path="cards[0].validMonth" /></td>
		</tr>
		</table>
		<h3>カード情報２</h3>
		<table>
		<tr>
			<td>番号</td>
			<td><form:input path="cards[1].no" type="password"/></td>
			<td><form:errors path="cards[1].no" /></td>
		</tr>
		<tr>
			<td>期限</td>
			<td><form:input path="cards[1].validMonth" type="date"/></td>
			<td><form:errors path="cards[1].validMonth" /></td>
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