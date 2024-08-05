package com.api.estoquerp.service;

import com.api.estoquerp.dto.CategoriaDTO;
import com.api.estoquerp.dto.FilialDTO;
import com.api.estoquerp.dto.FilialMinDTO;
import com.api.estoquerp.entities.Filial;
import com.api.estoquerp.repository.FilialRepository;
import com.api.estoquerp.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class FilialService {

    @Autowired
    private FilialRepository filialRepository;

    @Transactional(readOnly = true)
    public FilialMinDTO findById(Long id) {
        Filial filial = filialRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Filial não encontrada!"));
        return new FilialMinDTO(filial);
    }

    @Transactional(readOnly = true)
    public List<FilialMinDTO> findAll() {
        List<Filial> list = filialRepository.findAll();
        return list.stream().map(FilialMinDTO::new).toList();
    }

    @Transactional
    public void deletar(Long id) {
        try {
            filialRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Filial não encontrada!");
        }
    }
}
