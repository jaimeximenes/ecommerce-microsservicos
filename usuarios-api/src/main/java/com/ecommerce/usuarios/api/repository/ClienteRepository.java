package com.ecommerce.usuarios.api.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.usuarios.api.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findById(int id);

    Optional<List<Cliente>> findByNome(String nome);

    Optional<List<Cliente>> findByNomeLike(String nome);

    Optional<Cliente> findByEmail(String email);

    Optional<Cliente> findByCpf(String cpf);

    Optional<List<Cliente>> findByNomeAndCpf(String cpf, String nome);

    Optional<List<Cliente>> findByDataNascimentoBetween(LocalDate dataInicio, LocalDate dataFim);

    boolean existsByEmail(String email);
}
