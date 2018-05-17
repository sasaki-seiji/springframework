<html>
<body>
	<h2>入力チェックルールの指定</h2>
	<form:form modelAttribute="validationForm">
		<table>
		<tr>
			<th>制約アノテーション</th>
			<th>型</th>
			<th>プロパティー</th>
			<th>入力フィールド</th>
			<th>エラーメッセージ</th>
		</tr>
		<tr>
			<td>@AlphaNumeric</td>
			<td>String</td>
			<td>alphaNumeric</td>
			<td><form:input path="alphaNumeric" /></td>
			<td><form:errors path="alphaNumeric" /></td>
		</tr>
		<tr>
			<td>@NotEmpty @AlphaNumeric</td>
			<td>String</td>
			<td>notEmptyAlphaNumeric</td>
			<td><form:input path="notEmptyAlphaNumeric" /></td>
			<td><form:errors path="notEmptyAlphaNumeric" /></td>
		</tr>
		</table>
		<br />
		<div>
			<form:button>入力</form:button>
		</div>
	</form:form>
</body>
</html>