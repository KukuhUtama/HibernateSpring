package org.personal.project.ren;

import java.util.List;

import org.personal.project.entity.BankAccountEntity;
import org.personal.project.entity.CustomerEntity;
import org.personal.project.repository.BankAccountRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/*
	 * One to Many Unidirectional CustomerEntity and BankAccoutEntity variable
	 */
	public static BankAccountRepository bankAccountRepository;
	public static BankAccountEntity firstBankAccount;
	public static BankAccountEntity secondBankAccount;
	public static BankAccountEntity thirdBankAccount;
	public static List<BankAccountEntity> bankAccounts;
	public static CustomerEntity firstCustomer;

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-application-context.xml");

		/* One to Many Unidirectional CustomerEntity and BankAccoutEntity */
		bankAccountRepository = ctx.getBean(BankAccountRepository.class);

		firstCustomer = new CustomerEntity("Kukuh", "Utama", "Klaten", "021-34556");
		firstBankAccount = new BankAccountEntity("ACC-01", 1000);
		firstBankAccount.setCustomer(firstCustomer);
		secondBankAccount = new BankAccountEntity("ACC-02", 1000);
		secondBankAccount.setCustomer(firstCustomer);

		firstBankAccount = bankAccountRepository.saveBankAccount(firstBankAccount);
		secondBankAccount = bankAccountRepository.saveBankAccount(secondBankAccount);

		thirdBankAccount = bankAccountRepository.findById(secondBankAccount.getId());
		bankAccounts = bankAccountRepository.findAllBankAccount();

		System.out.println("-------First Account Information---------");
		System.out.println("Account Number: " + bankAccounts.get(0).getAccountNumber());
		System.out.println("Account Amount: " + bankAccounts.get(0).getAmount());
		System.out.println("Account Owner: " + bankAccounts.get(0).getCustomer().getFirstName() + " "
				+ bankAccounts.get(0).getCustomer().getLastName());

		System.out.println("-------Second Account Information---------");
		System.out.println("Account Number: " + thirdBankAccount.getAccountNumber());
		System.out.println("Account Amount: " + thirdBankAccount.getAmount());
		System.out.println("Account Owner: " + thirdBankAccount.getCustomer().getFirstName() + " "
				+ thirdBankAccount.getCustomer().getLastName());
    
	}
}
