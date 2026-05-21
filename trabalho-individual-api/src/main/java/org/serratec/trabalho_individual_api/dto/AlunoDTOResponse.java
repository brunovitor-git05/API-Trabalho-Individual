package org.serratec.trabalho_individual_api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;


@JsonPropertyOrder({
    "id",
    "nome",
    "cpf",
    "email",
    "dataNascimento"
})


public class AlunoDTOResponse {
	@Schema(description = "ID do aluno", example = "1")
	private Long id;
	@Schema(description = "Nome do aluno", example = "Bruno")
	private String nome;
	@Schema(description = "CPF do aluno", example = "123.456.789-00")
	private String cpf;
	@Schema(description = "Email do aluno", example = "bruno.serratec@gmail.com")
	private String email;
	@Schema(description = "Data de nascimento do aluno", example = "1990-01-01")
	private LocalDate dataNascimento;
	
	public AlunoDTOResponse() {
		super();
	}
	
	public AlunoDTOResponse(Long id, String nome, String cpf, String email, LocalDate dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
	

}
