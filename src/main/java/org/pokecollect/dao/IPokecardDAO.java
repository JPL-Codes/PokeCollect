package org.pokecollect.dao;

import org.pokecollect.dto.Pokecard;

import java.util.List;

/**
 * Saves a Pokecard object to the data store.
 *
 * @param pokecard The Pokecard to save.
 * @return The saved Pokecard.
 * @throws PokecardSaveException If an error occurs while saving the Pokecard.
 */

public interface IPokecardDAO {
    Pokecard save(Pokecard pokecard) throws Exception;

    List<Pokecard> fetchAll();
    Pokecard fetch(int id);

    void delete(int id);
}
