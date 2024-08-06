package com.api.estoquerp.dto;

import com.api.estoquerp.entities.Filial;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilialDTO {

    private Long id;
    private String cnpj;
    private String apelido;
    private String telefone;
    private String email;
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    private String numero;

    public FilialDTO() { }

    public FilialDTO(String cnpj, Long id, String apelido, String telefone, String email, String cep, String logradouro, String complemento, String unidade, String bairro, String localidade, String uf, String ibge, String gia, String ddd, String siafi, String numero) {
        this.id = id;
        this.apelido = apelido;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.unidade = unidade;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
        this.numero = numero;
        this.cnpj = cnpj;
    }

    public FilialDTO(Filial entity) {
        id = entity.getId();
        apelido = entity.getApelido();
        telefone = entity.getTelefone();
        email = entity.getEmail();
        cep = entity.getCep();
        logradouro = entity.getLogradouro();
        complemento = entity.getComplemento();
        unidade = entity.getUnidade();
        bairro = entity.getBairro();
        localidade = entity.getLocalidade();
        uf = entity.getUf();
        ibge = entity.getIbge();
        gia = entity.getGia();
        ddd = entity.getDdd();
        siafi = entity.getSiafi();
        numero = entity.getNumero();
        cnpj = entity.getCnpj();
    }
}
