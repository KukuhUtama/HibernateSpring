package org.personal.project.repository;

import java.util.List;

import org.personal.project.dto.LecturerProfileDto;
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
	
	/**
	 * Find all lecture nanme and code.
	 *
	 * @return the list
	 */
	public List<Object[]> findAllLectureNanmeAndCode();
	
	/**
	 * Find all lecturer profile.
	 *
	 * @return the list
	 */
	public List<LecturerProfileDto> findAllLecturerProfile();
	
}
