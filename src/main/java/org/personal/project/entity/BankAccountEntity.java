/*
 * 
 */
package org.personal.project.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Inheritance;
// TODO: Auto-generated Javadoc
/**
 * The Class BankAccountEntity.
 *
 * @author kukuh.utama
 * The Class BankAccountEntity.
 */
@Entity
@Table(name="bank_account")
public class BankAccountEntity extends BaseEntity implements Serializable{
   
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3587947663253329255L;

	/** The id. */
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	/** The account number. */
	@Column(name="account_number")
	private String accountNumber;
	
	/** The amount. */
	@Column(name="amount")
	private int amount;
	
	/** The customer. */
	@ManyToOne
	@JoinColumn(name="customer_id")
	private CustomerEntity customer;
	
	/**
	 * Instantiates a new bank account entity.
	 */
	public BankAccountEntity(){
		super();
	}
	
	/**
	 * Instantiates a new bank account entity.
	 *
	 * @param accountNumber the account number
	 * @param amount the amount
	 */
	public BankAccountEntity(String accountNumber, int amount) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
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
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * Sets the account number.
	 *
	 * @param accountNumber the new account number
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public CustomerEntity getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
	
	
}