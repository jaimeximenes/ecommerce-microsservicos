package com.ecommerce.produtos.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.produtos.api.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<List<Categoria>> findByNomeLike(String nome);

    // Page<Categoria> obterPaginasCategoria(Pageable page);

    Optional<Categoria> findById(int id);

}
