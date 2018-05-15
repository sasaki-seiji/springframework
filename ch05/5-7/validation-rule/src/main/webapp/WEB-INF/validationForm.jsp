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
			<td>@NotNull</td>
			<td>String</td>
			<td>notNullString</td>
			<td><form:input path="notNullString" /></td>
			<td><form:errors path="notNullString" /></td>
		</tr>
		<tr>
			<td>@NotEmpty</td>
			<td>String</td>
			<td>notEmptyString</td>
			<td><form:input path="notEmptyString" /></td>
			<td><form:errors path="notEmptyString" /></td>
		</tr>
		<tr>
			<td>@NotBlank</td>
			<td>String</td>
			<td>notBlankString</td>
			<td><form:input path="notBlankString" /></td>
			<td><form:errors path="notBlankString" /></td>
		</tr>
		<tr>
			<td>@Size(max=10)</td>
			<td>String</td>
			<td>max10String</td>
			<td><form:input path="max10String" /></td>
			<td><form:errors path="max10String" /></td>
		</tr>
		<tr>
			<td>@Pattern(regexp="[a-zA-Z0-9]*")</td>
			<td>String</td>
			<td>alnumString</td>
			<td><form:input path="alnumString" /></td>
			<td><form:errors path="alnumString" /></td>
		</tr>
		<tr>
			<td>@Email</td>
			<td>String</td>
			<td>email</td>
			<td><form:input path="email" /></td>
			<td><form:errors path="email" /></td>
		</tr>
		<tr>
			<td>@URL</td>
			<td>String</td>
			<td>url</td>
			<td><form:input path="url" /></td>
			<td><form:errors path="url" /></td>
		</tr>
		<tr>
			<td>@CreditCardNumber</td>
			<td>String</td>
			<td>creditCardNumber</td>
			<td><form:input path="creditCardNumber" /></td>
			<td><form:errors path="creditCardNumber" /></td>
		</tr>
		<tr>
			<td>@Min(1) @Max(100)</td>
			<td>int</td>
			<td>min1Max100Int</td>
			<td><form:input path="min1Max100Int" /></td>
			<td><form:errors path="min1Max100Int" /></td>
		</tr>
		<tr>
			<td>@Digits(integer=2,fraction=2)</td>
			<td>BigDecimal</td>
			<td>rate</td>
			<td><form:input path="rate" /></td>
			<td><form:errors path="rate" /></td>
		</tr>
		<tr>
			<td>@Past @DateTimeFormat(pattern="yyyyMMdd")</td>
			<td>Date</td>
			<td>pastDate</td>
			<td><form:input path="pastDate" /></td>
			<td><form:errors path="pastDate" /></td>
		</tr>
		<tr>
			<td>@AssertTrue</td>
			<td>boolean</td>
			<td>isAgreed</td>
			<td><form:checkbox path="isAgreed" label="agreed"/></td>
			<td><form:errors path="isAgreed" /></td>
		</tr>
		</table>
		<br />
		<div>
			<form:button>入力</form:button>
		</div>
	</form:form>
</body>
</html>