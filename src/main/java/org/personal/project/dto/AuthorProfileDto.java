package org.personal.project.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorProfileDto.
 */
public class AuthorProfileDto {

	/** The author id. */
	private int authorId;
	
	/** The author name. */
	private String authorName;
	
	/** The book title. */
	private String bookTitle;

	/**
	 * Instantiates a new author profile dto.
	 */
	public AuthorProfileDto() {

	}

	/**
	 * Gets the author id.
	 *
	 * @return the author id
	 */
	public int getAuthorId() {
		return authorId;
	}

	/**
	 * Sets the author id.
	 *
	 * @param authorId the new author id
	 */
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	/**
	 * Gets the author name.
	 *
	 * @return the author name
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * Sets the author name.
	 *
	 * @param authorName the new author name
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * Gets the book title.
	 *
	 * @return the book title
	 */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * Sets the book title.
	 *
	 * @param bookTitle the new book title
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

}
