package com.tecgreen.loiola.dtos.parsers;

import com.tecgreen.loiola.dtos.ReservaDTO;
import com.tecgreen.loiola.entities.Reserva;

public class ReservaParser {

    public static ReservaDTO toDTO(Reserva reserva) {
        ReservaDTO reservaDTO = new ReservaDTO(reserva.getDataCheckin(), reserva.getDataCheckout());

        reservaDTO.setUsuario(UsuarioParser.toDTO(reserva.getUsuario()));
        reservaDTO.setQuartos(ReservaQuartoParser.toDTO(reserva.getQuartos()));

        return reservaDTO;
    }
}
