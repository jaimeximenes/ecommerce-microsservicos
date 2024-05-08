package com.ecommerce.usuarios.api.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="tb_clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique = true)
    private String nome;  
    @Column(nullable=false, unique = true)
    private String cpf;
    @Column(nullable=false, unique = true)
    private String email;
    @Column(nullable=false, unique = true)
    private String telefone;
    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(nullable=false, unique = true)
    private LocalDate dataNascimento;
    @Embedded
    private Endereco endereco;
}
