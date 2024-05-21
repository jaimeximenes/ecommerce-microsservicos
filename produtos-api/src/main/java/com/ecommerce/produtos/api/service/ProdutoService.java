package com.ecommerce.produtos.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.produtos.api.dto.ProdutoDTO;
import com.ecommerce.produtos.api.model.Produto;
import com.ecommerce.produtos.api.repository.ProdutoRepository;

@Service
public class ProdutoService {
    public Produto salvarCliente(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> obterListaClientes() {
        return produtoRepository.findAll();
    }

    public Page<ProdutoDTO> obterPaginasProdutos(Pageable page) {
        return produtoRepository.findAll(page).map(Produto::convertToDTO);
    }

    @Autowired
    private ProdutoRepository produtoRepository;

}
