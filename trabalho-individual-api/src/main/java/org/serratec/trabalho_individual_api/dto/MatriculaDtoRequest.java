package org.serratec.trabalho_individual_api.dto;

import java.time.LocalDate;

import org.serratec.trabalho_individual_api.domain.StatusMatricula;


public class MatriculaDtoRequest {

	private Long idAluno;
	private Long idCurso;
	private StatusMatricula status;
	private LocalDate dataMatricula;
	
	
	
	public MatriculaDtoRequest() {
		super();
	}
	

	public MatriculaDtoRequest(Long idAluno, Long idCurso, StatusMatricula status, LocalDate dataMatricula) {
		super();
		this.status = status;
		this.dataMatricula = dataMatricula;
	}



	public Long getIdAluno() {
		return idAluno;
	}


	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}


	public Long getIdCurso() {
		return idCurso;
	}


	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
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
