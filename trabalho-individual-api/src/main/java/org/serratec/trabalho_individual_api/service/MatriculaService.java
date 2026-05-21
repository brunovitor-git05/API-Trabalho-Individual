package org.serratec.trabalho_individual_api.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.trabalho_individual_api.domain.Aluno;
import org.serratec.trabalho_individual_api.domain.Curso;
import org.serratec.trabalho_individual_api.domain.Matricula;
import org.serratec.trabalho_individual_api.dto.MatriculaDTORequest;
import org.serratec.trabalho_individual_api.dto.MatriculaDTOResponse;
import org.serratec.trabalho_individual_api.exception.ResourceNotFoundException;
import org.serratec.trabalho_individual_api.repository.AlunoRepository;
import org.serratec.trabalho_individual_api.repository.CursoRepository;
import org.serratec.trabalho_individual_api.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	
	public List <MatriculaDTOResponse> findAll() {
		
		List<Matricula> matriculas = matriculaRepository.findAll();
		
		List<MatriculaDTOResponse> matriculasDTO = new ArrayList<MatriculaDTOResponse>();
		
		for(Matricula matricula: matriculas) {
			MatriculaDTOResponse matriculaDTOResponse = new MatriculaDTOResponse();
			matriculaDTOResponse.setId(matricula.getId());
			matriculaDTOResponse.setNomeAluno(matricula.getAluno().getNome());
			matriculaDTOResponse.setNomeCurso(matricula.getCurso().getNome());
			matriculaDTOResponse.setStatus(matricula.getStatus());
			matriculaDTOResponse.setDataMatricula(matricula.getDataMatricula());
			matriculasDTO.add(matriculaDTOResponse);
			
		}
		
		return matriculasDTO;
	}
	
	
	
	
	
	public MatriculaDTOResponse buscar(Long id) {
		Matricula matricula = matriculaRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Matrícula não encontrada"));
		
		MatriculaDTOResponse matriculaDTOResponse = new MatriculaDTOResponse();
		matriculaDTOResponse.setId(matricula.getId());
		matriculaDTOResponse.setNomeAluno(matricula.getAluno().getNome());
		matriculaDTOResponse.setNomeCurso(matricula.getCurso().getNome());
		matriculaDTOResponse.setDataMatricula(matricula.getDataMatricula());
		
		return matriculaDTOResponse;
	}
	
	public MatriculaDTOResponse inserir(MatriculaDTORequest matriculaDTO) {
	    Aluno aluno = alunoRepository.findById(matriculaDTO.getAlunoId())
	        .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));

	    Curso curso = cursoRepository.findById(matriculaDTO.getCursoId())
	        .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));

	    Matricula matricula = new Matricula();
	    matricula.setAluno(aluno);
	    matricula.setCurso(curso);
	    matricula.setStatus(matriculaDTO.getStatus());
	    matricula.setDataMatricula(matriculaDTO.getDataMatricula());

	    matricula = matriculaRepository.save(matricula);

	    MatriculaDTOResponse matriculaDTOResponse = new MatriculaDTOResponse();
	    matriculaDTOResponse.setId(matricula.getId());
	    matriculaDTOResponse.setNomeAluno(matricula.getAluno().getNome());
	    matriculaDTOResponse.setNomeCurso(matricula.getCurso().getNome());
	    matriculaDTOResponse.setStatus(matricula.getStatus());
	    matriculaDTOResponse.setDataMatricula(matricula.getDataMatricula());

	    return matriculaDTOResponse;

	    
	}
	

	
	public MatriculaDTOResponse atualizar(Long id, MatriculaDTORequest matriculaDTO) {
	    Matricula matricula = matriculaRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Matrícula não encontrada"));

	    Aluno aluno = alunoRepository.findById(matriculaDTO.getAlunoId())
	        .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));

	    Curso curso = cursoRepository.findById(matriculaDTO.getCursoId())
	        .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));

	    matricula.setAluno(aluno);
	    matricula.setCurso(curso);
	    matricula.setStatus(matriculaDTO.getStatus());
	    matricula.setDataMatricula(matriculaDTO.getDataMatricula());

	    matricula = matriculaRepository.save(matricula);

	    MatriculaDTOResponse matriculaDTOResponse = new MatriculaDTOResponse();
	    matriculaDTOResponse.setId(matricula.getId());
	    matriculaDTOResponse.setNomeAluno(matricula.getAluno().getNome());
	    matriculaDTOResponse.setNomeCurso(matricula.getCurso().getNome());
	    matriculaDTOResponse.setStatus(matricula.getStatus());
	    matriculaDTOResponse.setDataMatricula(matricula.getDataMatricula());

	    return matriculaDTOResponse;
	}
	
	public void deletar(Long id) {
		Matricula matricula = matriculaRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Matrícula não encontrada"));
		
		matriculaRepository.delete(matricula);
	}
	


}
