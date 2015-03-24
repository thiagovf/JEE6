package br.com.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "LOAN")
public class Loan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2442873420976326343L;

	@Temporal(TemporalType.DATE)
	@Id private Date loanDate;

	@Id private Long bookId;

	@Temporal(TemporalType.DATE)
	private Date devolutionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="LIST_PERSON")
	private Person person;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="LIST_BOOK")
	private Book book;

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Date getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
