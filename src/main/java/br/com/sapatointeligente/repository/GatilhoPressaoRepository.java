package br.com.sapatointeligente.repository;

import br.com.sapatointeligente.models.GatilhoPressao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GatilhoPressaoRepository extends CrudRepository<GatilhoPressao, Long>{

    @Query("SELECT g FROM GatilhoPressao g JOIN SapatoInteligente p ON p.id =:id")
    public List<GatilhoPressao> findAllByPaciente(@Param("id") String id);

    @Query("SELECT g FROM GatilhoPressao g JOIN SapatoInteligente p ON p.id =:id")
    public GatilhoPressao findByPaciente(@Param("id") String id);
}
