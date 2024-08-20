package com.api.estoquerp.dto;

import com.api.estoquerp.entities.Categoria;
import com.api.estoquerp.entities.Produto;
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
    private String produtoCodBarras;
    private String categoriaNome;

    public ProdutoCategoriaDTO() { }

    public ProdutoCategoriaDTO(Long produtoId, String produtoNome, String produtoDescricao, BigDecimal produtoPreco, String produtoCodBarras, String categoriaNome) {
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
        this.produtoDescricao = produtoDescricao;
        this.produtoPreco = produtoPreco;
        this.produtoCodBarras = produtoCodBarras;
        this.categoriaNome = categoriaNome;
    }

    public ProdutoCategoriaDTO(ProdutoRegisterDTO dto) {
        this.produtoId = dto.getId();
        this.produtoNome = dto.getNome();
        this.produtoDescricao = dto.getDescricao();
        this.produtoPreco = dto.getPreco();
        this.produtoCodBarras = dto.getCodBarras();
        this.categoriaNome = dto.getNomeCategoria();
    }

    public ProdutoCategoriaDTO(Produto entity) {
        this.produtoId = entity.getId();
        this.produtoNome = entity.getNome();
        this.produtoDescricao = entity.getDescricao();
        this.produtoPreco = entity.getPreco();
        this.produtoCodBarras = entity.getCodBarras();
        for(Categoria cat : entity.getCategorias()){
            this.categoriaNome = cat.getNome();
        }
    }

    public ProdutoCategoriaDTO(ProdutoCategoriaDTO dt) {
        this.produtoId = dt.getProdutoId();
        this.produtoNome = dt.getProdutoNome();
        this.produtoDescricao = dt.getProdutoDescricao();
        this.produtoPreco = dt.getProdutoPreco();
        this.produtoCodBarras = dt.getProdutoCodBarras();
        this.categoriaNome = dt.getCategoriaNome();
    }
}
