package com.tecgreen.loiola.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecgreen.loiola.dtos.QuartoDTO;
import com.tecgreen.loiola.entities.Quarto;
import com.tecgreen.loiola.repositories.QuartoRepository;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public List<Quarto> buscarTodos() {
        return quartoRepository.findAll();
    }

    public Quarto salvar(Quarto quarto) {
        return quartoRepository.save(quarto);
    }

    public Quarto buscarPorId(Long id) {
        return quartoRepository.findById(id).orElse(null);
    }

    public List<QuartoDTO> buscarQuartosDisponiveis(LocalDate checkin, LocalDate checkout) {
        return quartoRepository.findAllDisponiveis(checkin, checkout);
        
        
   
    }
}
