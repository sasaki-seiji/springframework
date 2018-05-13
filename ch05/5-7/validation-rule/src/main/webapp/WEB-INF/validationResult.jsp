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
		<td>@NotNull</td>
		<td>String</td>
		<td>notNullString</td>
		<td><c:out value="${validationForm.notNullString}" /></td>
	</tr>
	<tr>
		<td>@NotEmpty</td>
		<td>String</td>
		<td>notEmptyString</td>
		<td><c:out value="${validationForm.notEmptyString}" /></td>
	</tr>
	<tr>
		<td>@NotBlank</td>
		<td>String</td>
		<td>notBlankString</td>
		<td><c:out value="${validationForm.notBlankString}" /></td>
	</tr>
	<tr>
		<td>@Size(max=10)</td>
		<td>String</td>
		<td>max10String</td>
		<td><c:out value="${validationForm.max10String}" /></td>
	</tr>
	<tr>
		<td>@Pattern(regexp="[a-zA-Z0-9]*")</td>
		<td>String</td>
		<td>alnumString</td>
		<td><c:out value="${validationForm.alnumString}" /></td>
	</tr>
	<tr>
		<td>@Min(1) @Max(100)</td>
		<td>int</td>
		<td>min1Max100Int</td>
		<td><c:out value="${validationForm.min1Max100Int}" /></td>
	</tr>
	<tr>
		<td>@Past @DateTimeFormat(pattern="yyyyMMdd")</td>
		<td>Date</td>
		<td>pastDate</td>
		<td><c:out value="${validationForm.pastDate}" /></td>
	</tr>
	<tr>
		<td>@AssertTrue</td>
		<td>boolean</td>
		<td>isAgreed</td>
		<td><c:out value="${validationForm.isAgreed}" /></td>
	</tr>
	</table>
<ul>
	<li><a href="<c:url value='/' />">入力フォームへ戻る</a></li>
</ul>
</body>
</html>