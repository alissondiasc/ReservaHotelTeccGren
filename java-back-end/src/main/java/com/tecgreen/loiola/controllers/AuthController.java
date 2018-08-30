package com.tecgreen.loiola.controllers;

import com.tecgreen.loiola.dtos.CpfDTO;
import com.tecgreen.loiola.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value="/refresh-token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        String novoToken = authService.refreshToken();
        response.addHeader("Authorization", "Bearer " + novoToken);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value="/forgot")
    public ResponseEntity<String> esqueciASenha(@RequestBody CpfDTO cpfDTO) {
        String msg = authService.gerarNovaSenha(cpfDTO.getCpf());
        return ResponseEntity.ok(msg);
    }
}
