package com.tecgreen.loiola.dtos;

import java.io.Serializable;

public class ReservaQuartoDTO implements Serializable {

    private Integer quantidade;
    private QuartoDTO quarto;

    public ReservaQuartoDTO() {
    }

    public ReservaQuartoDTO(Integer quantidade, QuartoDTO quarto) {
        this.quantidade = quantidade;
        this.quarto = quarto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public QuartoDTO getQuarto() {
        return quarto;
    }

    public void setQuarto(QuartoDTO quarto) {
        this.quarto = quarto;
    }
}
