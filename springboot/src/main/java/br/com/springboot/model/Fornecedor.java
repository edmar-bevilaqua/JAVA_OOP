package br.com.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="fornecedor")
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	@NotBlank(message = "Informe um nome fantasia!")
	@Size(min = 1, max = 100)
	private String nomeFantasia;
	
	@Column(nullable = false, length = 100)
	@NotBlank(message = "Informe uma razão social!")
	@Size(max = 100)
	private String razaoSocial;
	
	@Column(nullable = false, length = 18)
	@NotBlank(message = "Informe um CNPJ")
	@Size(min = 18, max = 18)
	private String cnpj;
	
	@Column(length = 13)
	private String telefone;
	
	@Column(nullable = false, length = 15)
	@NotBlank(message = "Informe um Celular")
	@Size(min = 15, max = 15)
	private String celular;
	
	@Column(nullable = false, length = 15)
	@NotBlank(message = "Informe um Email")
	@Email
	private String email;
	
	private boolean ativo;
	
	public Fornecedor() {
		this.ativo = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
