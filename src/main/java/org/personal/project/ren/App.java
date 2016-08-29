package org.personal.project.ren;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.personal.project.entity.BankAccountEntity;
import org.personal.project.entity.CustomerEntity;
import org.personal.project.entity.DepartmentEntity;
import org.personal.project.entity.LecturerEntity;
import org.personal.project.entity.StudentEntity;
import org.personal.project.entity.UniversityEntity;
import org.personal.project.repository.BankAccountRepository;
import org.personal.project.repository.CustomerRepository;
import org.personal.project.repository.DepartmentRepository;
import org.personal.project.repository.LecturerRepository;
import org.personal.project.repository.StudentRepository;
import org.personal.project.repository.UniversityRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/**
	 * One to Many Unidirectional CustomerEntity and BankAccoutEntity variable
	 * with many side has relationship
	 */
	public static BankAccountRepository bankAccountRepository;
	public static CustomerRepository customerRepository;
	public static BankAccountEntity firstBankAccount;
	public static BankAccountEntity secondBankAccount;
	public static BankAccountEntity thirdBankAccount;
	public static List<BankAccountEntity> bankAccounts;
	public static CustomerEntity firstCustomer;
	public static CustomerEntity secondCustomer;

	/**
	 * 
	 * One to Many Unidirectional StudentEntity and UniversityEntity variable
	 * with one side has relationship
	 */

	public static UniversityRepository universityRepository;
	public static StudentRepository studentRepository;
	public static UniversityEntity university;
	public static StudentEntity firstStudent, secondStudent;

	/**
	 * One to Many Bidirectional DepartmentEntity and LecturerEntity variable
	 */
	public static DepartmentRepository departmentRepository;
	public static LecturerRepository lecturerRepository;
	public static DepartmentEntity departmentFirst, departmentSecond;
	public static LecturerEntity lecturerFirst, lecturerSecond, lecturerThird;
	public static List<LecturerEntity> lecturers;

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-application-context.xml");

		/*
		 * One to Many Unidirectional CustomerEntity and BankAccoutEntity with
		 * many side has relationship. Point to emphasize : CascadeType.ALL
		 */
		bankAccountRepository = ctx.getBean(BankAccountRepository.class);
		customerRepository = ctx.getBean(CustomerRepository.class);

		firstCustomer = new CustomerEntity("Kukuh", "Utama", "Klaten", "021-34556");
		secondCustomer = new CustomerEntity("Fitria", "Utami", "Klaten", "021-34556");
		firstCustomer = customerRepository.saveCustomer(firstCustomer);

		firstBankAccount = new BankAccountEntity("ACC-01", 1000);
		firstBankAccount.setCustomer(firstCustomer);
		secondBankAccount = new BankAccountEntity("ACC-02", 1000);
		secondBankAccount.setCustomer(firstCustomer);

		firstBankAccount = bankAccountRepository.saveBankAccount(firstBankAccount);
		secondBankAccount = bankAccountRepository.saveBankAccount(secondBankAccount);

		thirdBankAccount = bankAccountRepository.findById(secondBankAccount.getId());
		bankAccounts = bankAccountRepository.findAllBankAccount();

		bankAccountRepository.deleteBankAccount(firstBankAccount);
		bankAccountRepository.deleteBankAccount(secondBankAccount);
		customerRepository.deleteCustomer(firstCustomer);

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

		System.out.println("-------Second Customer Information---------");
		secondCustomer = customerRepository.saveCustomer(secondCustomer);
		System.out.println("Customer Name:" + secondCustomer.getFirstName() + " " + secondCustomer.getLastName());
		System.out.println("Customer Id:" + secondCustomer.getId());
		customerRepository.deleteCustomer(secondCustomer);

		/*
		 * One to Many Unidirectional StudentEntity and UniversityEntity
		 * variable with one side has relationship. Point to emphasize : orphan
		 * removal with value true
		 */
		studentRepository = ctx.getBean(StudentRepository.class);
		universityRepository = ctx.getBean(UniversityRepository.class);
		List<StudentEntity> students = new ArrayList<StudentEntity>();
		firstStudent = new StudentEntity("IF1", "Anna", "Mubitha");
		secondStudent = new StudentEntity("IF2", "Heski", "Putri");
		students.add(firstStudent);
		students.add(secondStudent);
		university = new UniversityEntity("IT Telkom", "Bandung");
		university.setStudents(students);
		university = universityRepository.saveUniversity(university);
		System.out.println("Student Number: " + university.getStudents().size());
		List<StudentEntity> allStudent = university.getStudents();
		university.setStudents(allStudent.subList(0, 1));
		universityRepository.updateUniversity(university);
		System.out.println("Student Number: " + university.getStudents().size());
		universityRepository.deleteUniversity(university);

		/*
		 * One to Many Bidirectional DepartmentEntity and LecturerEntity
		 */
		departmentRepository = ctx.getBean(DepartmentRepository.class);
		lecturerRepository = ctx.getBean(LecturerRepository.class);

		departmentFirst = new DepartmentEntity("Informatic Engineering");

		List<LecturerEntity> lecturers = new ArrayList();
		lecturerFirst = new LecturerEntity("Kukuh Utama");
		lecturerFirst.setDepartment(departmentFirst);
		lecturers.add(lecturerFirst);
		lecturerSecond = new LecturerEntity("Shinta Putri");
		lecturerSecond.setDepartment(departmentFirst);
		lecturers.add(lecturerSecond);
		departmentFirst.setLecturers(lecturers);
		departmentFirst = departmentRepository.saveDepartment(departmentFirst);
		
		departmentSecond = new DepartmentEntity("Electrical Engineering");
		departmentSecond = departmentRepository.saveDepartment(departmentSecond);
		
		lecturerThird = new LecturerEntity("Wisanggeni Sakti");
		lecturerThird.setDepartment(departmentSecond);
		lecturerThird = lecturerRepository.saveLecturer(lecturerThird);
		
		Serializable id = departmentSecond.getId();
		departmentSecond = departmentRepository.loadDepartment(id);
		
		departmentRepository.deleteDepartment(departmentFirst);
		departmentRepository.deleteDepartment(departmentSecond);
		
		
		
	}
}
