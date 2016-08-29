package org.personal.project.repository.impl;

import org.personal.project.entity.StudentEntity;
import org.personal.project.repository.AbstractRepository;
import org.personal.project.repository.StudentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class StudentRepositoryImpl.
 */
@Repository
public class StudentRepositoryImpl extends AbstractRepository implements StudentRepository {

	/** The student. */
	private StudentEntity student;

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.personal.project.repository.StudentRepository#saveStudent(org.
	 * personal.project.entity.StudentEntity)
	 */
	@Transactional
	public StudentEntity saveStudent(StudentEntity student) {
		try {
			student = (StudentEntity) persist(student);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return student;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.personal.project.repository.StudentRepository#deleteStudent(org.
	 * personal.project.entity.StudentEntity)
	 */
	@Transactional
	public void deleteStudent(StudentEntity student) {
		try {
			delete(student);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
