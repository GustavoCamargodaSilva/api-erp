package com.api.estoquerp.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoCategoriaDTO {

    private Long produtoId;
    private String produtoNome;
    private String produtoDescricao;
    private BigDecimal produtoPreco;
    private String produtoImagemUrl;
    private String categoriaNome;
    private String categoriaDescricao;

    public ProdutoCategoriaDTO() { }

    public ProdutoCategoriaDTO(Long produtoId, String produtoNome, String produtoDescricao, BigDecimal produtoPreco, String produtoImagemUrl, String categoriaNome, String categoriaDescricao) {
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
        this.produtoDescricao = produtoDescricao;
        this.produtoPreco = produtoPreco;
        this.produtoImagemUrl = produtoImagemUrl;
        this.categoriaNome = categoriaNome;
        this.categoriaDescricao = categoriaDescricao;
    }
}
