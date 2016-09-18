package org.personal.project.repository.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.personal.project.entity.UniversityEntity;
import org.personal.project.repository.AbstractRepository;
import org.personal.project.repository.UniversityRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class UniversityRepositoryImpl.
 */
@Repository
public class UniversityRepositoryImpl extends AbstractRepository implements UniversityRepository {

	/** The university. */
	private UniversityEntity university;

	/** The universities. */
	private List<UniversityEntity> universities;

	/** The criteria. */
	private Criteria criteria;

	/**
	 * (non-Javadoc).
	 *
	 * @param university
	 *            the university
	 * @return the university entity
	 * @see org.personal.project.repository.UniversityRepository#saveUniversity(org.
	 *      personal.project.entity.UniversityEntity)
	 */
	@Transactional
	public UniversityEntity saveUniversity(UniversityEntity university) {
		try {
			university = (UniversityEntity) persist(university);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return university;
	}

	/**
	 * (non-Javadoc).
	 *
	 * @param university
	 *            the university
	 * @see org.personal.project.repository.UniversityRepository#deleteUniversity(org
	 *      .personal.project.entity.UniversityEntity)
	 */
	@Transactional
	public void deleteUniversity(UniversityEntity university) {
		try {
			delete(university);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * (non-Javadoc).
	 *
	 * @param university
	 *            the university
	 * @see org.personal.project.repository.UniversityRepository#updateUniversity(org
	 *      .personal.project.entity.UniversityEntity)
	 */
	@Transactional
	public void updateUniversity(UniversityEntity university) {
		try {
			update(university);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * (non-Javadoc).
	 *
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @return the list
	 * @see org.personal.project.repository.UniversityRepository#findUniversitiesByStudentName(java.lang.String,
	 *      java.lang.String)
	 */
	@Transactional
	public List<UniversityEntity> findUniversitiesByStudentName(String firstName, String lastName) {
		try {
			criteria = getSession().createCriteria(UniversityEntity.class);
			criteria.createAlias("students", "student");
			Criterion firstNameCriterion = Restrictions.eq("student.firstName", firstName);
			Criterion lastNameCriterion = Restrictions.eq("student.lastName", lastName);
			/* And conditional as default */
			criteria.add(firstNameCriterion);
			criteria.add(lastNameCriterion);
			universities = criteria.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return universities;
	}

	/**
	 * (non-Javadoc).
	 *
	 * @param name
	 *            the name
	 * @param address
	 *            the address
	 * @return the list
	 * @see org.personal.project.repository.UniversityRepository#findUniversitiesByNameOrAddress(java.lang.String,
	 *      java.lang.String)
	 */
	@Transactional
	public List<UniversityEntity> findUniversitiesByNameOrAddress(String name, String address) {
		try {
			criteria = getSession().createCriteria(UniversityEntity.class);
			Criterion criterion = Restrictions.disjunction().add(Restrictions.eq("name", name))
					.add(Restrictions.eq("address", address));
			criteria.add(criterion);
			universities = criteria.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return universities;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.personal.project.repository.UniversityRepository#findUniversitiesByCity(java.util.Map)
	 */
	@Transactional
	public List<UniversityEntity> findUniversitiesByCity(Map<String, List<String>> orClause) {
		Disjunction or;
		List<String> cities;
		String columnName;
		try {
			criteria = getSession().createCriteria(UniversityEntity.class);
			or = Restrictions.disjunction();
			for (Map.Entry<String, List<String>> element : orClause.entrySet()) {
				columnName = element.getKey();
				cities = element.getValue();
				for (String cityName : cities) {
					or.add(Restrictions.eq(columnName, cityName));
				}
			}
			criteria.add(or);
			universities = criteria.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return universities;
	}

}