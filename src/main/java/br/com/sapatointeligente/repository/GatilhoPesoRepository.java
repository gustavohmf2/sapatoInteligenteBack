package br.com.sapatointeligente.repository;

import br.com.sapatointeligente.models.GatilhoPeso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GatilhoPesoRepository extends CrudRepository<GatilhoPeso, Long>{


    @Query("SELECT g FROM GatilhoPercurso g JOIN SapatoInteligente p ON p.id =:id")
    public List<GatilhoPeso> findAllByPaciente(@Param("id") String id);
}
