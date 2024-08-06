package com.api.estoquerp.util;

import com.api.estoquerp.dto.FilialDTO;
import com.api.estoquerp.entities.Filial;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumoApiCep {

    @Value("${app.key.path-apicep}")
    private String pathApiCep;

    public Filial consultarCep(String cep) throws RuntimeException {
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        Filial filial = restTemplate.getForObject(pathApiCep.concat(cep) + "/json", Filial.class);
        filial.setCep(filial.getCep().replace("-", ""));
        return filial;
    }
}
