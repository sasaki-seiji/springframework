<html>
<body>
<h2>Welcome to logout project</h2>
<form action="<c:url value='/logout'/>" method="post">
	<sec:csrfInput />
	<!-- 2018.11.11, 2019.06.22 modify: 
		STS では<buton>エレメントはうまくsubmitできない
		microsoft Edge ではうまくいく
	<button>ログアウト</button>
	-->
	<input type="submit" value="ログアウト" />
</form>
</body>
</html>
