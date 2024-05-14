package com.ecommerce.usuarios.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.usuarios.api.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    Optional<Fornecedor> findByCnpj(String cnpj);

    Optional<List<Fornecedor>> findByNomeFantasiaLike(String nomeFantasia);

    Optional<Fornecedor> findByRazaoSocialLike(String razaoSocial);

    Optional<Fornecedor> findByEmail(String email);
}
