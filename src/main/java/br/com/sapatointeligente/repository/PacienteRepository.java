package br.com.sapatointeligente.repository;

import br.com.sapatointeligente.models.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Integer>{


    @Query("SELECT p FROM Paciente p JOIN SapatoInteligente s ON s.id =:id")
    public List<Paciente> findAllBySapatoId(@Param("id") String id);

    @Query("SELECT p FROM Paciente p JOIN SapatoInteligente s ON s.id =:id")
    public Paciente findBySapatoId(@Param("id") String id);

    @Query("SELECT p FROM Paciente p JOIN Medico m ON m.id =:id")
    List<Paciente> getAllPacienteForMedico(@Param("id")Integer idMedico);
}
