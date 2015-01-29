package br.com.business.bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.business.BookEJBRemote;
import br.com.persistence.entity.Book;

@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {

	@PersistenceContext(unitName = "libraryPU")
	private EntityManager em;

	public List<Book> findBooks() {
		TypedQuery<Book> query = em
				.createNamedQuery("findAllBooks", Book.class);
		return query.getResultList();
	}

	public Book findBookById(Long id) {
		return em.find(Book.class, id);
	}

	public Book createBook(Book book) {
		em.persist(book);
		return book;
	}

	public void deleteBook(Book book) {
		em.remove(em.merge(book));
	}

	public Book updateBook(Book book) {
		return em.merge(book);
	}

}
