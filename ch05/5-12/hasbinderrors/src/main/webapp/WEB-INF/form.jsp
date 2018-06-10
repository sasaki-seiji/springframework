<html>
<body>
	<h2>spring:hasBindErrors tag</h2>
	<form:form modelAttribute="accountCreateForm" >
		ユーザー名：<form:input path="username" /><br />
		生年月日：<form:input path="dateOfBirth" /><br />
		<form:button>登録</form:button>
	</form:form>
	<spring:hasBindErrors name="accountCreateForm">
		<div id="errorMessages">
			<p>入力値に誤りがあります</p>
			<ul>
				<c:forEach items="${errors.allErrors}" var="error">
					<li><spring:message message="${error}"/></li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>
</body>
</html>