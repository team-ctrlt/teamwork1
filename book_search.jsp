<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html>
	<head><title>書籍検索画面</title></head>

	<body>
		<html:errors/>

		検索したい書籍の情報を入力してください。
		<html:form action="/book-search" focus="title">
			書籍名<html:text property="title"></html:text><br>
			著者名<html:text property="authorName"></html:text><br>
			ISBN  <html:text property="isbn"></html:text><br>
			出版社<html:text property="publisher"></html:text><br>
			<html:submit property="submit" value="送信"/>
			<html:reset value="リセット" />
		</html:form>
	</body>
</html>