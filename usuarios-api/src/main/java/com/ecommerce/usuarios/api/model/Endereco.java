package com.ecommerce.usuarios.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {
   
    @Column(nullable=false, unique = true)
    private String cep;
    private String logradouro;
    private String cidade;
    private String uf;
    private String bairro;
    private String numero;
    private String complemento;
}
