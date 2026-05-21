package org.serratec.trabalho_individual_api.controller;

import java.util.List;

import org.serratec.trabalho_individual_api.dto.MatriculaDTORequest;
import org.serratec.trabalho_individual_api.dto.MatriculaDTOResponse;
import org.serratec.trabalho_individual_api.service.MatriculaService;
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
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private MatriculaService matriculaService;
	
	@Operation(summary = "Listar todas as matrículas", description = "Retorna uma lista de todas as matrículas cadastradas")
	@GetMapping
	public ResponseEntity<List<MatriculaDTOResponse>> listar() {
		return ResponseEntity.ok(matriculaService.findAll());
	}
	
	@Operation(summary = "Buscar matrícula por ID", description = "Retorna os detalhes de uma matrícula com base no ID fornecido")
	@GetMapping("/{id}")
	public ResponseEntity<MatriculaDTOResponse> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(matriculaService.buscar(id));
	}
	
	@Operation(summary = "Inserir uma nova matrícula", description = "Adiciona uma nova matrícula ao sistema com os dados fornecidos")
	@PostMapping
	public ResponseEntity<MatriculaDTOResponse> inserir(@RequestBody @Valid MatriculaDTORequest matriculaDTO) {
		MatriculaDTOResponse matriculaDTOResponse = matriculaService.inserir(matriculaDTO);
				return ResponseEntity.status(201).body(matriculaDTOResponse);
	}
	
	@Operation(summary = "Atualizar uma matrícula existente", description = "Atualiza os dados de uma matrícula com base no ID fornecido")
	@PutMapping("/{id}")
	public ResponseEntity<MatriculaDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid MatriculaDTORequest matriculaDTO) {
		return ResponseEntity.ok(matriculaService.atualizar(id, matriculaDTO));
	}
	
	@Operation(summary = "Deletar uma matrícula", description = "Remove uma matrícula do sistema com base no ID fornecido")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		matriculaService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	

}
