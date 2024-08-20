package com.api.estoquerp.dto;

import com.api.estoquerp.entities.Categoria;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {

    private Long id;
    @NotNull(message = "Nome do produto nao pode estar vazio!")
    private String nome;

    public CategoriaDTO() { }

    public CategoriaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDTO(Categoria entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
    }
}
