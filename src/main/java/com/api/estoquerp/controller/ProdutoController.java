package com.api.estoquerp.controller;

import com.api.estoquerp.dto.ProdutoCategoriaDTO;
import com.api.estoquerp.dto.ProdutoDTO;
import com.api.estoquerp.dto.ProdutoRegisterDTO;
import com.api.estoquerp.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/listarprodutos")
    public ResponseEntity<List<ProdutoCategoriaDTO>> findAll(){
        List<ProdutoCategoriaDTO> list = produtoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/consultarprodutos/{id}")
    public ResponseEntity<ProdutoCategoriaDTO> findProdutoByIdWithCategoria(@PathVariable Long id) {
        ProdutoCategoriaDTO dto = produtoService.findProdutoByIdWithCategoria(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(value = "/cadastrarproduto")
    public ResponseEntity<ProdutoCategoriaDTO> insert(@Valid @RequestBody ProdutoRegisterDTO dto){
        ProdutoCategoriaDTO dt = produtoService.cadastrar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dt.getProdutoId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoCategoriaDTO(dt));
    }

    @PutMapping(value = "/alterarproduto")
    public ResponseEntity<ProdutoCategoriaDTO> update(@Valid @RequestBody ProdutoRegisterDTO dto){
        ProdutoCategoriaDTO dt = produtoService.alterar(dto);
        return ResponseEntity.ok().body(dt);
    }

    @DeleteMapping(value = "/deletarproduto/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
