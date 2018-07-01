package br.com.sapatointeligente.models;

import br.com.sapatointeligente.utils.TipoGatilho;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Cada gatilho define um comportamento que será verificado constantemente para que o
 * sistema possa identificar comportamentos fora dos padrões
 */

@MappedSuperclass
public abstract class Gatilho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private boolean status;
    private Calendar dataInicio;
    private Calendar dataFim;


    public Gatilho() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataFim() {
        return dataFim;
    }

    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }
}
