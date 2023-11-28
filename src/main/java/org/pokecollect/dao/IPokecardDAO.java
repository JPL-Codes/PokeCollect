package org.pokecollect.dao;

import org.pokecollect.dto.Pokecard;

import java.util.List;

/**
 * The interface for managing Pokecards, providing methods for saving, deleting, and fetching Pokecards.
 */
public interface IPokecardDAO {

    Pokecard save(Pokecard pokecard) throws Exception;

    //void delete(int id);

    List<Pokecard> fetchAll();

    Pokecard fetch(int id);
}
