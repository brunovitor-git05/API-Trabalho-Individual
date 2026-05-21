package org.serratec.trabalho_individual_api.service;

import java.util.ArrayList;
import java.util.List;
import org.serratec.trabalho_individual_api.domain.Aluno;
import org.serratec.trabalho_individual_api.domain.PerfilSocial;
import org.serratec.trabalho_individual_api.dto.PerfilSocialDTORequest;
import org.serratec.trabalho_individual_api.dto.PerfilSocialDTOResponse;
import org.serratec.trabalho_individual_api.repository.AlunoRepository;
import org.serratec.trabalho_individual_api.repository.PerfilSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilSocialService {
	
	@Autowired
	private PerfilSocialRepository perfilSocialRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	
	
	public List<PerfilSocialDTOResponse> findAll() {
		
		List<PerfilSocial> perfisSociais = perfilSocialRepository.findAll();
		
		List<PerfilSocialDTOResponse> perfisSociaisDTO = new ArrayList<PerfilSocialDTOResponse>();
		
		for(PerfilSocial perfilSocial: perfisSociais) {
			PerfilSocialDTOResponse perfilSocialDTOResponse = new PerfilSocialDTOResponse();
			perfilSocialDTOResponse.setId(perfilSocial.getId());
			perfilSocialDTOResponse.setNomeAluno(perfilSocial.getAluno().getNome());
			perfilSocialDTOResponse.setRedeSocial(perfilSocial.getRedeSocial());
			perfisSociaisDTO.add(perfilSocialDTOResponse);
		}
		
		return perfisSociaisDTO;
	}
	
	
	public PerfilSocialDTOResponse inserir(PerfilSocialDTORequest perfilSocialDTO) {
		
		PerfilSocial perfilSocial = new PerfilSocial();
		
		Aluno aluno = alunoRepository.findById(perfilSocialDTO.getIdAluno())
			    .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
			perfilSocial.setAluno(aluno);
			perfilSocial.setRedeSocial(perfilSocialDTO.getRedeSocial());

		perfilSocial = perfilSocialRepository.save(perfilSocial);
		
		PerfilSocialDTOResponse perfilSocialDTOResponse = new PerfilSocialDTOResponse();
		perfilSocialDTOResponse.setId(perfilSocial.getId());
		perfilSocialDTOResponse.setNomeAluno(perfilSocial.getAluno().getNome());
		perfilSocialDTOResponse.setRedeSocial(perfilSocial.getRedeSocial());

		
		return perfilSocialDTOResponse;
	}
	
	public PerfilSocialDTOResponse buscar(Long id) {
		PerfilSocial perfilSocial = perfilSocialRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Perfil Social não encontrado com id: " + id));
		
		PerfilSocialDTOResponse perfilSocialDTOResponse = new PerfilSocialDTOResponse();
		perfilSocialDTOResponse.setId(perfilSocial.getId());
		perfilSocialDTOResponse.setNomeAluno(perfilSocial.getAluno().getNome());
		perfilSocialDTOResponse.setRedeSocial(perfilSocial.getRedeSocial());
		
		return perfilSocialDTOResponse;
	}
	
	
	public PerfilSocialDTOResponse atualizar(Long id, PerfilSocialDTORequest perfilSocialDTO) {
		PerfilSocial perfilSocial = perfilSocialRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Perfil Social não encontrado com id: " + id));
		
		Aluno aluno = alunoRepository.findById(perfilSocialDTO.getIdAluno())
			    .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
			perfilSocial.setAluno(aluno);
			perfilSocial.setRedeSocial(perfilSocialDTO.getRedeSocial());
		
		perfilSocial = perfilSocialRepository.save(perfilSocial);
		
		PerfilSocialDTOResponse perfilSocialDTOResponse = new PerfilSocialDTOResponse();
		perfilSocialDTOResponse.setId(perfilSocial.getId());
		perfilSocialDTOResponse.setNomeAluno(perfilSocial.getAluno().getNome());
		perfilSocialDTOResponse.setRedeSocial(perfilSocial.getRedeSocial());
		
		return perfilSocialDTOResponse;
	}
	
	
	
	public void deletar(Long id) {
		PerfilSocial perfilSocial = perfilSocialRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Perfil Social não encontrado com id: " + id));
		
		perfilSocialRepository.delete(perfilSocial);
	}

}
