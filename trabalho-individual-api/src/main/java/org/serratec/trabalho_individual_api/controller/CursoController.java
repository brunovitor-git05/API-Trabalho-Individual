package org.serratec.trabalho_individual_api.controller;

import java.util.List;

import org.serratec.trabalho_individual_api.dto.CursoDTORequest;
import org.serratec.trabalho_individual_api.dto.CursoDTOResponse;
import org.serratec.trabalho_individual_api.service.CursoService;
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
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@Operation(summary = "Listar todos os cursos", description = "Retorna uma lista de todos os cursos cadastrados")
	@GetMapping
	public ResponseEntity<List<CursoDTOResponse>> listar() {
		return ResponseEntity.ok(cursoService.findAll());
	}
	
	@Operation(summary = "Buscar curso por ID", description = "Retorna os detalhes de um curso com base no ID fornecido")
	@GetMapping("/{id}")
	public ResponseEntity<CursoDTOResponse> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(cursoService.buscar(id));
	}
	
	@Operation(summary = "Inserir um novo curso", description = "Adiciona um novo curso ao sistema com os dados fornecidos")
	@PostMapping
	public ResponseEntity<CursoDTOResponse> inserir(@RequestBody @Valid CursoDTORequest cursoDTO) {
		CursoDTOResponse cursoDTOResponse = cursoService.inserir(cursoDTO);
				return ResponseEntity.status(201).body(cursoDTOResponse);
	}
	
	@Operation(summary = "Atualizar um curso existente", description = "Atualiza os dados de um curso com base no ID fornecido")
	@PutMapping("/{id}")
	public ResponseEntity<CursoDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid CursoDTORequest cursoDTO) {
		return ResponseEntity.ok(cursoService.atualizar(id, cursoDTO));
	}
	
	@Operation(summary = "Deletar um curso", description = "Remove um curso do sistema com base no ID fornecido")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		cursoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	

}
