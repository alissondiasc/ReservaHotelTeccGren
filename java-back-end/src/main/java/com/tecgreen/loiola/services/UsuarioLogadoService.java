package com.tecgreen.loiola.services;


import com.tecgreen.loiola.security.UsuarioSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

public class UsuarioLogadoService {

    public static UsuarioSecurity usuarioLogado() {
        return (UsuarioSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
