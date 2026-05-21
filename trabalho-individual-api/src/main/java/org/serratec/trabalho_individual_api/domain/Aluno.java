package org.serratec.trabalho_individual_api.domain;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome é obrigatório.")
	@Size(max = 60, message = "O nome deve conter no máximo 60 caracteres.")
	@Column(name = "nome", nullable = false, length = 60)
	private String nome;
	
	
	@CPF(message = "O CPF deve ser válido.")
	@NotBlank(message = "O CPF é obrigatório.")
	@Column(name = "cpf", nullable = false, length = 11, unique = true)
	private String cpf;
	
	@Email(message = "O email deve ser válido.")
	@Size(max = 50, message = "O email deve conter no máximo 50 caracteres.")
	@Column(name = "email", nullable = false, length = 50, unique = true)
	private String email;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	
	
	@OneToOne(mappedBy = "aluno")
	@Schema(description = "Perfil Social do aluno")
	private PerfilSocial perfilSocial;
	
	@OneToMany(mappedBy = "aluno")
	@Schema(description = "Lista de matrículas do aluno")
	private List<Matricula> matricula;

	public Aluno() {
		super();
	}

	public Aluno(Long id, String nome, String cpf, String email, LocalDate dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	public PerfilSocial getPerfilSocial() {
		return perfilSocial;
	}
	
	
	public void setPerfilSocial(PerfilSocial perfilSocial) {
		this.perfilSocial = perfilSocial;
	}
	
	public List<Matricula> getMatricula() {
		return matricula;
	}
	
	public void setMatricula(List<Matricula> matricula) {
		this.matricula = matricula;
	}
	
	
	

}
