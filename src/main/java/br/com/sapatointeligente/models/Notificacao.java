package br.com.sapatointeligente.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Calendar data;
    private String tipo;
    private Integer repeticao = 0;
    private boolean visualizada;
    private String texto;

    public Notificacao() {
    }

    public Notificacao(Paciente paciente, Medico medico, Calendar data, String tipo, boolean visualizada, String texto) {
        this.data = data;
        this.tipo = tipo;
        this.visualizada = visualizada;
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isVisualizada() {
        return visualizada;
    }

    public void setVisualizada(boolean visualizada) {
        this.visualizada = visualizada;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(Integer repeticao) {
        this.repeticao = repeticao;
    }
}
