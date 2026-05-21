package org.serratec.trabalho_individual_api.controller;

import java.util.List;

import org.serratec.trabalho_individual_api.dto.PerfilSocialDTORequest;
import org.serratec.trabalho_individual_api.dto.PerfilSocialDTOResponse;
import org.serratec.trabalho_individual_api.service.PerfilSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/perfil-social")
public class PerfilSocialController {

	
	@Autowired
	private PerfilSocialService perfilSocialService;
	
	@Operation(summary = "Listar todos os perfis sociais", description = "Retorna uma lista de todos os perfis sociais cadastrados")
	@GetMapping
	public ResponseEntity<List<PerfilSocialDTOResponse>> listar() {
		return ResponseEntity.ok(perfilSocialService.findAll());
		
	}
	
	@Operation(summary = "Buscar perfil social por ID", description = "Retorna os detalhes de um perfil social com base no ID fornecido")
	@GetMapping("/{id}")
	public ResponseEntity<PerfilSocialDTOResponse> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(perfilSocialService.buscar(id));
	}
	
	@Operation(summary = "Inserir um novo perfil social", description = "Adiciona um novo perfil social ao sistema com os dados fornecidos")
	@PostMapping
	public ResponseEntity<PerfilSocialDTOResponse> inserir(@RequestBody @Valid PerfilSocialDTORequest perfilSocialDTO) {
		PerfilSocialDTOResponse perfilSocialDTOResponse = perfilSocialService.inserir(perfilSocialDTO);
				return ResponseEntity.status(201).body(perfilSocialDTOResponse);
	}
	
	@Operation(summary = "Atualizar um perfil social existente", description = "Atualiza os dados de um perfil social com base no ID fornecido")
	@PutMapping("/{id}")
	public ResponseEntity<PerfilSocialDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid PerfilSocialDTORequest perfilSocialDTO) {
		return ResponseEntity.ok(perfilSocialService.atualizar(id, perfilSocialDTO));
	}
	
	@Operation(summary = "Deletar um perfil social", description = "Remove um perfil social do sistema com base no ID fornecido")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		perfilSocialService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
