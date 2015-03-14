package br.com.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@javax.persistence.Entity
@javax.persistence.NamedQuery(name = "findAllBooks", 
		query = "SELECT b FROM Book b")
public class Book {

	@Id
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    @Column(name="ID")
	private Long id;

	@javax.persistence.Column(nullable = false)
	private String title;

	@javax.persistence.Column(length = 200)
	private String description;
	private String isbn;
	private Integer nbOfPage;
	private Boolean illustrations;
	private Boolean borrowed;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "TAG")
	@Column(name = "VALUE")
	private List<String> tags = new ArrayList<String>();

	private List<Loan> loans = new ArrayList<Loan>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNbOfPage() {
		return nbOfPage;
	}

	public void setNbOfPage(Integer nbOfPage) {
		this.nbOfPage = nbOfPage;
	}

	public Boolean getIllustrations() {
		return illustrations;
	}

	public void setIllustrations(Boolean illustrations) {
		this.illustrations = illustrations;
	}

	public Boolean getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(Boolean borrowed) {
		this.borrowed = borrowed;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
