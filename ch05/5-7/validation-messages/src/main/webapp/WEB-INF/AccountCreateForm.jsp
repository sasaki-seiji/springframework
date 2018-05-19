<html>
<body>
	<h2>アカウント作成画面</h2>
	<form:form modelAttribute="accountCreateForm" >
		<table>
		<tr>
			<td>名前</td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" /></td>
		</tr>
		<tr>
			<td>誕生日</td>
			<td><form:input path="dateOfBirth" type="date" /></td>
			<td><form:errors path="dateOfBirth" /></td>
		</tr>
		<tr>
			<td>住所</td>
			<td><form:input path="streetAddress" /></td>
			<td><form:errors path="streetAddress" /></td>
		</tr>
		</table>
		<br />
		<div>
			<form:button name="clear">クリア</form:button>
			<form:button name="confirm">確認</form:button>
		</div>
	</form:form>
</body>
</html>