package org.serratec.trabalho_individual_api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonPropertyOrder({
	"id",
	"nome",
	"area",
	"cargaHoraria"
})
public class CursoDTOResponse {
	@Schema(description = "ID do curso", example = "1")
	private Long id;
	@Schema(description = "Nome do curso", example = "Java")
	private String nome;
	@Schema(description = "Área do curso", example = "Programação")
	private String area;
	@Schema(description = "Carga horária do curso", example = "40")
	private Integer cargaHoraria;
	
	
	
	public CursoDTOResponse() {
		super();
	}
	
	
	
	public CursoDTOResponse(Long id, String nome, String area, Integer cargaHoraria) {
		super();
		this.id = id;
		this.nome = nome;
		this.area = area;
		this.cargaHoraria = cargaHoraria;
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
	
}
