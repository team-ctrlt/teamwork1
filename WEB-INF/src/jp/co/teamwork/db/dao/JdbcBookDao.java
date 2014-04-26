package jp.co.teamwork.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jp.co.teamwork.BookInfo;

/**
 * JDBC 接続用の BookDao クラス
 */
public class JdbcBookDao extends BookDao {

	/** DB 接続用 */
	private Connection conn = null;

	/**
	 * コンストラクタ
	 * @param conn
	 */
	public JdbcBookDao(Connection conn) {
		this.conn = conn;
	}

	/**
	 * DB から書籍情報を取得する。
	 * @return 書籍情報
	 */
	public List<BookInfo> select() {
		Statement stmt = null;
		ResultSet rs = null;
		BookInfo book = new BookInfo();
		List<BookInfo> resultList = new ArrayList<BookInfo>();

		try {
			String sql = "SELECT * FROM BOOKS";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				book.setTitle(rs.getString("TITLE"));
				book.setAuthorName(rs.getString("AUTHOR_NAME"));
				book.setAuthorId(rs.getInt("AUTHOR_ID"));
				book.setIsbn(rs.getString("ISBN"));
				book.setPublisher(rs.getString("PUBLISHER"));
				book.setPublishDate(rs.getString("PUBLISH_DATE"));

				resultList.add(book);
			}
		}
		catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(stmt);
			close(conn);
		}

		return resultList;
	}


	/**
	 * 書籍名をもとに書籍情報を取得する。
	 * @param title 書籍名
	 * @return 取得した書籍情報
	 */
	public List<BookInfo> selectByTitle(String title) {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		BookInfo bookInfo = new BookInfo();
		List<BookInfo> listBookInfo = new ArrayList<BookInfo>();

		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select");
			sql.append(" TITLE,");
			sql.append(" AUTHOR_NAME,");
			sql.append(" AUTHOR_ID,");
			sql.append(" ISBN,");
			sql.append(" PUBLISHER,");
			sql.append(" PUBLISH_DATE");
			sql.append(" from");
			sql.append(" BOOKS");
			sql.append(" where");
			sql.append(" TITLE = ?");

			System.out.println(sql);
			System.out.println(title);

			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, title);

			rs = stmt.executeQuery();

			while (rs.next()) {
				bookInfo.setTitle(rs.getString("TITLE"));
				bookInfo.setAuthorName(rs.getString("AUTHOR_NAME"));
				bookInfo.setAuthorId(rs.getInt("AUTHOR_ID"));
				bookInfo.setIsbn(rs.getString("ISBN"));
				bookInfo.setPublisher(rs.getString("PUBLISHER"));
				bookInfo.setPublishDate(rs.getString("PUBLISH_DATE"));

				System.out.println(bookInfo.getTitle());

				listBookInfo.add(bookInfo);
			}
		}
		catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(stmt);
			close(conn);
		}

		return listBookInfo;
	}

	/* (非 Javadoc)
	 * @see jp.co.teamwork.db.dao.BookDao#selectByAuthorName(java.lang.String)
	 */
	@Override
	public List<BookInfo> selectByAuthorName(String authorName) {
		return null;
	}

	/* (非 Javadoc)
	 * @see jp.co.teamwork.db.dao.BookDao#selectByAuthorId(int)
	 */
	@Override
	public List<BookInfo> selectByAuthorId(int isbn) {
		return null;
	}

	/* (非 Javadoc)
	 * @see jp.co.teamwork.db.dao.BookDao#selectByPublisher(java.lang.String)
	 */
	@Override
	public List<BookInfo> selectByPublisher(String publisher) {
		return null;
	}

	@Override
	public List<BookInfo> selectBooks(String title, String authorName, String isbn, String publisher) {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<BookInfo> listBookInfo = new ArrayList<BookInfo>();

		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select");
			sql.append(" TITLE,");
			sql.append(" AUTHOR_NAME,");
			sql.append(" AUTHOR_ID,");
			sql.append(" ISBN,");
			sql.append(" PUBLISHER,");
			sql.append(" PUBLISH_DATE");
			sql.append(" from");
			sql.append(" BOOKS");
			sql.append(" where");
			sql.append(" TITLE like ?");
			sql.append(" and AUTHOR_NAME like ?");
			sql.append(" and ISBN like ?");
			sql.append(" and PUBLISHER like ?");

//			System.out.println(sql);

//			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, "%" + title + "%");
			stmt.setString(2, "%" + authorName + "%");
			stmt.setString(3, "%" + isbn + "%");
			stmt.setString(4, "%" + publisher + "%");

			System.out.println(title);
			System.out.println(authorName);
			System.out.println(isbn);
			System.out.println(publisher);

			rs = stmt.executeQuery();

			while (rs.next()) {
				BookInfo bookInfo = new BookInfo();
				bookInfo.setTitle(rs.getString("TITLE"));
				bookInfo.setAuthorName(rs.getString("AUTHOR_NAME"));
				bookInfo.setAuthorId(rs.getInt("AUTHOR_ID"));
				bookInfo.setIsbn(rs.getString("ISBN"));
				bookInfo.setPublisher(rs.getString("PUBLISHER"));
				bookInfo.setPublishDate(rs.getString("PUBLISH_DATE"));

				//System.out.println(bookInfo.getIsbn());

				listBookInfo.add(bookInfo);

				for (BookInfo bi : listBookInfo) {
					System.out.println(bi.getTitle());
					System.out.println(bi.getIsbn());
				}
				System.out.println();
			}

		}
		catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(stmt);
			close(conn);
		}

		return listBookInfo;
	}
}
