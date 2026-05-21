package org.serratec.trabalho_individual_api.service;
	

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.trabalho_individual_api.domain.Professor;
import org.serratec.trabalho_individual_api.dto.ProfessorDTORequest;
import org.serratec.trabalho_individual_api.dto.ProfessorDTOResponse;
import org.serratec.trabalho_individual_api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;

	
	
	public List<ProfessorDTOResponse> findAll() {
		
		List<Professor> professores = professorRepository.findAll();
		
		List<ProfessorDTOResponse> professoresDTO = new ArrayList<ProfessorDTOResponse>();
		
		for(Professor professor: professores) {
			ProfessorDTOResponse professorDTOResponse = new ProfessorDTOResponse();
			professorDTOResponse.setId(professor.getId());
			professorDTOResponse.setNome(professor.getNome());
			professorDTOResponse.setCpf(professor.getCpf());
			professorDTOResponse.setEmail(professor.getEmail());
			professorDTOResponse.setDataNascimento(professor.getDataNascimento());
			professorDTOResponse.setEspecialidade(professor.getEspecialidade());
			professoresDTO.add(professorDTOResponse);
		}
		
		return professoresDTO;
	}


	public ProfessorDTOResponse inserir(ProfessorDTORequest professorDTO) {
		
		Professor professor = new Professor();
		professor.setNome(professorDTO.getNome());
		professor.setCpf(professorDTO.getCpf());
		professor.setEmail(professorDTO.getEmail());
		professor.setDataNascimento(professorDTO.getDataNascimento());
		professor.setEspecialidade(professorDTO.getEspecialidade());
		
		professor = professorRepository.save(professor);
		
		ProfessorDTOResponse professorDTOResponse = new ProfessorDTOResponse();
		professorDTOResponse.setId(professor.getId());
		professorDTOResponse.setNome(professor.getNome());
		professorDTOResponse.setCpf(professor.getCpf());
		professorDTOResponse.setEmail(professor.getEmail());
		professorDTOResponse.setDataNascimento(professor.getDataNascimento());
		professorDTOResponse.setEspecialidade(professor.getEspecialidade());
		
		return professorDTOResponse;
	}
	
	public ProfessorDTOResponse buscar(Long id) {
		Professor professor = professorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Professor não encontrado com id: " + id));
		
		
		ProfessorDTOResponse professorDTOResponse = new ProfessorDTOResponse();
		professorDTOResponse.setId(professor.getId());
		professorDTOResponse.setNome(professor.getNome());
		professorDTOResponse.setCpf(professor.getCpf());
		professorDTOResponse.setEmail(professor.getEmail());
		professorDTOResponse.setDataNascimento(professor.getDataNascimento());
		professorDTOResponse.setEspecialidade(professor.getEspecialidade());
		
		return professorDTOResponse;
	}
	
	
	public ProfessorDTOResponse atualizar(Long id, ProfessorDTORequest professorDTO) {
		Optional<Professor> professorOptional = professorRepository.findById(id);
		
		if(professorOptional.isEmpty()) {
			throw new RuntimeException("Professor não encontrado com id: " + id);
		}
		
		Professor professor = professorOptional.get();
		professor.setNome(professorDTO.getNome());
		professor.setCpf(professorDTO.getCpf());
		professor.setEmail(professorDTO.getEmail());
		professor.setDataNascimento(professorDTO.getDataNascimento());
		professor.setEspecialidade(professorDTO.getEspecialidade());
		
		professor = professorRepository.save(professor);
		
		ProfessorDTOResponse professorDTOResponse = new ProfessorDTOResponse();
		professorDTOResponse.setId(professor.getId());
		professorDTOResponse.setNome(professor.getNome());
		professorDTOResponse.setCpf(professor.getCpf());
		professorDTOResponse.setEmail(professor.getEmail());
		professorDTOResponse.setDataNascimento(professor.getDataNascimento());
		professorDTOResponse.setEspecialidade(professor.getEspecialidade());
		
		return professorDTOResponse;
		
	}
	public void deletar(Long id) {
		Optional<Professor> professorOptional = professorRepository.findById(id);
		
		if(professorOptional.isEmpty()) {
			throw new RuntimeException("Professor não encontrado com id: " + id);
		}
		
		professorRepository.deleteById(id);
	}
}
	

