package org.serratec.trabalho_individual_api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
	"id",
	"nome",
	"area",
	"cargaHoraria"
})
public class CursoDTOResponse {
	
	private Long id;
	private String nome;
	private String area;
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
