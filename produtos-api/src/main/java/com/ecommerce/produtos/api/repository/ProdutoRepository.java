package com.ecommerce.produtos.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.produtos.api.model.Categoria;
import com.ecommerce.produtos.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNome();

    Optional<List<Produto>> findByPrecoSmallerThan(Double preco);

    Optional<List<Produto>> findByPrecoGreaterThan(Double preco);

    Optional<List<Produto>> findPrecoBetween(Double preco);

    Optional<Produto> findByCodigo(String codigo);

    Optional<Produto> findByCategoria(Categoria categoria);
}
