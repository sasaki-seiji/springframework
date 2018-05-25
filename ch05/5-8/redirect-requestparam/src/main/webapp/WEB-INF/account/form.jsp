<html>
<body>
	<h2>アカウント作成</h2>
	<form:form modelAttribute="accountCreateForm" action="create">
		<table>
		<tr>
			<td>ID</td>
			<td><form:input path="id" /></td>
			<td><form:errors path="id" /></td>
		</tr>
		<tr>
			<td>名前</td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" /></td>
		</tr>
		</table>
		<br />
		<div>
			<form:button name="create">作成</form:button>
		</div>
	</form:form>
</body>
</html>