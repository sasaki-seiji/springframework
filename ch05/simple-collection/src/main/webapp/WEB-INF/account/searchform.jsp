<html>
<body>
	<h2>検索画面</h2>
	<form:form modelAttribute="searchForm" action="search" method="get">
		<form:checkbox path="roles[0]" value="1" />利用者<br />
		<form:checkbox path="roles[1]" value="2" />承認者<br />
		<form:checkbox path="roles[2]" value="3" />システム管理者<br />
		<br />
		<div>
			<form:button name="search">検索</form:button>
		</div>
	</form:form>
</body>
</html>