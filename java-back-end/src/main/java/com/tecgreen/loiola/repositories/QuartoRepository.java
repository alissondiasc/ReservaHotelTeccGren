package com.tecgreen.loiola.repositories;

import com.tecgreen.loiola.entities.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {

    List findAllDisponiveis(@Param("checkin") LocalDate checkin, @Param("checkout") LocalDate checkout);
}
