
package jp.co.teamwork.db.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.co.teamwork.db.dao.BookDao;
import jp.co.teamwork.db.dao.JdbcPoolingBookDao;


/**
 * @author matsudat
 *
 */
public class JdbcPoolingDaoFactory implements DaoFactory {

	/* (非 Javadoc)
	 * @see jp.co.teamwork.db.factory.DaoFactory#createBookDao()
	 */
	@Override
	public BookDao createBookDao() {
		return new JdbcPoolingBookDao(getConnection());
	}

	private Connection getConnection() {
		InitialContext initCon = null;
		DataSource ds = null;
		Connection conn = null;
		String url = "jdbc:sqlite:G:\\04.Software\\sqlite-shell-win32-x86-3080402\\sample.sqlite3";

		try {
			initCon = new InitialContext();
			ds = (DataSource) initCon.lookup(url);
			conn = ds.getConnection();
		}
		catch (NamingException e) {
			e.printStackTrace();
			if (initCon != null) {
				try {
					initCon.close();
				}
				catch (NamingException en){
					en.printStackTrace();
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			if (initCon != null) {
				try {
					initCon.close();
				}
				catch (NamingException en) {
					en.printStackTrace();
				}
			}
		}

		return conn;
	}

}
