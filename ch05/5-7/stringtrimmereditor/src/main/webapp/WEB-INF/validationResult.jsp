<html>
<body>
<h2>${title}</h2>
	<table>
	<tr>
		<th>制約アノテーション</th>
		<th>型</th>
		<th>プロパティー</th>
		<th>値</th>
	</tr>
	<tr>
		<td>@NotNull</td>
		<td>String</td>
		<td>notNullString</td>
		<td><c:out value="${validationForm.notNullString}" /></td>
	</tr>
	<tr>
		<td>@Size(min=4)</td>
		<td>String</td>
		<td>min4String</td>
		<td><c:out value="${validationForm.min4String}" /></td>
	</tr>
	<tr>
		<td>@NotNull @Size(min=4)</td>
		<td>String</td>
		<td>notNullMin4String</td>
		<td><c:out value="${validationForm.notNullMin4String}" /></td>
	</tr>
	</table>
<ul>
	<li><a href="<c:url value='/' />">メニューへ戻る</a></li>
</ul>
</body>
</html>