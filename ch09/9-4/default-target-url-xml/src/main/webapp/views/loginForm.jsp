<div id="wrapper">
	<h3>ログインフォーム</h3>
	<c:if test="${param.containsKey('error')}">
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
<!-- 2018.10.08 change: <button> element not submit form				
				<td><button>ログイン</button></td>
-->
				<td><input type="submit" value="ログイン"/></td>
			</tr>
		</table>
	</form:form>

</div>