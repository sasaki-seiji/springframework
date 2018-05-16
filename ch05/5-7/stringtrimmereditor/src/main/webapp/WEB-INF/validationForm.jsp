<html>
<body>
	<h2>${title}</h2>
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
			<td>@NotNull</td>
			<td>String</td>
			<td>notNullString</td>
			<td><form:input path="notNullString" /></td>
			<td><form:errors path="notNullString" /></td>
		</tr>
		<tr>
			<td>@Size(min=4)</td>
			<td>String</td>
			<td>min4String</td>
			<td><form:input path="min4String" /></td>
			<td><form:errors path="min4String" /></td>
		</tr>
		<tr>
			<td>@NotNull @Size(min=4)</td>
			<td>String</td>
			<td>notNullMin4String</td>
			<td><form:input path="notNullMin4String" /></td>
			<td><form:errors path="notNullMin4String" /></td>
		</tr>
		</table>
		<br />
		<div>
			<form:button>入力</form:button>
		</div>
	</form:form>
</body>
</html>