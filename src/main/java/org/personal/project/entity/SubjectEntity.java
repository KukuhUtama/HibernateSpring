package org.personal.project.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

/**
 * The Class SubjectEntity.
 */
@Entity
@Table(name = "subject")
public class SubjectEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6745498423536375515L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	/** The name. */
	@Column(name = "name")
	private String name;

	/** The students. */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "subject_student", joinColumns = { @JoinColumn(name = "subject_id") }, inverseJoinColumns = {
			@JoinColumn(name = "student_id") })
	private List<StudentEntity> students = new LinkedList<StudentEntity>();

	/**
	 * Instantiates a new subject entity.
	 */
	public SubjectEntity() {
		super();
	}

	/**
	 * Instantiates a new subject entity.
	 *
	 * @param name
	 *            the name
	 */
	public SubjectEntity(String name) {
		super();
		this.name = name;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the students.
	 *
	 * @return the students
	 */
	public List<StudentEntity> getStudents() {
		return students;
	}

	/**
	 * Sets the students.
	 *
	 * @param students
	 *            the new students
	 */
	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

}
