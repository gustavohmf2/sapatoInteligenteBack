package br.com.sapatointeligente.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GatilhoPressao extends Gatilho{

    @ManyToOne
    @JoinColumn(name="sapatoInteligente")
    private SapatoInteligente sapatoInteligente;
    private Integer count = 100;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
