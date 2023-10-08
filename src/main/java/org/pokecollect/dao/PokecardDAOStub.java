package org.pokecollect.dao;

import org.pokecollect.dto.Pokecard;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PokecardDAOStub implements IPokecardDAO{

    HashMap<Integer, Pokecard> allPokecards = new HashMap<>();
    @Override
    public Pokecard save(Pokecard pokecard) throws Exception {
        String pokecardId = pokecard.getId();
        allPokecards.put(Integer.parseInt(pokecardId), pokecard);
        return pokecard;
    }

    @Override
    public List<Pokecard> fetchAll() {
        List<Pokecard> returnPokecard = new ArrayList<>(allPokecards.values());
        return returnPokecard;
    }

    @Override
    public Pokecard fetch(int id) {
        return allPokecards.get(id);
    }

    @Override
    public void delete(int id) {
        allPokecards.remove(id);
    }
}
