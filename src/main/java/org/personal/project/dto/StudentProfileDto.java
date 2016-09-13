package org.personal.project.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentProfileDto.
 */
public class StudentProfileDto {

	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The subject name. */
	private String subjectName;
	
	/**
	 * Instantiates a new student profile dto.
	 */
	public StudentProfileDto(){
		
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the subject name.
	 *
	 * @return the subject name
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * Sets the subject name.
	 *
	 * @param subjectName the new subject name
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
}
