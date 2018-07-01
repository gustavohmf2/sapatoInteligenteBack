package br.com.sapatointeligente.repository;

import br.com.sapatointeligente.models.SensorDistancia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDistanciaRepository extends CrudRepository<SensorDistancia, Long>{

    @Query("SELECT d FROM SensorDistancia d JOIN SapatoInteligente p ON p.id =:id")
    public SensorDistancia findBySapato(@Param("id") String id);
}
