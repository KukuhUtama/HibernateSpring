package org.personal.project.repository;

import java.util.List;
import java.util.Map;

import org.personal.project.entity.UniversityEntity;
import org.personal.project.dto.UniversityProfileDto;

// TODO: Auto-generated Javadoc
/**
 * The Interface UniversityRepository.
 */
public interface UniversityRepository {

	/**
	 * Save university.
	 *
	 * @param university
	 *            the university
	 * @return the university entity
	 */
	public UniversityEntity saveUniversity(UniversityEntity university);

	/**
	 * Delete university.
	 *
	 * @param university
	 *            the university
	 */
	public void deleteUniversity(UniversityEntity university);

	/**
	 * Update university.
	 *
	 * @param university
	 *            the university
	 */
	public void updateUniversity(UniversityEntity university);
	
	/**
	 * Find universities by student name.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @return the list
	 */
	public List<UniversityEntity> findUniversitiesByStudentName(String firstName, String lastName);
	
	/**
	 * Find universities by name or address.
	 *
	 * @param name the name
	 * @param address the address
	 * @return the list
	 */
	public List<UniversityEntity> findUniversitiesByNameOrAddress(String name, String address);
	
	
	/**
	 * Find universities by city.
	 *
	 * @param orClause the or clause
	 * @return the list
	 */
	public List<UniversityEntity> findUniversitiesByCity(Map<String, List<String>> orClause);
	
	/**
	 * Find all university profile.
	 *
	 * @return the list
	 */
	public List<UniversityProfileDto> findAllUniversityProfile();
}
