package org.serratec.trabalho_individual_api.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.trabalho_individual_api.domain.Curso;
import org.serratec.trabalho_individual_api.domain.Professor;
import org.serratec.trabalho_individual_api.dto.CursoDTORequest;
import org.serratec.trabalho_individual_api.dto.CursoDTOResponse;
import org.serratec.trabalho_individual_api.exception.ResourceNotFoundException;
import org.serratec.trabalho_individual_api.repository.CursoRepository;
import org.serratec.trabalho_individual_api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
	
	
	@Autowired
	private CursoRepository cursoRepository;
	
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	
	public List<CursoDTOResponse> findAll() {
		
		List<Curso> cursos = cursoRepository.findAll();
		
		List<CursoDTOResponse> cursosDTO = new ArrayList<CursoDTOResponse>();
		
		for(Curso curso: cursos) {
			CursoDTOResponse cursoDTOResponse = new CursoDTOResponse();
			cursoDTOResponse.setId(curso.getId());
			cursoDTOResponse.setNome(curso.getNome());
			cursoDTOResponse.setArea(curso.getArea());
			cursoDTOResponse.setCargaHoraria(curso.getCargaHoraria());
			cursosDTO.add(cursoDTOResponse);
		}
		
		return cursosDTO;
	}
	
	
	public CursoDTOResponse buscar(Long id) {
		Curso curso = cursoRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));
		
		CursoDTOResponse cursoDTOResponse = new CursoDTOResponse();
		cursoDTOResponse.setId(curso.getId());
		cursoDTOResponse.setNome(curso.getNome());
		cursoDTOResponse.setArea(curso.getArea());
		cursoDTOResponse.setCargaHoraria(curso.getCargaHoraria());
		
		return cursoDTOResponse;
	}
	
	
	
	
	public CursoDTOResponse inserir(CursoDTORequest cursoDTO) {

	    Curso curso = new Curso();
	    curso.setNome(cursoDTO.getNome());
	    curso.setArea(cursoDTO.getArea());
	    curso.setCargaHoraria(cursoDTO.getCargaHoraria());

	 
	    Professor professor = professorRepository.findById(cursoDTO.getProfessorId())
	        .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado com id: " + cursoDTO.getProfessorId()));
	    curso.setProfessor(professor);

	    curso = cursoRepository.save(curso);

	    CursoDTOResponse cursoDTOResponse = new CursoDTOResponse();
	    cursoDTOResponse.setId(curso.getId());
	    cursoDTOResponse.setNome(curso.getNome());
	    cursoDTOResponse.setArea(curso.getArea());
	    cursoDTOResponse.setCargaHoraria(curso.getCargaHoraria());

	    return cursoDTOResponse;
	}
	
	
	public CursoDTOResponse atualizar(Long id, CursoDTORequest cursoDTO) {
			    Curso curso = cursoRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com id: " + id));

	    curso.setNome(cursoDTO.getNome());
	    curso.setArea(cursoDTO.getArea());
	    curso.setCargaHoraria(cursoDTO.getCargaHoraria());

	    Professor professor = professorRepository.findById(cursoDTO.getProfessorId())
	        .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado com id: " + cursoDTO.getProfessorId()));
	    curso.setProfessor(professor);

	    curso = cursoRepository.save(curso);

	    CursoDTOResponse cursoDTOResponse = new CursoDTOResponse();
	    cursoDTOResponse.setId(curso.getId());
	    cursoDTOResponse.setNome(curso.getNome());
	    cursoDTOResponse.setArea(curso.getArea());
	    cursoDTOResponse.setCargaHoraria(curso.getCargaHoraria());

	    return cursoDTOResponse;

	}

	
	public void deletar(Long id) {
		Curso curso = cursoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com id: " + id));
		
		cursoRepository.delete(curso);
	}
	
	
	
	
	
}
