package org.personal.project.repository;

import org.personal.project.entity.LecturerEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface LecturerRepository.
 */
public interface LecturerRepository {

	/**
	 * Save lecturer.
	 *
	 * @param lecturer the lecturer
	 * @return the lecturer entity
	 */
	public LecturerEntity saveLecturer(LecturerEntity lecturer);
	
	/**
	 * Delete lecturer.
	 *
	 * @param lecturer the lecturer
	 */
	public void deleteLecturer(LecturerEntity lecturer);
	
}
