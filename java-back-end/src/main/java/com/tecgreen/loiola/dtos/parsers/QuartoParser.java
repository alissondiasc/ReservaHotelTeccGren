package com.tecgreen.loiola.dtos.parsers;

import com.tecgreen.loiola.dtos.QuartoDTO;
import com.tecgreen.loiola.entities.Quarto;

public class QuartoParser {

    public static QuartoDTO toDTO(Quarto quarto) {
        return new QuartoDTO(quarto.getId(), quarto.getDescricao(), quarto.getValor(), quarto.getQuantidade());
    }
}
