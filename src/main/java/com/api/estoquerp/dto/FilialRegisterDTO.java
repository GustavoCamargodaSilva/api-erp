package com.api.estoquerp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilialRegisterDTO {

    @NotNull(message = "Campo obrigatório")
    private String apelido;
    @NotNull(message = "Campo obrigatório")
    private String telefone;
    @NotNull(message = "Campo obrigatório")
    private String email;
    @NotNull(message = "Campo obrigatório")
    private String cep;
    @NotNull(message = "Campo obrigatório")
    private String numero;
    @NotNull(message = "Campo obrigatório")
    private String cnpj;

    public FilialRegisterDTO() { }

    public FilialRegisterDTO(String cnpj, String apelido, String telefone, String email, String cep, String numero) {
        this.apelido = apelido;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.numero = numero;
        this.cnpj = cnpj;
    }

}
