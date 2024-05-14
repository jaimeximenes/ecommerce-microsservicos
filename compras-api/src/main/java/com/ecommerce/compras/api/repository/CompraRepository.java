package com.ecommerce.compras.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.compras.api.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}
