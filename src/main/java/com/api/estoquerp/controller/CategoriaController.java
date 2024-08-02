package com.api.estoquerp.controller;

import com.api.estoquerp.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


}
