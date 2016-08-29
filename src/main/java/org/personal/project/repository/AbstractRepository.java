package org.personal.project.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractRepository.
 */
public abstract class AbstractRepository {

	/** The session factory. */
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	/** The session. */
	private Session session;

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	public Session getSession() {
		Session session = getSessionFactory().getCurrentSession();
		if (session == null) {
			session = getSessionFactory().openSession();
		}
		return session;
	}

	/**
	 * Persist.
	 *
	 * @param entity
	 *            the entity
	 * @return the object
	 */
	@Transactional
	public Object persist(Object entity) {
		session = getSession();
		session.save(entity);
		return entity;
	}

	/**
	 * Delete.
	 *
	 * @param entity
	 *            the entity
	 */

	public void delete(Object entity) {
		session = getSession();
		session.delete(entity);
	}

	/**
	 * Update.
	 *
	 * @param entity
	 *            the entity
	 */
	public void update(Object entity) {
		session = getSession();
		session.merge(entity);
	}

}
