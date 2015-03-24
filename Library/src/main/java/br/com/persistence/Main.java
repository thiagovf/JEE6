package br.com.persistence;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.persistence.entity.Book;
import br.com.persistence.entity.Loan;
import br.com.persistence.entity.Person;

public class Main {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;

	public static void main(String[] args) {
		generateEntityManager();
		openTransaction();

		Book book = createBook();
		Person person = createPerson();
		createLoan(person, book);

		close();
	}
	
	private static void generateEntityManager() {
		if (emf == null) {
			// Gets an entity manager and a transaction
			emf = Persistence.createEntityManagerFactory("libraryPU");
			em = emf.createEntityManager();
		}
	}
	
	private static void openTransaction() {
		if (em != null) {
			tx = em.getTransaction();
			tx.begin();
		}
	}
	
	private static void close() {
		tx.commit();
		em.close();
		emf.close();
	}
	
	private static Book createBook() {
		Book book = new Book();
		book.setTitle("Teste de Software");
		book.setDescription("TesteSoftware");
		book.setIsbn("123-456-789");
		book.setNbOfPage(500);
		book.setIllustrations(true);

		// Persists the book to the database
		em.persist(book);

		return book;
	}

	private static Person createPerson() {

		Person person = new Person();
		person.setEmail("thiagu.vf@gmail.com");
		person.setNome("Thiago");

		em.persist(person);
		return person;
	}

	private static void createLoan(Person person, Book book) {
		Loan loan = new Loan();
		loan.setBookId(book.getId());
		loan.setPerson(person);
		loan.setLoanDate(new Date());
		loan.setBook(book);

		em.persist(loan);
	}
}
