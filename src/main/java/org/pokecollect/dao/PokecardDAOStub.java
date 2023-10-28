package org.pokecollect.dao;

import org.pokecollect.dto.Pokecard;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A stub implementation of the {@link IPokecardDAO} interface for managing Pokecards in memory.
 * This implementation is primarily used for testing and development purposes.
 */
@Repository
public class PokecardDAOStub implements IPokecardDAO{

    HashMap<String, Pokecard> allPokecards = new HashMap<>();
    @Override
    public Pokecard save(Pokecard pokecard) throws Exception {
        String pokecardId = pokecard.getId();
        allPokecards.put(pokecardId, pokecard);
        return pokecard;
    }

    @Override
    public void delete(int id) { allPokecards.remove(id); }

    @Override
    public List<Pokecard> fetchAll() {
        List<Pokecard> returnPokecard = new ArrayList<>(allPokecards.values());
        return returnPokecard;
    }

    @Override
    public Pokecard fetch(int id) {
        return allPokecards.get(id);
    }
}
