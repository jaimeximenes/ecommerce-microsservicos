package com.ecommerce.usuarios.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.compras.client.usuario.EnderecoDTO;

@Service
public class EnderecoService {
    public EnderecoDTO buscaEndereco(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);
        
        ResponseEntity<EnderecoDTO> response = restTemplate.getForEntity(url, EnderecoDTO.class);
        
        return response.getBody();
    }
}
