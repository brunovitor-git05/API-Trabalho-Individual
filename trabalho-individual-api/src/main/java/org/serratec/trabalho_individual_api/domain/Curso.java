package org.serratec.trabalho_individual_api.domain;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Schema(description = "Identificador único do curso", example = "1")
	private Long id;
		
	@NotBlank(message = "O nome é obrigatório")
	@Size(max = 50)
	@Column(nullable = false, length = 50)
	@Schema(description = "Nome do curso", example = "Engenharia de Software")
	private String nome;
		
	@NotBlank(message = "A área é obrigatória")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	@Schema(description = "Área de atuação", example = "Tecnologia")
	private String area;
		
	@NotNull(message = "A carga horária é obrigatória")
	@Min(value = 1, message = "A carga horária deve ser maior que zero")
	@Column(nullable = false)
	@Schema(description = "Duração do curso em horas", example = "3600")
	private Integer cargaHoraria;
	
	
	@JsonBackReference
	@ManyToOne
	@Schema(description = "Professor responsável pelo curso")
	@JoinColumn(name = "id_professor", nullable = false)
	private Professor professor;
	
	@JsonBackReference
	@OneToMany(mappedBy = "curso")
	@Schema(description = "Lista de matrículas associadas ao curso")
	private List<Matricula> matriculas;
	

	
	
	public Curso() {
		super();
	}
	
	public Curso(Long id, String nome, String area, Integer cargaHoraria) {
		this.id = id;
		this.nome = nome;
		this.area = area;
		this.cargaHoraria = cargaHoraria;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public List<Matricula> getMatriculas() {
		return matriculas;
	}
	
	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
}
