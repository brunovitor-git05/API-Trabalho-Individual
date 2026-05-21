package org.serratec.trabalho_individual_api.controller;

import java.util.List;

import org.serratec.trabalho_individual_api.dto.ProfessorDTORequest;
import org.serratec.trabalho_individual_api.dto.ProfessorDTOResponse;
import org.serratec.trabalho_individual_api.service.ProfessorService;
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
@RequestMapping("/professores")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping
	public ResponseEntity<List<ProfessorDTOResponse>> listar() {
	return ResponseEntity.ok(professorService.findAll());
	
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProfessorDTOResponse> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(professorService.buscar(id));
	}
	
	@PostMapping
	public ResponseEntity<ProfessorDTOResponse> inserir(@RequestBody @Valid ProfessorDTORequest professorDTO) {
		ProfessorDTOResponse professorDTOResponse = professorService.inserir(professorDTO);
				return ResponseEntity.status(201).body(professorDTOResponse);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProfessorDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid ProfessorDTORequest professorDTO) {
		return ResponseEntity.ok(professorService.atualizar(id, professorDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		professorService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
