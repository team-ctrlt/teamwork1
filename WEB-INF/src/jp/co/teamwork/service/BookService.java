package jp.co.teamwork.service;

import java.util.List;

import jp.co.teamwork.BookInfo;

/**
 * 書籍検索サービスインターフェースです。
 */
public interface BookService {

	public List<BookInfo> selectByTitle(String title);
	public List<BookInfo> findBooks(String title, String authorName, String isbn, String publisher);
	public void updateBooks(String authorName, String authorId, String publisher);
	public void deleteBooks();
}
