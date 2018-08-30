package com.tecgreen.loiola.repositories;

import com.tecgreen.loiola.entities.ReservaQuarto;
import com.tecgreen.loiola.entities.ReservaQuartoPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaQuartoRepository extends CrudRepository<ReservaQuarto, ReservaQuartoPK> {
}
