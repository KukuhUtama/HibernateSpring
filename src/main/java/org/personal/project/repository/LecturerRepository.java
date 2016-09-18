package org.personal.project.repository;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * Find lecturer by name and code and department name.
	 *
	 * @param andClause the and clause
	 * @return the lecturer entity
	 */
	public LecturerEntity findLecturerByNameAndCodeAndDepartmentName(Map<String,String> andClause);
	
}
