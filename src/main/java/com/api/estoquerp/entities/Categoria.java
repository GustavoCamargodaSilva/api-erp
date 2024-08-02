package com.api.estoquerp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "categoria")
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private String descricao;
    private Instant dataCadastro;
    private Instant dataAlteracao;


    public Categoria() { }

    public Categoria(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    @PrePersist
    public void prePersiste(){
        dataCadastro = Instant.now();
    }
    @PreUpdate
    public void preUpdate(){
        dataAlteracao = Instant.now();
    }


}
