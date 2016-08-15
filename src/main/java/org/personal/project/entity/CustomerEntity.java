package org.personal.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kukuh.utama
 * The Class CustomerEntity.
 */
@Entity
@Table(name ="customer")
public class CustomerEntity extends BaseEntity implements Serializable{
   
	/** The id. */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	/** The first name. */
	@Column(name="first_name")
	private String firstName;
	
	/** The last name. */
	@Column(name="last_name")
	private String lastName;
	
	/** The address. */
	@Column(name="address")
	private String address;
	
	/** The contact number. */
	@Column(name="contract_number")
	private String contactNumber;
	
	/**
	 * Instantiates a new customer entity.
	 */
	public CustomerEntity(){
		super();
	}

	/**
	 * Instantiates a new customer entity.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param address the address
	 * @param contactNumber the contact number
	 */
	public CustomerEntity(String firstName, String lastName, String address, String contactNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactNumber = contactNumber;
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
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the contact number.
	 *
	 * @return the contact number
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * Sets the contact number.
	 *
	 * @param contactNumber the new contact number
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
}
