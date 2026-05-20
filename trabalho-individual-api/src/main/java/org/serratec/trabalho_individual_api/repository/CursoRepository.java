package org.serratec.trabalho_individual_api.repository;

import java.util.Optional;

import org.serratec.trabalho_individual_api.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	Optional<Curso> findByArea(String area);
	
	

}
