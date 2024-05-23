package com.ecommerce.compras.api.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.ecommerce.compras.client.compra.CompraDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String emailCliente;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @OneToMany
    @JoinColumn(name = "idItem")
    private List<Item> itens;

    public CompraDTO convertToDTO() {
        CompraDTO dto = new CompraDTO();
        dto.setId(id);
        dto.setCliente(null);
        dto.setData(data);
        dto.setTotal(total);
        dto.setItens(itens.stream().map(Item::convertToDto).collect(Collectors.toList()));
        return dto;
    }
}
