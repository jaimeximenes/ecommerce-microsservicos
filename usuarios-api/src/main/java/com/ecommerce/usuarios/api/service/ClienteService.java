package com.ecommerce.usuarios.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.usuarios.api.dto.ClienteDTO;
import com.ecommerce.usuarios.api.model.Cliente;
import com.ecommerce.usuarios.api.repository.ClienteRepository;

@Service
public class ClienteService {
    public ClienteDTO salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente).convertToDTO();
    }

    public List<ClienteDTO> obterListaClientes() {
        return clienteRepository.findAll().stream().map(c -> c.convertToDTO()).collect(Collectors.toList());
    }

    public Page<ClienteDTO> obterPaginasClientes(Pageable page) {
        return clienteRepository.findAll(page).map(Cliente::convertToDTO);
    }

    public ClienteDTO obterCliente(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get().convertToDTO();
        }
        return null;
    }

    public List<ClienteDTO> obterClientesPeloNome(String nome) {

        Optional<List<Cliente>> clientes = clienteRepository.findByNomeLike(nome + "%");

        if (clientes.isEmpty()) {
            return clienteRepository.findByNomeLike("%" + nome + "%")
                    .get()
                    .stream()
                    .map(c -> c.convertToDTO())
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Autowired
    private ClienteRepository clienteRepository;

}
