package com.api.estoquerp.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ProdutoFilialPK {

    private Long produtoId;
    private Long filialId;

    public ProdutoFilialPK() { }

    public ProdutoFilialPK(Long produtoId, Long filialId) {
        this.produtoId = produtoId;
        this.filialId = filialId;
    }
}
