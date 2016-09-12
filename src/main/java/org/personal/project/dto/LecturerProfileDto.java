package org.personal.project.dto;


/**
 * The Class LecturerProfileDto.
 */
public class LecturerProfileDto {
	
	/**
	 * Instantiates a new lecturer profile dto.
	 */
	public LecturerProfileDto(){
		
	}
	
	/** The lecturer name. */
	private String lecturerName;
	
	/** The lecturer code. */
	private String lecturerCode;
	
	/** The department name. */
	private String departmentName;
	
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

}
