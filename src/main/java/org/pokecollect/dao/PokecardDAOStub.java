package org.pokecollect.dao;

import org.pokecollect.dto.Pokecard;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PokecardDAOStub implements IPokecardDAO{

    HashMap<Integer, Pokecard> allPokecards = new HashMap<>();
    HashMap<String, HashMap> allSets = new HashMap<>();
    @Override
    public Pokecard save(Pokecard pokecard) throws Exception {
        int pokecardSet = pokecard.getSet();
        int pokecardId = pokecard.getId();
        allPokecards.put(pokecardId, pokecard);
        allSets.put(pokecardSet, pokecardId)
        return pokecard;
    }

    @Override
    public List<Pokecard> fetchAll() {
        List<Pokecard> returnPokecard = new ArrayList<>(allPokecards.values());
        return returnPokecard;
    }

    @Override
    public Pokecard fetch(String set, int id) {
        ArrayList<Pokecard> selectedSet = new ArrayList<Pokecard>();
        selectedSet.add(allSets.get(set))
        return selectedSet(id);
    }

    @Override
    public void delete(String set, int id) {
        ArrayList<Pokecard> selectedSet = new ArrayList<Pokecard>();
        selectedSet.add(allSets.get(set))
        allPokecards.remove(id);
    }
}
