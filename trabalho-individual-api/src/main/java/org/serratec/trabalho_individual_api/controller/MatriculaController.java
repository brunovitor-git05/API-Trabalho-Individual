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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private MatriculaService matriculaService;
	
	
	@GetMapping
	public ResponseEntity<List<MatriculaDTOResponse>> listar() {
		return ResponseEntity.ok(matriculaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MatriculaDTOResponse> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(matriculaService.buscar(id));
	}
	
	@PostMapping
	public ResponseEntity<MatriculaDTOResponse> inserir(@RequestBody @Valid MatriculaDTORequest matriculaDTO) {
		MatriculaDTOResponse matriculaDTOResponse = matriculaService.inserir(matriculaDTO);
				return ResponseEntity.status(201).body(matriculaDTOResponse);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MatriculaDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid MatriculaDTORequest matriculaDTO) {
		return ResponseEntity.ok(matriculaService.atualizar(id, matriculaDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		matriculaService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	

}
