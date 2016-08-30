package org.personal.project.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/*
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;*/

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentEntity.
 */
@Entity
@Table(name="Department")
public class DepartmentEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6221599323765325196L;
    
	/** The id. */
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	/** The department name. */
	@Column(name="department_name")
	private String departmentName;
	
	/** The lecturers. mappedBy = "department",*/
	@OneToMany(mappedBy="department", cascade= CascadeType.ALL, fetch= FetchType.EAGER, orphanRemoval=true)
    private List<LecturerEntity> lecturers = new ArrayList<LecturerEntity>();
    
	/**
	 * Instantiates a new department entity.
	 */
	public DepartmentEntity(){
		
	}
	
	/**
	 * Instantiates a new department entity.
	 *
	 * @param departmentName the department name
	 */
	public DepartmentEntity(String departmentName) {
		super();
		this.departmentName = departmentName;
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
	 * Gets the department name.
	 *
	 * @return the department name
	 */
	public String getDepartmentName() {
		return departmentName;
	}
	
	/**
	 * Sets the department name.
	 *
	 * @param departmentName the new department name
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
    
	/**
	 * Sets the lecturers.
	 *
	 * @param lecturers the new lecturers
	 */
	public void setLecturers(List<LecturerEntity> lecturers) {
		this.lecturers = lecturers;
	}
	

	/**
	 * Gets the lecturers.
	 *
	 * @return the lecturers
	 */
	public List<LecturerEntity> getLecturers() {
		return lecturers;
	}


}
