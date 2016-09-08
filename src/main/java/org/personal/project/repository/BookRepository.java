package org.personal.project.repository;

import java.util.List;

import org.personal.project.entity.BookEntity;
/**
 * The Interface BookRepository.
 */
public interface BookRepository {

	/**
	 * Save book.
	 *
	 * @param boook
	 *            the boook
	 * @return the book entity
	 */
	public BookEntity saveBook(BookEntity boook);

	/**
	 * Update book.
	 *
	 * @param book
	 *            the book
	 */
	public void updateBook(BookEntity book);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<BookEntity> findAll();

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the book entity
	 */
	public BookEntity findById(int id);
	
	/**
	 * Delete book.
	 *
	 * @param book the book
	 */
	public void deleteBook(BookEntity book);
}
