package com.api.estoquerp.controller;

import com.api.estoquerp.dto.CategoriaDTO;
import com.api.estoquerp.service.CategoriaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoriaController.class)
public class CategoriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoriaService categoriaService;

    private CategoriaDTO categoriaDTO;

    @BeforeEach
    void setUp() {
        categoriaDTO = new CategoriaDTO(1L, "Categoria Teste");
    }

    @Test
    void testFindById() throws Exception {
        when(categoriaService.findById(anyLong())).thenReturn(categoriaDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/categoria/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nome").value("Categoria Teste"))
                .andExpect(jsonPath("$.descricao").value("Descrição Teste"));
    }

    @Test
    void testCadastrarCategoria() throws Exception {
        when(categoriaService.cadastrar(any(CategoriaDTO.class))).thenReturn(categoriaDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/categoria/cadastrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\": \"Categoria Teste\", \"descricao\": \"Descrição Teste\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nome").value("Categoria Teste"))
                .andExpect(jsonPath("$.descricao").value("Descrição Teste"));
    }

    @Test
    void testAlterarCategoria() throws Exception {
        when(categoriaService.alterar(any(CategoriaDTO.class), anyLong())).thenReturn(categoriaDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/categoria/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\": \"Categoria Atualizada\", \"descricao\": \"Descrição Atualizada\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nome").value("Categoria Teste"))
                .andExpect(jsonPath("$.descricao").value("Descrição Teste"));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/categoria/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
