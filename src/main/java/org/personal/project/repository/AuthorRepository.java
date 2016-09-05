package org.personal.project.repository;

import org.personal.project.entity.AuthorEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface AuthorRepository.
 */
public interface AuthorRepository {

	/**
	 * Save author.
	 *
	 * @param author
	 *            the author
	 * @return the author entity
	 */
	public AuthorEntity saveAuthor(AuthorEntity author);

	/**
	 * Delete author.
	 *
	 * @param author
	 *            the author
	 */
	public void deleteAuthor(AuthorEntity author);
}
