package com.ecommerce.produtos.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.produtos.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNome();

    Optional<List<Produto>> findByPrecoSmaller();

    Optional<List<Produto>> findByPrecoGreaterThan();

    Optional<List<Produto>> findPrecoBetween();

    Optional<Produto> findByCodigo();

    Optional<Produto> findByCategoria();
}
