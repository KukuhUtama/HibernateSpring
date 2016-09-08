package org.personal.project.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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

	/** The author. */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.personal.project.repository.AuthorRepository#updateAuthor(org.
	 * personal.project.entity.AuthorEntity)
	 */
	@Transactional
	public void updateAuthor(AuthorEntity author) {
		try {
			update(author);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.personal.project.repository.AuthorRepository#findById(int)
	 */
	@Transactional
	public AuthorEntity findById(int id) {
		try {
			Criteria criteria = getSession().createCriteria(AuthorEntity.class);
			author = (AuthorEntity) criteria.add(Restrictions.eq("id", id)).uniqueResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return author;
	}

}
