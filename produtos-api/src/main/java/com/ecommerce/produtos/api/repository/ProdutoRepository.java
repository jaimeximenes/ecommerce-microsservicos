package com.ecommerce.produtos.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.produtos.api.model.Categoria;
import com.ecommerce.produtos.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNome();

    Optional<List<Produto>> findByPrecoSmallerThan(Double preco);

    Optional<List<Produto>> findByPrecoGreaterThan(Double preco);

    Optional<List<Produto>> findPrecoBetween(Double preco);

    Optional<Produto> findByCodigo(String codigo);

    @Query("SELECT u FROM tb_produtos u WHERE u.tb_produtos.idCategoria = :idCategoria")
    Optional<Produto> findByCategoria(@Param("idCategoria") int id);
}
