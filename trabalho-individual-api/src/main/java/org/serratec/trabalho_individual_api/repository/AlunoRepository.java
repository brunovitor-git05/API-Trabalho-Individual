package org.serratec.trabalho_individual_api.repository;

import java.util.Optional;

import org.serratec.trabalho_individual_api.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	Optional<Aluno> findByCpf(String cpf);
	Optional<Aluno> findByEmail(String email);
	


}
