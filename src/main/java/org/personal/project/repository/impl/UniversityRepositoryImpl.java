package org.personal.project.repository.impl;

import org.personal.project.entity.UniversityEntity;
import org.personal.project.repository.AbstractRepository;
import org.personal.project.repository.UniversityRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class UniversityRepositoryImpl.
 */
@Repository
public class UniversityRepositoryImpl extends AbstractRepository implements UniversityRepository {

	/** The university. */
	private UniversityEntity university;

	/* (non-Javadoc)
	 * @see org.personal.project.repository.UniversityRepository#saveUniversity(org.personal.project.entity.UniversityEntity)
	 */
	@Transactional
	public UniversityEntity saveUniversity(UniversityEntity university) {
		try{
			university = (UniversityEntity) persist(university);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return university;
	}

	/* (non-Javadoc)
	 * @see org.personal.project.repository.UniversityRepository#deleteUniversity(org.personal.project.entity.UniversityEntity)
	 */
	@Transactional
	public void deleteUniversity(UniversityEntity university) {
		try {
			delete(university);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
