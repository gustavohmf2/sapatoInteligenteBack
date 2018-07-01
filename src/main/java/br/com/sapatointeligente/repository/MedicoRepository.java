package br.com.sapatointeligente.repository;

import br.com.sapatointeligente.models.Medico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Integer>{
}
