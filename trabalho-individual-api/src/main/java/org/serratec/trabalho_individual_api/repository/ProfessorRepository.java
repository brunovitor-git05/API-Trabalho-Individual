package org.serratec.trabalho_individual_api.repository;

import java.util.Optional;

import org.serratec.trabalho_individual_api.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
	Optional<Professor> findByEspecialidade(String especialidade);
	Optional<Professor> findByCpf(String cpf);

}
