package org.serratec.trabalho_individual_api.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AlunoDTORequest {
	

	@NotBlank(message = "O nome é obrigatório.")
	@Size(max = 60, message = "O nome deve conter no máximo 60 caracteres.")
	private String nome;
	
	
	@CPF(message = "O CPF deve ser válido.")
	@NotBlank(message = "O CPF é obrigatório.")
	private String cpf;
	
	@Email(message = "O email deve ser válido.")
	@Size(max = 50, message = "O email deve conter no máximo 50 caracteres.")
	private String email;
	
	
	private LocalDate dataNascimento;
	
	public AlunoDTORequest() {
		super();
	}
	
	
	public AlunoDTORequest(String nome, String cpf, String email, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	

}
