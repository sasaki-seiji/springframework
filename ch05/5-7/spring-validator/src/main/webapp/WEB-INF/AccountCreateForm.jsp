<html>
<body>
	<h2>登録画面</h2>
	<form:form modelAttribute="accountCreateForm" >
		<table>
		<tr>
			<td>名前</td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" /></td>
		</tr>
		<tr>
			<td>タイプ</td>
			<td><form:radiobutton path="type" value="1" label="無料会員" /></td>
			<td><form:errors path="type" /></td>
		</tr>
		<tr>
			<td></td>
			<td><form:radiobutton path="type" value="2" label="有料会員" /></td>
			<td></td>
		</tr>
		<tr>
			<td>カード番号</td>
			<td><form:input path="cardNo" /></td>
			<td><form:errors path="cardNo" /></td>
		</tr>
		</table>
		<br />
		<div>
			<form:button name="confirm">確認</form:button>
		</div>
	</form:form>
</body>
</html>