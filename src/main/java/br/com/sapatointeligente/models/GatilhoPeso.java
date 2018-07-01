package br.com.sapatointeligente.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GatilhoPeso extends Gatilho {


    private Integer pesoMin;
    private Integer pesoMax;
    @ManyToOne
    @JoinColumn(name="sapatoInteligente")
    private SapatoInteligente sapatoInteligente;

    public GatilhoPeso() {
    }

    public Integer getPesoMin() {
        return pesoMin;
    }

    public void setPesoMin(Integer pesoMin) {
        this.pesoMin = pesoMin;
    }

    public Integer getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(Integer pesoMax) {
        this.pesoMax = pesoMax;
    }

    public SapatoInteligente getSapatoInteligente() {
        return sapatoInteligente;
    }

    public void setSapatoInteligente(SapatoInteligente sapatoInteligente) {
        this.sapatoInteligente = sapatoInteligente;
    }

    @Override
    public String toString() {
        return "GatilhoPeso{" +
                "pesoMin=" + pesoMin +
                ", pesoMax=" + pesoMax +
                ", sapatoInteligente=" + sapatoInteligente +
                '}';
    }
}
