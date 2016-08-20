package org.personal.project.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class UniversityEntity.
 */
@Entity
@Table(name="university")
public class UniversityEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -120022418687169946L;

	/** The id. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/** The name. */
	@Column(name = "name")
	private String name;
	
	/** The address. */
	@Column(name = "address")
	private String address;

	/** The students. */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "university_id")
	private List<StudentEntity> students;

	/**
	 * Instantiates a new university entity.
	 */
	public UniversityEntity() {
		super();
	}

	/**
	 * Instantiates a new university entity.
	 *
	 * @param name the name
	 * @param address the address
	 */
	public UniversityEntity(String name, String address) {
		super();
		this.name = name;
		this.address = address;
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
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @param name the new name
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
	 * @param students the new students
	 */
	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

}
