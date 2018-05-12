<html>
<body>
	<h2>登録画面</h2>
	<form:form modelAttribute="accountCreateForm" action="create">
		<table>
		<tr>
			<td>名前：</td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" /></td>
		</tr>
		<tr>
			<td>電話番号:</td>
			<td><form:input path="tel" /></td>
			<td><form:errors path="tel" /></td>
		</tr>
		<tr>
			<td>誕生日:</td>
			<td><form:input path="dateOfBirth" type="date" /></td>
			<td><form:errors path="dateOfBirth" /></td>
		</tr>
		<tr>
			<td>メールアドレス：</td>
			<td><form:input path="email" type="email"/></td>
			<td><form:errors path="email" /></td>
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