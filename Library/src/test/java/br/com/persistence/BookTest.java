package br.com.persistence;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;

	@BeforeClass
	public static void initEntityManager() throws Exception {
		emf = Persistence.createEntityManagerFactory("libraryTestPU");
		em = emf.createEntityManager();
	}

	@AfterClass
	public static void closeEntityManager() throws SQLException {
		em.close();
		emf.close();
	}

	@Before
	public void initTransaction() {
		tx = em.getTransaction();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldCreateABook() throws Exception {
		// Creates an instance of book
		Book book = new Book();
		book.setTitle("The Hitchhiker's Guide to the Galaxy");
		book.setBorrowed(false);
		book.setDescription("Science fiction comedy book");
		book.setIsbn("1-84023-742-2");
		book.setNbOfPage(354);
		book.setIllustrations(false);
		// Persists the book to the database
		tx.begin();
		em.persist(book);
		tx.commit();
		assertNotNull("ID should not be null", book.getId());
		// Retrieves all the books from the database
		List<Book> books = em.createNamedQuery("findAllBooks").getResultList();
		assertEquals(1, books.size());
	}

}
