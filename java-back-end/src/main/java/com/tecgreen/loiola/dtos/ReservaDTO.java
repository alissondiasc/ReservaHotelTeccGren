package com.tecgreen.loiola.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaDTO implements Serializable {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCheckin;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCheckout;

    private UsuarioDTO usuario;

    private List<ReservaQuartoDTO> quartos = new ArrayList<>();

    public ReservaDTO() {
    }

    public ReservaDTO(LocalDate dataCheckin, LocalDate dataCheckout) {
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
    }

    public LocalDate getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(LocalDate dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public LocalDate getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(LocalDate dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public List<ReservaQuartoDTO> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<ReservaQuartoDTO> quartos) {
        this.quartos = quartos;
    }
}
