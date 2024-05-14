package com.ecommerce.usuarios.api.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.usuarios.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findById(int id);

    Optional<Cliente> findByNome(String nome);

    Optional<Cliente> findByEmailCliente(String nome);

    Optional<Cliente> findByCpf(String cpf);

    Optional<List<Cliente>> findByNomeLike(String cpf);

    Optional<List<Cliente>> findByNomeAndCpf(String cpf, String nome);

    Optional<List<Cliente>> findByDataNascimentoBetween(LocalDate dataInicio, LocalDate dataFim);

    Optional<List<Cliente>> findByContainsIgnoreCase(String nome);

    boolean existsByEmail(String email);
}
