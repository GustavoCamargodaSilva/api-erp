package com.api.estoquerp.service;

import com.api.estoquerp.dto.CategoriaDTO;
import com.api.estoquerp.dto.ProdutoCategoriaDTO;
import com.api.estoquerp.dto.ProdutoDTO;
import com.api.estoquerp.dto.ProdutoRegisterDTO;
import com.api.estoquerp.entities.Categoria;
import com.api.estoquerp.entities.Produto;
import com.api.estoquerp.repository.ProdutoRepository;
import com.api.estoquerp.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Transactional(readOnly = true)
    public List<ProdutoCategoriaDTO> findAll() {
        List<ProdutoCategoriaDTO> produtos = produtoRepository.findAllProdutos();
        if (produtos.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum produto encontrado");
        }
        return produtos;
    }

    @Transactional(readOnly = true)
    public ProdutoCategoriaDTO findProdutoByIdWithCategoria(Long produtoId) {
        if (!produtoRepository.existsById(produtoId)) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }
        return produtoRepository.findProdutoByIdWithCategoria(produtoId);
    }

    @Transactional
    public ProdutoCategoriaDTO cadastrar(ProdutoRegisterDTO dto) {
        Produto entity = new Produto();
        copyDtoToEntity(dto, entity);
        Categoria categoria = categoriaService.findByName(dto.getNomeCategoria());
        entity.addCategoria(categoria);
        entity = produtoRepository.save(entity);
        return new ProdutoCategoriaDTO(entity);
    }

    @Transactional
    public ProdutoCategoriaDTO alterar(ProdutoRegisterDTO dto) {
        if (!produtoRepository.existsById(dto.getId())) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }else{
            Produto entity = produtoRepository.getReferenceById(dto.getId());
            copyDtoToEntity(dto, entity);
            Categoria categoria = categoriaService.findByName(dto.getNomeCategoria());
            entity.addCategoria(categoria);
            entity = produtoRepository.save(entity);
            return new ProdutoCategoriaDTO(entity);
        }
    }

    @Transactional
    public void deletar(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }else{
            produtoRepository.deleteById(id);
        }
    }

    public void copyDtoToEntity(ProdutoRegisterDTO dto, Produto entity) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());
        entity.setImagemUrl(dto.getImagemUrl());
        entity.setCodBarras(dto.getCodBarras());
    }

}
