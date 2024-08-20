package com.api.estoquerp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoRegisterDTO {

    private Long id;
    @NotNull (message = "O nome do produto é obrigatório")
    private String nome;
    @NotNull (message = "A descrição do produto é obrigatória")
    private String descricao;
    @NotNull (message = "O preço do produto é obrigatório")
    private BigDecimal preco;
    @NotNull (message = "A URL da imagem do produto é obrigatória")
    private String imagemUrl;
    @NotNull (message = "O código de barras do produto é obrigatório")
    private String codBarras;
    @NotNull (message = "A categoria do produto é obrigatória")
    private String nomeCategoria;

    public ProdutoRegisterDTO() { }

    public ProdutoRegisterDTO(String nome, String descricao, BigDecimal preco, String imagemUrl, String codBarras, String nomeCategoria, Long id) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagemUrl = imagemUrl;
        this.codBarras = codBarras;
        this.nomeCategoria = nomeCategoria;
    }

}
