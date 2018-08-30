package com.tecgreen.loiola.controllers;

import com.tecgreen.loiola.dtos.QuartoDTO;
import com.tecgreen.loiola.entities.Quarto;
import com.tecgreen.loiola.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "quartos")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @GetMapping
    public ResponseEntity<List<Quarto>> buscarTodos() {
        List<Quarto> quartos = quartoService.buscarTodos();

        return ResponseEntity.ok(quartos);
    }

    @GetMapping(value = "disponiveis")
    public ResponseEntity<List<QuartoDTO>> verificarDisponibilidade(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate checkin, @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate checkout) {
        List<QuartoDTO> quartos = quartoService.buscarQuartosDisponiveis(checkin, checkout);

        return ResponseEntity.ok(quartos);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Quarto> cadastrar(@RequestBody Quarto quarto) {
        Quarto novoQuarto = quartoService.salvar(quarto);

        return ResponseEntity.ok(novoQuarto);
    }
}
