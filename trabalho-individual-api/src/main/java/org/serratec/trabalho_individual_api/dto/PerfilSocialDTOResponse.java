package org.serratec.trabalho_individual_api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"nomeAluno", "redeSocial"})

public class PerfilSocialDTOResponse {
	
	
	private Long id;
	private String nomeAluno;
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
