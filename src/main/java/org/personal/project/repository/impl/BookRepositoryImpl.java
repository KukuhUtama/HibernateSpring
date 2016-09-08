package org.personal.project.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.personal.project.entity.BookEntity;
import org.personal.project.repository.AbstractRepository;
import org.personal.project.repository.BookRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class BookRepositoryImpl.
 */
@Repository("bookRepository")
public class BookRepositoryImpl extends AbstractRepository implements BookRepository {

	/** The books. */
	private List<BookEntity> books;

	/** The book. */
	private BookEntity book;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.personal.project.repository.BookRepository#saveBook(org.personal.
	 * project.entity.BookEntity)
	 */
	@Transactional
	public BookEntity saveBook(BookEntity book) {
		try {
			book = (BookEntity) persist(book);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return book;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.personal.project.repository.BookRepository#updateBook(org.personal.
	 * project.entity.BookEntity)
	 */
	@Transactional
	public void updateBook(BookEntity book) {
		try {
			update(book);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.personal.project.repository.BookRepository#findAll()
	 */
	@Transactional
	public List<BookEntity> findAll() {
		Criteria criteria = getSession().createCriteria(BookEntity.class);
		try {
			books = criteria.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return books;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.personal.project.repository.BookRepository#findById(int)
	 */
	@Transactional
	public BookEntity findById(int id) {
		Criteria criteria = getSession().createCriteria(BookEntity.class);
		try {
			criteria.add(Restrictions.eq("id", id));
			book = (BookEntity) criteria.uniqueResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return book;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.personal.project.repository.BookRepository#deleteBook(org.personal.
	 * project.entity.BookEntity)
	 */
	@Transactional
	public void deleteBook(BookEntity book) {
		try {
			delete(book);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}