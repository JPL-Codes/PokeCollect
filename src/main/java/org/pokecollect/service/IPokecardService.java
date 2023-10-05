package org.pokecollect.service;

import org.pokecollect.dto.Pokecard;

public interface IPokecardService {
    /**
     * Fetch a pokecard with a given ID.
     * @param id a unique identifier for a pokecard.
     * @return the matching pokecard, or null if no matches found.
     * */
    Pokecard fetchByID(int id);
}
