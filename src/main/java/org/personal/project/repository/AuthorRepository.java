package org.personal.project.repository;

import java.util.List;

import org.personal.project.dto.AuthorProfileDto;
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

	/**
	 * Update author.
	 *
	 * @param author
	 *            the author
	 */
	public void updateAuthor(AuthorEntity author);

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the author entity
	 */
	public AuthorEntity findById(int id);
	
    
	/**
	 * Find all author profile.
	 *
	 * @return the list
	 */
	public List<AuthorProfileDto> findAllAuthorProfile();
}
