package org.personal.project.repository.impl;

import org.personal.project.entity.AuthorEntity;
import org.personal.project.repository.AbstractRepository;
import org.personal.project.repository.AuthorRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorRepositoryImpl.
 */
@Repository("authorRepository")
public class AuthorRepositoryImpl extends AbstractRepository implements AuthorRepository {

	private AuthorEntity author;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.personal.project.repository.AuthorRepository#saveAuthor(org.personal.
	 * project.entity.AuthorEntity)
	 */
	@Transactional
	public AuthorEntity saveAuthor(AuthorEntity author) {
		try {
			author = (AuthorEntity) persist(author);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return author;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.personal.project.repository.AuthorRepository#deleteAuthor(org.
	 * personal.project.entity.AuthorEntity)
	 */
	@Transactional
	public void deleteAuthor(AuthorEntity author) {
		try {
			delete(author);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
