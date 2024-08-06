package com.api.estoquerp.util;

import com.api.estoquerp.entities.Filial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(ConsumoApiCep.class)
public class ConsumoApiCepTest {

    @Autowired
    private ConsumoApiCep consumoApiCep;

    @Autowired
    private RestTemplate restTemplate;

    @MockBean
    private Environment environment;

    @Value("${app.key.path-apicep}")
    private String pathApiCep;

    private MockRestServiceServer mockServer;

    @BeforeEach
    public void setup() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testConsultarCep() {
        String cep = "12345678";
        String apiUrl = "http://api.test.com/" + cep + "/json";
        String jsonResponse = "{\"cep\":\"12345678\",\"logradouro\":\"Logradouro Teste\",\"complemento\":\"Complemento Teste\",\"bairro\":\"Bairro Teste\",\"localidade\":\"Localidade Teste\",\"uf\":\"UF\"}";

        when(environment.getProperty("app.key.path-apicep")).thenReturn("http://api.test.com/");

        mockServer.expect(requestTo(apiUrl))
                .andRespond(withSuccess(jsonResponse, MediaType.APPLICATION_JSON));

        Filial filial = consumoApiCep.consultarCep(cep);

        assertNotNull(filial);
        assertEquals("12345678", filial.getCep());
        assertEquals("Logradouro Teste", filial.getLogradouro());
        assertEquals("Complemento Teste", filial.getComplemento());
        assertEquals("Bairro Teste", filial.getBairro());
        assertEquals("Localidade Teste", filial.getLocalidade());
        assertEquals("UF", filial.getUf());
    }
}
