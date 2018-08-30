package com.tecgreen.loiola.security;

import com.tecgreen.loiola.enums.Perfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class UsuarioSecurity implements UserDetails {

    private String cpf;
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioSecurity() {
    }

    public UsuarioSecurity(String cpf, String senha, Perfil perfil) {
        this.cpf = cpf;
        this.senha = senha;
        this.authorities = new ArrayList<>(Collections.singletonList(new SimpleGrantedAuthority(perfil.getDescricao())));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
