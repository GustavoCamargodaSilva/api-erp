package com.api.estoquerp.controller;

import com.api.estoquerp.dto.ProdutoCategoriaDTO;
import com.api.estoquerp.dto.ProdutoDTO;
import com.api.estoquerp.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/listarprodutos")
    public ResponseEntity<List<ProdutoDTO>> findAll(){
        List<ProdutoDTO> list = produtoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/consultarprodutos/{id}")
    public ResponseEntity<ProdutoCategoriaDTO> findProdutoByIdWithCategoria(@PathVariable Long id) {
        ProdutoCategoriaDTO dto = produtoService.findProdutoByIdWithCategoria(id);
        return ResponseEntity.ok().body(dto);
    }

}
