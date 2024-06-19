package br.unitins.topicos1.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;

@Entity
public class Fornecedor extends DefaultEntity{

	@Column(length = 200, nullable = false)
    private String nome;

	@Email
	@Column(length = 250, nullable = false)
	private String email;

	@Column(length = 300, nullable=false)
	private String endereco;

	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Telefone telefone;

	@Column(length = 18, nullable = false)
	private String cnpj;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}	
}
