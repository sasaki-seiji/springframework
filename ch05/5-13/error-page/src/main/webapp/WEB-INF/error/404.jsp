<html>
<body>
	<h2>404 file not found</h2>
	<table border=1>
	<tr>
	  <td><b>ステータスコード</b></td>
	  <td><%= request.getAttribute("javax.servlet.error.status_code") %></td>
	</tr> 
	<tr>
	  <td><b>例外のタイプ</b></td>
	  <td><%= request.getAttribute("javax.servlet.error.exception_type") %></td>
	</tr> 
	<tr>
	  <td><b>メッセージ</b></td>
	  <td><%= request.getAttribute("javax.servlet.error.message") %></td>
	</tr>
	<tr>
	  <td><b>例外</b></td>
	  <td><%= request.getAttribute("javax.servlet.error.exception") %></td>
	</tr>
	<tr>
	  <td><b>URI</b></td>
	  <td><%= request.getAttribute("javax.servlet.error.request_uri") %></td>
	</tr>
	<tr>
	  <td><b>サーブレット名</b></td>
	  <td><%= request.getAttribute("javax.servlet.error.servlet_name") %></td>
	</tr>
	</table>
	<ul>
		<li><a href="<c:url value='/'/>">戻る</a>
	</ul>
</body>
</html>