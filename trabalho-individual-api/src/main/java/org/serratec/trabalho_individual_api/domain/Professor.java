package org.serratec.trabalho_individual_api.domain;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
	
	
@Entity
@Table(name = "professor")
public class Professor {
		
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
	
	@Column(name = "especialidade", length = 100)
	private String especialidade;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
	@Schema(description = "Lista de cursos ministrados pelo professor")
	private List<Curso> cursos;
	
	
	
	
	public Professor() {
		super();
	}
	
	public Professor(Long id,
			String nome,
			String cpf,
			String email,
			LocalDate dataNascimento,
			String especialidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.especialidade = especialidade;
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
	
	public String getEspecialidade() {
		return especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public List<Curso> getCursos() {
		return cursos;
	}
	
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	
}
