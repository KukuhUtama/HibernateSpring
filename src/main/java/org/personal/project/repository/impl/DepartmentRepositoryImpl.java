package org.personal.project.repository.impl;

import java.io.Serializable;

import org.personal.project.entity.DepartmentEntity;
import org.personal.project.repository.AbstractRepository;
import org.personal.project.repository.DepartmentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentRepositoryImpl.
 */
@Repository("departmentRepository")
public class DepartmentRepositoryImpl extends AbstractRepository implements DepartmentRepository {

	
	/** The department. */
	private DepartmentEntity department;
	
	/**
	 *  (non-Javadoc).
	 *
	 * @param department the department
	 * @return the department entity
	 * @see org.personal.project.repository.DepartmentRepository#saveDepartment(org.personal.project.entity.DepartmentEntity)
	 */
	@Transactional
	public DepartmentEntity saveDepartment(DepartmentEntity department) {
		try{
			department = (DepartmentEntity) persist(department);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return department;
	}

	/**
	 *  (non-Javadoc).
	 *
	 * @param department the department
	 * @see org.personal.project.repository.DepartmentRepository#deleteDepartment(org.personal.project.entity.DepartmentEntity)
	 */
	@Transactional
	public void deleteDepartment(DepartmentEntity department) {
		try{
			delete(department);
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/** (non-Javadoc)
	 * @see org.personal.project.repository.DepartmentRepository#loadDepartment(java.io.Serializable)
	 */
	@Transactional
	public DepartmentEntity loadDepartment(Serializable id){
		try{
			department = (DepartmentEntity) getSession().load(DepartmentEntity.class, id);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return department;
	}

}
