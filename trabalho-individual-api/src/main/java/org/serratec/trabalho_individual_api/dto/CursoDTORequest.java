package org.serratec.trabalho_individual_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CursoDTORequest {
	
		
	@NotBlank(message = "O nome é obrigatório")
	@Size(max = 50)
	private String nome;
		
	@NotBlank(message = "A área é obrigatória")
	@Size(max = 30)
	private String area;
		
	@NotNull(message = "A carga horária é obrigatória")
	@Min(value = 1, message = "A carga horária deve ser maior que zero")
	private Integer cargaHoraria;
	
	
	public CursoDTORequest() {
		super();
	}


	public CursoDTORequest( String nome, String area, Integer cargaHoraria) {
		super();
		this.nome = nome;
		this.area = area;
		this.cargaHoraria = cargaHoraria;
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
