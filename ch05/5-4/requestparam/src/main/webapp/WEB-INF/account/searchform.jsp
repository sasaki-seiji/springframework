<html>
<body>
	<h2>検索画面</h2>
	<form:form modelAttribute="searchForm" action="search" method="get">
		<div>ID:</div>
		<div>
			<form:input path="id" />
			<form:errors path="id" />
		</div>
		<br />
		<div>
			<form:button name="search">検索</form:button>
		</div>
	</form:form>
</body>
</html>