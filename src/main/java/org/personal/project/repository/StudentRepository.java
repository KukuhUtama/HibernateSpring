package org.personal.project.repository;

import java.util.List;

import org.personal.project.entity.StudentEntity;
import org.personal.project.dto.StudentProfileDto;
/**
 * The Interface StudentRepository.
 */
public interface StudentRepository {

	/**
	 * Save student.
	 *
	 * @param student
	 *            the student
	 * @return the student entity
	 */
	public StudentEntity saveStudent(StudentEntity student);

	/**
	 * Delete student.
	 *
	 * @param student
	 *            the student
	 */
	public void deleteStudent(StudentEntity student);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the student entity
	 */
	public StudentEntity findById(int id);
	
	/**
	 * Find all student profile.
	 *
	 * @return the list
	 */
	public List<StudentProfileDto> findAllStudentProfile();
}
