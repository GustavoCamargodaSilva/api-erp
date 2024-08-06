package com.api.estoquerp.repository;

import com.api.estoquerp.entities.Filial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FilialRepositoryTest {

    @Autowired
    private FilialRepository filialRepository;

    private Filial filial;

    @BeforeEach
    public void setup() {
        filial = new Filial("12345678000195", 1L, "Apelido Teste", "123456789", "email@teste.com", "12345-678", "Logradouro Teste", "Complemento Teste", "Unidade Teste", "Bairro Teste", "Localidade Teste", "UF", "1234567", "GIA Teste", "12", "SIAFI Teste", "123");
        filialRepository.save(filial);
    }

    @Test
    public void testSaveFilial() {
        Filial savedFilial = filialRepository.save(filial);
        assertNotNull(savedFilial);
        assertEquals(filial.getCnpj(), savedFilial.getCnpj());
    }

    @Test
    public void testFindById() {
        Optional<Filial> foundFilial = filialRepository.findById(filial.getId());
        assertTrue(foundFilial.isPresent());
        assertEquals(filial.getCnpj(), foundFilial.get().getCnpj());
    }

    @Test
    public void testUpdateFilial() {
        filial.setApelido("Apelido Atualizado");
        Filial updatedFilial = filialRepository.save(filial);
        assertEquals("Apelido Atualizado", updatedFilial.getApelido());
    }

    @Test
    public void testDeleteFilial() {
        filialRepository.deleteById(filial.getId());
        Optional<Filial> deletedFilial = filialRepository.findById(filial.getId());
        assertFalse(deletedFilial.isPresent());
    }

}
