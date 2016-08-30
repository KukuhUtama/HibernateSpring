package org.personal.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Lecturer.
 */
@Entity
@Table(name="lecturer")
public class LecturerEntity extends BaseEntity implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 446089492592652000L;
	
	/** The id. */
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	/** The lecturer name. */
	@Column(name="lecturer_name")
	private String lecturerName;
	
	/** The department.*/
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "department_id")
	private DepartmentEntity department;

	/**
	 * Instantiates a new lecturer.
	 */
	public LecturerEntity(){
		
	}
	
	/**
	 * Instantiates a new lecturer.
	 *
	 * @param lecturerName the lecturer name
	 */
	public LecturerEntity(String lecturerName) {
		super();
		this.lecturerName = lecturerName;
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
	 * Gets the lecturer name.
	 *
	 * @return the lecturer name
	 */
	public String getLecturerName() {
		return lecturerName;
	}

	/**
	 * Sets the lecturer name.
	 *
	 * @param lecturerName the new lecturer name
	 */
	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	/**
	 * Gets the departemnt.
	 *
	 * @return the departemnt
	 */
	public DepartmentEntity getDepartment() {
		return department;
	}

	/**
	 * Sets the department.
	 *
	 * @param departement the new department
	 */
	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
		
}