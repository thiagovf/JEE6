package br.com.entities;

@javax.persistence.Entity
@javax.persistence.NamedQuery(name = "findAllMyBooks", 
	query = "SELECT b FROM BOOK b where b.title = 'H2G2'")
public class Book {
	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	private Long id;
	
	@javax.persistence.Column (nullable = false)
	private String title;
	
	private Float price;
	
	@javax.persistence.Column (length = 200)
	private String description;
	
	private String isbn;
	
	private Integer nbOfPage;
	
	private Boolean illustration;

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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
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

	public Boolean getIllustration() {
		return illustration;
	}

	public void setIllustration(Boolean illustration) {
		this.illustration = illustration;
	}

}
