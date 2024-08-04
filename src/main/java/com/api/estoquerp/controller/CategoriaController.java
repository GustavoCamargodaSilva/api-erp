package com.api.estoquerp.controller;

import com.api.estoquerp.dto.CategoriaDTO;
import com.api.estoquerp.entities.Categoria;
import com.api.estoquerp.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> findById (@PathVariable Long id){
        CategoriaDTO categoria = categoriaService.findById(id);
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<CategoriaDTO> cadastrarCategoria(@Valid @RequestBody CategoriaDTO dto){
        dto = categoriaService.cadastrar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> alterarCategoria(@Valid @PathVariable Long id, @RequestBody CategoriaDTO cat){
        cat = categoriaService.alterar(cat, id);
        return ResponseEntity.ok().body(cat);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
