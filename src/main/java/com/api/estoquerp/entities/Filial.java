package com.api.estoquerp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "filial")
@Getter
@Setter
public class Filial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private String cnpj;

    public Filial() { }

    public Filial(String cnpj,Long id, String apelido, String telefone, String email, String cep, String logradouro, String complemento, String unidade, String bairro, String localidade, String uf, String ibge, String gia, String ddd, String siafi, String numero) {
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
}
