package com.api.estoquerp.entities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FilialTest {

    @Test
    public void testFilialConstructor() {
        Filial filial = new Filial("12345678000195", 1L, "Apelido Teste", "123456789", "email@teste.com", "12345-678", "Logradouro Teste", "Complemento Teste", "Unidade Teste", "Bairro Teste", "Localidade Teste", "UF", "1234567", "GIA Teste", "12", "SIAFI Teste", "123");

        assertEquals(1L, filial.getId());
        assertEquals("Apelido Teste", filial.getApelido());
        assertEquals("123456789", filial.getTelefone());
        assertEquals("email@teste.com", filial.getEmail());
        assertEquals("12345-678", filial.getCep());
        assertEquals("Logradouro Teste", filial.getLogradouro());
        assertEquals("Complemento Teste", filial.getComplemento());
        assertEquals("Unidade Teste", filial.getUnidade());
        assertEquals("Bairro Teste", filial.getBairro());
        assertEquals("Localidade Teste", filial.getLocalidade());
        assertEquals("UF", filial.getUf());
        assertEquals("1234567", filial.getIbge());
        assertEquals("GIA Teste", filial.getGia());
        assertEquals("12", filial.getDdd());
        assertEquals("SIAFI Teste", filial.getSiafi());
        assertEquals("123", filial.getNumero());
        assertEquals("12345678000195", filial.getCnpj());
    }

    @Test
    public void testFilialSettersAndGetters() {
        Filial filial = new Filial();
        filial.setId(1L);
        filial.setApelido("Apelido Teste");
        filial.setTelefone("123456789");
        filial.setEmail("email@teste.com");
        filial.setCep("12345-678");
        filial.setLogradouro("Logradouro Teste");
        filial.setComplemento("Complemento Teste");
        filial.setUnidade("Unidade Teste");
        filial.setBairro("Bairro Teste");
        filial.setLocalidade("Localidade Teste");
        filial.setUf("UF");
        filial.setIbge("1234567");
        filial.setGia("GIA Teste");
        filial.setDdd("12");
        filial.setSiafi("SIAFI Teste");
        filial.setNumero("123");
        filial.setCnpj("12345678000195");

        assertEquals(1L, filial.getId());
        assertEquals("Apelido Teste", filial.getApelido());
        assertEquals("123456789", filial.getTelefone());
        assertEquals("email@teste.com", filial.getEmail());
        assertEquals("12345-678", filial.getCep());
        assertEquals("Logradouro Teste", filial.getLogradouro());
        assertEquals("Complemento Teste", filial.getComplemento());
        assertEquals("Unidade Teste", filial.getUnidade());
        assertEquals("Bairro Teste", filial.getBairro());
        assertEquals("Localidade Teste", filial.getLocalidade());
        assertEquals("UF", filial.getUf());
        assertEquals("1234567", filial.getIbge());
        assertEquals("GIA Teste", filial.getGia());
        assertEquals("12", filial.getDdd());
        assertEquals("SIAFI Teste", filial.getSiafi());
        assertEquals("123", filial.getNumero());
        assertEquals("12345678000195", filial.getCnpj());
    }
}
