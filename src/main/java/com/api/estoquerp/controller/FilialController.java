package com.api.estoquerp.controller;

import com.api.estoquerp.dto.CategoriaDTO;
import com.api.estoquerp.dto.FilialDTO;
import com.api.estoquerp.dto.FilialMinDTO;
import com.api.estoquerp.dto.FilialRegisterDTO;
import com.api.estoquerp.service.CategoriaService;
import com.api.estoquerp.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/filiais")
public class FilialController {

    @Autowired
    private FilialService filialService;

    @GetMapping(value = "/buscarfilial/{id}")
    public ResponseEntity<FilialMinDTO> findById(@PathVariable Long id){
        FilialMinDTO dto = filialService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    @RequestMapping(value = "/listarfiliais")
    public ResponseEntity<List<FilialMinDTO>> findAll(){
        List<FilialMinDTO> list = filialService.findAll();
        return ResponseEntity.ok().body(list);
    }

   @PutMapping(value = "/atualizarfilial/{id}")
   public ResponseEntity<FilialDTO>atualizarFilial(@PathVariable Long id, @RequestBody FilialRegisterDTO dto) {
       FilialDTO filialDTO = filialService.atualizar(id, dto);
       return ResponseEntity.ok().body(filialDTO);
   }

    @DeleteMapping(value = "/deletarfilial/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        filialService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/cadastrarfilial")

}
