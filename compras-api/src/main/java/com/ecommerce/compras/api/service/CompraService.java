package com.ecommerce.compras.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.compras.api.model.Compra;
import com.ecommerce.compras.api.repository.CompraRepository;
import com.ecommerce.compras.client.compra.CompraDTO;
import com.ecommerce.compras.client.compra.ItemDTO;
import com.ecommerce.compras.client.usuario.ClienteDTO;

@Service
public class CompraService {
    public ClienteDTO obterdetalhesCliente(String email) {
        RestTemplate template = new RestTemplate();
        String url = String.format("%s/produtos/codigos/codigo?codigo=%s", compraWsUrl, email);
        ResponseEntity<ClienteDTO> response = template.getForEntity(url, ClienteDTO.class);

        return response.getBody();
    }

    public CompraDTO salvarCompra(Compra compra, ClienteDTO cliente, List<ItemDTO> itens) {
        return compraRepository.save(compra).convertToDTO(cliente, itens);
    }

    @Value(value = "${compras.ws.url}")
    private String compraWsUrl;
    @Autowired
    private CompraRepository compraRepository;
}
