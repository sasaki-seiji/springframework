<html>
<body>
<h2>入力チェックの結果</h2>
	<table>
	<tr>
		<th>制約アノテーション</th>
		<th>型</th>
		<th>プロパティー</th>
		<th>値</th>
	</tr>
	<tr>
		<td>@AlphaNumeric</td>
		<td>String</td>
		<td>alphaNumeric</td>
		<td><c:out value="${validationForm.alphaNumeric}" /></td>
	</tr>
	<tr>
		<td>@NotEmpty @AlphaNumeric</td>
		<td>String</td>
		<td>notEmptyAlphaNumeric</td>
		<td><c:out value="${validationForm.notEmptyAlphaNumeric}" /></td>
	</tr>
	</table>
<ul>
	<li><a href="<c:url value='/' />">入力フォームへ戻る</a></li>
</ul>
</body>
</html>