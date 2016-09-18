package org.personal.project.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.personal.project.entity.BankAccountEntity;
import org.personal.project.repository.AbstractRepository;
import org.personal.project.repository.BankAccountRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class BankAccountRepositoryImpl.
 */
@Repository("bankAccountRepository")
public class BankAccountRepositoryImpl extends AbstractRepository implements BankAccountRepository {

	/** The bank account entities. */
	private List<BankAccountEntity> bankAccountEntities;

	/** The bank account. */
	private BankAccountEntity bankAccount;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.personal.project.repository.BankAccountRepository#saveBankAccount(org
	 * .personal.project.entity.BankAccountEntity)
	 */
	@Transactional
	public BankAccountEntity saveBankAccount(BankAccountEntity bankAccount) {
		return (BankAccountEntity) persist(bankAccount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.personal.project.repository.BankAccountRepository#deleteBankAccount(
	 * org.personal.project.entity.BankAccountEntity)
	 */
	@Transactional
	public void deleteBankAccount(BankAccountEntity bankAccount) {
		try {
			delete(bankAccount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.personal.project.repository.BankAccountRepository#findAllBankAccount(
	 * )
	 */
	@Transactional
	public List<BankAccountEntity> findAllBankAccount() {
		Criteria criteria = getSession().createCriteria(BankAccountEntity.class);
		try {
			bankAccountEntities = criteria.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bankAccountEntities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.personal.project.repository.BankAccountRepository#findById(int)
	 */
	@Transactional
	public BankAccountEntity findById(int id) {
		try {
			Criteria criteria = getSession().createCriteria(BankAccountEntity.class);
			criteria.add(Restrictions.eq("id", id));
			bankAccount = (BankAccountEntity) criteria.uniqueResult();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bankAccount;
	}

}
