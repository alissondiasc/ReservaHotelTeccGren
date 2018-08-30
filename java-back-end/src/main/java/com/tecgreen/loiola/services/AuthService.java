package com.tecgreen.loiola.services;

import com.tecgreen.loiola.entities.Usuario;
import com.tecgreen.loiola.security.JWTUtil;
import com.tecgreen.loiola.security.UsuarioSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public String refreshToken() {
        UsuarioSecurity usuario = UsuarioLogadoService.usuarioLogado();

        return jwtUtil.generateToken(usuario.getUsername());
    }

    public String gerarNovaSenha(String cpf) {
        Usuario usuario = usuarioService.buscarPorCpf(cpf);

        if (usuario != null) {
            String novaSenha = novaSenha();
            usuario.setSenha(encoder.encode(novaSenha));
            usuarioService.salvar(usuario);

            return "Sua nova senha é " + novaSenha;
        } else {
            return "Usuário não encontrado";
        }
    }

    private String novaSenha() {
        int leftLimit = 97; // letra 'a'
        int rightLimit = 122; // letra 'z'
        int targetStringLength = 6;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);

        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }
}
