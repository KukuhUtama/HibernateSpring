package org.personal.project.repository.impl;

import org.hibernate.criterion.Restrictions;
import org.personal.project.entity.SubjectEntity;
import org.personal.project.repository.AbstractRepository;
import org.personal.project.repository.SubjectRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class SubjectRepositoryImpl.
 */
@Repository
public class SubjectRepositoryImpl extends AbstractRepository implements SubjectRepository {

	/** The subject. */
	private SubjectEntity subject=null;

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
}
