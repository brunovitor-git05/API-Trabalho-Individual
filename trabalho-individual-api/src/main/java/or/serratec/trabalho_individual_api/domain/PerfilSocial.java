package or.serratec.trabalho_individual_api.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "perfil_social")
public class PerfilSocial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "rede_social", length = 100)
	@NotBlank(message = "Uma rede social obrigatória.")
	@Schema(description = "Perfil social do aluno", example = "brunovitor-git05")
	private String redeSocial;
	
	
	@OneToOne
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;
	
	
	
	
	public PerfilSocial() {
		super();
	}
	
	public PerfilSocial(Long id, String redeSocial) {
		super();
		this.id = id;
		this.redeSocial = redeSocial;
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRedeSocial() {
		return redeSocial;
	}
	
	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	


}
