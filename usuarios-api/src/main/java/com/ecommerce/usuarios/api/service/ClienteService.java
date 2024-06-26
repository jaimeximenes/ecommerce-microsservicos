package com.ecommerce.usuarios.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.compras.client.usuario.ClienteDTO;
import com.ecommerce.compras.client.usuario.EnderecoDTO;
import com.ecommerce.usuarios.api.model.Cliente;
import com.ecommerce.usuarios.api.model.Endereco;
import com.ecommerce.usuarios.api.repository.ClienteRepository;

@Service
public class ClienteService {
    public ClienteDTO salvarCliente(Cliente cliente) {
        String senha = cliente.getSenha();
        BCryptPasswordEncoder encoder = authorizationService.getPasswordEncoder();
        String senhaCriptografada = encoder.encode(senha);
        cliente.setSenha(senhaCriptografada);

        EnderecoDTO enderecoDTO = enderecoService.buscaEndereco(cliente.getEndereco().getCep());
        Endereco endereco = cliente.getEndereco();
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setCidade(enderecoDTO.getLocalidade());
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setUf(enderecoDTO.getUf());
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

    public ClienteDTO obterClientePorEmail(String email) {
        Optional<Cliente> cliente = clienteRepository.findByEmail(email);
        if (cliente.isPresent()) {
            return cliente.get().convertToDTO();
        }
        return null;
    }

    public Cliente obterClientePorCpf(String cpf) {
        Optional<Cliente> cliente = clienteRepository.findByEmail(cpf);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        return null;
    }

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private AuthorizationService authorizationService;

}
