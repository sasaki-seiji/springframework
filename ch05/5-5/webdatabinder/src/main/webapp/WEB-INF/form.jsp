<html>
<body>
	<h2>日付の入力フォーム</h2>
	<form:form modelAttribute="searchForm" action="search" method="get">
		<div>
			<form:input path="date" />
			<form:errors path="date" />
		</div>
		<div>
			<form:button>検索</form:button>
		</div>
	</form:form>
</body>
</html>