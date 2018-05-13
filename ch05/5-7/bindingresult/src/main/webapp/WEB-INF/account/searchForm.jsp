<html>
<body>
	<h2>検索画面</h2>
	<form:form modelAttribute="accountSearchForm" action="search" method="get">
		<div>名前:</div>
		<div>
			<form:input path="name" />
			<form:errors path="name" />
		</div>
		<br />
		<div>
			<form:button name="execute">検索</form:button>
		</div>
	</form:form>
</body>
</html>