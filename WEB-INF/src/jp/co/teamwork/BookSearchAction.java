package jp.co.teamwork;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.teamwork.service.BookServiceImpl;

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

//		HttpSession session = request.getSession();
//		ActionMessages errors = new ActionMessages();

		BookSearchForm bookSearchForm = (BookSearchForm) form;

		BookServiceImpl bookService = new BookServiceImpl(1);

		List<BookInfo> resultList = null;

		resultList = 	bookService.findBooks(bookSearchForm.getTitle(), bookSearchForm.getAuthorName(),
												bookSearchForm.getIsbn(), bookSearchForm.getPublisher());
		//resultList = bookService.selectByTitle(bookSearchForm.getTitle());

		//session.setAttribute("book_info", resultList);
		request.setAttribute("book_info", resultList);

		return (mapping.findForward("next"));

	}
}
