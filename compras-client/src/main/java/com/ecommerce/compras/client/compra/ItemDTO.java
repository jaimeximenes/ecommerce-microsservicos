package com.ecommerce.compras.client.compra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private Long id;
    private String codigoProduto;
    private int quantidade;
    private double subTotal;
}
