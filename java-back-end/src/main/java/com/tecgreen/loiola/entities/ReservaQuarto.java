package com.tecgreen.loiola.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class ReservaQuarto implements Serializable {

    @EmbeddedId
    private ReservaQuartoPK id = new ReservaQuartoPK();
    private Integer quantidade;

    public ReservaQuartoPK getId() {
        return id;
    }

    public void setId(ReservaQuartoPK id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setReserva(Reserva reserva) {
        this.id.setReserva(reserva);
    }

    public Quarto getQuarto() {
        return id.getQuarto();
    }

    public void setQuarto(Quarto quarto) {
        this.id.setQuarto(quarto);
    }
}
