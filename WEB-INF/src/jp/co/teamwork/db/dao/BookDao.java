package jp.co.teamwork.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import jp.co.teamwork.BookInfo;

/**
 * 書籍情報にアクセスするインタフェースです。
 */
public abstract class BookDao {

	/**
	 * 書籍情報を取得する。
	 *
	 * @return 書籍情報
	 */
	abstract List<BookInfo> select();

	/**
	 * 書籍名をキーに書籍情報を取得する。
	 * @param title 書籍名
	 * @return 書籍情報
	 */
	public abstract List<BookInfo> selectByTitle(String title);

	public abstract List<BookInfo> selectByAuthorName(String authorName);

	public abstract List<BookInfo> selectByAuthorId(int isbn);

	public abstract List<BookInfo> selectByPublisher(String publisher);

	public abstract List<BookInfo> selectBooks(String title, String authorName, String isbn, String publisher);

	/**
	 * コミットする。
	 * @param conn
	 */
	public void commit(Connection conn) {
		if (conn != null) {
			try {
				conn.commit();
			}
			catch (SQLException e) {
				// 例外処理
			}
		}
	}

	/**
	 * ロールバックする。
	 *
	 * @param conn
	 */
	public void rollback(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			}
			catch (SQLException e) {
				// 例外処理
			}
		}
	}

	/**
	 * コネクションをクローズする。
	 * @param connection
	 */
	public void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		}
		catch (SQLException e) {
			// 例外処理
		}
	}

	/**
	 * ステートメントをクローズする。
	 * @param stmt
	 */
	public void close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		}
		catch (SQLException e) {
			// 例外処理
		}
	}

	/**
	 * リザルトセットをクローズする。
	 * @param rs
	 */
	public void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		}
		catch (SQLException e) {
			// 例外処理
		}
	}
}
