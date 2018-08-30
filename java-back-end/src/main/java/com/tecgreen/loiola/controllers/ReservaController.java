package com.tecgreen.loiola.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecgreen.loiola.dtos.ReservaDTO;
import com.tecgreen.loiola.entities.Reserva;
import com.tecgreen.loiola.services.ReservaService;

@RestController
@RequestMapping(value = "reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaDTO> reservar(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.salvar(reserva));
    }
    
    
}
