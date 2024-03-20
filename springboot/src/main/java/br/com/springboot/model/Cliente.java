package br.com.springboot.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	@NotBlank(message = "Informe um Nome")
	@Size(min = 3, max = 50)
	private String nome;
	
	@Column(length = 15)
	@NotBlank(message = "CPF Inválido")
	private String cpf;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "data_nascimento", columnDefinition = "DATE")
	@NotNull(message = "Informe uma data de nascimento")
	@Past
	private LocalDate dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Selecione uma opção")
	private Sexo sexo;
	
	@Column(length = 20)
	private String telefone;
	
	@Column(length = 20)
	@NotBlank(message = "Campo Obrigatório")
	private String celular;
	
	@Column(length = 50)
	@NotBlank(message = "Campo Obrigatório")
	@Email
	private String email;
	
	private boolean ativo;
	
	public Cliente() {
		this.ativo = true;
	}
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
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
