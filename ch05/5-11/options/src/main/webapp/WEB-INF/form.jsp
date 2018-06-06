<spring:eval expression="@prefectureCodeListForNorthKanto" 
		var="prefectureCodeListForNorthKanto" />
<spring:eval expression="@prefectureCodeListForSouthKanto" 
		var="prefectureCodeListForSouthKanto" />

<html>
<body>
	<h2>form:option, form:options</h2>
	<form:form modelAttribute="optionsForm">
		お住まい：<form:select path="livingPrefecture">
			<form:option value="" label="--選択してください--"/>
			<optgroup label="北関東">
				<form:options items="${prefectureCodeListForNorthKanto}" />
			</optgroup>	
			<optgroup label="南関東">
				<form:options items="${prefectureCodeListForSouthKanto}" />
			</optgroup>	
		</form:select><br />
		<form:button>送信</form:button>
	</form:form>
</body>
</html>