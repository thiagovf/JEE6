package br.com.persistence;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Person {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
	private Long id;

	@Column(name="NOME", nullable = false, length = 200)
	private String nome;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "TELEFONE")
	@Column(name = "VALUE")
	private List<String> telefone;

	@Column(name="EMAIL", nullable = false)
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<String> telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
