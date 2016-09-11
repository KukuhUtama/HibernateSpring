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
	
	/** The lecturer code. */
	@Column(name="lecturer_code")
	private String lecturerCode;
	
	/** The contact phone. */
	@Column(name="contact_phone")
	private String contactPhone;
	
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
	 * @param lecturerCode the lecturer code
	 */
	public LecturerEntity(String lecturerName, String lecturerCode, String contactPhone) {
		super();
		this.lecturerName = lecturerName;
		this.lecturerCode = lecturerCode;
		this.contactPhone = contactPhone;
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
	 * Gets the contact phone.
	 *
	 * @return the contact phone
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * Sets the contact phone.
	 *
	 * @param contactPhone the new contact phone
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	/**
	 * Gets the lecturer code.
	 *
	 * @return the lecturer code
	 */
	public String getLecturerCode() {
		return lecturerCode;
	}

	/**
	 * Sets the lecturer code.
	 *
	 * @param lecturerCode the new lecturer code
	 */
	public void setLecturerCode(String lecturerCode) {
		this.lecturerCode = lecturerCode;
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
	 * @param department the new department
	 */
	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
		
}