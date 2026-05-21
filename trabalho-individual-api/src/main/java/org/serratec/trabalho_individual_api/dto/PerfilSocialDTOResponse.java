package org.serratec.trabalho_individual_api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonPropertyOrder({"nomeAluno", "redeSocial"})

public class PerfilSocialDTOResponse {
	
	@Schema(description = "ID do perfil social", example = "1")
	private Long id;
	@Schema(description = "Nome do aluno", example = "Bruno")
	private String nomeAluno;
	@Schema(description = "Rede social do aluno", example = "LinkedIn")
	private String redeSocial;
	
	
	public PerfilSocialDTOResponse() {
		super();
	}
	
	public PerfilSocialDTOResponse(Long id, String nomeAluno, String redeSocial) {
		super();
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.redeSocial = redeSocial;
		this.redeSocial = redeSocial;
	}
	
	

	public long getId() {
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

	public String getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}

	
	

}
