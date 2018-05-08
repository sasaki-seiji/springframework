<html>
<body>
	<h2>AccountCreateForm</h2>
	<form:form modelAttribute="accountCreateForm" action="create" method="get">
		<div>
			<form:input path="dateOfBirth" />
			<form:errors path="dateOfBirth" />
		</div>
		<div>
			<form:button>検索</form:button>
		</div>
	</form:form>
</body>
</html>