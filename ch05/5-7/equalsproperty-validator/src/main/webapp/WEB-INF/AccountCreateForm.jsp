<html>
<body>
	<h2>登録画面</h2>
	<form:form modelAttribute="accountCreateForm" >
		<table>
		<tr>
			<td>名前：</td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" /></td>
		</tr>
		<tr>
			<td>パスワード:</td>
			<td><form:password path="password" /></td>
			<td><form:errors path="password" /></td>
		</tr>
		<tr>
			<td>パスワード再入力:</td>
			<td><form:password path="reEnteredPassword" /></td>
			<td><form:errors path="reEnteredPassword" /></td>
		</tr>
		</table>
		<br />
		<div>
			<form:button>登録</form:button>
		</div>
	</form:form>
</body>
</html>