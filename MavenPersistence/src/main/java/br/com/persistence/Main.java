package br.com.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		Book book = new Book();
		book.setTitle("Teste de Software");
		book.setPrice(89.0F);
		book.setDescription("TesteSoftware");
		book.setIsbn("123-456-789");
		book.setNbOfPage(500);
		book.setIllustrations(true);
		// Gets an entity manager and a transaction
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("bookStorePU");
		EntityManager em = emf.createEntityManager();

		// Persists the book to the database
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(book);
		tx.commit();
		em.close();
		emf.close();


	}
}
