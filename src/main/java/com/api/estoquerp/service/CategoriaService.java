package com.api.estoquerp.service;

import com.api.estoquerp.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;


}
