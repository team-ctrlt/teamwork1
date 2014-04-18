<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
	<head><title>書籍検索結果画面</title></head>

	<body>
		書籍名：
		<bean:write name="title" scope="session" />
	</body>
</html>

