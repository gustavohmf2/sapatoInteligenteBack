package br.com.sapatointeligente.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
public class Paciente extends Usuario{


    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Calendar dataNascimento;
    //@Length(min = 40, max = 120, message = "O pesso informado está fora do intervalo definido 40 a 120")
    private Float peso;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="PACIENTE_NOTIFICACAO",
            joinColumns=@JoinColumn(name="pciente_id"),
            inverseJoinColumns=@JoinColumn(name="notificacao_id"))
    private List<Notificacao> notificacao;

    @OneToOne
    @JoinColumn(name = "sapatoInteligente")
    private SapatoInteligente sapatoInteligente;


    public Paciente() {
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public List<Notificacao> getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(List<Notificacao> notificacao) {
        this.notificacao = notificacao;
    }

    public SapatoInteligente getSapatoInteligente() {
        return sapatoInteligente;
    }

    public void setSapatoInteligente(SapatoInteligente sapatoInteligente) {
        this.sapatoInteligente = sapatoInteligente;
    }
}
