package br.com.persistence;

import java.util.List;

import javax.ejb.EJB;

import br.com.business.BookEJBRemote;
import br.com.persistence.entity.Book;

public class MainEJB {

	@EJB
	private static BookEJBRemote bookEJB;

	public static void main(String[] args) {
		List<Book> books = bookEJB.findBooks();
		for (Book book : books) {
			System.out.println(book.getTitle());
		}
	}
}
