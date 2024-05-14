package com.ecommerce.produtos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.produtos.api.model.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto,Long>{
    
}
