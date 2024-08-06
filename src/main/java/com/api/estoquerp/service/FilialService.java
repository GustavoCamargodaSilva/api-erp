package com.api.estoquerp.service;

import com.api.estoquerp.dto.FilialDTO;
import com.api.estoquerp.dto.FilialMinDTO;
import com.api.estoquerp.dto.FilialRegisterDTO;
import com.api.estoquerp.entities.Filial;
import com.api.estoquerp.repository.FilialRepository;
import com.api.estoquerp.service.exception.ResourceNotFoundException;
import com.api.estoquerp.util.ConsumoApiCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilialService {

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private ConsumoApiCep consumoApiCep;

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

    @Transactional
    public FilialDTO atualizar(Long id, FilialRegisterDTO dto) {
        try {
            Filial entity = filialRepository.getReferenceById(id);
            Filial att = consumoApiCep.consultarCep(dto.getCep());
            entity.setTelefone(dto.getTelefone());
            entity.setEmail(dto.getEmail());
            entity.setApelido(dto.getApelido());
            entity.setLogradouro(att.getLogradouro());
            entity.setComplemento(att.getComplemento());
            entity.setUnidade(att.getUnidade());
            entity.setBairro(att.getBairro());
            entity.setLocalidade(att.getLocalidade());
            entity.setUf(att.getUf());
            entity.setIbge(att.getIbge());
            entity.setGia(att.getGia());
            entity.setDdd(att.getDdd());
            entity.setSiafi(att.getSiafi());
            entity = filialRepository.save(entity);
            return new FilialDTO(entity);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Filial não encontrada!");
        }
    }

    @Transactional
    public FilialDTO cadastrar(FilialRegisterDTO dto) {
        Filial entity = consumoApiCep.consultarCep(dto.getCep());
        entity.setCnpj(dto.getCnpj());
        entity.setApelido(dto.getApelido());
        entity.setTelefone(dto.getTelefone());
        entity.setEmail(dto.getEmail());
        entity.setNumero(dto.getNumero());
        entity = filialRepository.save(entity);
        return new FilialDTO(entity);
    }
}
