package org.personal.project.ren;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.personal.project.dto.LecturerProfileDto;
import org.personal.project.entity.AuthorEntity;
import org.personal.project.entity.BankAccountEntity;
import org.personal.project.entity.BookEntity;
import org.personal.project.entity.CustomerEntity;
import org.personal.project.entity.DepartmentEntity;
import org.personal.project.entity.LecturerEntity;
import org.personal.project.entity.StudentEntity;
import org.personal.project.entity.SubjectEntity;
import org.personal.project.entity.UniversityEntity;
import org.personal.project.repository.AuthorRepository;
import org.personal.project.repository.BankAccountRepository;
import org.personal.project.repository.BookRepository;
import org.personal.project.repository.CustomerRepository;
import org.personal.project.repository.DepartmentRepository;
import org.personal.project.repository.LecturerRepository;
import org.personal.project.repository.StudentRepository;
import org.personal.project.repository.SubjectRepository;
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
	public static List<CustomerEntity> customers;
	public static List<String> contactNumbers;
	public static CustomerEntity firstCustomer;
	public static CustomerEntity secondCustomer;
	public static CustomerEntity customer;

	/**
	 * 
	 * One to Many Unidirectional StudentEntity and UniversityEntity variable
	 * with one side has relationship
	 */

	public static UniversityRepository universityRepository;
	public static StudentRepository studentRepository;
	public static UniversityEntity university;
	public static StudentEntity firstStudent, secondStudent, thirdStudent;

	/**
	 * One to Many Bidirectional DepartmentEntity and LecturerEntity variable
	 */
	public static DepartmentRepository departmentRepository;
	public static LecturerRepository lecturerRepository;
	public static DepartmentEntity departmentFirst, departmentSecond;
	public static LecturerEntity lecturerFirst, lecturerSecond, lecturerThird, lecturerFourth, lecturerFifth;
	public static List<LecturerEntity> lecturerList;
	public static List<Object[]> queryResult;
	public static List<LecturerProfileDto> lecturerProfiles;

	/**
	 * Many to Many Unidirectional AuthorEntity and BookEntity varible
	 */
	public static AuthorRepository authorRepository;
	public static BookRepository bookRepository;
	public static AuthorEntity firstAuthor, secondAuthor, thirdAuthor;
	public static BookEntity firstBook, secondBook, thirdBook, fourthBook;
	public static List<BookEntity> books;

	/**
	 * Many to Many Bidirectional SubjectEntity and StudentEntity varible.
	 * SubjectEntity as owner side.
	 */
	public static SubjectRepository subjectRepository;
	public static SubjectEntity firstSubject, secondSubject, thirdSubject;
	public static List<SubjectEntity> firstSubjects, secondSubjects;
	public static List<StudentEntity> firstStudents, secondStudents;

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-application-context.xml");

		/*
		 * One to Many Unidirectional CustomerEntity and BankAccoutEntity with
		 * many side has relationship. Point to emphasize : CascadeType.ALL
		 */

		bankAccountRepository = ctx.getBean(BankAccountRepository.class);
		customerRepository = ctx.getBean(CustomerRepository.class);

		firstCustomer = new CustomerEntity("Kukuh", "Utama", "Klaten", "021-34556");
		secondCustomer = new CustomerEntity("Fitria", "Utami", "Klaten", "021-55555");
		firstCustomer = customerRepository.saveCustomer(firstCustomer);
		secondCustomer = customerRepository.saveCustomer(secondCustomer);

		firstBankAccount = new BankAccountEntity("ACC-01", 1000);
		firstBankAccount.setCustomer(firstCustomer);
		secondBankAccount = new BankAccountEntity("ACC-02", 1000);
		secondBankAccount.setCustomer(firstCustomer);

		firstBankAccount = bankAccountRepository.saveBankAccount(firstBankAccount);
		secondBankAccount = bankAccountRepository.saveBankAccount(secondBankAccount);

		thirdBankAccount = bankAccountRepository.findById(secondBankAccount.getId());
		bankAccounts = bankAccountRepository.findAllBankAccount();
		customers = customerRepository.findAllCustomer();
		System.out.println("-----------------------------All Customer Order By Name-----------------------");
		for (CustomerEntity element : customers) {
			System.out.println("Full Name: " + element.getFirstName() + " " + element.getLastName());
		}

		customer = customerRepository.findByFirstName("Fitria");
		System.out.println("-----------------------------Find Customer By Name-----------------------");
		System.out.println("Full Name: " + customer.getFirstName() + " " + customer.getLastName());

		contactNumbers = customerRepository.findAllContactNumberOnly();
		System.out.println("-----------------------------All Contact Number-----------------------");
		for (String element : contactNumbers) {
			System.out.println("Contact Number: " + element);
		}

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

		List<LecturerEntity> lecturers = new ArrayList<LecturerEntity>();
		lecturerFirst = new LecturerEntity("Kukuh Utama", "KKU", "0893333");
		lecturerFirst.setDepartment(departmentFirst);
		lecturers.add(lecturerFirst);

		lecturerSecond = new LecturerEntity("Shinta Putri", "SHP", "08972222");
		lecturerSecond.setDepartment(departmentFirst);
		lecturers.add(lecturerSecond);

		lecturerThird = new LecturerEntity("Joko Pri", "JKP", "09383938");
		lecturerThird.setDepartment(departmentFirst);
		lecturers.add(lecturerThird);

		departmentFirst.setLecturers(lecturers);
		departmentFirst = departmentRepository.saveDepartment(departmentFirst);
		lecturerList = departmentFirst.getLecturers();
		System.out.println("-----One To Many Bidirectional-----");
		System.out.println("Department First Lecturer Size: " + lecturerList.size());

		departmentFirst.setLecturers(lecturerList.subList(0, 2));
		departmentRepository.updateDepartment(departmentFirst);
		System.out.println("-----After Updated Lecturer List-----");
		departmentFirst = departmentRepository.loadDepartment(departmentFirst.getId());
		lecturerList = departmentFirst.getLecturers();
		System.out.println("Department First Lecturer Size: " + lecturerList.size());

		departmentSecond = new DepartmentEntity("Electrical Engineering");
		departmentSecond = departmentRepository.saveDepartment(departmentSecond);

		lecturerFourth = new LecturerEntity("Wisanggeni Sakti", "WSS", "3030384");
		lecturerFourth.setDepartment(departmentSecond);
		lecturerFourth = lecturerRepository.saveLecturer(lecturerFourth);

		lecturerFifth = new LecturerEntity("Fransisca W", "FSW", "0383839");
		lecturerFifth.setDepartment(departmentSecond);
		lecturerFifth = lecturerRepository.saveLecturer(lecturerFifth);

		queryResult = lecturerRepository.findAllLectureNanmeAndCode();
		System.out.println("-----Find All Lecturer Name And Code-----");
		for (Object[] element : queryResult) {
			System.out.println("Lecturer Name: " + element[0]);
			System.out.println("Lecturer Code: " + element[1]);
		}

		System.out.println("-----Find All Lecturer Profile-----");
		lecturerProfiles = lecturerRepository.findAllLecturerProfile();
		for (LecturerProfileDto element : lecturerProfiles) {
			System.out.println("Lecturer Name: " + element.getLecturerName());
			System.out.println("Lecturer Code: " + element.getLecturerCode());
			System.out.println("Department Name: " + element.getDepartmentName());
		}

		Serializable id = departmentSecond.getId();
		departmentSecond = departmentRepository.loadDepartment(id);
		lecturerList = departmentSecond.getLecturers();
		System.out.println("Department Second Lecturer Size: " + lecturerList.size());
		lecturerRepository.deleteLecturer(lecturerFifth);
		departmentSecond = departmentRepository.loadDepartment(id);
		lecturerList = departmentSecond.getLecturers();
		System.out.println("-----After Delete One of Lecturer-----");
		System.out.println("Department Second Lecturer Size: " + lecturerList.size());

		departmentRepository.deleteDepartment(departmentFirst);
		departmentRepository.deleteDepartment(departmentSecond);

		/**
		 * Many to Many Unidirectional AuthorEntity and BookEntity
		 */
		bookRepository = ctx.getBean(BookRepository.class);
		authorRepository = ctx.getBean(AuthorRepository.class);
		books = new ArrayList<BookEntity>();

		firstAuthor = new AuthorEntity("Kukuh Utama");
		secondAuthor = new AuthorEntity("Helena Senjaya");
		thirdAuthor = new AuthorEntity("Fitria Amalia");

		firstBook = new BookEntity("How to program with Java");
		firstBook = bookRepository.saveBook(firstBook);
		secondBook = new BookEntity("How to cook Pancake");
		secondBook = bookRepository.saveBook(secondBook);
		thirdBook = new BookEntity("How to survice in world");
		thirdBook = bookRepository.saveBook(thirdBook);
		firstAuthor.getBooks().add(firstBook);
		secondAuthor.getBooks().add(secondBook);
		thirdAuthor.getBooks().add(thirdBook);

		firstAuthor = authorRepository.saveAuthor(firstAuthor);
		secondAuthor = authorRepository.saveAuthor(secondAuthor);
		thirdAuthor = authorRepository.saveAuthor(thirdAuthor);

		firstAuthor.setName("Budi Waseso");
		authorRepository.updateAuthor(firstAuthor);
		firstAuthor = authorRepository.findById(firstAuthor.getId());
		authorRepository.deleteAuthor(secondAuthor);
		authorRepository.deleteAuthor(firstAuthor);
		authorRepository.deleteAuthor(thirdAuthor);
		bookRepository.deleteBook(secondBook);
		bookRepository.deleteBook(firstBook);
		bookRepository.deleteBook(thirdBook);

		/**
		 * Many to Many Bidirectional SubjectEntity and StudentEntity varible.
		 * SubjectEntity as owner side.
		 */
		subjectRepository = ctx.getBean(SubjectRepository.class);

		firstStudent = new StudentEntity("TE1", "Anna", "wati");
		secondStudent = new StudentEntity("TE3", "Heski", "Priska");
		thirdStudent = new StudentEntity("IF4", "Inggrid", "Puty");

		/* First subject has 3 student */
		firstSubject = new SubjectEntity("Calculus");
		firstStudent.getSubjects().add(firstSubject);
		firstSubject.getStudents().add(firstStudent);
		secondStudent.getSubjects().add(firstSubject);
		firstSubject.getStudents().add(secondStudent);
		thirdStudent.getSubjects().add(firstSubject);
		firstSubject.getStudents().add(thirdStudent);

		/* Second subject has 1 student */
		secondSubject = new SubjectEntity("Algorithm");
		thirdStudent.getSubjects().add(secondSubject);
		secondSubject.getStudents().add(thirdStudent);

		studentRepository.saveStudent(firstStudent);
		studentRepository.saveStudent(secondStudent);
		thirdStudent = studentRepository.saveStudent(thirdStudent);

		firstSubject = subjectRepository.saveSubject(firstSubject);
		secondSubject = subjectRepository.saveSubject(secondSubject);

		System.out.println("Student of First Subject");
		SubjectEntity first = subjectRepository.findById(firstSubject.getId());
		for (StudentEntity element : first.getStudents()) {
			System.out.println("Student: " + element.getFirstName() + " " + element.getLastName());
		}

		System.out.println("Third Student has Subject");
		StudentEntity third = studentRepository.findById(thirdStudent.getId());
		for (SubjectEntity element : third.getSubjects()) {
			System.out.println("Student: " + element.getName());
		}

		subjectRepository.deleteSubject(firstSubject);
		subjectRepository.deleteSubject(secondSubject);
		studentRepository.deleteStudent(firstStudent);
		studentRepository.deleteStudent(secondStudent);
		studentRepository.deleteStudent(thirdStudent);
	}
}
