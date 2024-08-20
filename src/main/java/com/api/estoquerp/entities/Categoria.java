package com.api.estoquerp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

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
    private Instant dataCadastro;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataAlteracao;

    @ManyToMany(mappedBy = "categorias")
    private Set<Produto> produtos = new HashSet<>();

    public Categoria() { }

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @PrePersist
    public void prePersiste(){
        dataCadastro = Instant.now();
    }
    @PreUpdate
    public void preUpdate(){
        dataAlteracao = Instant.now();
    }

    public void addProduto(Produto produto){
        produtos.add(produto);
    }
}
