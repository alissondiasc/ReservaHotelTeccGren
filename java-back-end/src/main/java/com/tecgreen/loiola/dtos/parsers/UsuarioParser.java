package com.tecgreen.loiola.dtos.parsers;

import com.tecgreen.loiola.dtos.UsuarioDTO;
import com.tecgreen.loiola.entities.Usuario;

public class UsuarioParser {

    public static UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(usuario.getNome(), usuario.getCpf());
    }
}
