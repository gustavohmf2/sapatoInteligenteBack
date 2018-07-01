package br.com.sapatointeligente.repository;

import br.com.sapatointeligente.models.Notificacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoRepository extends CrudRepository<Notificacao, Long>{

    @Query("SELECT n FROM Notificacao n JOIN Paciente p ON p.id =:id")
    public Notificacao findByPaciente(@Param("id") Integer id);
}
