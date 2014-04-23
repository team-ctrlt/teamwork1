
package jp.co.teamwork.db.factory;

import javax.activation.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
		return new JdbcPoolingBookDao(getDataSource());
	}

	private DataSource getDataSource() {
		InitialContext initCon = null;
		DataSource ds = null;
		String url = "jdbc:sqlite:G:\\04.Software\\sqlite-shell-win32-x86-3080402\\sample.sqlite3";

		try {
			initCon = new InitialContext();
			ds = (DataSource) initCon.lookup(url);
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
		return ds;
	}

}
