package com.devweek.backend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "regiao")
public class Regiao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regiao_seq")
    @SequenceGenerator(name = "regiao_seq")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private String regiao;
    private Integer total_exames;

    public Regiao() {
    }

    public Regiao(String regiao, Integer total_exames) {
        this.regiao = regiao;
        this.total_exames = total_exames;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Integer getTotal_exames() {
        return total_exames;
    }

    public void setTotal_exames(Integer total_exames) {
        this.total_exames = total_exames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}