package com.api.estoquerp.dto;

import com.api.estoquerp.entities.Categoria;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {

    @NotNull(message = "Id produto nao pode estar vazio!")
    private Long id;
    @NotNull(message = "Nome do produto nao pode estar vazio!")
    private String nome;
    @NotNull(message = "Descricao do produto nao pode estar vazio!")
    @Column(columnDefinition = "TEXT")
    private String descricao;

    public CategoriaDTO() { }

    public CategoriaDTO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public CategoriaDTO(Categoria entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
    }
}
