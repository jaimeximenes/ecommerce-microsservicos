package com.ecommerce.compras.client.compra;

import com.ecommerce.compras.client.produto.ProdutoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private Long id;
    private ProdutoDTO produto;
    private int quantidade;
    private double subTotal;
}
