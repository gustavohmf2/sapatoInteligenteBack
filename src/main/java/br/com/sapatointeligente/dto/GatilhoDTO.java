package br.com.sapatointeligente.dto;

import br.com.sapatointeligente.models.GatilhoPercurso;
import br.com.sapatointeligente.models.GatilhoPeso;
import br.com.sapatointeligente.models.GatilhoPressao;

import java.util.List;

public class GatilhoDTO {

    private String idSapato;
    private List<GatilhoPeso> gatilhoPesos;
    private List<GatilhoPercurso> gatilhoPercursos;
    private List<GatilhoPressao> gatilhoPressaos;

    public GatilhoDTO() {
    }

    public GatilhoDTO(String idSapato, List<GatilhoPeso> gatilhoPesos, List<GatilhoPercurso> gatilhoPercursos, List<GatilhoPressao> gatilhoPressaos) {
        this.idSapato = idSapato;
        this.gatilhoPesos = gatilhoPesos;
        this.gatilhoPercursos = gatilhoPercursos;
        this.gatilhoPressaos = gatilhoPressaos;
    }

    public String getIdSapato() {
        return idSapato;
    }

    public void setIdSapato(String idSapato) {
        this.idSapato = idSapato;
    }

    public List<GatilhoPeso> getGatilhoPesos() {
        return gatilhoPesos;
    }

    public void setGatilhoPesos(List<GatilhoPeso> gatilhoPesos) {
        this.gatilhoPesos = gatilhoPesos;
    }

    public List<GatilhoPercurso> getGatilhoPercursos() {
        return gatilhoPercursos;
    }

    public void setGatilhoPercursos(List<GatilhoPercurso> gatilhoPercursos) {
        this.gatilhoPercursos = gatilhoPercursos;
    }

    public List<GatilhoPressao> getGatilhoPressaos() {
        return gatilhoPressaos;
    }

    public void setGatilhoPressaos(List<GatilhoPressao> gatilhoPressaos) {
        this.gatilhoPressaos = gatilhoPressaos;
    }
}
