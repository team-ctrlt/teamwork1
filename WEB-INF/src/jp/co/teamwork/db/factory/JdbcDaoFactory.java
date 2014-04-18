package jp.co.teamwork.db.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jp.co.teamwork.db.dao.BookDao;
import jp.co.teamwork.db.dao.JdbcBookDao;



/**
 * DAO のファクトリクラスです。
 *
 * @author matsudat
 */
public class JdbcDaoFactory implements DaoFactory {

	/**
	 * BookDao を生成する。
	 * @return BookDao
	 */
	public BookDao createBookDao() {
		return new JdbcBookDao(getConnection());
	}


	/**
	 * DB との connection を取得する
	 * @return conn 生成したコネクション
	 */
	private static Connection getConnection() {

		/** DB接続用 */
		Connection conn = null;
		/** URL */
		String url = "jdbc:sqlite:G:\\04.Software\\sqlite-shell-win32-x86-3080402\\sample.sqlite3";


		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(url);
		}
		catch (ClassNotFoundException ce) {
			// 例外処理
			ce.printStackTrace();
		}
		catch (SQLException se) {
			// 例外処理
			se.printStackTrace();
		}

		return conn;

	}
}
