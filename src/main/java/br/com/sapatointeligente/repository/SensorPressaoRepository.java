package br.com.sapatointeligente.repository;

import br.com.sapatointeligente.models.SensorPressao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorPressaoRepository extends CrudRepository<SensorPressao, Long>{

    @Query("SELECT p FROM SensorPressao p JOIN SapatoInteligente p ON p.id =:id")
    public SensorPressao findBySapato(@Param("id") String id);
}
