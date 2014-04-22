package jp.co.teamwork.service;

import java.util.List;

import jp.co.teamwork.BookInfo;
import jp.co.teamwork.db.dao.BookDao;
import jp.co.teamwork.db.factory.DaoFactory;
import jp.co.teamwork.db.factory.JdbcDaoFactory;

/**
 * 書籍管理サービスです。
 */
public class BookService {

	// 定数
	public static final int JDBC_DAO = 1;

	/** DAO **/
	private BookDao bookDao = null;
	/** DAO 生成用 */
	private DaoFactory daoFactory = null;

	/**
	 * コンストラクタ
	 * @param daoType
	 */
	public BookService(int daoType) {
		if (daoType == JDBC_DAO) {
			daoFactory = new JdbcDaoFactory();
			bookDao = daoFactory.createBookDao();
		}
	}

	/**
	 * 書籍情報を取得する。
	 * @param bookInfo
	 * @param daoType
	 * @return
	 */
	public List<BookInfo> selectByTitle(String title) {
		return bookDao.selectByTitle(title);
	}

}
