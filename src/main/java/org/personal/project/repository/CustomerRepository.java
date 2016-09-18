package org.personal.project.repository;

import java.util.List;
import java.util.Map;

import org.personal.project.entity.CustomerEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface CustomerRepository.
 */
public interface CustomerRepository {

	/**
	 * Save customer.
	 *
	 * @param customer
	 *            the customer
	 * @return the customer entity
	 */
	public CustomerEntity saveCustomer(CustomerEntity customer);

	/**
	 * Delete customer.
	 *
	 * @param customer
	 *            the customer
	 */
	public void deleteCustomer(CustomerEntity customer);

	/**
	 * Find all customer.
	 *
	 * @return the list
	 */
	public List<CustomerEntity> findAllCustomer();

	/**
	 * Find by first name.
	 *
	 * @param firstName
	 *            the first name
	 * @return the customer entity
	 */
	public CustomerEntity findByFirstName(String firstName);

	/**
	 * Find all contact number only.
	 *
	 * @return the list
	 */
	public List<String> findAllContactNumberOnly();

}
