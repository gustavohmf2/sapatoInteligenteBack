package br.com.sapatointeligente.repository;

import br.com.sapatointeligente.models.SapatoInteligente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SapatoInteligenteRepository extends CrudRepository<SapatoInteligente, String> {

}
