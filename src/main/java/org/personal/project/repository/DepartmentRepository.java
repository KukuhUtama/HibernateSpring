package org.personal.project.repository;

import java.io.Serializable;

import org.personal.project.entity.DepartmentEntity;


// TODO: Auto-generated Javadoc
/**
 * The Interface DepartmentRepository.
 */
public interface DepartmentRepository {
	
	/**
	 * Save department.
	 *
	 * @param department the department
	 * @return the department entity
	 */
	public DepartmentEntity saveDepartment(DepartmentEntity department);
	
	/**
	 * Delete department.
	 *
	 * @param department the department
	 */
	public void deleteDepartment(DepartmentEntity department);
	
	/**
	 * Load department.
	 *
	 * @param Id the id
	 * @return the department entity
	 */
	public DepartmentEntity loadDepartment(Serializable Id);
}
