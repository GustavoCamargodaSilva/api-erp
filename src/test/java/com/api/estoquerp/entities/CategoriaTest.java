package com.api.estoquerp.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CategoriaTest {

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        categoria = new Categoria();
    }

    @Test
    void testPrePersiste() {
        categoria.prePersiste();
        assertNotNull(categoria.getDataCadastro());
        assertTrue(categoria.getDataCadastro().isBefore(Instant.now()) || categoria.getDataCadastro().equals(Instant.now()));
    }

    @Test
    void testPreUpdate() {
        categoria.preUpdate();
        assertNotNull(categoria.getDataAlteracao());
        assertTrue(categoria.getDataAlteracao().isBefore(Instant.now()) || categoria.getDataAlteracao().equals(Instant.now()));
    }

}
