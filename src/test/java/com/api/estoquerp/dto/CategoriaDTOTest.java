package com.api.estoquerp.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CategoriaDTOTest {

    private CategoriaDTO categoriaDTO;

    @BeforeEach
    void setUp() {
        categoriaDTO = new CategoriaDTO();
    }

    @Test
    void testGettersAndSetters() {
        categoriaDTO.setId(1L);
        categoriaDTO.setNome("Categoria Teste");
        categoriaDTO.setDescricao("Descrição Teste");

        assertEquals(1L, categoriaDTO.getId());
        assertEquals("Categoria Teste", categoriaDTO.getNome());
        assertEquals("Descrição Teste", categoriaDTO.getDescricao());
    }

}
