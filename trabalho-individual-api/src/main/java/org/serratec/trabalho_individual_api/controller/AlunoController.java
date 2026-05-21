package org.serratec.trabalho_individual_api.controller;

import java.util.List;

import org.serratec.trabalho_individual_api.dto.AlunoDTORequest;
import org.serratec.trabalho_individual_api.dto.AlunoDTOResponse;
import org.serratec.trabalho_individual_api.service.AlunoService;
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
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
    private AlunoService alunoService;
	
	
	
	@GetMapping
	public ResponseEntity<List<AlunoDTOResponse>> listar() {
	    return ResponseEntity.ok(alunoService.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<AlunoDTOResponse> buscar(@PathVariable Long id) {
	    return ResponseEntity.ok(alunoService.buscar(id));
    }

    @PostMapping
    public ResponseEntity<AlunoDTOResponse> inserir(@RequestBody @Valid AlunoDTORequest alunoDTO) {
    	AlunoDTOResponse alunoDTOResponse = alunoService.inserir(alunoDTO);
    			return ResponseEntity.status(201).body(alunoDTOResponse);
      
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AlunoDTORequest alunoDTO) {
        return ResponseEntity.ok(alunoService.atualizar(id, alunoDTO));
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
