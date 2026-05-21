package org.serratec.trabalho_individual_api.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class AlunoDTORequest {
	

	@NotBlank(message = "O nome é obrigatório.")
	@Size(max = 60, message = "O nome deve conter no máximo 60 caracteres.")
	@Schema(description = "Nome do aluno", example = "Bruno")
	private String nome;
	
	
	@CPF(message = "O CPF deve ser válido.")
	@NotBlank(message = "O CPF é obrigatório.")
	@Schema(description = "CPF do aluno", example = "123.456.789-00")
	private String cpf;
	
	@Email(message = "O email deve ser válido.")
	@Size(max = 50, message = "O email deve conter no máximo 50 caracteres.")
	@Schema(description = "Email do aluno", example = "bruno.serratec@gmail.com")
	private String email;
	
	@Schema(description = "Data de nascimento do aluno", example = "1990-01-01")
	@Past(message = "A data de nascimento deve estar no passado")
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
