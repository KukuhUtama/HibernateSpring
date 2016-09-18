package org.personal.project.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.personal.project.entity.CustomerEntity;
import org.personal.project.repository.AbstractRepository;
import org.personal.project.repository.CustomerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerRepositoryImpl.
 */
@Repository("customerRepository")
public class CustomerRepositoryImpl extends AbstractRepository implements CustomerRepository {

	/** The customer. */
	private CustomerEntity customer;

	/** The hql query. */
	private String hqlQuery;

	/** The query. */
	private Query query;

	/** The customers. */
	private List<CustomerEntity> customers = new ArrayList<CustomerEntity>();

	/**
	 * (non-Javadoc).
	 *
	 * @param customer
	 *            the customer
	 * @return the customer entity
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

	/**
	 * (non-Javadoc).
	 *
	 * @param customer
	 *            the customer
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

	/**
	 * (non-Javadoc).
	 *
	 * @return the list
	 * @see org.personal.project.repository.CustomerRepository#findAllCustomer()
	 */
	@Transactional
	public List<CustomerEntity> findAllCustomer() {
		hqlQuery = "from CustomerEntity order by firstName";
		try {
			customers = (List<CustomerEntity>) getSession().createQuery(hqlQuery).list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return customers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.personal.project.repository.CustomerRepository#findByFirstName(java.
	 * lang.String)
	 */
	@Transactional
	public CustomerEntity findByFirstName(String firstName) {
		hqlQuery = "from CustomerEntity where firstName= :firstName";
		try {
			query = (Query) getSession().createQuery(hqlQuery);
			query.setParameter("firstName", firstName);
			customer = (CustomerEntity) query.uniqueResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.personal.project.repository.CustomerRepository#
	 * findAllContactNumberOnly()
	 */
	@Transactional
	public List<String> findAllContactNumberOnly() {
		List<String> contactNumbers = new ArrayList<String>();
		hqlQuery = "select contactNumber from CustomerEntity";
		try {
			contactNumbers = getSession().createQuery(hqlQuery).list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return contactNumbers;
	}

}