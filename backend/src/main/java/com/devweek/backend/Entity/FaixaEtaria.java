package com.devweek.backend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "faixa_etaria")
public class FaixaEtaria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faixa_etaria_seq")
    @SequenceGenerator(name = "faixa_etaria_seq")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private Integer Faixa_i;
    private Integer Faixa_n;
    private String Descricao;

    public FaixaEtaria() {
    }

    public FaixaEtaria(Long id, Integer faixa_i, Integer faixa_n, String descricao) {
        this.id = id;
        Faixa_i = faixa_i;
        Faixa_n = faixa_n;
        Descricao = descricao;
    }

    public Integer getFaixa_i() {
        return Faixa_i;
    }

    public void setFaixa_i(Integer faixa_i) {
        Faixa_i = faixa_i;
    }

    public Integer getFaixa_n() {
        return Faixa_n;
    }

    public void setFaixa_n(Integer faixa_n) {
        Faixa_n = faixa_n;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}