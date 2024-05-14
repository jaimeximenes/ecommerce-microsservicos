package com.ecommerce.compras.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.compras.api.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    Optional<Compra> findByEmailCliente();

    Optional<List<Compra>> findByDataNascimentoBetween();
}
