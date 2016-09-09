package org.personal.project.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.personal.project.entity.SubjectEntity;
import org.personal.project.repository.AbstractRepository;
import org.personal.project.repository.SubjectRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class SubjectRepositoryImpl.
 */
@Repository
public class SubjectRepositoryImpl extends AbstractRepository implements SubjectRepository {

	/** The subject. */
	private SubjectEntity subject = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.personal.project.repository.SubjectRepository#saveSubject(org.
	 * personal.project.entity.SubjectEntity)
	 */
	@Transactional
	public SubjectEntity saveSubject(SubjectEntity subject) {
		try {
			subject = (SubjectEntity) persist(subject);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return subject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.personal.project.repository.SubjectRepository#deleteSubject(org.
	 * personal.project.entity.SubjectEntity)
	 */
	@Transactional
	public void deleteSubject(SubjectEntity subject) {
		try {
			delete(subject);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.personal.project.repository.SubjectRepository#findById(int)
	 */
	@Transactional
	public SubjectEntity findById(int id) {
		try {
			Criteria criteria = getSession().createCriteria(SubjectEntity.class);
			Criterion clause = Restrictions.eq("id", id);
			criteria.add(clause).setFetchMode("students", FetchMode.JOIN);
			subject = (SubjectEntity) criteria.uniqueResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return subject;
	}
}
