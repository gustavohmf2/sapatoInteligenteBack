package br.com.sapatointeligente.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
public class SensorDistancia  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean ativo;
    private Float distanciaPercorrida = new Float(0);
    @ManyToOne
    @JoinColumn(name="sapatoInteligente")
    private SapatoInteligente sapatoInteligente;
    private Calendar dtCaptura;


    public SensorDistancia() {
    }

    public SensorDistancia(boolean ativo, SapatoInteligente sapatoInteligente, Calendar dtCaptura) {
        this.ativo = ativo;
        this.distanciaPercorrida = new Float(0);
        this.sapatoInteligente = sapatoInteligente;
        this.dtCaptura = dtCaptura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Float getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(Float distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public SapatoInteligente getSapatoInteligente() {
        return sapatoInteligente;
    }

    public void setSapatoInteligente(SapatoInteligente sapatoInteligente) {
        this.sapatoInteligente = sapatoInteligente;
    }

    public Calendar getDtCaptura() {
        return dtCaptura;
    }

    public void setDtCaptura(Calendar dtCaptura) {
        this.dtCaptura = dtCaptura;
    }
}
