package org.serratec.trabalho_individual_api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "nome", "cpf", "email", "especialidade"})


public class ProfessorDTOResponse {
	
	private Long id;
	private String nome;
	private String cpf;
	private String email;
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
