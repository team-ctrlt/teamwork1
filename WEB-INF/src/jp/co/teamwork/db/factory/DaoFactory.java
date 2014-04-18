package jp.co.teamwork.db.factory;

import jp.co.teamwork.db.dao.BookDao;


/**
 * Dao のファクトリインタフェースです。
 */
public interface DaoFactory {

	/**
	 * BookDao を生成する。
	 * @return BookDao
	 */
	abstract BookDao createBookDao();
}
