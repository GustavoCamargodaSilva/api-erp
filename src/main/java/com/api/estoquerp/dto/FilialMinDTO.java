package com.api.estoquerp.dto;

import com.api.estoquerp.entities.Filial;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilialMinDTO {

    private String apelido;
    private String telefone;
    private String email;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String numero;
    private String cnpj;

    public FilialMinDTO() { }

    public FilialMinDTO(String numero, String cnpj, String apelido, String telefone, String email, String logradouro, String complemento, String bairro, String localidade, String uf) {
        this.apelido = apelido;
        this.telefone = telefone;
        this.email = email;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.numero = numero;
        this.cnpj = cnpj;
    }

    public FilialMinDTO(Filial entity) {
        apelido = entity.getApelido();
        telefone = entity.getTelefone();
        email = entity.getEmail();
        logradouro = entity.getLogradouro();
        complemento = entity.getComplemento();
        bairro = entity.getBairro();
        localidade = entity.getLocalidade();
        uf = entity.getUf();
        numero = entity.getNumero();
        cnpj = entity.getCnpj();
    }
}
