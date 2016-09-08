package org.personal.project.repository;

import org.personal.project.entity.SubjectEntity;

/**
 * The Interface SubjectRepository.
 */
public interface SubjectRepository {
	
	/**
	 * Save subject.
	 *
	 * @param subject the subject
	 * @return the subject entity
	 */
	public SubjectEntity saveSubject(SubjectEntity subject);
	
	/**
	 * Delete subject.
	 *
	 * @param subject the subject
	 */
	public void deleteSubject(SubjectEntity subject);

}
