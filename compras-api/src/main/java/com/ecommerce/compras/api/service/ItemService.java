package com.ecommerce.compras.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.compras.api.model.Item;
import com.ecommerce.compras.api.repository.ItemRepository;
import com.ecommerce.compras.client.compra.ItemDTO;
import com.ecommerce.compras.client.produto.ProdutoDTO;

@Service
public class ItemService {
    public ProdutoDTO obterDetalhesProduto(String codigo) {
        RestTemplate template = new RestTemplate();
        String url = String.format("%s/produtos/codigos/codigo?codigo=%s", produtoWsUrl, codigo);
        ResponseEntity<ProdutoDTO> response = template.getForEntity(url, ProdutoDTO.class);

        return response.getBody();
    }

    public ItemDTO salvarItem(Item item, ProdutoDTO produto) {
        return itemRepository.save(item).convertToDto(produto);
    }

    @Value(value = "${produtos.ws.url}")
    private String produtoWsUrl;
    @Autowired
    private ItemRepository itemRepository;
}
