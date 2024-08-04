package com.api.estoquerp.controller;

import com.api.estoquerp.dto.CategoriaDTO;
import com.api.estoquerp.dto.FilialDTO;
import com.api.estoquerp.dto.FilialMinDTO;
import com.api.estoquerp.service.CategoriaService;
import com.api.estoquerp.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/filiais")
public class FilialController {

    @Autowired
    private FilialService filialService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FilialDTO> findById(@PathVariable Long id){
        FilialDTO dto = filialService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    @RequestMapping(value = "/listarfiliais")
    public ResponseEntity<List<FilialMinDTO>> findAll(){
        List<FilialMinDTO> list = filialService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
