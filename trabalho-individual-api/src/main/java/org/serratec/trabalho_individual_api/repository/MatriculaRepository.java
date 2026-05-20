package org.serratec.trabalho_individual_api.repository;

import java.util.Optional;

import org.serratec.trabalho_individual_api.domain.Matricula;
import org.serratec.trabalho_individual_api.domain.StatusMatricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
	
	Optional<Matricula> findByStatus(StatusMatricula status);

}
