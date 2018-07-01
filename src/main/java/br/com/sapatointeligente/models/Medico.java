package br.com.sapatointeligente.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Medico extends Usuario{

    @NotEmpty(message = "O registro é obrigátorio")
    @NotNull(message = "O campo registro é obrigatório")
    @Length(min = 8, max = 8, message = "Tamanho do campo registro inválido")
    private String registro;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="MEDICO_PCIENTE",
            joinColumns=@JoinColumn(name="medico_id"),
            inverseJoinColumns=@JoinColumn(name="paciente_id"))
    private List<Paciente> pacientes;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="MEDICO_NOTIFICACAO",
            joinColumns=@JoinColumn(name="medico_id"),
            inverseJoinColumns=@JoinColumn(name="notificacao_id"))
    private List<Notificacao> notificacao;

    public Medico() {
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Notificacao> getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(List<Notificacao> notificacao) {
        this.notificacao = notificacao;
    }

    public void addPaciente(Paciente paciente) {
        if(!getPacientes().contains(paciente)) {
            getPacientes().add(paciente);
        }
    }

}
