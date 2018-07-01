package br.com.sapatointeligente.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;


@Entity
public class SensorPressao implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean ativo;
    @ManyToOne
    @JoinColumn(name="sapatoInteligente")
    private SapatoInteligente sapatoInteligente;
    private Calendar dtCaptura;

    private Integer e1;
    private Integer e2;
    private Integer e3;
    private Integer e4;
    private Integer e5;
    private Integer e6;

    private Integer d1;
    private Integer d2;
    private Integer d3;
    private Integer d4;
    private Integer d5;
    private Integer d6;

    public SensorPressao(SapatoInteligente sapatoInteligente, Integer e1, Integer e2, Integer e3, Integer e4, Integer e5, Integer e6, Integer d1, Integer d2, Integer d3, Integer d4, Integer d5, Integer d6, Calendar dtCaptura) {
        this.sapatoInteligente = sapatoInteligente;
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
        this.e4 = e4;
        this.e5 = e5;
        this.e6 = e6;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.d4 = d4;
        this.d5 = d5;
        this.d6 = d6;
        this.dtCaptura = dtCaptura;
    }

    public SensorPressao() { }

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

    public SapatoInteligente getSapatoInteligente() {
        return sapatoInteligente;
    }

    public void setSapatoInteligente(SapatoInteligente sapatoInteligente) {
        this.sapatoInteligente = sapatoInteligente;
    }

    public Integer getE1() {
        return e1;
    }

    public void setE1(Integer e1) {
        this.e1 = e1;
    }

    public Integer getE2() {
        return e2;
    }

    public void setE2(Integer e2) {
        this.e2 = e2;
    }

    public Integer getE3() {
        return e3;
    }

    public void setE3(Integer e3) {
        this.e3 = e3;
    }

    public Integer getE4() {
        return e4;
    }

    public void setE4(Integer e4) {
        this.e4 = e4;
    }

    public Integer getE5() {
        return e5;
    }

    public void setE5(Integer e5) {
        this.e5 = e5;
    }

    public Integer getE6() {
        return e6;
    }

    public void setE6(Integer e6) {
        this.e6 = e6;
    }

    public Integer getD1() {
        return d1;
    }

    public void setD1(Integer d1) {
        this.d1 = d1;
    }

    public Integer getD2() {
        return d2;
    }

    public void setD2(Integer d2) {
        this.d2 = d2;
    }

    public Integer getD3() {
        return d3;
    }

    public void setD3(Integer d3) {
        this.d3 = d3;
    }

    public Integer getD4() {
        return d4;
    }

    public void setD4(Integer d4) {
        this.d4 = d4;
    }

    public Integer getD5() {
        return d5;
    }

    public void setD5(Integer d5) {
        this.d5 = d5;
    }

    public Integer getD6() {
        return d6;
    }

    public void setD6(Integer d6) {
        this.d6 = d6;
    }

    @Override
    public String toString() {
        return "SensorPressao{" +
                "id=" + id +
                ", ativo=" + ativo +
                ", sapatoInteligente=" + sapatoInteligente.getId() +
                ", e1=" + e1 +
                ", e2=" + e2 +
                ", e3=" + e3 +
                ", e4=" + e4 +
                ", e5=" + e5 +
                ", e6=" + e6 +
                ", d1=" + d1 +
                ", d2=" + d2 +
                ", d3=" + d3 +
                ", d4=" + d4 +
                ", d5=" + d5 +
                ", d6=" + d6 +
                '}';
    }


}
