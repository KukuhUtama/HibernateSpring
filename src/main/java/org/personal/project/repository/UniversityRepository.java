package org.personal.project.repository;

import org.personal.project.entity.UniversityEntity;

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
}
