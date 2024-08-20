package com.api.estoquerp.repository;

import com.api.estoquerp.entities.Categoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository categoriaRepository;

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        categoria = new Categoria(null, "Categoria Teste");
    }

    @Test
    void testSaveCategoria() {
        Categoria savedCategoria = categoriaRepository.save(categoria);
        assertNotNull(savedCategoria);
        assertNotNull(savedCategoria.getId());
    }

    @Test
    void testFindById() {
        Categoria savedCategoria = categoriaRepository.save(categoria);
        Optional<Categoria> foundCategoria = categoriaRepository.findById(savedCategoria.getId());
        assertTrue(foundCategoria.isPresent());
        assertEquals(savedCategoria.getId(), foundCategoria.get().getId());
    }

    @Test
    void testUpdateCategoria() {
        Categoria savedCategoria = categoriaRepository.save(categoria);
        savedCategoria.setNome("Categoria Atualizada");
        Categoria updatedCategoria = categoriaRepository.save(savedCategoria);
        assertEquals("Categoria Atualizada", updatedCategoria.getNome());
    }

    @Test
    void testDeleteCategoria() {
        Categoria savedCategoria = categoriaRepository.save(categoria);
        categoriaRepository.deleteById(savedCategoria.getId());
        Optional<Categoria> foundCategoria = categoriaRepository.findById(savedCategoria.getId());
        assertFalse(foundCategoria.isPresent());
    }
}
