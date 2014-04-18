package jp.co.teamwork;


/**
 * 書籍情報を保持する Bean クラス
 */
public class BookInfo {

	/** タイトル */
	private String title;
	/** 著者名 */
	private String authorName;
	/** 著者ID */
	private int authorId;
	/** ISBN */
	private int isbn;
	/** 出版社 */
	private String publisher;
	/** 出版日 */
	private String publishDate;

	/**
	 * デフォルトコンストラクタ
	 */
	public BookInfo() {};

	/**
	 * タイトルを返却します。
	 *
	 * @return タイトル
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * タイトルを設定します。
	 *
	 * @param title タイトル
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 著者名を返却します。
	 *
	 * @return 著者名
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * 著者名を設定します。
	 *
	 * @param authorName 著者名
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * 著者ID を返却します。
	 *
	 * @return 著者ID
	 */
	public int getAuthorId() {
		return authorId;
	}

	/**
	 * 著者ID を設定します。
	 *
	 * @param authorId 著者ID
	 */
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	/**
	 * ISBN を返却します。
	 *
	 * return ISBN
	 */
	public int getIsbn() {
		return isbn;
	}

	/**
	 * ISBN を設定します。
	 *
	 * @param isbn ISBN
	 */
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	/**
	 * 出版社を返却します。
	 *
	 * @return 出版社
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * 出版社を設定します。
	 *
	 * @param publisher 出版社
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * 出版日を返却します。
	 *
	 * @return 出版日
	 */
	public String getPublishDate() {
		return publishDate;
	}

	/**
	 * 出版日を設定します。
	 *
	 * @param publishDate 出版日
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
}
