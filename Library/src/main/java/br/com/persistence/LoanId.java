package br.com.persistence;

import java.util.Date;

public class LoanId {

	private Date loanDate;
	private Book book;

	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result
				+ ((loanDate == null) ? 0 : loanDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanId other = (LoanId) obj;
		if (book == null) {
			if (other.book != null) {
				return false;
			}
		} else if (!book.equals(other.book)) {
			return false;
		} 
		
		if (loanDate == null) {
			if (other.loanDate != null) {
				return false;
			}
		} else if (!loanDate.equals(other.loanDate)) {
			return false;
		}
		return true;
	}

	
}