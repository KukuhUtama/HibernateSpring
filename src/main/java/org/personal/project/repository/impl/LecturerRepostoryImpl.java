package org.personal.project.repository.impl;

import java.util.List;

import org.hibernate.transform.AliasToBeanResultTransformer;
import org.personal.project.dto.LecturerProfileDto;
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

	/** The lecturer profiles. */
	private List<LecturerProfileDto> lecturerProfiles;

	/** The hql query. */
	private String hqlQuery;

	/**
	 * (non-Javadoc).
	 *
	 * @param lecturer
	 *            the lecturer
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
	 * (non-Javadoc).
	 *
	 * @param lecturer
	 *            the lecturer
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
	 * (non-Javadoc).
	 *
	 * @return the list
	 * @see org.personal.project.repository.LecturerRepository#findAllLectureNanmeAndCode()
	 */
	@Transactional
	public List<Object[]> findAllLectureNanmeAndCode() {
		hqlQuery = "select lecturerName, lecturerCode from LecturerEntity";
		try {
			queryResult = getSession().createQuery(hqlQuery).list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return queryResult;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.personal.project.repository.LecturerRepository#findAllLecturerProfile()
	 */
	@Transactional
	public List<LecturerProfileDto> findAllLecturerProfile() {
		hqlQuery = "select lecturerName as lecturerName, lecturerCode as lecturerCode, lecturer.department.departmentName as departmentName from LecturerEntity as lecturer";
		try {
			lecturerProfiles = getSession().createQuery(hqlQuery)
					.setResultTransformer(new AliasToBeanResultTransformer(LecturerProfileDto.class)).list();
		} catch (Exception ex) {

		}
		return lecturerProfiles;
	}

}
