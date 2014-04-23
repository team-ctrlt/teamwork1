<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
	<head><title>書籍検索結果画面</title></head>

	<body>
		<content>
			<div class="row">
				<div class="large-12 columns">

			<table>
				<thead>
					<tr>
						<th>タイトル</th>
						<th>著者名</th>
						<th>ISBN</th>
						<th>出版社</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<logic:iterate id="book" name="book_info">
						<tr>
							<html:form action="/dispatch">
								<td><bean:write name="book" property="title"/></td>
								<td><bean:write name="book" property="authorName"/></td>
								<td><bean:write name="book" property="isbn"/></td>
								<td><bean:write name="book" property="publisher"/></td>
							</html:form>
						</tr>
					</logic:iterate>
				</tbody>
			</table>
			</div>
			</div>
			<a class="button" href="book-search.do">書籍検索画面に戻る</a>
		</content>
	</body>
</html>

