package com.tecgreen.loiola.dtos.parsers;

import com.tecgreen.loiola.dtos.ReservaQuartoDTO;
import com.tecgreen.loiola.entities.ReservaQuarto;

import java.util.ArrayList;
import java.util.List;

public class ReservaQuartoParser {

    private static ReservaQuartoDTO toDTO(ReservaQuarto reservaQuarto) {
        return new ReservaQuartoDTO(reservaQuarto.getQuantidade(), QuartoParser.toDTO(reservaQuarto.getQuarto()));
    }

    public static List<ReservaQuartoDTO> toDTO(List<ReservaQuarto> reservaQuartoList) {
        List<ReservaQuartoDTO> quartos = new ArrayList<>();

        reservaQuartoList.forEach(reservaQuarto -> quartos.add(toDTO(reservaQuarto)));

        return quartos;
    }
}
