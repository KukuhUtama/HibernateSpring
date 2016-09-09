package org.personal.project.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorEntity.
 */
@Entity
@Table(name = "author")
public class AuthorEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6810674045247038392L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The name. */
	@Column(name = "name")
	private String name;

	/** The authors. */
	@ManyToMany(cascade ={CascadeType.MERGE, CascadeType.PERSIST}, fetch=FetchType.LAZY)
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
	private List<BookEntity> books = new ArrayList<BookEntity>();

	/**
	 * Instantiates a new author entity.
	 */
	public AuthorEntity() {

	}

	/**
	 * Instantiates a new author entity.
	 *
	 * @param name
	 *            the name
	 */
	public AuthorEntity(String name) {
		super();
		this.name = name;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the books.
	 *
	 * @return the books
	 */
	public List<BookEntity> getBooks() {
		return books;
	}

	/**
	 * Sets the books.
	 *
	 * @param books
	 *            the new books
	 */
	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}

}
