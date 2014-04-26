/**
 *
 */
package jp.co.teamwork.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.teamwork.BookInfo;

/**
 * @author matsudat
 *
 */
public class JdbcPoolingBookDao extends BookDao {

//	private DataSource ds = null;
	private Connection conn = null;

/*	public JdbcPoolingBookDao(DataSource ds) {
		this.ds = ds;
	}
*/

	public JdbcPoolingBookDao(Connection conn) {
		this.conn = conn;
	}

	/* (非 Javadoc)
	 * @see jp.co.teamwork.db.dao.BookDao#select()
	 */
	@Override
	List<BookInfo> select() {
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

	@Override
	public List<BookInfo> selectBooks(String title, String authorName, String isbn, String publisher) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
//		Connection conn = null;

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
			sql.append(" TITLE like ?");
			sql.append(" and AUTHOR_NAME like ?");
			sql.append(" and ISBN like ?");
			sql.append(" and PUBLISHER like ?");

//			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + title + "%");
			pstmt.setString(2, "%" + authorName + "%");
			pstmt.setString(3, "%" + isbn + "%");
			pstmt.setString(4, "%" + publisher + "%");

			rs = pstmt.executeQuery();

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
			close(pstmt);
			close(conn);
		}

		return null;
	}

}
