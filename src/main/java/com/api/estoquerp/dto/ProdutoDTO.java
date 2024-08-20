package com.api.estoquerp.dto;

import com.api.estoquerp.entities.Categoria;
import com.api.estoquerp.entities.Produto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String imagemUrl;
    private String codBarras;
    private List<CategoriaDTO> categorias;

    public ProdutoDTO() { }

    public ProdutoDTO(Long id, String nome, String descricao, BigDecimal preco, String imagemUrl, String codBarras, List<CategoriaDTO> categorias) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagemUrl = imagemUrl;
        this.codBarras = codBarras;
        this.categorias.addAll(categorias);
    }

    public ProdutoDTO(Produto entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
        this.preco = entity.getPreco();
        this.imagemUrl = entity.getImagemUrl();
        this.codBarras = entity.getCodBarras();
        for(Categoria cat : entity.getCategorias()){
            CategoriaDTO dto = new CategoriaDTO(cat);
            this.categorias.add(dto);
        }
    }

    public ProdutoDTO(ProdutoRegisterDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
        this.preco = dto.getPreco();
        this.imagemUrl = dto.getImagemUrl();
        this.codBarras = dto.getCodBarras();
    }
}
