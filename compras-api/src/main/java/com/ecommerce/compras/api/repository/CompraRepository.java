package com.ecommerce.compras.api.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.compras.api.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    Optional<Compra> findByEmailCliente(String Email);

    Optional<List<Compra>> findByDataBetween(Date Date);

    // @Query("SELECT c from tb_compras")
    // Optional<List<Compra>> findByItem(@Param("idItem")Long idItem);

}
