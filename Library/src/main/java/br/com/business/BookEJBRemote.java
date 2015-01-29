package br.com.business;

import java.util.List;

import javax.ejb.Remote;

import br.com.persistence.entity.Book;

@Remote
public interface BookEJBRemote {
	List<Book> findBooks();
	Book findBookById(Long id);
	Book createBook(Book book);
	void deleteBook(Book book);
	Book updateBook(Book book);
}
