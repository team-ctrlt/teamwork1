/**
 *
 */
package jp.co.teamwork.db.dao;

import java.util.List;

import javax.activation.DataSource;

import jp.co.teamwork.BookInfo;

/**
 * @author matsudat
 *
 */
public class JdbcPoolingBookDao extends BookDao {

	private DataSource ds = null;

	public JdbcPoolingBookDao(DataSource ds) {
		this.ds = ds;
	}

	/* (非 Javadoc)
	 * @see jp.co.teamwork.db.dao.BookDao#select()
	 */
	@Override
	List<BookInfo> select() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/* (非 Javadoc)
	 * @see jp.co.teamwork.db.dao.BookDao#selectByTitle(java.lang.String)
	 */
	@Override
	public List<BookInfo> selectByTitle(String title) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/* (非 Javadoc)
	 * @see jp.co.teamwork.db.dao.BookDao#selectByAuthorName(java.lang.String)
	 */
	@Override
	public List<BookInfo> selectByAuthorName(String authorName) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/* (非 Javadoc)
	 * @see jp.co.teamwork.db.dao.BookDao#selectByAuthorId(int)
	 */
	@Override
	public List<BookInfo> selectByAuthorId(int isbn) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/* (非 Javadoc)
	 * @see jp.co.teamwork.db.dao.BookDao#selectByPublisher(java.lang.String)
	 */
	@Override
	public List<BookInfo> selectByPublisher(String publisher) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/* (非 Javadoc)
	 * @see jp.co.teamwork.db.dao.BookDao#selectBooks(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<BookInfo> selectBooks(String title, String authorName, String isbn, String publisher) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


}
