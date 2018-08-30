package com.tecgreen.loiola.services;

import com.tecgreen.loiola.entities.Reserva;
import com.tecgreen.loiola.entities.ReservaQuarto;
import com.tecgreen.loiola.repositories.ReservaQuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaQuartoService {

    @Autowired
    private ReservaQuartoRepository reservaQuartoRepository;

    @Autowired
    private QuartoService quartoService;

    public List<ReservaQuarto> salvar(Reserva reserva, List<ReservaQuarto> reservaQuartoList) {

        reservaQuartoList.forEach(reservaQuarto -> {
            reservaQuarto.setReserva(reserva);
            reservaQuarto.setQuarto(quartoService.buscarPorId(reservaQuarto.getQuarto().getId()));
            reservaQuartoRepository.save(reservaQuarto);
        });

        return reservaQuartoList;
    }
}
