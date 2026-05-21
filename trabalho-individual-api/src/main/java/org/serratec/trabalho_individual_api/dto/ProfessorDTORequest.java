package org.serratec.trabalho_individual_api.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class ProfessorDTORequest {
	
	@NotBlank(message = "O nome é obrigatório.")
	@Size(max = 60, message = "O nome deve conter no máximo 60 caracteres.")
	@Schema(description = "Nome do professor", example = "Carlos")
	private String nome;
	
	
	@CPF(message = "O CPF deve ser válido.")
	@NotBlank(message = "O CPF é obrigatório.")
	@Schema(description = "CPF do professor", example = "123.456.789-00")
	private String cpf;
	
	@Email(message = "O email deve ser válido.")
	@Size(max = 50, message = "O email deve conter no máximo 50 caracteres.")
	@Schema(description = "Email do professor", example = "bruno.serratec@gmail.com")
	private String email;
	
	@Schema(description = "Data de nascimento do professor", example = "2010-08-21")
	@Past(message = "A data de nascimento deve estar no passado")
	private LocalDate dataNascimento;
	
	@Schema(description = "Especialidade do professor", example = "Matemática")
	private String especialidade;
	
	
	public ProfessorDTORequest() {
		super();
	}
	
	public ProfessorDTORequest(String nome, String cpf, String email, LocalDate dataNascimento, String especialidade) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.especialidade = especialidade;
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

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}	

}
