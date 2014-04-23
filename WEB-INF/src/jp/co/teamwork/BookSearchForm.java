package jp.co.teamwork;

import org.apache.struts.action.ActionForm;

public class BookSearchForm extends ActionForm {

	/** 書籍名 */
	private String title;
	/** 著者名 */
	private String authorName;
	/** ISBN */
	private String isbn;
	/** 出版社 */
	private String publisher;

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName セットする authorName
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * @return isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn セットする isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher セットする publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
