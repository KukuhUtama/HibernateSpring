package org.personal.project.repository;

import org.personal.project.entity.CustomerEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface CustomerRepository.
 */
public interface CustomerRepository {
	
	/**
	 * Save customer.
	 *
	 * @param customer the customer
	 * @return the customer entity
	 */
	public CustomerEntity saveCustomer(CustomerEntity customer);
	
	/**
	 * Delete customer.
	 *
	 * @param customer the customer
	 */
	public void deleteCustomer(CustomerEntity customer);
}
