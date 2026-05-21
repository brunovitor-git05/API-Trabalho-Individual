package org.serratec.trabalho_individual_api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonPropertyOrder({"id", "nome", "cpf", "email", "especialidade"})


public class ProfessorDTOResponse {
	@Schema(description = "ID do professor", example = "1")
	private Long id;
	@Schema(description = "Nome do professor", example = "Bruno")
	private String nome;
	@Schema(description = "CPF do professor", example = "123.456.789-00")
	private String cpf;
	@Schema(description = "Email do professor", example = "bruno.serratec@gmail.com")
	private String email;
	@Schema(description = "Especialidade do professor", example = "Matemática")
	private String especialidade;
	
	
	public ProfessorDTOResponse() {
		super();
	}
	
	public ProfessorDTOResponse(Long id, String nome, String cpf, String email, String especialidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.especialidade = especialidade;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public LocalDate getDataNascimento() {
		return null;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		
		
	}
	
	
}
