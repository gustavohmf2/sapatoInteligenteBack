package br.com.sapatointeligente.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class SapatoInteligente {

    @Id
    private String id;
    private boolean status;
    private Integer cargaBateria;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="SI_SDISTANCIA",
            joinColumns=@JoinColumn(name="sapato_id"),
            inverseJoinColumns=@JoinColumn(name="sdistancia_id"))
    private List<SensorDistancia> sensorDistancia;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="SI_SPESO",
            joinColumns=@JoinColumn(name="sapato_id"),
            inverseJoinColumns=@JoinColumn(name="speso_id"))
    private List<SensorPeso> sensorPeso;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="SI_SPRESSAO",
            joinColumns=@JoinColumn(name="sapato_id"),
            inverseJoinColumns=@JoinColumn(name="spressao_id"))
    private List<SensorPressao> sensorPressao;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="SI_GATILHOPRESSAO",
            joinColumns=@JoinColumn(name="sapato_id"),
            inverseJoinColumns=@JoinColumn(name="gpressao_id"))
    private List<GatilhoPressao> gatilhoPressaos;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="SI_GATILHOPERCURSO",
            joinColumns=@JoinColumn(name="sapato_id"),
            inverseJoinColumns=@JoinColumn(name="gpercurso_id"))
    private List<GatilhoPercurso> gatilhoPercurso;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="SI_GATILHOPESO",
            joinColumns=@JoinColumn(name="sapato_id"),
            inverseJoinColumns=@JoinColumn(name="gpeso_id"))
    private List<GatilhoPeso> gatilhoPeso;

    public SapatoInteligente() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getCargaBateria() {
        return cargaBateria;
    }

    public void setCargaBateria(Integer cargaBateria) {
        this.cargaBateria = cargaBateria;
    }

    public List<SensorDistancia> getSensorDistancia() {
        return sensorDistancia;
    }

    public void setSensorDistancia(List<SensorDistancia> sensorDistancia) {
        this.sensorDistancia = sensorDistancia;
    }

    public List<SensorPeso> getSensorPeso() {
        return sensorPeso;
    }

    public void setSensorPeso(List<SensorPeso> sensorPeso) {
        this.sensorPeso = sensorPeso;
    }

    public List<SensorPressao> getSensorPressao() {
        return sensorPressao;
    }

    public void setSensorPressao(List<SensorPressao> sensorPressao) {
        this.sensorPressao = sensorPressao;
    }
}
