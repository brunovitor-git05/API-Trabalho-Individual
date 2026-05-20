package or.serratec.trabalho_individual_api.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private StatusMatricula status;
	
	@Column(name = "data_matricula")
	private LocalDate dataMatricula;
	
	@ManyToOne
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;
	
	public Matricula() {
		super();
	}
	
	
	public Matricula(Long id, StatusMatricula status, LocalDate dataMatricula, Aluno aluno, Curso curso) {
		super();
		this.id = id;
		this.status = status;
		this.dataMatricula = dataMatricula;
		this.aluno = aluno;
		this.curso = curso;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public StatusMatricula getStatus() {
		return status;
	}


	public void setStatus(StatusMatricula status) {
		this.status = status;
	}


	public LocalDate getDataMatricula() {
		return dataMatricula;
	}


	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}