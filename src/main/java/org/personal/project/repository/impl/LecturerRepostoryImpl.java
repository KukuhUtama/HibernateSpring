package org.personal.project.repository.impl;

import org.personal.project.entity.LecturerEntity;
import org.personal.project.repository.AbstractRepository;
import org.personal.project.repository.LecturerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * The Class LecturerRepostoryImpl.
 */
@Repository("lecturerRepository")
public class LecturerRepostoryImpl extends AbstractRepository implements LecturerRepository {

	/** The lecturer. */
	private LecturerEntity lecturer;

	/** (non-Javadoc)
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

	/** (non-Javadoc)
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
	


}
