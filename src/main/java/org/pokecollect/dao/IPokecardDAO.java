package org.pokecollect.dao;

import org.pokecollect.dto.Pokecard;

import java.util.List;

public interface IPokecardDAO {
    Pokecard save(Pokecard pokecard) throws Exception;

    List<Pokecard> fetchAll();
    Pokecard fetch(int id);

    void delete(int id);
}
