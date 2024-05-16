package com.ecommerce.usuarios.api.dto;

import com.ecommerce.usuarios.api.model.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Integer idade;
    private Endereco endereco;
    private String cep;
    private String logradouro;
    private String cidade;
    private String uf;
    private String bairro;
    private String numero;
    private String complemento;
}
