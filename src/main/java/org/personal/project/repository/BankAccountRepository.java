package org.personal.project.repository;

import java.util.List;

import org.personal.project.entity.BankAccountEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface BankAccountRepository.
 */
public interface BankAccountRepository {

	/**
	 * Save bank account.
	 *
	 * @param bankAccount
	 *            the bank account
	 * @return the bank account entity
	 */
	BankAccountEntity saveBankAccount(BankAccountEntity bankAccount);

	/**
	 * Delete bank account.
	 *
	 * @param bankAccount
	 *            the bank account
	 */
	void deleteBankAccount(BankAccountEntity bankAccount);

	/**
	 * Find all bank account.
	 *
	 * @return the list
	 */
	List<BankAccountEntity> findAllBankAccount();

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the bank account entity
	 */
	BankAccountEntity findById(int id);

}
