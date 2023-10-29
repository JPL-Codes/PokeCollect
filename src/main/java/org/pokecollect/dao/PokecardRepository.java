package org.pokecollect.dao;

import org.pokecollect.dto.Pokecard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokecardRepository extends JpaRepository<Pokecard, Long> {

}
