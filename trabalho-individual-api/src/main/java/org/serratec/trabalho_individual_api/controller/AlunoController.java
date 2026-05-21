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

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
    private AlunoService alunoService;
	
	
	@Operation(summary = "Listar todos os alunos", description = "Retorna uma lista de todos os alunos cadastrados")
	@GetMapping
	public ResponseEntity<List<AlunoDTOResponse>> listar() {
	    return ResponseEntity.ok(alunoService.findAll());
	}
	
	@Operation(summary = "Buscar aluno por ID", description = "Retorna os detalhes de um aluno com base no ID fornecido")
	@GetMapping("/{id}")
	public ResponseEntity<AlunoDTOResponse> buscar(@PathVariable Long id) {
	    return ResponseEntity.ok(alunoService.buscar(id));
    }
	
	@Operation(summary = "Inserir um novo aluno", description = "Adiciona um novo aluno ao sistema com os dados fornecidos")
    @PostMapping
    public ResponseEntity<AlunoDTOResponse> inserir(@RequestBody @Valid AlunoDTORequest alunoDTO) {
    	AlunoDTOResponse alunoDTOResponse = alunoService.inserir(alunoDTO);
    			return ResponseEntity.status(201).body(alunoDTOResponse);
      
    }

	@Operation(summary = "Atualizar um aluno existente", description = "Atualiza os dados de um aluno com base no ID fornecido")
    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AlunoDTORequest alunoDTO) {
        return ResponseEntity.ok(alunoService.atualizar(id, alunoDTO));
    }
    
    @Operation(summary = "Deletar um aluno", description = "Remove um aluno do sistema com base no ID fornecido")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
