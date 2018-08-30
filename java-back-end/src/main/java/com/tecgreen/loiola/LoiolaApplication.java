package com.tecgreen.loiola;

import com.tecgreen.loiola.entities.Quarto;
import com.tecgreen.loiola.entities.Usuario;
import com.tecgreen.loiola.enums.Perfil;
import com.tecgreen.loiola.services.QuartoService;
import com.tecgreen.loiola.services.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LoiolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoiolaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(BCryptPasswordEncoder passwordEncoder, UsuarioService usuarioService, QuartoService quartoService) {
		return args -> {
		    initUsers(usuarioService, passwordEncoder);
		    initQuartos(quartoService);
        };
	}

    private void initUsers(UsuarioService usuarioService, BCryptPasswordEncoder passwordEncoder) {
        if (usuarioService.buscarPorCpf("12345678910") == null) {
            Usuario admin = new Usuario();
            String senha = "maria123";

            admin.setNome("Maria");
            admin.setCpf("12345678910");
            admin.setSenha(passwordEncoder.encode(senha));
            admin.setPerfil(Perfil.ADMIN);

            usuarioService.salvar(admin);
        }
    }

    private void initQuartos(QuartoService quartoService) {
        Quarto q1 = new Quarto("Casal", 100D, 10);
        Quarto q2 = new Quarto("Solteiro", 70D, 15);
        Quarto q3 = new Quarto("Luxo", 150D, 5);

        quartoService.salvar(q1);
        quartoService.salvar(q2);
        quartoService.salvar(q3);
    }
}
