package org.serratec.trabalho_individual_api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"nomeAluno", "redeSocial"})

public class PerfilSocialDTOResponse {
	
	private Long nomeAluno;
	private String redeSocial;
	
	
	public PerfilSocialDTOResponse() {
		super();
	}
	
	public PerfilSocialDTOResponse(Long nomeAluno, String redeSocial) {
		super();
		this.nomeAluno = nomeAluno;
		this.redeSocial = redeSocial;
	}

	public Long getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(Long nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}
	
	
	

}
