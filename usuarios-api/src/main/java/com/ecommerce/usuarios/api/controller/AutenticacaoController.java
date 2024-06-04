package com.ecommerce.usuarios.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.usuarios.api.dto.AutenticacaoDTO;
import com.ecommerce.usuarios.api.dto.UsuarioDTO;
import com.ecommerce.usuarios.api.model.Cliente;
import com.ecommerce.usuarios.api.service.TokenService;

@RestController
@RequestMapping(value = "/auth")
public class AutenticacaoController {
    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody AutenticacaoDTO dto) {
        try {
            Authentication authentication = manager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getSenha()));
            Cliente cliente = (Cliente) authentication.getPrincipal();

            String token = service.generateToken(cliente);
            UsuarioDTO usuarioDTO = new UsuarioDTO(cliente.convertToDTO(), token);
            return ResponseEntity.status(HttpStatus.OK).body(usuarioDTO);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService service;
}
