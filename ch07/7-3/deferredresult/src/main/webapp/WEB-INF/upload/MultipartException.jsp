<%-- (3) --%>
<% response.setStatus(HttpServletResponse.SC_BAD_REQUEST); %>
<!DOCTYPE html>
<html>
	<h2>アップロードの失敗(ファイルサイズが大きすぎる)</h2>
	<c:url var="root" value="/" />
	<ul>
		<li><a href="${root}">最初に戻る</a></li>
	</ul>
</html>