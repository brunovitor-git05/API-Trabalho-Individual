package org.serratec.trabalho_individual_api.dto;

import jakarta.validation.constraints.NotBlank;

public class PerfilSocialDTORequest {
	
	private Long alunoId;
	
	@NotBlank(message = "Uma rede social obrigatória.")
	private String redeSocial;

	
	public PerfilSocialDTORequest() {
		super();
	}
	
	
	public PerfilSocialDTORequest(Long alunoId, String redeSocial) {
		super();
		this.alunoId = alunoId;
		this.redeSocial = redeSocial;
	}
	
	
	
	
	public String getRedeSocial() {
		return redeSocial;
	}
	
	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}


	public Long getAlunoId() {
		return alunoId;
	}


	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}
}
