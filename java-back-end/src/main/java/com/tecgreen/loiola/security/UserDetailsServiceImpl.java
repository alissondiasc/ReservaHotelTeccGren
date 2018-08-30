package com.tecgreen.loiola.security;

import com.tecgreen.loiola.entities.Usuario;
import com.tecgreen.loiola.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscarPorCpf(cpf);

        if (usuario == null) {
            throw new UsernameNotFoundException(cpf);
        }

        return new UsuarioSecurity(usuario.getCpf(), usuario.getSenha(), usuario.getPerfil());
    }
}
