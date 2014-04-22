package jp.co.teamwork;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.teamwork.service.BookService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class BookSearchAction extends Action {

	/**
	 *
	 */
	public ActionForward execute (ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response) {

		HttpSession session = request.getSession();
//		ActionMessages errors = new ActionMessages();

		BookSearchForm bookSearchForm = (BookSearchForm) form;

		String title = bookSearchForm.getTitle();
		String authorName = bookSearchForm.getAuthorName();
		int isbn = bookSearchForm.getIsbn();
		String publisher = bookSearchForm.getPublisher();

		BookService bookService = new BookService(1);

		List<BookInfo> resultList = bookService.selectByTitle(title);

		session.setAttribute("book_info", resultList);

		return (mapping.findForward("next"));

	}

}
