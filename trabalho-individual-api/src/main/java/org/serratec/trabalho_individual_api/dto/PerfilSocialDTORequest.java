package org.serratec.trabalho_individual_api.dto;

import jakarta.validation.constraints.NotBlank;

public class PerfilSocialDTORequest {
	
	private Long idAluno;
	
	@NotBlank(message = "Uma rede social obrigatória.")
	private String redeSocial;

	
	public PerfilSocialDTORequest() {
		super();
	}
	
	
	public PerfilSocialDTORequest(Long idAluno, String redeSocial) {
		super();
		this.idAluno = idAluno;
		this.redeSocial = redeSocial;
	}
	

	public Long getIdAluno() {
		return idAluno;
	}


	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}
	
	
	public String getRedeSocial() {
		return redeSocial;
	}
	
	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}


}
