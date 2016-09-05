package org.personal.project.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

// TODO: Auto-generated Javadoc
/**
 * The Class BookEntity.
 */
@Entity
@Table(name = "book")
public class BookEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -5538332204239836494L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** The title. */
	@Column(name = "title")
	private String title;

	/**
	 * Instantiates a new book entity.
	 */
	public BookEntity() {

	}

	/**
	 * Instantiates a new book entity.
	 *
	 * @param title
	 *            the title
	 * @param authors
	 *            the authors
	 */
	public BookEntity(String title) {
		super();
		this.title = title;
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
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
