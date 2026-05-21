package org.serratec.trabalho_individual_api.dto;

import java.time.LocalDate;

import org.serratec.trabalho_individual_api.domain.StatusMatricula;

import io.swagger.v3.oas.annotations.media.Schema;


public class MatriculaDTORequest {
	@Schema(description = "ID do aluno", example = "1")
	private Long alunoId;
	@Schema(description = "ID do curso", example = "2")
	private Long cursoId;
	@Schema(description = "Status da matrícula", example = "ATIVA")
	private StatusMatricula status;
	@Schema(description = "Data da matrícula", example = "2024-01-01")
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
