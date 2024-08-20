package com.api.estoquerp.service;

import com.api.estoquerp.dto.CategoriaDTO;
import com.api.estoquerp.entities.Categoria;
import com.api.estoquerp.repository.CategoriaRepository;
import com.api.estoquerp.service.exception.DataBaseException;
import com.api.estoquerp.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
        entity.setNome(dto.getNome().toUpperCase());
        entity = categoriaRepository.save(entity);
        return new CategoriaDTO(entity);
    }

    @Transactional
    public Categoria findByName(String nome) {
        String ref = nome.toUpperCase();
        Categoria entity = categoriaRepository.findByNome(nome);
        if(entity == null){
            throw new ResourceNotFoundException("Categoria nao encontrada");
        }
        return entity;
    }

    @Transactional
    public CategoriaDTO alterar(CategoriaDTO cat, Long id) {
        try {
            Categoria entity = new Categoria();
            entity = categoriaRepository.getReferenceById(id);
            entity.setNome(cat.getNome());
            entity.setId(id);
            entity = categoriaRepository.save(entity);
            return new CategoriaDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Categoria nao encontrada");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletar(Long id){
        if (!categoriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Categoria não encontrada");
        }
        try {
            categoriaRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Falha de integridade referencial");
        }
    }


}
