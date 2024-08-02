package com.api.estoquerp.service;

import com.api.estoquerp.dto.CategoriaDTO;
import com.api.estoquerp.entities.Categoria;
import com.api.estoquerp.repository.CategoriaRepository;
import com.api.estoquerp.service.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Transactional
    public CategoriaDTO findById(Long id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        Categoria categoria = obj.orElseThrow(() ->
            new ResourceNotFoundException("Id categoria nao encontrado")
        );
        return new CategoriaDTO(categoria);
    }
}
