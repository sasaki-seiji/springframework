<div id="wrapper">
	<h3>ログインフォーム</h3>
	<c:if test="${param.containsKey('error')}" >
		<span style="color: red;">
			<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
		</span>
	</c:if>
	<c:url var="loginUrl" value="/login"/>
	<form:form action="${loginUrl}">
		<table>
			<tr>
				<td><label for="username">ユーザー名</label></td>
				<td><input type="text" id="username" name="username"/></td>
			</tr>
			<tr>
				<td><label for="password">パスワード</label></td>
				<td><input type="password" id="password" name="password"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="ログイン"/></td>
			</tr>
		</table>
	</form:form>
</div>