package org.serratec.trabalho_individual_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CursoDTORequest {
	
	
	@NotBlank(message = "O nome é obrigatório")
	@Size(max = 50)
	@Schema(description = "Nome do curso", example = "Java")
	private String nome;
		
	@NotBlank(message = "A área é obrigatória")
	@Size(max = 30)
	@Schema(description = "Área do curso", example = "Programação")
	private String area;
		
	@NotNull(message = "A carga horária é obrigatória")
	@Positive(message = "A carga horária deve ser positiva")
	@Schema(description = "Carga horária do curso", example = "40")
	private Integer cargaHoraria;
	
	
	private Long professorId;
	
	
	public CursoDTORequest() {
		super();
	}


	public CursoDTORequest( String nome, String area, Integer cargaHoraria, Long professorId) {
		super();
		this.nome = nome;
		this.area = area;
		this.cargaHoraria = cargaHoraria;
		this.professorId = professorId;
	}
	


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public Integer getCargaHoraria() {
		return cargaHoraria;
	}


	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}


	public Long getProfessorId() {
		return professorId;
	}


	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}
	
}
