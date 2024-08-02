package com.api.estoquerp.service;

import com.api.estoquerp.dto.CategoriaDTO;
import com.api.estoquerp.entities.Categoria;
import com.api.estoquerp.repository.CategoriaRepository;
import com.api.estoquerp.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public CategoriaDTO findById(Long id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        Categoria categoria = obj.orElseThrow(() ->
            new ResourceNotFoundException("Id categoria nao encontrado")
        );
        return new CategoriaDTO(categoria);
    }

    @Transactional(readOnly = true)
    public CategoriaDTO cadastrar(CategoriaDTO dto) {
        Categoria entity = new Categoria();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity = categoriaRepository.save(entity);
        return new CategoriaDTO(entity);
    }

    @Transactional
    public CategoriaDTO alterar(CategoriaDTO cat, Long id) {
        try {
            Categoria entity = new Categoria();
            entity = categoriaRepository.getReferenceById(id);
            entity.setNome(cat.getNome());
            entity.setDescricao(cat.getDescricao());
            entity.setId(id);

            entity = categoriaRepository.save(entity);
            return new CategoriaDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("id not found");
        }
    }
}
