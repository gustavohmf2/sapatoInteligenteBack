package br.com.sapatointeligente.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Calendar;

/**
 * Em um determinado periodo o gatilho vai verificar se o valor da distancia se manteve entre
 * o min e o max
 */
@Entity
public class GatilhoPercurso extends Gatilho{


    private Integer tempo;
    private Integer distMin;
    private Integer distMax;
    @ManyToOne
    @JoinColumn(name="sapatoInteligente")
    private SapatoInteligente sapatoInteligente;
    private Calendar dataInicio;

    public GatilhoPercurso() {
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public Integer getDistMin() {
        return distMin;
    }

    public void setDistMin(Integer distMin) {
        this.distMin = distMin;
    }

    public Integer getDistMax() {
        return distMax;
    }

    public void setDistMax(Integer distMax) {
        this.distMax = distMax;
    }

    public SapatoInteligente getSapatoInteligente() {
        return sapatoInteligente;
    }

    public void setSapatoInteligente(SapatoInteligente sapatoInteligente) {
        this.sapatoInteligente = sapatoInteligente;
    }

    @Override
    public Calendar getDataInicio() {
        return dataInicio;
    }

    @Override
    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }
}
