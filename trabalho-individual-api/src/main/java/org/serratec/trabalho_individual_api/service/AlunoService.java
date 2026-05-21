package org.serratec.trabalho_individual_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.trabalho_individual_api.domain.Aluno;
import org.serratec.trabalho_individual_api.dto.AlunoDTORequest;
import org.serratec.trabalho_individual_api.dto.AlunoDTOResponse;
import org.serratec.trabalho_individual_api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;

	
	
	public List<AlunoDTOResponse> findAll() {
		
		List<Aluno> alunos = alunoRepository.findAll();
		
		List<AlunoDTOResponse> alunosDTO = new ArrayList<AlunoDTOResponse>();
		
		for(Aluno aluno: alunos) {
			AlunoDTOResponse alunoDTOResponse = new AlunoDTOResponse();
			alunoDTOResponse.setId(aluno.getId());
			alunoDTOResponse.setNome(aluno.getNome());
			alunoDTOResponse.setCpf(aluno.getCpf());
			alunoDTOResponse.setEmail(aluno.getEmail());
			alunoDTOResponse.setDataNascimento(aluno.getDataNascimento());
			alunosDTO.add(alunoDTOResponse);
		}
		
		return alunosDTO;
	}


	public AlunoDTOResponse inserir(AlunoDTORequest alunoDTO) {
		
		Aluno aluno = new Aluno();
		aluno.setNome(alunoDTO.getNome());
		aluno.setCpf(alunoDTO.getCpf());
		aluno.setEmail(alunoDTO.getEmail());
		aluno.setDataNascimento(alunoDTO.getDataNascimento());
		
		aluno = alunoRepository.save(aluno);
		
		AlunoDTOResponse alunoDTOResponse = new AlunoDTOResponse();
		alunoDTOResponse.setId(aluno.getId());
		alunoDTOResponse.setNome(aluno.getNome());
		alunoDTOResponse.setCpf(aluno.getCpf());
		alunoDTOResponse.setEmail(aluno.getEmail());
		alunoDTOResponse.setDataNascimento(aluno.getDataNascimento());
		
		return alunoDTOResponse;
	}
	
	public AlunoDTOResponse buscar(Long id) {
		Aluno aluno = alunoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Aluno não encontrado com id: " + id));
		
		
		AlunoDTOResponse alunoDTOResponse = new AlunoDTOResponse();
		alunoDTOResponse.setId(aluno.getId());
		alunoDTOResponse.setNome(aluno.getNome());
		alunoDTOResponse.setCpf(aluno.getCpf());
		alunoDTOResponse.setEmail(aluno.getEmail());
		alunoDTOResponse.setDataNascimento(aluno.getDataNascimento());
		
		return alunoDTOResponse;
	}
	
	
	public AlunoDTOResponse atualizar(Long id, AlunoDTORequest alunoDTO) {
		Optional<Aluno> alunoOptional = alunoRepository.findById(id);
		
		if(alunoOptional.isEmpty()) {
			throw new RuntimeException("Aluno não encontrado com id: " + id);
		}
		
		Aluno aluno = alunoOptional.get();
		aluno.setNome(alunoDTO.getNome());
		aluno.setCpf(alunoDTO.getCpf());
		aluno.setEmail(alunoDTO.getEmail());
		aluno.setDataNascimento(alunoDTO.getDataNascimento());
		
		aluno = alunoRepository.save(aluno);
		
		AlunoDTOResponse alunoDTOResponse = new AlunoDTOResponse();
		alunoDTOResponse.setId(aluno.getId());
		alunoDTOResponse.setNome(aluno.getNome());
		alunoDTOResponse.setCpf(aluno.getCpf());
		alunoDTOResponse.setEmail(aluno.getEmail());
		alunoDTOResponse.setDataNascimento(aluno.getDataNascimento());
		
		return alunoDTOResponse;
		
	}
	
	public void deletar(Long id) {
		Optional<Aluno> alunoOptional = alunoRepository.findById(id);
		
		if(alunoOptional.isEmpty()) {
			throw new RuntimeException("Aluno não encontrado com id: " + id);
		}
		
		alunoRepository.deleteById(id);
	}
}
	
	
	
	
	

