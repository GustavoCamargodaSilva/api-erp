package com.api.estoquerp.repository;

import com.api.estoquerp.dto.ProdutoCategoriaDTO;
import com.api.estoquerp.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT new com.api.estoquerp.dto.ProdutoCategoriaDTO(p.id, p.nome, p.descricao, p.preco, p.codBarras, c.nome) " +
            "FROM Produto p " +
            "JOIN p.categorias c " +
            "WHERE p.id = :produtoId")
    ProdutoCategoriaDTO findProdutoByIdWithCategoria(@Param("produtoId") Long produtoId);

    @Query("SELECT new com.api.estoquerp.dto.ProdutoCategoriaDTO(p.id, p.nome, p.descricao, p.preco, p.codBarras, c.nome) " +
            "FROM Produto p " +
            "JOIN p.categorias c")
    List<ProdutoCategoriaDTO> findAllProdutos();
}
