package com.api.estoquerp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produto_filial")
@Getter
@Setter
public class ProdutoFilial {

    @EmbeddedId
    private ProdutoFilialPK id = new ProdutoFilialPK();

    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @MapsId("filialId")
    @JoinColumn(name = "filial_id")
    private Filial filial;

    private Integer quantidadeEstoque;
    private String numeroNotaFiscal;

    public ProdutoFilial() { }

}
