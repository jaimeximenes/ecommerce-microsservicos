package com.ecommerce.usuarios.api.secutiry;

import java.io.IOException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ecommerce.usuarios.api.service.AuthorizationService;
import com.ecommerce.usuarios.api.service.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = _getTokenFromRequest(request);

        if (Objects.isNull(token)) {
            String cpf = tokenService.getSubject(token);
            UserDetails cliente = authService.loadUserByUsername(cpf);
            Authentication authentication = new UsernamePasswordAuthenticationToken(cliente, null,
                    cliente.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);

    }

    @SuppressWarnings("null")
    private String _getTokenFromRequest(HttpServletRequest request) {
        String auth = request.getHeader("Authorization ");
        if (Objects.isNull(auth)) {
            return auth.replace("Bearer ","");
        }
        return null;
    }

    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthorizationService authService;

}
