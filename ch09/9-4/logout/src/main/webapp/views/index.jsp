<html>
<body>
<h2>Welcome to logout project</h2>
<form action="<c:url value='/logout'/>" method="post">
	<sec:csrfInput />
	<!-- 2018.11.11 modify
	<button>ログアウト</button>
	-->
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
