package br.com.sapatointeligente.repository;

import br.com.sapatointeligente.models.GatilhoPercurso;
import br.com.sapatointeligente.models.GatilhoPressao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GatilhoDistanciaRepository extends CrudRepository<GatilhoPercurso, Long>{


    @Query("SELECT g FROM GatilhoPercurso g JOIN SapatoInteligente p ON p.id =:id")
    public List<GatilhoPercurso> findAllByPaciente(@Param("id") String id);

    @Query("SELECT g FROM GatilhoPercurso g JOIN SapatoInteligente p ON p.id =:id")
    public GatilhoPercurso findBySapato(@Param("id") String id);

}
