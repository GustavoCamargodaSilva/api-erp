package com.api.estoquerp.service;

import com.api.estoquerp.dto.CategoriaDTO;
import com.api.estoquerp.entities.Categoria;
import com.api.estoquerp.repository.CategoriaRepository;
import com.api.estoquerp.service.exception.DataBaseException;
import com.api.estoquerp.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {

    @InjectMocks
    private CategoriaService categoriaService;

    @Mock
    private CategoriaRepository categoriaRepository;

    private Categoria categoria;
    private CategoriaDTO categoriaDTO;

    @BeforeEach
    void setUp() {
        categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNome("Categoria Teste");

        categoriaDTO = new CategoriaDTO(categoria);
    }

    @Test
    void testFindById_CategoriaFound() {
        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));

        CategoriaDTO result = categoriaService.findById(1L);

        assertNotNull(result);
        assertEquals(categoriaDTO.getId(), result.getId());
    }

    @Test
    void testFindById_CategoriaNotFound() {
        when(categoriaRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> categoriaService.findById(1L));
    }

    @Test
    void testCadastrar() {
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        CategoriaDTO result = categoriaService.cadastrar(categoriaDTO);

        assertNotNull(result);
        assertEquals(categoriaDTO.getId(), result.getId());
    }

    @Test
    void testAlterar_CategoriaFound() {
        when(categoriaRepository.getReferenceById(1L)).thenReturn(categoria);
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        CategoriaDTO result = categoriaService.alterar(categoriaDTO, 1L);

        assertNotNull(result);
        assertEquals(categoriaDTO.getId(), result.getId());
    }

    @Test
    void testAlterar_CategoriaNotFound() {
        when(categoriaRepository.getReferenceById(1L)).thenThrow(EntityNotFoundException.class);

        assertThrows(ResourceNotFoundException.class, () -> categoriaService.alterar(categoriaDTO, 1L));
    }

    @Test
    void testDeletar_CategoriaFound() {
        when(categoriaRepository.existsById(1L)).thenReturn(true);
        doNothing().when(categoriaRepository).deleteById(1L);

        assertDoesNotThrow(() -> categoriaService.deletar(1L));
    }

    @Test
    void testDeletar_CategoriaNotFound() {
        when(categoriaRepository.existsById(1L)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> categoriaService.deletar(1L));
    }

    @Test
    void testDeletar_DataIntegrityViolation() {
        when(categoriaRepository.existsById(1L)).thenReturn(true);
        doThrow(DataIntegrityViolationException.class).when(categoriaRepository).deleteById(1L);

        assertThrows(DataBaseException.class, () -> categoriaService.deletar(1L));
    }
}
