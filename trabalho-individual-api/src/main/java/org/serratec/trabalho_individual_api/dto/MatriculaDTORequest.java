package org.serratec.trabalho_individual_api.dto;

import java.time.LocalDate;

import org.serratec.trabalho_individual_api.domain.StatusMatricula;


public class MatriculaDTORequest {

	private Long alunoId;
	private Long cursoId;
	private StatusMatricula status;
	private LocalDate dataMatricula;
	
	
	
	public MatriculaDTORequest() {
		super();
	}
	

	public MatriculaDTORequest(Long alunoId, Long cursoId, StatusMatricula status, LocalDate dataMatricula) {
		super();
		this.status = status;
		this.dataMatricula = dataMatricula;
		this.alunoId = alunoId;
		this.cursoId = cursoId;
	}


	public Long getAlunoId() {
		return alunoId;
	}


	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}


	public Long getCursoId() {
		return cursoId;
	}


	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
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
