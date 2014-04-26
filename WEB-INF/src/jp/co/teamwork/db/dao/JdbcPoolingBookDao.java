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
		return null;
	}

	@Override
	public List<BookInfo> selectBooks(String title, String authorName, String isbn, String publisher) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		List<BookInfo> listBookInfo = new ArrayList<BookInfo>();

		try {
			pstmt = conn.prepareStatement(createSelectSql());
			pstmt.setString(1, "%" + title + "%");
			pstmt.setString(2, "%" + authorName + "%");
			pstmt.setString(3, "%" + isbn + "%");
			pstmt.setString(4, "%" + publisher + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookInfo bookInfo = new BookInfo();
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

	@Override
	public void updateBooks(String authorName, String authorId, String publisher, String isbn) {
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(createUpdateSql());
			pstmt.setString(1, "%" + authorName + "%");
			pstmt.setString(2, "%" + isbn + "%");
			pstmt.setString(3, "%" + publisher + "%");
			pstmt.setString(4, "%" + isbn + "%");

			int result = pstmt.executeUpdate();

			if (result == 0) {
				System.out.println("Error: Update is denny");
			}
		}
		catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(conn);
		}

	}

	@Override
	public void deleteBooks(String isbn) {
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(createDeleteSql());
			pstmt.setString(1, "%" + isbn + "%");

			int result = pstmt.executeUpdate();

			if (result == 0) {
				System.out.println("Error: Delete is denny");
			}
		}
		catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(conn);
		}
	}

	private String createSelectSql() {
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

		return sql.toString();
	}

	private String createUpdateSql() {
		StringBuffer sql = new StringBuffer();

		sql.append("update");
		sql.append(" BOOKS");
		sql.append(" set");
		sql.append(" authorName = ?,");
		sql.append(" authorId = ?,");
		sql.append(" publisher = ?");
		sql.append(" where");
		sql.append(" isbn = ?");

		return sql.toString();
	}

	private String createDeleteSql() {
		StringBuffer sql = new StringBuffer();

		sql.append("delete");
		sql.append(" from");
		sql.append(" BOOKS");
		sql.append(" where");
		sql.append(" isbn = ?");

		return sql.toString();
	}



}
