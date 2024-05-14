package com.ecommerce.usuarios.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.usuarios.api.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    Optional<Fornecedor> findByCnpj();

    Optional<Fornecedor> findByNomeFantasiaLike();

    Optional<Fornecedor> findByRazaoSocialLike();

    Optional<Fornecedor> findByEmail();
}
