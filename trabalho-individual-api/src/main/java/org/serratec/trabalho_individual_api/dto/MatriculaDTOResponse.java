package org.serratec.trabalho_individual_api.dto;

import java.time.LocalDate;

import org.serratec.trabalho_individual_api.domain.StatusMatricula;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "nomeAluno", "nomeCurso", "status", "dataMatricula",})


public class MatriculaDTOResponse {
	
	private Long id;
	private String nomeAluno;
	private String nomeCurso;
	private StatusMatricula status;
	private LocalDate dataMatricula;
	
	
	public MatriculaDTOResponse() {
		super();
	}
	
	public MatriculaDTOResponse(Long id, String nomeAluno, String nomeCurso, StatusMatricula status,
			LocalDate dataMatricula) {
		super();
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.nomeCurso = nomeCurso;
		this.status = status;
		this.dataMatricula = dataMatricula;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public StatusMatricula getStatus() {
		return status;
	}

	public void setStatus(StatusMatricula status) {
		this.status = status;
	}

	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	
}