package org.serratec.trabalho_individual_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PerfilSocialDTORequest {
	@Schema(description = "ID do aluno", example = "1")
	private Long idAluno;
	
	@NotBlank(message = "Uma rede social obrigatória.")
	@Schema(description = "Rede social do aluno", example = "LinkedIn")
	@Pattern(regexp = "^(http?://).+", message = "A rede social deve ser uma URL válida.")
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
