package com.ecommerce.usuarios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.usuarios.api.model.Fornecedor;

public interface FornecedorRepository  extends JpaRepository<Fornecedor, Long> {
    
}
