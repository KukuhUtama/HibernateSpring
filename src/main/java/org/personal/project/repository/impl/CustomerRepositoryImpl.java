package org.personal.project.repository.impl;

import org.personal.project.entity.CustomerEntity;
import org.personal.project.repository.AbstractRepository;
import org.personal.project.repository.CustomerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class CustomerRepositoryImpl.
 */
@Repository("customerRepository")
public class CustomerRepositoryImpl extends AbstractRepository implements CustomerRepository {

	/** The customer. */
	private CustomerEntity customer;

	/** (non-Javadoc)
	 * @see org.personal.project.repository.CustomerRepository#saveCustomer(org.personal.project.entity.CustomerEntity)
	 */
	@Transactional
	public CustomerEntity saveCustomer(CustomerEntity customer) {
		try {
			customer = (CustomerEntity) persist(customer);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return customer;
	}

	/** (non-Javadoc)
	 * @see org.personal.project.repository.CustomerRepository#deleteCustomer(org.personal.project.entity.CustomerEntity)
	 */
	@Transactional
	public void deleteCustomer(CustomerEntity customer) {
		try {
			delete(customer);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}