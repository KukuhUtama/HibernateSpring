package org.personal.project.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.personal.project.dto.AuthorProfileDto;
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

	/** The author profiles. */
	private List<AuthorProfileDto> authorProfiles;

	/** The hql query. */
	private String hqlQuery;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.personal.project.repository.AuthorRepository#findAllAuthorProfile()
	 */
	@Transactional
	public List<AuthorProfileDto> findAllAuthorProfile() {
		hqlQuery = "select books.title as bookTitle, author.id as authorId, author.name as authorName from AuthorEntity author left join author.books books";
		try {
			authorProfiles = getSession().createQuery(hqlQuery)
					.setResultTransformer(new AliasToBeanResultTransformer(AuthorProfileDto.class)).list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return authorProfiles;
	}

}
