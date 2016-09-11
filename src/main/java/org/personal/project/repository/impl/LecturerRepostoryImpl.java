package org.personal.project.repository.impl;

import java.util.List;

import org.personal.project.entity.LecturerEntity;
import org.personal.project.repository.AbstractRepository;
import org.personal.project.repository.LecturerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


// TODO: Auto-generated Javadoc
/**
 * The Class LecturerRepostoryImpl.
 */
@Repository("lecturerRepository")
public class LecturerRepostoryImpl extends AbstractRepository implements LecturerRepository {
 
	/** The lecturer. */
	private LecturerEntity lecturer;
    
    /** The query result. */
    private List<Object[]> queryResult;
    
    /** The hql query. */
    private String hqlQuery;
	/**
	 *  (non-Javadoc).
	 *
	 * @param lecturer the lecturer
	 * @return the lecturer entity
	 * @see org.personal.project.repository.LecturerRepository#saveLecturer(org.personal.project.entity.LecturerEntity)
	 */
	@Transactional
	public LecturerEntity saveLecturer(LecturerEntity lecturer) {
		try {
			lecturer = (LecturerEntity) persist(lecturer);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lecturer;
	}

	/**
	 *  (non-Javadoc).
	 *
	 * @param lecturer the lecturer
	 * @see org.personal.project.repository.LecturerRepository#deleteLecturer(org.personal.project.entity.LecturerEntity)
	 */
	@Transactional
	public void deleteLecturer(LecturerEntity lecturer) {
		try {
			delete(lecturer);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 *  (non-Javadoc).
	 *
	 * @return the list
	 * @see org.personal.project.repository.LecturerRepository#findAllLectureNanmeAndCode()
	 */
	@Transactional
	public List<Object[]> findAllLectureNanmeAndCode() {
		hqlQuery = "select lecturerName, lecturerCode from LecturerEntity";
		try{
			queryResult = getSession().createQuery(hqlQuery).list();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return queryResult;
	}
	


}
