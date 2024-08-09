package com.api.estoquerp.service;

import com.api.estoquerp.dto.ProdutoCategoriaDTO;
import com.api.estoquerp.dto.ProdutoDTO;
import com.api.estoquerp.entities.Produto;
import com.api.estoquerp.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<ProdutoDTO> findAll() {
        List<Produto> list = produtoRepository.findAll();
        return list.stream().map(ProdutoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProdutoCategoriaDTO findProdutoByIdWithCategoria(Long produtoId) {
        return produtoRepository.findProdutoByIdWithCategoria(produtoId);
    }
}
