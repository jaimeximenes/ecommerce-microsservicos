package com.ecommerce.produtos.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.produtos.api.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByCodigo(String codigo);

    // Optional<List<Produto>> findByPrecoSmallerThan(Double preco);

    // Optional<List<Produto>> findByPrecoGreaterThan(Double preco);

    // Optional<List<Produto>> findPrecoBetween(Double precoInicial, Double precoFinal);

    // Optional<List<Produto>> findByCategoria(@Param("nomeCategoria") String nomeCategoria);

}
