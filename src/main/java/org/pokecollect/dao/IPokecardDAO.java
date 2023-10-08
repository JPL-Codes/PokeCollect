package org.pokecollect.dao;

import org.pokecollect.dto.Pokecard;

public interface IPokecardDAO {
    Pokecard save(Pokecard pokecard) throws Exception;
}
